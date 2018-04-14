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

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Service
public class JvmService {

    private final static Logger logger = LoggerFactory.getLogger(JvmService.class);

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
        Map<String, InternalThread> internalThreadMap = getInternalThreadMap(diagnosticImage.getId(), threadDumpMap.keySet());

        for (String threadName : threadDumpMap.keySet()) {
            ThreadDump threadDump = threadDumpMap.get(threadName);
            jvm.getThreadDumpList().add(threadDump);
            threadDump.setJvm(jvm);

            InternalThread internalThread = internalThreadMap.get(threadName);
            if(internalThread != null) {
                threadDump.setInternalThread(internalThread);
            }

            ExecutionDetails executionDetails = executionDetailsMap.get(threadName);
            if(executionDetails != null) {
                threadDump.setExecutionDetails(executionDetails);
                executionDetails.setThreadDump(threadDump);
            }
        }

        return jvmRepository.save(jvm).getId() != null;
    }

    private Map<String,InternalThread> getInternalThreadMap(Long diagnosticImageId, Set<String> threadNames) {
        List<InternalThread> threadList = internalThreadRepository.findAllByDiagnosticImageIdAndNameIn(diagnosticImageId, threadNames);
        Map<String, InternalThread> internalThreadMap = new HashMap<>();
        for (InternalThread internalThread : threadList) {
            if (internalThreadMap.get(internalThread.getName())==null) {
                internalThreadMap.put(internalThread.getName(), internalThread);
            }
        }
        return internalThreadMap;
    }


    public Map<String, ThreadDump> extractThreadDumps(String threadDump) {
        BufferedReader reader = new BufferedReader(new StringReader(threadDump));
        Map<String, ThreadDump> threadDumpMap = new HashMap<>();
        try {
            String line = null;
            StringBuffer sb = new StringBuffer();
            Boolean isThePreviousLineEmpty = false;

            ThreadDump td = new ThreadDump();
            while((line = reader.readLine()) !=null ) {
                if(line.startsWith("\"")) {
                    sb = new StringBuffer();
                    isThePreviousLineEmpty = false;
//                    Pattern pattern = Pattern.compile("^\"(.*)\"\\s\\w+=([0-9]+)\\s(.*)");
                    Pattern pattern = Pattern.compile("([\"])((?:(?!\\1).)+)\\1\\sId=([0-9]+)\\s(.*)");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String name = matcher.group(2);
                        String id = matcher.group(3);
                        String state = matcher.group(4);
                        td = new ThreadDump();
                        td.setThreadId(Long.parseLong(id));
                        td.setThreadName(name);
                        td.setState(state);
                    }
                } else if (line.startsWith("\t")) {
                    if(isThePreviousLineEmpty) {
                        String extraInfo = line.trim();
                        extraInfo += reader.readLine();
                        td.setExtraInfo(extraInfo);
                    } else {
                        sb.append(line);
                    }
                } else if (line.isEmpty()) {

                    if (!isThePreviousLineEmpty) {
                        isThePreviousLineEmpty=true;
                    } else {
                        td.setStackTrace(sb.toString());
                        threadDumpMap.put(td.getThreadName(), td);
                    }
                }
            }
        } catch (IOException e) {
            logger.error("Failed to extract thread dumps", e);
        }
        return threadDumpMap;
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
}
