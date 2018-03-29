package it.senape.wldiag.xml;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jvm.JvmDto;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class XMLConverter {

    public static JtaDto convertJTAFileToObject(String fileName) {
        JtaDto jta = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JtaDto.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(fileName);
            jta = (JtaDto) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return jta;
    }

    public static JtaDto convertJTAInputStreamToObject(InputStream fileInputStream) {
        JtaDto jta = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JtaDto.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jta = (JtaDto) jaxbUnmarshaller.unmarshal(fileInputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return jta;
    }

    public static JvmDto convertJvmInputStreamToObject(InputStream byteArrayInputStream) {
        JvmDto jta = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JvmDto.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jta = (JvmDto) jaxbUnmarshaller.unmarshal(byteArrayInputStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return jta;
    }

    public static DomainType convertDomainInputStreamToObject(ByteArrayInputStream byteArrayInputStream) {
        DomainType domainType = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DomainType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            domainType = ((JAXBElement<DomainType>) jaxbUnmarshaller.unmarshal(byteArrayInputStream)).getValue();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return domainType;
    }
}
