package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.InternalThread;
import it.senape.wldiag.jpa.model.jvm.ThreadDump;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * Created by michele.arciprete on 07-Apr-18
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ITInternalThreadRepositoryTest {

    @Autowired
    private InternalThreadRepository repo;

    @Test
    public void findByDiagnosticImageIdAndNames_criteriaMatch_shouldReturnAList() throws Exception {
        Long diagnosticImageId = 1l;
        Collection<String> threadNames = Arrays.asList("[ACTIVE] ExecuteThread: '18' for queue: 'weblogic.kernel.Default (self-tuning)'", "[STUCK] ExecuteThread: '17' for queue: 'weblogic.kernel.Default (self-tuning)'");
        List<InternalThread> threadList = repo.findAllByDiagnosticImageIdAndNameIn(diagnosticImageId, threadNames);
        assertFalse(threadList.isEmpty());
    }


//    @Test
//    public void findAllDumpedThreads() throws Exception {
//        Page<ThreadDump> dumpedThreads = repo.findAllDumpedThreads(PageRequest.of(0,10));
//        assertFalse(dumpedThreads.getContent().isEmpty());
//    }
}