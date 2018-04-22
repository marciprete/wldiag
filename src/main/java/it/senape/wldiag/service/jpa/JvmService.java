package it.senape.wldiag.service.jpa;

import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.InternalThread;
import it.senape.wldiag.jpa.model.jvm.ExecutionDetails;
import it.senape.wldiag.jpa.model.jvm.Jvm;
import it.senape.wldiag.jpa.model.jvm.ThreadDump;
import it.senape.wldiag.jpa.model.jvm.Work;
import it.senape.wldiag.jpa.repository.InternalThreadRepository;
import it.senape.wldiag.jpa.repository.JvmRepository;
import it.senape.wldiag.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Service
public class JvmService {

    private final static Logger logger = LoggerFactory.getLogger(JvmService.class);
    private static final String SIMPLE_THREAD_PATTERN = "([\"])((?:(?!\\1).)+)\\1\\sId=([0-9]+)\\s(.*)";
    private static final String ADVANCED_THREAD_PATTERN = "([\"])((?:(?!\\1).)+)\\1(?:\\s#([0-9]+))?(?:\\s(daemon))?(?:\\sprio=([0-9-]+))?(?:\\sos_prio=([0-9-]+))?\\s(?:tid=([\\w]+))\\s(?:nid=([\\w]+))\\s([\\w\\s\\.\\(\\)]+)(?:\\[([\\w]+)\\])?";

    private JvmRepository jvmRepository;
    private InternalThreadRepository internalThreadRepository;

    @Autowired
    public JvmService(JvmRepository jvmRepository,
                      InternalThreadRepository internalThreadRepository) {
        this.jvmRepository = jvmRepository;
        this.internalThreadRepository = internalThreadRepository;
    }

    public Boolean save(JvmDto jvmDto) {
        Jvm jvm = new Jvm();
        DiagnosticImage diagnosticImage = new DiagnosticImage();
        diagnosticImage.setId(jvmDto.getDiagnosticImageId());
        jvm.setDiagnosticImage(diagnosticImage);

        BeanUtils.copyProperties(jvmDto,jvm);

        Map<String, ThreadDump> threadDumpMap = extractThreadDumps(jvmDto.getThreadDump());
        Map<String, ExecutionDetails> executionDetailsMap = extractExecutionDetails(jvmDto.getThreadRequestExecutionDetails());

        Set<String> names = threadDumpMap.values().stream().map(ThreadDump::getThreadName).collect(Collectors.toSet());
        Map<String, InternalThread> internalThreadMap = getInternalThreadMap(diagnosticImage.getId(), names);

        for (String key : threadDumpMap.keySet()) {
            ThreadDump threadDump = threadDumpMap.get(key);
            jvm.getThreadDumpList().add(threadDump);
            threadDump.setJvm(jvm);

            InternalThread internalThread = internalThreadMap.get(key);
            if(internalThread != null) {
                threadDump.setInternalThread(internalThread);
            }

            ExecutionDetails executionDetails = executionDetailsMap.get(key);
            if(executionDetails != null) {
                threadDump.setExecutionDetails(executionDetails);
                executionDetails.setThreadDump(threadDump);
            }
        }

        return jvmRepository.save(jvm).getId() != null;
    }

    private Map<String,InternalThread> getInternalThreadMap(Long diagnosticImageId, Set<String> threadNames) {
        Map<String, InternalThread> internalThreadMap = new HashMap<>();
        if(!threadNames.isEmpty()) {
            List<InternalThread> threadList = internalThreadRepository.findAllByDiagnosticImageIdAndNameIn(diagnosticImageId, threadNames);
            for (InternalThread internalThread : threadList) {
                if (internalThreadMap.get(internalThread.getName())==null) {
                    internalThreadMap.put(internalThread.getName(), internalThread);
                }
            }
        }
        return internalThreadMap;
    }


