package it.senape.wldiag.message;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by michele.arciprete on 07-Apr-18
 */
public class DiagnosticImagesTransactionsMessage {

    //JTA Info
    private String health;
    private LocalDateTime lastCheckpointTime;
    private Integer transactionCount;

    //Work Manager Info
    private Integer totalThreadCount;
    private Integer idleThreadCount;
    private Integer standbyThreadCount;
    private Double meanThroughput;
    private Integer totalRequests;

    //JVM Info
    private Long heapMemoryUsedBytes; //2396672856
    private Long heapMemoryMaxBytes; //10468982784
    private Long heapMemoryInitBytes; //10737418240
    private Long heapMemoryCommittedBytes; //10468982784
    private Long nonHeapMemoryUsedBytes; //503502480
    private Long nonHeapMemoryInitBytes; //2555904
    private Long nonHeapMemoryCommittedBytes; //525537280
    private Integer threadCount; //109
    private Integer peakThreadCount; //112
    private Integer totalStartedThreadCount;
    private Long currentThreadCpuTime; //1406817907
    private Long currentThreadUserTime; //1240000000
    private Long uptime;

    private List<ThreadedTransaction> transactions = new LinkedList<>();

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public LocalDateTime getLastCheckpointTime() {
        return lastCheckpointTime;
    }

    public void setLastCheckpointTime(LocalDateTime lastCheckpointTime) {
        this.lastCheckpointTime = lastCheckpointTime;
    }

