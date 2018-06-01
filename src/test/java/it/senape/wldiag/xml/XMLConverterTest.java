package it.senape.wldiag.xml;

import it.senape.wldiag.dto.HealthDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.TransactionDto;
import it.senape.wldiag.dto.config.ConfigDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.service.jpa.JvmService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class XMLConverterTest {

    @Test
    public void testConvertJTAFileToObject() throws Exception {
        String fileName = "src\\test\\resources\\JTA.xml";
        JtaDto jta = XMLConverter.convertJTAFileToObject(fileName);
        System.out.println(jta);
        assertNotNull(jta);

        assertEquals(3600, jta.getDefaultTimeout());
        assertEquals(7200, jta.getAbandonTimeout());
        assertEquals(0, jta.getCompletionTimeout());
        assertTrue(jta.isForgetHeuristics());

        //ASSERTIONS JTA
        assertEquals(10, jta.getBeforeCompletionIterationLimit());
        assertEquals(10000,jta.getMaxTransactions());
        assertEquals(1000,jta.getMaxUniqueNameStatistics());
        assertEquals("_WLS_ManagedServer_1",jta.getTlogStoreName());
        assertEquals("_WLS_ManagedServer_1",jta.getHlogStoreName());
        assertEquals(1513171401858L,jta.getLastCheckpointTime());
        assertEquals(300000L,jta.getCheckpointInterval());
        assertTrue(jta.isParallelXAEnabled());
        assertTrue(jta.isForgetHeuristics());

        //ASSERTIONS HEALTH
        HealthDto health = jta.getHealth();
        assertNotNull(health);
        assertNotNull(health.getHealthState());
        assertEquals("HEALTH_OK", health.getHealthState().getState().toString());

        //TRANSACTIONS
        Collection<TransactionDto> transactions = jta.getTransactions();
        assertNotNull(transactions);
        assertEquals(3, transactions.size());
        transactions.forEach(t->{
            assertNotEquals(java.util.Optional.of(0L),t.getBeginTime());
        });

    }

    @Test
    public void testConvertJVMFileToObject() throws Exception {
        String fileName = "src\\test\\resources\\JVM.xml";
        JvmDto jvmDto = XMLConverter.convertJvmFileToObject(fileName);
        assertNotNull(jvmDto);
    }


    @Test
    public void testConvertConfigFile() throws Exception {
        String fileName = "src/integration-test/resources/exploded_di/configuration/config/config.xml";
        ConfigDto configDto = XMLConverter.convertConfigFileToObject(fileName);
        System.out.println(configDto.getName());
        System.out.println(configDto.getDomainVersion());
        System.out.println(configDto.getServers());
    }
}