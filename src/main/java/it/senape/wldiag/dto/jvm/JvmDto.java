package it.senape.wldiag.dto.jvm;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 17-Jan-18.
 */
@XmlRootElement(name = "jvm-runtime")
public class JvmDto implements Serializable {

    private Integer objectPendingFinalizationCount; //0

    private Long heapMemoryUsedBytes; //2396672856

    private Long heapMemoryMaxBytes; //10468982784

    private Long heapMemoryInitBytes; //10737418240

    private Long heapMemoryCommittedBytes; //10468982784

    private Long nonHeapMemoryUsedBytes; //503502480

    private Long nonHeapMemoryInitBytes; //2555904

    private Long nonHeapMemoryCommittedBytes; //525537280

    private Integer threadCount; //109

    private Integer peakThreadCount; //112

    private Integer totalStartedThreadCount; //230

    private Integer daemonThreadCount; //75

    private Boolean threadContentionMonitoringSupported; //true

    private Boolean threadContentionMonitoringEnabled; //false

    private Long currentThreadCpuTime; //1406817907

    private Long currentThreadUserTime; //1240000000

    private Boolean threadCpuTimeSupported; //true

    private Boolean currentThreadCpuTimeSupported; //true

    private Boolean threadCpuTimeEnabled; //true

    private String runningJvmName; //27959

    private Integer managementSpecVersion; //1

    private String vmName; //Java

    private String vmVendor; //Oracle

    private Integer vmVersion; //25

    private String specName; //Java

    private String specVendor; //Oracle

    private Integer specVersion; //1

    private Long uptime; //1750911

    private Long startTime; //1513169886152

    private Boolean bootClassPathSupported; //true

    private String osName; //Linux

    private Integer osVersion; //2

    private String osArch; //amd64

    private Integer osAvailableProcessors; //8

    private Long loadedClassCount; //45697

    private Long totalLoadedClassCount; //45697

    private Integer unloadedClassCount; //0

    private String threadDump;
    private String threadRequestExecutionDetails; //Thread

    private Long diagnosticImageId;


    public Integer getObjectPendingFinalizationCount() {
        return objectPendingFinalizationCount;
    }

    @XmlElement(name="object-pending-finalization-count")
    public void setObjectPendingFinalizationCount(Integer objectPendingFinalizationCount) {
        this.objectPendingFinalizationCount = objectPendingFinalizationCount;
    }

    public Long getHeapMemoryUsedBytes() {
        return heapMemoryUsedBytes;
    }

    @XmlElement(name="heap-memory-used-bytes")
    public void setHeapMemoryUsedBytes(Long heapMemoryUsedBytes) {
        this.heapMemoryUsedBytes = heapMemoryUsedBytes;
    }

    public Long getHeapMemoryMaxBytes() {
        return heapMemoryMaxBytes;
    }

    @XmlElement(name="heap-memory-max-bytes")
    public void setHeapMemoryMaxBytes(Long heapMemoryMaxBytes) {
        this.heapMemoryMaxBytes = heapMemoryMaxBytes;
    }

    public Long getHeapMemoryInitBytes() {
        return heapMemoryInitBytes;
    }

    @XmlElement(name="heap-memory-init-bytes")
    public void setHeapMemoryInitBytes(Long heapMemoryInitBytes) {
        this.heapMemoryInitBytes = heapMemoryInitBytes;
    }

    public Long getHeapMemoryCommittedBytes() {
        return heapMemoryCommittedBytes;
    }

    @XmlElement(name="heap-memory-committed-bytes")
    public void setHeapMemoryCommittedBytes(Long heapMemoryCommittedBytes) {
        this.heapMemoryCommittedBytes = heapMemoryCommittedBytes;
    }

    public Long getNonHeapMemoryUsedBytes() {
        return nonHeapMemoryUsedBytes;
    }

    @XmlElement(name="non-heap-memory-used-bytes")
    public void setNonHeapMemoryUsedBytes(Long nonHeapMemoryUsedBytes) {
        this.nonHeapMemoryUsedBytes = nonHeapMemoryUsedBytes;
    }

    public Long getNonHeapMemoryInitBytes() {
        return nonHeapMemoryInitBytes;
    }

    @XmlElement(name="non-heap-memory-init-bytes")
    public void setNonHeapMemoryInitBytes(Long nonHeapMemoryInitBytes) {
        this.nonHeapMemoryInitBytes = nonHeapMemoryInitBytes;
    }

    public Long getNonHeapMemoryCommittedBytes() {
        return nonHeapMemoryCommittedBytes;
    }


