package it.senape.wldiag.dto.config;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 25-Apr-18
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigServerDto implements Serializable {

    private String name;

    @XmlElement(name="reverse-dns-allowed")
    private Boolean reverseDnsAllowed;

    @XmlElement(name = "self-tuning-thread-pool-size-min")
    private Long selfTuningThreadPoolSizeMin;

    @XmlElement(name = "self-tuning-thread-pool-size-max")
    private Long selfTuningThreadPoolSizeMax;

    @XmlElement(name = "native-io-enabled")
    private Boolean nativeIOEnabled;

    @XmlElement(name = "muxer-class")
    private String muxerClass;

    @XmlElement(name = "period-length")
    private Long periodLength;

    @XmlElement(name = "listen-port")
    private Long listenPort;

    @XmlElement(name = "server-address")
    private String serverAddress;


    @XmlTransient
    private String label;

}
    /*
    <name>ManagedServer_1</name>
    <reverse-dns-allowed>false</reverse-dns-allowed>
    <>1</self-tuning-thread-pool-size-min>
    <self-tuning-thread-pool-size-max>400</self-tuning-thread-pool-size-max>
    <native-io-enabled>true</native-io-enabled>
    <muxer-class>weblogic.socket.PosixSocketMuxer</muxer-class>
    <period-length>60000</period-length>
    <idle-periods-until-timeout>4</idle-periods-until-timeout>
    <dgc-idle-periods-until-timeout>5</dgc-idle-periods-until-timeout>
    <max-open-sock-count>-1</max-open-sock-count>
    <stuck-thread-max-time>600</stuck-thread-max-time>
    <stuck-thread-timer-interval>60</stuck-thread-timer-interval>
    <gathered-writes-enabled>false</gathered-writes-enabled>
    <scattered-reads-enabled>false</scattered-reads-enabled>
    <use-concurrent-queue-for-request-manager>false</use-concurrent-queue-for-request-manager>
    <machine>Machine_1</machine>
    <listen-port>7011</listen-port>

    <ssl>
      <name>ManagedServer_1</name>
      <enabled>true</enabled>
      <hostname-verification-ignored>true</hostname-verification-ignored>
      <listen-port>7503</listen-port>
      <login-timeout-millis>25000</login-timeout-millis>
      <server-private-key-alias>servercert</server-private-key-alias>
      <server-private-key-pass-phrase-encrypted>{AES}yP+efuB7JXTE2l8fUlMvsEdlBVtD8KUi9BF0fysvotw=</server-private-key-pass-phrase-encrypted>
    </ssl>
*/
