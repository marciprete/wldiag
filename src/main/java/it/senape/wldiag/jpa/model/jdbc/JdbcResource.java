package it.senape.wldiag.jpa.model.jdbc;

import it.senape.wldiag.jpa.model.AbstractEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type")
@AttributeOverride(name = "id", column = @Column(name="jdbc_resource_id"))
public class JdbcResource extends AbstractEntity<Long> {

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

    @Column(name = "jdbc_current_user")
    private String currentUser; //null

    private String currentThread; //null
    private String lastUser; //null
    private String currentError; //null
    private String currentErrorTimestamp; //null
    private Boolean JDBC4Runtime; //true
    private Boolean supportStatementPoolable; //true
    private Boolean needRestoreClientInfo; //false
    private String defaultClientInfo; //{}
    private Boolean supportIsValid; //true

    @Type(type="text")
    private String stackTrace;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    @JoinColumn(name = "jdbc_resource_pool_id")
    private JdbcResourcePool resourcePool;

    public JdbcResourcePool getResourcePool() {
        return resourcePool;
    }

    public void setResourcePool(JdbcResourcePool resourcePool) {
        this.resourcePool = resourcePool;
    }

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

    public Boolean getIsXA() {
        return isXA;
    }

    public void setIsXA(Boolean XA) {
        isXA = XA;
    }

    public Boolean getIsJTS() {
        return isJTS;
    }

    public void setIsJTS(Boolean JTS) {
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

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
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

    @Override
    public String toString() {
        return "JdbcResource{" +
                ", autoCommit=" + autoCommit +
                ", enabled=" + enabled +
                ", isXA=" + isXA +
                ", isJTS=" + isJTS +
                ", vendorID=" + vendorID +
                ", connUsed=" + connUsed +
                ", doInit=" + doInit +
                ", destroyed=" + destroyed +
                ", poolname='" + poolname + '\'' +
                ", appname='" + appname + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", connectTime=" + connectTime +
                ", dirtyIsolationLevel=" + dirtyIsolationLevel +
                ", initialIsolationLevel=" + initialIsolationLevel +
                ", infected=" + infected +
                ", lastSuccessfulConnectionUse=" + lastSuccessfulConnectionUse +
                ", secondsToTrustAnIdlePoolConnection=" + secondsToTrustAnIdlePoolConnection +
                ", currentUser='" + currentUser + '\'' +
                ", currentThread='" + currentThread + '\'' +
                ", lastUser='" + lastUser + '\'' +
                ", currentError='" + currentError + '\'' +
                ", currentErrorTimestamp='" + currentErrorTimestamp + '\'' +
                ", JDBC4Runtime=" + JDBC4Runtime +
                ", supportStatementPoolable=" + supportStatementPoolable +
                ", needRestoreClientInfo=" + needRestoreClientInfo +
                ", defaultClientInfo='" + defaultClientInfo + '\'' +
                ", supportIsValid=" + supportIsValid +
                ", stackTrace='" + stackTrace + '\'' +
//                ", resourceType=" + resourceType +
                '}';
    }
}