    @XmlElement(name="non-heap-memory-committed-bytes")
    public void setNonHeapMemoryCommittedBytes(Long nonHeapMemoryCommittedBytes) {
        this.nonHeapMemoryCommittedBytes = nonHeapMemoryCommittedBytes;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    @XmlElement(name="thread-count")
    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    public Integer getPeakThreadCount() {
        return peakThreadCount;
    }

    @XmlElement(name="peak-thread-count")
    public void setPeakThreadCount(Integer peakThreadCount) {
        this.peakThreadCount = peakThreadCount;
    }

    public Integer getTotalStartedThreadCount() {
        return totalStartedThreadCount;
    }

    @XmlElement(name="total-started-thread-count")
    public void setTotalStartedThreadCount(Integer totalStartedThreadCount) {
        this.totalStartedThreadCount = totalStartedThreadCount;
    }

    public Integer getDaemonThreadCount() {
        return daemonThreadCount;
    }

    @XmlElement(name="daemon-thread-count")
    public void setDaemonThreadCount(Integer daemonThreadCount) {
        this.daemonThreadCount = daemonThreadCount;
    }

    public Boolean getThreadContentionMonitoringSupported() {
        return threadContentionMonitoringSupported;
    }

    @XmlElement(name="thread-contention-monitoring-supported")
    public void setThreadContentionMonitoringSupported(Boolean threadContentionMonitoringSupported) {
        this.threadContentionMonitoringSupported = threadContentionMonitoringSupported;
    }

    public Boolean getThreadContentionMonitoringEnabled() {
        return threadContentionMonitoringEnabled;
    }

    @XmlElement(name="thread-contention-monitoring-enabled")
    public void setThreadContentionMonitoringEnabled(Boolean threadContentionMonitoringEnabled) {
        this.threadContentionMonitoringEnabled = threadContentionMonitoringEnabled;
    }

    public Long getCurrentThreadCpuTime() {
        return currentThreadCpuTime;
    }


    @XmlElement(name="current-thread-cpu-time")
    public void setCurrentThreadCpuTime(Long currentThreadCpuTime) {
        this.currentThreadCpuTime = currentThreadCpuTime;
    }

    public Long getCurrentThreadUserTime() {
        return currentThreadUserTime;
    }


    @XmlElement(name="current-thread-user-time")
    public void setCurrentThreadUserTime(Long currentThreadUserTime) {
        this.currentThreadUserTime = currentThreadUserTime;
    }

    public Boolean getThreadCpuTimeSupported() {
        return threadCpuTimeSupported;
    }

    @XmlElement(name="thread-cpu-time-supported")
    public void setThreadCpuTimeSupported(Boolean threadCpuTimeSupported) {
        this.threadCpuTimeSupported = threadCpuTimeSupported;
    }

    public Boolean getCurrentThreadCpuTimeSupported() {
        return currentThreadCpuTimeSupported;
    }


    @XmlElement(name="current-thread-cpu-time-supported")
    public void setCurrentThreadCpuTimeSupported(Boolean currentThreadCpuTimeSupported) {
        this.currentThreadCpuTimeSupported = currentThreadCpuTimeSupported;
    }

    public Boolean getThreadCpuTimeEnabled() {
        return threadCpuTimeEnabled;
    }


    @XmlElement(name="thread-cpu-time-enabled")
    public void setThreadCpuTimeEnabled(Boolean threadCpuTimeEnabled) {
        this.threadCpuTimeEnabled = threadCpuTimeEnabled;
    }

    public String getRunningJvmName() {
        return runningJvmName;
    }


    @XmlElement(name="running-jvm-name")
    public void setRunningJvmName(String runningJvmName) {
        this.runningJvmName = runningJvmName;
    }

    public Integer getManagementSpecVersion() {
        return managementSpecVersion;
    }


    @XmlElement(name="management-spec-version")
    public void setManagementSpecVersion(Integer managementSpecVersion) {
        this.managementSpecVersion = managementSpecVersion;
    }

    public String getVmName() {
        return vmName;
    }


    @XmlElement(name="vm-name")
    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public String getVmVendor() {
        return vmVendor;
    }


    @XmlElement(name="vm-vendor")
    public void setVmVendor(String vmVendor) {
        this.vmVendor = vmVendor;
    }

    public Integer getVmVersion() {
        return vmVersion;
    }


    @XmlElement(name="vm-version")
    public void setVmVersion(Integer vmVersion) {
        this.vmVersion = vmVersion;
    }

    public String getSpecName() {
        return specName;
    }


    @XmlElement(name="spec-name")
    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecVendor() {
        return specVendor;
    }


    @XmlElement(name="spec-vendor")
    public void setSpecVendor(String specVendor) {
        this.specVendor = specVendor;
    }

    public Integer getSpecVersion() {
        return specVersion;
    }


    @XmlElement(name="spec-version")
    public void setSpecVersion(Integer specVersion) {
        this.specVersion = specVersion;
    }

    public Long getUptime() {
        return uptime;
    }


    @XmlElement(name="uptime")
    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }

