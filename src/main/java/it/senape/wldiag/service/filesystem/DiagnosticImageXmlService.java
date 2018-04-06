package it.senape.wldiag.service.filesystem;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.util.Util;
import it.senape.wldiag.xml.XMLConverter;
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


    private JtaXmlService jtaXmlService;
    private JdbcXmlService jdbcXmlService;
    private WorkManagerTxtService workManagerService;

    @Autowired
    public DiagnosticImageXmlService(
            JtaXmlService jtaXmlService,
            JdbcXmlService jdbcXmlService,
            WorkManagerTxtService workManagerService) {

        this.jtaXmlService = jtaXmlService;
        this.jdbcXmlService = jdbcXmlService;
        this.workManagerService = workManagerService;
    }


    public DiagnosticImageDto extract(DiagnosticImageResource resource) {
        return extractFiles(resource);
    }

    private DiagnosticImageDto extractFiles(DiagnosticImageResource resource) {
        DiagnosticImageDto diagnosticImageDto = new DiagnosticImageDto();
        Path path = resource.getPath();
        diagnosticImageDto.setFileName(path.getFileName().toString());
        diagnosticImageDto.setServerName(resource.getServerName());
        diagnosticImageDto.setAcquisitionTime(resource.getAcquisitionTime());

        if (path != null) {
            try {
                ByteArrayOutputStream dest = null;
                ZipInputStream zipIn = new ZipInputStream(
                        new ByteArrayInputStream(Files.readAllBytes(path)));
                ZipEntry entry;
                while ((entry = zipIn.getNextEntry()) != null) {
                    dest = Util.getFileAsByteArrayOS(zipIn);
                    if ("JTA.xml" .equalsIgnoreCase(entry.getName())) {
                        JtaDto jtaDto = jtaXmlService.extract(dest);
                        diagnosticImageDto.setJtaDto(jtaDto);
                    } else if ("JDBC.txt".equalsIgnoreCase(entry.getName())) {
                        JdbcResourcePoolDto resourcePoolDto = jdbcXmlService.extract(new BufferedReader(new InputStreamReader(zipIn)));
                        diagnosticImageDto.setJdbcResourcePool(resourcePoolDto);
                    } else if ("WORK_MANAGER.txt".equalsIgnoreCase(entry.getName())) {
                        WorkManagerDto workManagerDto = workManagerService.extract(dest);
                        diagnosticImageDto.setWorkManagerDto(workManagerDto);
                    } else if ("JVM.xml".equalsIgnoreCase(entry.getName())) {
                        diagnosticImageDto.setJvmDto(XMLConverter.convertJvmInputStreamToObject(new ByteArrayInputStream(dest.toByteArray())));
                    }
                    //TODO: create and extract Configuration entity
//                    else if ("configuration.zip" .equalsIgnoreCase(entry.getName())) {
//                        extractConfiguration(zipIn);
//                    }
                    if (dest != null) {
                        dest.flush();
                        dest.close();
                    }
                }
            } catch (IOException e) {
                log.error("IO Exception reading file", e);
                diagnosticImageDto = null;
            }
        }
        return diagnosticImageDto;
    }

}
