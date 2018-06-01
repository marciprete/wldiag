package it.senape.wldiag.service.jpa.impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.service.jpa.DiagnosticImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by michele.arciprete on 17-Apr-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ITDiagnosticImageServiceImplTest {


    @Autowired
    DiagnosticImageService diagnosticImageService;

    @Test
    public void findLatest() {
        assertNotNull(diagnosticImageService);
        Page<DiagnosticImageDto> resp = diagnosticImageService.findLatest(PageRequest.of(0, 10));
    }
}