    public Map<String, ThreadDump> extractThreadDumps(String threadDump) {
        BufferedReader reader = new BufferedReader(new StringReader(threadDump));
        Map<String, ThreadDump> threadDumpMap = new HashMap<>();
        try {
            String line = null;
            ThreadDump td = new ThreadDump();
            while((line = reader.readLine()) !=null ) {
                if(line.startsWith("\"")) {
                    td = initThreadDump(line, reader);
                    String key = td.getTid() != null ? td.getTid() : td.getThreadName();
                    threadDumpMap.put(key, td);
                } else if (!line.isEmpty()) {
                    addStackTrace(td, line, reader);
                }

            }
        } catch (IOException e) {
            logger.error("Failed to extract thread dumps", e);
        }
        return threadDumpMap;
    }

    private void addStackTrace(ThreadDump td, String line, BufferedReader reader) throws IOException {
        if(td.getTid() != null) {
            addExtendedStackTrace(td, line, reader);
        } else {
            addSimpleStackTrace(td, line, reader);
        }
    }

    private void addSimpleStackTrace(ThreadDump td, String line, BufferedReader reader) throws IOException {
        Boolean isThePreviousLineEmpty = false;
        StringBuffer sb = new StringBuffer();
        Boolean hasLine = true;
        while(line != null && hasLine ) {
            if (line.startsWith("\t")) {
                if (isThePreviousLineEmpty) {
                    String extraInfo = line.trim();
                    extraInfo += reader.readLine();
                    td.setExtraInfo(extraInfo);
                    hasLine = false;
                } else {
                    sb.append(line);
                    line = reader.readLine();
                }
            } else {
                if (!isThePreviousLineEmpty) {
                    isThePreviousLineEmpty = true;
                    td.setStackTrace(sb.toString());
                    line = reader.readLine();
                } else {
                    hasLine=false;
                }
            }

        }

    }

    private void addExtendedStackTrace(ThreadDump td, String line, BufferedReader reader) throws IOException {
        Boolean hasLine = true;
        StringBuffer sb = new StringBuffer();
        while(hasLine) {
            if (line.startsWith("\t")) {
                sb.append(line);
                if(line.contains("&lt;")) {
                    String referencedTid = line.substring(line.lastIndexOf("0x"), line.lastIndexOf("&gt;"));
                    td.setReferencedTid(referencedTid);
                }
                line = reader.readLine();
            } else {
                td.setStackTrace(sb.toString());
                hasLine = false;
            }
        }
    }


    private ThreadDump initThreadDump(String line, BufferedReader reader) throws IOException {
        if (line.contains("tid=")) {
            return buildExtendedThreadDump(line, reader);
        } else {
            return buildSimpleThreadDump(line);
        }

    }

