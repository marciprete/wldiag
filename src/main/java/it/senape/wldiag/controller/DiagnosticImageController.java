package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.exceptions.StorageException;
import it.senape.wldiag.service.internal.DiagnosticImageService;
import it.senape.wldiag.service.internal.StorageProperties;
import it.senape.wldiag.service.internal.StorageService;
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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Controller
@RequestMapping(value = UrlMappings.API_DIAGNOSTIC_IMAGE)
@CrossOrigin("http://localhost:4200")
public class DiagnosticImageController {

    private static final Logger log = LoggerFactory.getLogger(DiagnosticImageController.class);
    public static final String SAVE_SUCCESSFUL = "Save successful";
    public static final String SAVE_FAILED = "Save failed";
    public static final String UPLOAD_FAILED_FILENAME_NOT_VALID = "Upload failed - Filename not valid";

    StorageService storageService;
    DiagnosticImageService diagnosticImageService;

    @Autowired
    public DiagnosticImageController(StorageService storageService,
                                     DiagnosticImageService diagnosticImageService) {
        this.storageService = storageService;
        this.diagnosticImageService = diagnosticImageService;
    }


    @ResponseBody
    @RequestMapping(value = UrlMappings.SHOW + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DiagnosticImageDto> show(@PathVariable("id") Long id) {
        DiagnosticImageDto dto = diagnosticImageService.findById(id);
        if (dto != null && dto.getFileName()!=null) {
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.LIST, method = RequestMethod.GET)
    public Page<DiagnosticImageDto> list(Pageable pageRequest) {
        log.debug("Listing diangostic images");
        return diagnosticImageService.findLatest(pageRequest);
    }

    @ResponseBody
    @RequestMapping(value = UrlMappings.ADD, method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> upload(@RequestParam("diagnosticImage") List<MultipartFile> files,
                         @RequestParam("customerId") Long customer,
                         RedirectAttributes redirectAttributes) {

        Map<String, String> results = new LinkedHashMap<>();

        if(files.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(results);
        }
        files.forEach(file -> {
            String fileName = file.getOriginalFilename();
            if(fileName.matches(StorageProperties.DIAGNOSTIC_IMAGE_FILENAME_PATTERN)) {
                try {
                    storageService.store(file);
                    if(diagnosticImageService.save(fileName, customer)) {
                        log.info(SAVE_SUCCESSFUL);
                        results.put(fileName, SAVE_SUCCESSFUL);
                    } else {
                        results.put(fileName, SAVE_FAILED);
                    }
                } catch (StorageException se) {
                    log.error("Problem saving file", se);
                    results.put(fileName, se.getMessage());
                }
            } else {
                log.error("File name not valid");
                results.put(fileName, UPLOAD_FAILED_FILENAME_NOT_VALID);
            }
        });

        return ResponseEntity.ok(results);
    }

}