    public Long getStartTime() {
        return startTime;
    }


    @XmlElement(name="start-time")
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Boolean getBootClassPathSupported() {
        return bootClassPathSupported;
    }


    @XmlElement(name="boot-class-path-supported")
    public void setBootClassPathSupported(Boolean bootClassPathSupported) {
        this.bootClassPathSupported = bootClassPathSupported;
    }

    public String getOsName() {
        return osName;
    }


    @XmlElement(name="os-name")
    public void setOsName(String osName) {
        this.osName = osName;
    }

    public Integer getOsVersion() {
        return osVersion;
    }


    @XmlElement(name="os-version")
    public void setOsVersion(Integer osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArch() {
        return osArch;
    }


    @XmlElement(name="os-arch")
    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public Integer getOsAvailableProcessors() {
        return osAvailableProcessors;
    }


    @XmlElement(name="os-available-processors")
    public void setOsAvailableProcessors(Integer osAvailableProcessors) {
        this.osAvailableProcessors = osAvailableProcessors;
    }

    public Long getLoadedClassCount() {
        return loadedClassCount;
    }


    @XmlElement(name="loaded-class-count")
    public void setLoadedClassCount(Long loadedClassCount) {
        this.loadedClassCount = loadedClassCount;
    }

    public Long getTotalLoadedClassCount() {
        return totalLoadedClassCount;
    }


    @XmlElement(name="total-loaded-class-count")
    public void setTotalLoadedClassCount(Long totalLoadedClassCount) {
        this.totalLoadedClassCount = totalLoadedClassCount;
    }

    public Integer getUnloadedClassCount() {
        return unloadedClassCount;
    }


    @XmlElement(name="unloaded-class-count")
    public void setUnloadedClassCount(Integer unloadedClassCount) {
        this.unloadedClassCount = unloadedClassCount;
    }

    public String getThreadDump() {
        return threadDump;
    }
    @XmlElement(name="thread-dump")
    public void setThreadDump(String threadDump) {
        this.threadDump = threadDump;
    }

    public String getThreadRequestExecutionDetails() {
        return threadRequestExecutionDetails;
    }

    @XmlElement(name="thread-request-execution-details")
    public void setThreadRequestExecutionDetails(String threadRequestExecutionDetails) {
        this.threadRequestExecutionDetails = threadRequestExecutionDetails;
    }

    public Long getDiagnosticImageId() {
        return diagnosticImageId;
    }

    public void setDiagnosticImageId(Long diagnosticImageId) {
        this.diagnosticImageId = diagnosticImageId;
    }

    @Override
    public String toString() {
        return "JvmDTO{" +
                "objectPendingFinalizationCount=" + objectPendingFinalizationCount +
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
                ", daemonThreadCount=" + daemonThreadCount +
                ", threadContentionMonitoringSupported=" + threadContentionMonitoringSupported +
                ", threadContentionMonitoringEnabled=" + threadContentionMonitoringEnabled +
                ", currentThreadCpuTime=" + currentThreadCpuTime +
                ", currentThreadUserTime=" + currentThreadUserTime +
                ", threadCpuTimeSupported=" + threadCpuTimeSupported +
                ", currentThreadCpuTimeSupported=" + currentThreadCpuTimeSupported +
                ", threadCpuTimeEnabled=" + threadCpuTimeEnabled +
                ", runningJvmName='" + runningJvmName + '\'' +
                ", managementSpecVersion=" + managementSpecVersion +
                ", vmName='" + vmName + '\'' +
                ", vmVendor='" + vmVendor + '\'' +
                ", vmVersion=" + vmVersion +
                ", specName='" + specName + '\'' +
                ", specVendor='" + specVendor + '\'' +
                ", specVersion=" + specVersion +
                ", uptime=" + uptime +
                ", startTime=" + startTime +
                ", bootClassPathSupported=" + bootClassPathSupported +
                ", osName='" + osName + '\'' +
                ", osVersion=" + osVersion +
                ", osArch='" + osArch + '\'' +
                ", osAvailableProcessors=" + osAvailableProcessors +
                ", loadedClassCount=" + loadedClassCount +
                ", totalLoadedClassCount=" + totalLoadedClassCount +
                ", unloadedClassCount=" + unloadedClassCount +
                ", threadDump='" + threadDump + '\'' +
                ", threadRequestExecutionDetails='" + threadRequestExecutionDetails + '\'' +
                '}';
    }
}
