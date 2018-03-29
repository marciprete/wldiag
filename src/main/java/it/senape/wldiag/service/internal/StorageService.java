package it.senape.wldiag.service.internal;

import it.senape.wldiag.exceptions.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public interface StorageService {

    void store(MultipartFile file) throws StorageException;

    Path load(String filename);

    Resource loadAsResource(String filename);

}
