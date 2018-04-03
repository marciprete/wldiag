package it.senape.wldiag.dto.jdbc;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 03-Apr-18
 */
public class JdbcResourceDto implements Serializable {

    private Boolean autoCommit; //false
    private Boolean enabled; //true
    private Boolean isXA; //false
    private Boolean isJTS; //false
    private Integer vendorID; //100
    private Boolean connUsed; //false
    private Boolean doInit; //false
    private Boolean destroyed; //false
    private String poolname; //EBOOKING_DATASOURCE
    private String appname; //null
    private String moduleName; //null
    private Integer connectTime; //55
    private Boolean dirtyIsolationLevel; //false
    private Integer initialIsolationLevel; //2
    private Boolean infected; //false
    private Long lastSuccessfulConnectionUse; //1516872070308
    private Integer secondsToTrustAnIdlePoolConnection; //10
    private String currentUser; //null
    private String currentThread; //null
    private String lastUser; //null
    private String currentError; //null
    private String currentErrorTimestamp; //null
    private Boolean JDBC4Runtime; //true
    private Boolean supportStatementPoolable; //true
    private Boolean needRestoreClientInfo; //false
    private String defaultClientInfo; //{}
    private Boolean supportIsValid;
    private String stackTrace;

    public Boolean getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getXA() {
        return isXA;
    }

    public void setXA(Boolean XA) {
        isXA = XA;
    }

    public Boolean getJTS() {
        return isJTS;
    }

    public void setJTS(Boolean JTS) {
        isJTS = JTS;
    }

    public Integer getVendorID() {
        return vendorID;
    }

    public void setVendorID(Integer vendorID) {
        this.vendorID = vendorID;
    }

    public Boolean getConnUsed() {
        return connUsed;
    }

    public void setConnUsed(Boolean connUsed) {
        this.connUsed = connUsed;
    }

    public Boolean getDoInit() {
        return doInit;
    }

    public void setDoInit(Boolean doInit) {
        this.doInit = doInit;
    }

    public Boolean getDestroyed() {
        return destroyed;
    }

    public void setDestroyed(Boolean destroyed) {
        this.destroyed = destroyed;
    }

    public String getPoolname() {
        return poolname;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Integer connectTime) {
        this.connectTime = connectTime;
    }

    public Boolean getDirtyIsolationLevel() {
        return dirtyIsolationLevel;
    }

    public void setDirtyIsolationLevel(Boolean dirtyIsolationLevel) {
        this.dirtyIsolationLevel = dirtyIsolationLevel;
    }

    public Integer getInitialIsolationLevel() {
        return initialIsolationLevel;
    }

    public void setInitialIsolationLevel(Integer initialIsolationLevel) {
        this.initialIsolationLevel = initialIsolationLevel;
    }

    public Boolean getInfected() {
        return infected;
    }

    public void setInfected(Boolean infected) {
        this.infected = infected;
    }

    public Long getLastSuccessfulConnectionUse() {
        return lastSuccessfulConnectionUse;
    }

    public void setLastSuccessfulConnectionUse(Long lastSuccessfulConnectionUse) {
        this.lastSuccessfulConnectionUse = lastSuccessfulConnectionUse;
    }

    public Integer getSecondsToTrustAnIdlePoolConnection() {
        return secondsToTrustAnIdlePoolConnection;
    }

    public void setSecondsToTrustAnIdlePoolConnection(Integer secondsToTrustAnIdlePoolConnection) {
        this.secondsToTrustAnIdlePoolConnection = secondsToTrustAnIdlePoolConnection;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentThread() {
        return currentThread;
    }

    public void setCurrentThread(String currentThread) {
        this.currentThread = currentThread;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public String getCurrentError() {
        return currentError;
    }

    public void setCurrentError(String currentError) {
        this.currentError = currentError;
    }

    public String getCurrentErrorTimestamp() {
        return currentErrorTimestamp;
    }

    public void setCurrentErrorTimestamp(String currentErrorTimestamp) {
        this.currentErrorTimestamp = currentErrorTimestamp;
    }

    public Boolean getJDBC4Runtime() {
        return JDBC4Runtime;
    }

    public void setJDBC4Runtime(Boolean JDBC4Runtime) {
        this.JDBC4Runtime = JDBC4Runtime;
    }

    public Boolean getSupportStatementPoolable() {
        return supportStatementPoolable;
    }

    public void setSupportStatementPoolable(Boolean supportStatementPoolable) {
        this.supportStatementPoolable = supportStatementPoolable;
    }

    public Boolean getNeedRestoreClientInfo() {
        return needRestoreClientInfo;
    }

    public void setNeedRestoreClientInfo(Boolean needRestoreClientInfo) {
        this.needRestoreClientInfo = needRestoreClientInfo;
    }

    public String getDefaultClientInfo() {
        return defaultClientInfo;
    }

    public void setDefaultClientInfo(String defaultClientInfo) {
        this.defaultClientInfo = defaultClientInfo;
    }

    public Boolean getSupportIsValid() {
        return supportIsValid;
    }

    public void setSupportIsValid(Boolean supportIsValid) {
        this.supportIsValid = supportIsValid;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
