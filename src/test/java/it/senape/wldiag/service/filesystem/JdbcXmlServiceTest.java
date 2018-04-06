package it.senape.wldiag.service.filesystem;

import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by michele.arciprete on 06-Apr-18
 */
class JdbcXmlServiceTest {

    private JdbcXmlService jdbcXmlService;

    @BeforeEach
    public void setUp() {
        jdbcXmlService = new JdbcXmlService();
    }

    @Test
    public void thatJdbcFileIsExtracted() throws Exception {
        String fileName = "src/test/resources/JDBC.txt";
        FileInputStream fis = new FileInputStream(fileName);
        assertNotNull(fis);
        ByteArrayOutputStream bos = Util.getFileAsByteArrayOS(fis);
        JdbcResourcePoolDto dto = jdbcXmlService.extract(bos);
        assertEquals("EBOOKING_DATASOURCE", dto.getPoolname());
    }
}