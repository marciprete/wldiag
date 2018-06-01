package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.projection.DiagnosticImageDetailProjection;
import it.senape.wldiag.jpa.projection.DiagnosticImageProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by michele.arciprete on 10-Apr-18
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ITDiagnosticImageRepositoryTest {

    @Autowired
    DiagnosticImageRepository diagnosticImageRepository;

    @Test
    public void findByFileName() {
    }

    @Test
    public void findByFileNameAndCustomerId() {
    }

    @Test
    public void findAll() {
        diagnosticImageRepository.findAll();
    }

    @Test
    public void deleteByFileNameAndCustomer_Id() {
    }

    @Test
    public void findDiagnosticImageDetails() {
        DiagnosticImageDetailProjection details = diagnosticImageRepository.findDiagnosticImageDetails(1L);
        assertNotNull(details);

        //JTA
        assertEquals("HEALTH_OK",details.getHealth());

        //JVM
        assertEquals(new Integer(33), details.getTotalThreadCount());

        //WorkManager
        assertEquals(new Long("4223964016"), details.getHeapMemoryUsedBytes());
    }

    @Test
    public void retrieveMyListOfDis() {
        Page<DiagnosticImageProjection> resp = diagnosticImageRepository.retrieveAll(PageRequest.of(0, 4));
        assertNotNull(resp);
        assertFalse(resp.getContent().isEmpty());
    }


}