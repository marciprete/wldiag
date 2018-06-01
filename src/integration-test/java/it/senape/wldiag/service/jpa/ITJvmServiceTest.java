package it.senape.wldiag.service.jpa;

import it.senape.wldiag.jpa.model.jvm.ThreadDump;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by michele.arciprete on 19-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ITJvmServiceTest {

    @Autowired
    JvmService jvmService;

    @Test
    public void extractThreadDumps() throws Exception {
        assertNotNull(jvmService);

        String threadDump = FileUtils.readFileToString(new File("src/integration-test/resources/nine_threads.txt"));
        Map<String, ThreadDump> threadDumpMap = jvmService.extractThreadDumps(threadDump);
        System.out.println(threadDumpMap.keySet());
        assertEquals(9, threadDumpMap.size());

        List<String> keys = Arrays.asList("0x0000000036958000", "0x00000000651c4800", "0x000000003f805000",
                "[STUCK] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)'",
                "0x000000003dd90800", "0x000000000109c800", "0x0000000050660000", "0x0000000001085800",
                "[STUCK] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)'");

        String k1 = "0x0000000036958000";
        String k2 = "0x00000000651c4800";
        String k3 = "0x000000003f805000";
        String k4 = "[STUCK] ExecuteThread: '24' for queue: 'weblogic.kernel.Default (self-tuning)'";
        String k5 = "0x000000003dd90800";
        String k6 = "0x000000000109c800";
        String k7 = "0x0000000050660000";
        String k8 = "0x0000000001085800";
        String k9 = "[STUCK] ExecuteThread: '1' for queue: 'weblogic.kernel.Default (self-tuning)']";



    }


    @Test
    public void testThatAllAreExtracted() throws Exception {
        final String threads = FileUtils.readFileToString(new File("src/integration-test/resources/all_threads.txt"));

        Map<String, ThreadDump> threadDumpMap = jvmService.extractThreadDumps(threads);
        assertEquals(169, threadDumpMap.size());
    }
}