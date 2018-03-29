package it.senape.wldiag.jpa.model.jvm;

import it.senape.wldiag.jpa.model.internal.DiagnosticImage;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 17-Jan-18.
 */
@Entity
public class Jvm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String threadRequestExecutionDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnostic_image_id")
    private DiagnosticImage diagnosticImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getObjectPendingFinalizationCount() {
        return objectPendingFinalizationCount;
    }

    public void setObjectPendingFinalizationCount(Integer objectPendingFinalizationCount) {
        this.objectPendingFinalizationCount = objectPendingFinalizationCount;
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

    public Integer getDaemonThreadCount() {
        return daemonThreadCount;
    }

    public void setDaemonThreadCount(Integer daemonThreadCount) {
        this.daemonThreadCount = daemonThreadCount;
    }

    public Boolean getThreadContentionMonitoringSupported() {
        return threadContentionMonitoringSupported;
    }

    public void setThreadContentionMonitoringSupported(Boolean threadContentionMonitoringSupported) {
        this.threadContentionMonitoringSupported = threadContentionMonitoringSupported;
    }

    public Boolean getThreadContentionMonitoringEnabled() {
        return threadContentionMonitoringEnabled;
    }

    public void setThreadContentionMonitoringEnabled(Boolean threadContentionMonitoringEnabled) {
        this.threadContentionMonitoringEnabled = threadContentionMonitoringEnabled;
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

    public Boolean getThreadCpuTimeSupported() {
        return threadCpuTimeSupported;
    }

    public void setThreadCpuTimeSupported(Boolean threadCpuTimeSupported) {
        this.threadCpuTimeSupported = threadCpuTimeSupported;
    }

    public Boolean getCurrentThreadCpuTimeSupported() {
        return currentThreadCpuTimeSupported;
    }

    public void setCurrentThreadCpuTimeSupported(Boolean currentThreadCpuTimeSupported) {
        this.currentThreadCpuTimeSupported = currentThreadCpuTimeSupported;
    }

    public Boolean getThreadCpuTimeEnabled() {
        return threadCpuTimeEnabled;
    }

    public void setThreadCpuTimeEnabled(Boolean threadCpuTimeEnabled) {
        this.threadCpuTimeEnabled = threadCpuTimeEnabled;
    }

    public String getRunningJvmName() {
        return runningJvmName;
    }

    public void setRunningJvmName(String runningJvmName) {
        this.runningJvmName = runningJvmName;
    }

    public Integer getManagementSpecVersion() {
        return managementSpecVersion;
    }

    public void setManagementSpecVersion(Integer managementSpecVersion) {
        this.managementSpecVersion = managementSpecVersion;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public String getVmVendor() {
        return vmVendor;
    }

    public void setVmVendor(String vmVendor) {
        this.vmVendor = vmVendor;
    }

    public Integer getVmVersion() {
        return vmVersion;
    }

    public void setVmVersion(Integer vmVersion) {
        this.vmVersion = vmVersion;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecVendor() {
        return specVendor;
    }

    public void setSpecVendor(String specVendor) {
        this.specVendor = specVendor;
    }

    public Integer getSpecVersion() {
        return specVersion;
    }

    public void setSpecVersion(Integer specVersion) {
        this.specVersion = specVersion;
    }

    public Long getUptime() {
        return uptime;
    }

    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Boolean getBootClassPathSupported() {
        return bootClassPathSupported;
    }

    public void setBootClassPathSupported(Boolean bootClassPathSupported) {
        this.bootClassPathSupported = bootClassPathSupported;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public Integer getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(Integer osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public Integer getOsAvailableProcessors() {
        return osAvailableProcessors;
    }

    public void setOsAvailableProcessors(Integer osAvailableProcessors) {
        this.osAvailableProcessors = osAvailableProcessors;
    }

    public Long getLoadedClassCount() {
        return loadedClassCount;
    }

    public void setLoadedClassCount(Long loadedClassCount) {
        this.loadedClassCount = loadedClassCount;
    }

    public Long getTotalLoadedClassCount() {
        return totalLoadedClassCount;
    }

    public void setTotalLoadedClassCount(Long totalLoadedClassCount) {
        this.totalLoadedClassCount = totalLoadedClassCount;
    }

    public Integer getUnloadedClassCount() {
        return unloadedClassCount;
    }

    public void setUnloadedClassCount(Integer unloadedClassCount) {
        this.unloadedClassCount = unloadedClassCount;
    }

    public String getThreadDump() {
        return threadDump;
    }

    public void setThreadDump(String threadDump) {
        this.threadDump = threadDump;
    }

    public String getThreadRequestExecutionDetails() {
        return threadRequestExecutionDetails;
    }

    public void setThreadRequestExecutionDetails(String threadRequestExecutionDetails) {
        this.threadRequestExecutionDetails = threadRequestExecutionDetails;
    }

    public DiagnosticImage getDiagnosticImage() {
        return diagnosticImage;
    }

    public void setDiagnosticImage(DiagnosticImage diagnosticImage) {
        this.diagnosticImage = diagnosticImage;
    }
}
