package it.senape.wldiag.service.jpa;

import it.senape.wldiag.jpa.projection.ThreadedTransaction;
import it.senape.wldiag.jpa.repository.TransactionRepository;
import it.senape.wldiag.message.DiagnosticImagesTransactionsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by michele.arciprete on 07-Apr-18
 */
@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public DiagnosticImagesTransactionsMessage getDiagnosticImageTransactions(Long diagnosticImageId) {
        DiagnosticImagesTransactionsMessage dto = new DiagnosticImagesTransactionsMessage();
//        List<Transaction> transactions = transactionRepository.findAllByDiagnosticImageId(diagnosticImageId);
//
//
//        if(!transactions.isEmpty()) {
//            Transaction entity = transactions.get(0);
//            Jta jta = entity.getJta();
//            DiagnosticImage diagnosticImage = jta.getDiagnosticImage();
//            Jvm jvm  = diagnosticImage.getJvm();
//            WorkManager workManager = diagnosticImage.getWorkManager();
//
//            dto.setHealth(jta.getHealth().getState().toString());
//            dto.setLastCheckpointTime(jta.getLastCheckpointTime());
//            dto.setTransactionCount(jta.getTransactionCount());
//
//            dto.setTotalThreadCount(workManager.getTotalThreadCount());
//            dto.setIdleThreadCount(workManager.getIdleThreadCount());
//            dto.setStandbyThreadCount(workManager.getStandbyThreadCount());
//            dto.setMeanThroughput(workManager.getMeanThroughput());
//            dto.setTotalRequests(workManager.getTotalRequests());
//
//            dto.setHeapMemoryUsedBytes(jvm.getHeapMemoryUsedBytes());
//            dto.setHeapMemoryMaxBytes(jvm.getHeapMemoryMaxBytes()); //10468982784
//            dto.setHeapMemoryInitBytes(jvm.getHeapMemoryInitBytes()); //10737418240
//            dto.setHeapMemoryCommittedBytes(jvm.getHeapMemoryCommittedBytes()); //10468982784
//            dto.setNonHeapMemoryUsedBytes(jvm.getNonHeapMemoryUsedBytes()); //503502480
//            dto.setNonHeapMemoryInitBytes(jvm.getNonHeapMemoryInitBytes()); //2555904
//            dto.setNonHeapMemoryCommittedBytes(jvm.getNonHeapMemoryCommittedBytes()); //525537280
//            dto.setThreadCount(jvm.getThreadCount()); //109
//            dto.setPeakThreadCount(jvm.getPeakThreadCount()); //112
//            dto.setTotalStartedThreadCount(jvm.getTotalStartedThreadCount());
//            dto.setCurrentThreadCpuTime(jvm.getCurrentThreadCpuTime()); //1406817907
//            dto.setCurrentThreadUserTime(jvm.getCurrentThreadUserTime());
//
//            Map<String, ThreadDump> threadDumpMap = new HashMap<>();
//            jvm.getThreadDumpList().forEach(threadDump -> {
//                threadDumpMap.put(threadDump.getThreadName(),threadDump);
//            });
//
//            for (Transaction transaction : transactions) {
//                DiagnosticImagesTransactionsMessage.ThreadedTransaction threadedTransaction = new DiagnosticImagesTransactionsMessage.ThreadedTransaction();
//                threadedTransaction.setBeginTime(transaction.getBeginTime());
//                threadedTransaction.setStatus(transaction.getStatus());
//                threadedTransaction.setXid(transaction.getXid());
//
////                Iterator<Property> ejbIterator = transaction.getGlobalProperties().iterator();
////                EjbTransactionProperty next = (EjbTransactionProperty) ejbIterator.next();
////                threadedTransaction.setClassName(next.);
//
//                InternalThread internalThread = transaction.getActiveThread();
//                String threadName = internalThread.getName();
//                threadedTransaction.setThreadName(threadName);
//                threadedTransaction.setPoolNumber(String.valueOf(internalThread.getPoolNumber()));
//                threadedTransaction.setWlsStatus(internalThread.getWlsStatus());
//
//                ThreadDump threadDump = threadDumpMap.get(threadName);
//                threadedTransaction.setExtraInfo(threadDump.getExtraInfo());
//                threadedTransaction.setStackTrace(threadDump.getStackTrace());
//                threadedTransaction.setJavaThreadState(threadDump.getState());
//
//                Work work = threadDump.getExecutionDetails().getWork();
//                threadedTransaction.setWorkManagerType(work.getType());
//                threadedTransaction.setWorkManager(work.getWorkManager());
//                threadedTransaction.setScheduled(work.getScheduled());
//                threadedTransaction.setStarted(work.getStarted());
//                threadedTransaction.setStartedTimeMillis(work.getStartedTimeMillis());
//
//                dto.getTransactions().add(threadedTransaction);
//            }
//
//        }
        return dto;
    }

    public Collection<ThreadedTransaction> findAllThreadedTransaction(Long diagnosticImageId) {
        return transactionRepository.findAllThreadedTransaction(diagnosticImageId);
    }
}
