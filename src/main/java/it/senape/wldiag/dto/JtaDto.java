package it.senape.wldiag.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Data
@XmlRootElement(name = "JTA")
@XmlAccessorType(XmlAccessType.FIELD)
public class JtaDto implements Serializable {
    @XmlAttribute
    private int defaultTimeout;//="3600"
    @XmlAttribute
    private int abandonTimeout;//="7200"
    @XmlAttribute
    private int completionTimeout;//="0"
    @XmlAttribute
    private boolean forgetHeuristics;//="true"
    @XmlAttribute
    private int beforeCompletionIterationLimit;//="10"
    @XmlAttribute
    private int maxTransactions;//="10000"
    @XmlAttribute
    private int maxUniqueNameStatistics;//="1000"
    @XmlAttribute
    private String tlogStoreName;//="_WLS_ManagedServer_1"
    @XmlAttribute
    private String hlogStoreName;//="_WLS_ManagedServer_1"
    @XmlAttribute
    private long lastCheckpointTime;//="1513171401858"
    @XmlAttribute
    private long checkpointInterval;//="300000"
    @XmlAttribute
    private boolean parallelXAEnabled;//="true"
    @XmlAttribute
    private boolean twoPhaseEnabled;//="false"

    @XmlElement(name="Health")
    private HealthDto health;

    @XmlElementWrapper(name="TxMap")
    @XmlElement(name = "Transaction")

    private Collection<TransactionDto> transactions;

    @XmlElement(name = "TMXAResource")
    private TMXAResourceDto tmxaResource;

    @XmlElementWrapper(name = "Servers")
    @XmlElement(name="Server")
    private Set<ServerDto> servers;

    @XmlElementWrapper(name = "Resources")
    @XmlElement(name = "XAResource")
    private Set<XAResourceDto> resources;

    @XmlTransient
    private Long diagnosticImageId;

    @XmlTransient
    private Long customerId;

    @XmlTransient
    private String serverLabel;

}
