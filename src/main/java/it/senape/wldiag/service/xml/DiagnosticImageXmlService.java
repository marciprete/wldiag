package it.senape.wldiag.service.xml;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.service.jpa.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by michele.arciprete on 18-Jan-18.
 */
@Service
public class DiagnosticImageXmlService {

    private final Logger log = LoggerFactory.getLogger(DiagnosticImageXmlService.class);

    private StorageService storageService;
    private JtaXmlService jtaXmlService;
    private JdbcXmlService jdbcXmlService;

    @Autowired
    public DiagnosticImageXmlService(StorageService storageService, JtaXmlService jtaXmlService, JdbcXmlService jdbcXmlService) {
        this.storageService = storageService;
        this.jtaXmlService = jtaXmlService;
        this.jdbcXmlService = jdbcXmlService;
    }


    public DiagnosticImageDto extract(DiagnosticImageResource resource) {
        return extractFiles(resource);
    }

    private DiagnosticImageDto extractFiles(DiagnosticImageResource resource) {
        DiagnosticImageDto diagnosticImage = new DiagnosticImageDto();
        Path path = resource.getPath();
        diagnosticImage.setFileName(path.getFileName().toString());
        diagnosticImage.setServerName(resource.getServerName());
        diagnosticImage.setAcquisitionTime(resource.getAcquisitionTime());

        if (path != null) {
            try {
                ByteArrayOutputStream dest = null;
                ZipInputStream zipIn = new ZipInputStream(
                        new ByteArrayInputStream(Files.readAllBytes(path)));
                ZipEntry entry;
                while ((entry = zipIn.getNextEntry()) != null) {
                    if ("configuration.zip" .equalsIgnoreCase(entry.getName())) {
                        //TODO: create and extract Configuration entity
//                        extractConfiguration(zipIn);
                    } else if ("jvm.xml" .equalsIgnoreCase(entry.getName())) {
                        //TODO: create and extract jvm entity
//                        dest = getFileAsByteArrayOS(zipIn);

//                        JvmDto jvmDTO = XMLConverter.convertJvmInputStreamToObject(new ByteArrayInputStream(dest.toByteArray()));
//                        if(jvmDTO!=null) {
//                            Jta jta = convertJvnDtoToEntity(jtaDTO);
//                            jta.setDiagnosticImage(diagnosticImage);
//                            jvmRepository.save(jta);
//                        }
                    } else if ("JTA.xml" .equalsIgnoreCase(entry.getName())) {
                        dest = getFileAsByteArrayOS(zipIn);
                        JtaDto jtaDto = jtaXmlService.extract(dest);
                        diagnosticImage.setJtaDto(jtaDto);
                    } else if ("JDBC.txt".equalsIgnoreCase(entry.getName())) {
                        JdbcResourcePoolDto resourcePoolDto = jdbcXmlService.extract(new BufferedReader(new InputStreamReader(zipIn)));
                        diagnosticImage.setJdbcResourcePool(resourcePoolDto);
                    }
                    if (dest != null) {
                        dest.flush();
                        dest.close();
                    }
                }
            } catch (IOException e) {
                log.error("IO Exception reading file", e);
                diagnosticImage = null;
            }
        }
        return diagnosticImage;
    }

    private ByteArrayOutputStream getFileAsByteArrayOS(InputStream is) throws IOException {
        final int BUFFER = 4096;
        int count;
        byte data[] = new byte[BUFFER];
        ByteArrayOutputStream dest = new ByteArrayOutputStream();
        while ((count = is.read(data, 0, BUFFER))
                != -1) {
            dest.write(data, 0, count);
        }
        return dest;
    }
}
