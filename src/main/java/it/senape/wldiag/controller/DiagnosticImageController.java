package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.exceptions.StorageException;
import it.senape.wldiag.jpa.projection.DiagnosticImageDetailProjection;
import it.senape.wldiag.service.filesystem.DiagnosticImageResource;
import it.senape.wldiag.service.filesystem.DiagnosticImageXmlService;
import it.senape.wldiag.service.jpa.DiagnosticImageService;
import it.senape.wldiag.service.jpa.StorageProperties;
import it.senape.wldiag.service.jpa.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Controller
@RequestMapping(value = UrlMappings.API_DIAGNOSTIC_IMAGE)
@CrossOrigin("http://localhost:4200")
public class DiagnosticImageController {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticImageController.class);

    public static final String SAVE_SUCCESSFUL = "Save successful";
    public static final String SAVE_FAILED = "Save failed";
    public static final String UPLOAD_FAILED_FILENAME_NOT_VALID = "Upload failed - Filename not valid";

    private StorageService storageService;
    private DiagnosticImageService diagnosticImageService;
    private DiagnosticImageXmlService diagnosticImageXmlService;


    @Autowired
    public DiagnosticImageController(StorageService storageService,
                                     DiagnosticImageService diagnosticImageService,
                                     DiagnosticImageXmlService diagnosticImageXmlService
    ) {
        this.storageService = storageService;
        this.diagnosticImageService = diagnosticImageService;
        this.diagnosticImageXmlService = diagnosticImageXmlService;
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.SHOW + "/n/{naturalId}", method = RequestMethod.GET)
    public ResponseEntity<DiagnosticImageDto> showDetailsByNaturalId(@PathVariable("naturalId") String fileName) {
        if(fileName!=null) {
            return ResponseEntity.ok(diagnosticImageService.findByFileName(fileName));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @ResponseBody
    @RequestMapping(value = UrlMappings.SHOW + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DiagnosticImageDetailProjection> show(@PathVariable("id") Long id) {
        logger.trace(">> Show diagnostic image with id: {}", id);
        DiagnosticImageDetailProjection dto = diagnosticImageService.getDiagnosticImageDetails(id);
        if (dto != null && dto.getFileName()!=null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        logger.trace("<< Show diagnostic image");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.LIST, method = RequestMethod.GET)
    public Page<DiagnosticImageDto> list(Pageable pageRequest) {
        logger.trace("Listing diangostic images");
        return diagnosticImageService.findLatest(pageRequest);
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.ADD, method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> upload(@RequestParam("diagnosticImage") List<MultipartFile> files,
                         @RequestParam("customerId") Long customerId,
                         @RequestParam("serverLabel") String serverLabel,
                         RedirectAttributes redirectAttributes) {
        logger.trace("Upload {} file(s) for customer with id {}", files.size(), customerId);
        Map<String, String> results = new LinkedHashMap<>();

        if(files.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(results);
        }

        if (customerId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(results);
        }

        files.forEach(file -> {
            DiagnosticImageResource resource = null;
            boolean fileValid = false;

            String fileName = file.getOriginalFilename();
            Pattern pattern = Pattern.compile(StorageProperties.DIAGNOSTIC_IMAGE_FILENAME_PATTERN);
            Matcher matcher = pattern.matcher(fileName);

            while (matcher.find()) {
                fileValid = true;

                Path path = storageService.load(fileName);
                String serverName = matcher.group(1);
                Integer year = Integer.parseInt(matcher.group(2));
                Integer month = Integer.parseInt(matcher.group(3));
                Integer day = Integer.parseInt(matcher.group(4));
                Integer hour = Integer.parseInt(matcher.group(5));
                Integer min = Integer.parseInt(matcher.group(6));
                Integer sec = Integer.parseInt(matcher.group(7));

                LocalDateTime imageTime = LocalDateTime.of(year, month, day, hour, min, sec);
                resource = new DiagnosticImageResource(path, serverName, serverLabel, imageTime);
            }

            if(fileValid) {
                try {
                    storageService.store(file);

                    DiagnosticImageDto dto = diagnosticImageXmlService.extract(resource);
                    dto.setCustomerId(customerId);
                    if(diagnosticImageService.save(dto)) {
                        logger.info(SAVE_SUCCESSFUL);
                        results.put(fileName, SAVE_SUCCESSFUL);
                    } else {
                        results.put(fileName, SAVE_FAILED);
                    }
                } catch (StorageException se) {
                    logger.error("Problem saving file", se);
                    results.put(fileName, se.getMessage());
                }
            } else {
                logger.error("File name not valid");
                results.put(fileName, UPLOAD_FAILED_FILENAME_NOT_VALID);
            }
        });

        return ResponseEntity.ok(results);
    }


    @ResponseBody
    @RequestMapping(value = "{diagnosticImage}/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("diagnosticImage") String fileName,
                                         @PathVariable("customerId") Long customerId) {
        try {
            diagnosticImageService.delete(fileName, customerId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("OK");
    }


    @ResponseBody
    @RequestMapping(value = "count", method = RequestMethod.GET)
    public long count() {
        return diagnosticImageService.count();
    }

}