    public Integer getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }

    public Integer getTotalThreadCount() {
        return totalThreadCount;
    }

    public void setTotalThreadCount(Integer totalThreadCount) {
        this.totalThreadCount = totalThreadCount;
    }

    public Integer getIdleThreadCount() {
        return idleThreadCount;
    }

    public void setIdleThreadCount(Integer idleThreadCount) {
        this.idleThreadCount = idleThreadCount;
    }

    public Integer getStandbyThreadCount() {
        return standbyThreadCount;
    }

    public void setStandbyThreadCount(Integer standbyThreadCount) {
        this.standbyThreadCount = standbyThreadCount;
    }

    public Double getMeanThroughput() {
        return meanThroughput;
    }

    public void setMeanThroughput(Double meanThroughput) {
        this.meanThroughput = meanThroughput;
    }

    public Integer getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Integer totalRequests) {
        this.totalRequests = totalRequests;
    }

    public Long getHeapMemoryUsedBytes() {
        return heapMemoryUsedBytes;
    }

    public void setHeapMemoryUsedBytes(Long heapMemoryUsedBytes) {
        this.heapMemoryUsedBytes = heapMemoryUsedBytes;
    }

    public Long getHeapMemoryMaxBytes() {
        return heapMemoryMaxBytes;
    }

    public void setHeapMemoryMaxBytes(Long heapMemoryMaxBytes) {
        this.heapMemoryMaxBytes = heapMemoryMaxBytes;
    }

    public Long getHeapMemoryInitBytes() {
        return heapMemoryInitBytes;
    }

    public void setHeapMemoryInitBytes(Long heapMemoryInitBytes) {
        this.heapMemoryInitBytes = heapMemoryInitBytes;
    }

    public Long getHeapMemoryCommittedBytes() {
        return heapMemoryCommittedBytes;
    }

    public void setHeapMemoryCommittedBytes(Long heapMemoryCommittedBytes) {
        this.heapMemoryCommittedBytes = heapMemoryCommittedBytes;
    }

    public Long getNonHeapMemoryUsedBytes() {
        return nonHeapMemoryUsedBytes;
    }

    public void setNonHeapMemoryUsedBytes(Long nonHeapMemoryUsedBytes) {
        this.nonHeapMemoryUsedBytes = nonHeapMemoryUsedBytes;
    }

    public Long getNonHeapMemoryInitBytes() {
        return nonHeapMemoryInitBytes;
    }

    public void setNonHeapMemoryInitBytes(Long nonHeapMemoryInitBytes) {
        this.nonHeapMemoryInitBytes = nonHeapMemoryInitBytes;
    }

    public Long getNonHeapMemoryCommittedBytes() {
        return nonHeapMemoryCommittedBytes;
    }

    public void setNonHeapMemoryCommittedBytes(Long nonHeapMemoryCommittedBytes) {
        this.nonHeapMemoryCommittedBytes = nonHeapMemoryCommittedBytes;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public Integer getPeakThreadCount() {
        return peakThreadCount;
    }

    public void setPeakThreadCount(Integer peakThreadCount) {
        this.peakThreadCount = peakThreadCount;
    }

    public Integer getTotalStartedThreadCount() {
        return totalStartedThreadCount;
    }

    public void setTotalStartedThreadCount(Integer totalStartedThreadCount) {
        this.totalStartedThreadCount = totalStartedThreadCount;
    }

    public Long getCurrentThreadCpuTime() {
        return currentThreadCpuTime;
    }

    public void setCurrentThreadCpuTime(Long currentThreadCpuTime) {
        this.currentThreadCpuTime = currentThreadCpuTime;
    }

    public Long getCurrentThreadUserTime() {
        return currentThreadUserTime;
    }

    public void setCurrentThreadUserTime(Long currentThreadUserTime) {
        this.currentThreadUserTime = currentThreadUserTime;
    }

    public Long getUptime() {
        return uptime;
    }

    public List<ThreadedTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ThreadedTransaction> transactions) {
        this.transactions = transactions;
    }

    public static class ThreadedTransaction {
        private LocalDateTime beginTime;
        private String status;
        private String xid;
        private String threadName;
        private String poolNumber;
        private String wlsStatus;
        private String javaThreadState;
        private String stackTrace;
        private String extraInfo;
        private String workManagerType;
        private String workManager;
        private Boolean started;
        private Boolean scheduled;
        private Long startedTimeMillis;

        private String className;
        private String method;
        private String arguments;

        public LocalDateTime getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(LocalDateTime beginTime) {
            this.beginTime = beginTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getXid() {
            return xid;
        }

        public void setXid(String xid) {
            this.xid = xid;
        }

        public String getThreadName() {
            return threadName;
        }

        public void setThreadName(String threadName) {
            this.threadName = threadName;
        }

        public String getPoolNumber() {
            return poolNumber;
        }

        public void setPoolNumber(String poolNumber) {
            this.poolNumber = poolNumber;
        }

        public String getWlsStatus() {
            return wlsStatus;
        }

        public void setWlsStatus(String wlsStatus) {
            this.wlsStatus = wlsStatus;
        }

        public String getStackTrace() {
            return stackTrace;
        }

        public void setStackTrace(String stackTrace) {
            this.stackTrace = stackTrace;
        }

        public String getWorkManagerType() {
            return workManagerType;
        }

        public void setWorkManagerType(String workManagerType) {
            this.workManagerType = workManagerType;
        }

        public String getWorkManager() {
            return workManager;
        }

        public void setWorkManager(String workManager) {
            this.workManager = workManager;
        }

        public Boolean getStarted() {
            return started;
        }

        public void setStarted(Boolean started) {
            this.started = started;
        }

        public Long getStartedTimeMillis() {
            return startedTimeMillis;
        }

        public void setStartedTimeMillis(Long startedTimeMillis) {
            this.startedTimeMillis = startedTimeMillis;
        }

        public String getJavaThreadState() {
            return javaThreadState;
        }

        public void setJavaThreadState(String javaThreadState) {
            this.javaThreadState = javaThreadState;
        }

        public String getExtraInfo() {
            return extraInfo;
        }

        public void setExtraInfo(String extraInfo) {
            this.extraInfo = extraInfo;
        }

        public Boolean getScheduled() {
            return scheduled;
        }

        public void setScheduled(Boolean scheduled) {
            this.scheduled = scheduled;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getArguments() {
            return arguments;
        }

        public void setArguments(String arguments) {
            this.arguments = arguments;
        }

        @Override
        public String toString() {
            return "ThreadedTransaction{" +
                    "beginTime=" + beginTime +
                    ", status='" + status + '\'' +
                    ", xid='" + xid + '\'' +
                    ", threadName='" + threadName + '\'' +
                    ", poolNumber='" + poolNumber + '\'' +
                    ", wlsStatus='" + wlsStatus + '\'' +
                    ", javaThreadState='" + javaThreadState + '\'' +
                    ", stackTrace='" + stackTrace + '\'' +
                    ", extraInfo='" + extraInfo + '\'' +
                    ", workManagerType='" + workManagerType + '\'' +
                    ", workManager='" + workManager + '\'' +
                    ", started=" + started +
                    ", scheduled=" + scheduled +
                    ", startedTimeMillis=" + startedTimeMillis +
                    ", className='" + className + '\'' +
                    ", method='" + method + '\'' +
                    ", arguments='" + arguments + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DiagnosticImagesTransactionsMessage{" +
                "health='" + health + '\'' +
                ", lastCheckpointTime=" + lastCheckpointTime +
                ", transactionCount=" + transactionCount +
                ", totalThreadCount=" + totalThreadCount +
                ", idleThreadCount=" + idleThreadCount +
                ", standbyThreadCount=" + standbyThreadCount +
                ", meanThroughput=" + meanThroughput +
                ", totalRequests=" + totalRequests +
                ", heapMemoryUsedBytes=" + heapMemoryUsedBytes +
                ", heapMemoryMaxBytes=" + heapMemoryMaxBytes +
                ", heapMemoryInitBytes=" + heapMemoryInitBytes +
                ", heapMemoryCommittedBytes=" + heapMemoryCommittedBytes +
                ", nonHeapMemoryUsedBytes=" + nonHeapMemoryUsedBytes +
                ", nonHeapMemoryInitBytes=" + nonHeapMemoryInitBytes +
                ", nonHeapMemoryCommittedBytes=" + nonHeapMemoryCommittedBytes +
                ", threadCount=" + threadCount +
                ", peakThreadCount=" + peakThreadCount +
                ", totalStartedThreadCount=" + totalStartedThreadCount +
                ", currentThreadCpuTime=" + currentThreadCpuTime +
                ", currentThreadUserTime=" + currentThreadUserTime +
                ", transactions=" + transactions +
                '}';
    }
}