    private ThreadDump buildSimpleThreadDump(String line) {
        ThreadDump td = new ThreadDump();
        Pattern pattern = Pattern.compile(SIMPLE_THREAD_PATTERN);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String name = matcher.group(2);
            String id = matcher.group(3);
            String state = matcher.group(4);
            td = new ThreadDump();
            td.setThreadId(Long.parseLong(id));
            td.setThreadName(name);
            td.setJavaThreadState(state);
            td.setWlsStatus(Util.extractWlsStatus(name));
        }
        return td;
    }

    private ThreadDump buildExtendedThreadDump(String line, BufferedReader reader) throws IOException {
        ThreadDump td = new ThreadDump();
        Pattern pattern = Pattern.compile(ADVANCED_THREAD_PATTERN);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String name = matcher.group(2);
            String id = matcher.group(3);
            String threadType = matcher.group(4);
            String prio = matcher.group(5);
            String osPrio = matcher.group(6);
            String tid = matcher.group(7);
            String nid = matcher.group(8);
            String status = matcher.group(9);
            String onCondition = matcher.group(10);


//            //if thread name is of type Timer-0, or Thread-39, we add the #id to avoid non-unique names.
//            //this assumes that the thread-request-execution-details tag will never contain one of these threads
//            if (name.matches("Timer-[0-9]+") || name.matches("Thread-[0-9]+")) { name += " #" +id;}

            td.setThreadName(name);
            if (id != null) { td.setThreadId(Long.parseLong(id));}
            td.setThreadType(threadType);
            td.setPrio(prio);
            td.setOsPrio(osPrio);
            td.setTid(tid);
            td.setNid(nid);
            td.setStatus(status);
            td.setOnCondition(onCondition);
            td.setWlsStatus(Util.extractWlsStatus(name));

            String statusLine = reader.readLine();
            String[] javaState = statusLine.split("java.lang.Thread.State: ");

            if(javaState.length == 2) {
                String[] stateArray = javaState[1].split("\\s\\(");
                String javaThreadState = stateArray[0];
                if(stateArray.length == 2) {
                    String stateInformation = stateArray[1].substring(0, stateArray[1].lastIndexOf(")"));
                    td.setStateInformation(stateInformation);
                }
                td.setJavaThreadState(javaThreadState);
            }
        }
        return td;
    }

    public Map<String, ExecutionDetails> extractExecutionDetails(String executionDetailsString) {
        BufferedReader reader = new BufferedReader(new StringReader(executionDetailsString));
        Map<String, ExecutionDetails> executionDetailsMap = new HashMap<>();
        try {
            String line;
            while((line=reader.readLine()) != null) {
                if(line.startsWith("Thread")) {
                    String threadName = line.substring(line.lastIndexOf("Thread name:")+12, line.indexOf(","));
                    line = line.substring(line.indexOf(",")+1);

                    String threadId = line.substring(line.indexOf("ThreadID:"), line.indexOf(",")).split(":")[1].trim();
                    line = line.substring(line.indexOf(",")+1);

                    String ECID = line.substring(line.indexOf("ECID:"), line.indexOf(",")).split(":")[1].trim();
                    line = line.substring(line.indexOf(",")+1);

                    String workString = line.substring(line.indexOf(":{")+2).trim();

                    ExecutionDetails executionDetails = new ExecutionDetails();
                    executionDetails.setThreadId(Long.parseLong(threadId));
                    executionDetails.setECID(ECID);

                    Work work = extractWorkFromString(workString);
                    executionDetails.setWork(work);
                    work.setExecutionDetails(executionDetails);

                    executionDetailsMap.put(threadName, executionDetails);
                }
            }
        } catch (IOException e) {
            logger.error("Failed to extract thread execution details", e);
        }
        return executionDetailsMap;
    }

    private Work extractWorkFromString(String workString) {
        Work work;
        if(workString.startsWith("No work")) {
            work = new Work("Unallocated");
            work.setWorkManager(workString);
        } else if (workString.startsWith("Workmanager")){
            String[] data = workString.split(",");
            work = new Work("WorkManager");
            if(data.length==5) {
                String workManager = data[0].split(":")[1].trim();
                Integer version = Integer.parseInt(data[1].split(":")[1].trim());
                Boolean scheduled = Boolean.parseBoolean(data[2].split("=")[1].trim());
                Boolean started = Boolean.parseBoolean(data[3].split("=")[1].trim());
                String time = data[4].split(":")[1].trim();
                Long startedTime = Long.parseLong(time.substring(0,time.indexOf(" ")));

                work.setWorkManager(workManager);
                work.setVersion(version);
                work.setScheduled(scheduled);
                work.setStarted(started);
                work.setStartedTimeMillis(startedTime);
            }
        } else {
            work = new Work("Custom");
            work.setWorkManager(workString);
        }
        return work;
    }

    public static void main(String[] args) {
        String line = "- parking to wait for  &lt;0x00000003cfc63500&gt; (a";
        String referencedTid = line.substring(line.lastIndexOf("0x"), line.lastIndexOf("&gt;"));
        System.out.println(referencedTid);
    }


}
