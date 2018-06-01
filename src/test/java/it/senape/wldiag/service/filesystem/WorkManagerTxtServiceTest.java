package it.senape.wldiag.service.filesystem;

import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.util.Util;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
class WorkManagerTxtServiceTest {

    private WorkManagerTxtService workManagerService = new WorkManagerTxtService();

    @Test
    void extract() throws Exception {
        String fileName = "src/test/resources/WORK_MANAGER.txt";
        FileInputStream fis = new FileInputStream(fileName);
        assertNotNull(fis);
        WorkManagerDto dto = workManagerService.extract(Util.getFileAsByteArrayOS(fis));
        assertEquals(new Integer(33), dto.getTotalThreadCount());
        assertEquals(new Integer(4), dto.getIdleThreadCount());
        assertEquals(new Integer(1), dto.getStandbyThreadCount());
        assertEquals(new Integer(0), dto.getQueueDepth());
        assertEquals(new Long(4191883), dto.getQueueDepartures());
        assertEquals(new Double(12.921089063221043), dto.getMeanThroughput());
        assertEquals(new Integer(28), dto.getTotalRequests());
    }
}