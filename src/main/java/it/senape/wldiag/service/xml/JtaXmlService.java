package it.senape.wldiag.service.xml;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.xml.XMLConverter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by michele.arciprete on 03-Apr-18
 */
@Service
public class JtaXmlService {

    public JtaDto extract(ByteArrayOutputStream byteArrayOutputStream) {
        return XMLConverter.convertJTAInputStreamToObject(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    }
}
