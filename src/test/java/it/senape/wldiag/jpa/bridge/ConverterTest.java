package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.xml.XMLConverter;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michele.arciprete on 17-Dec-17.
 */
public class ConverterTest {

    @Test
    public void testConvertDtoToEntity() throws Exception {
        String fileName = "src\\test\\resources\\JTA.xml";
        JtaDto dto = XMLConverter.convertJTAFileToObject(fileName);

        assertNotNull(dto);
//        Jta jta = Converter.convertDtoToEntity(dto);
//        assertNotNull(jta);
//        assertNotNull(jta.getTransactions());
//        jta.getTransactions().forEach( t -> {
//                assertNotNull(t);
//                assertNotNull(t.getGlobalProperties());
//                t.getGlobalProperties().forEach( p -> {
//                    assertNotNull(p);
//                    System.out.println(p);
//                });
//            }
//        );
    }
}