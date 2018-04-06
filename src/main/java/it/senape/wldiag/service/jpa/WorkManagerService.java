package it.senape.wldiag.service.jpa;

import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.workmanager.WorkManager;
import it.senape.wldiag.jpa.repository.WorkManagerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Service
public class WorkManagerService {

    private WorkManagerRepository workManagerRepository;

    @Autowired
    public WorkManagerService(WorkManagerRepository workManagerRepository) {
        this.workManagerRepository = workManagerRepository;
    }

    public WorkManagerDto save(WorkManagerDto workManagerDto) {
        WorkManager workManager = new WorkManager();
        DiagnosticImage di = new DiagnosticImage();
        di.setId(workManagerDto.getDiagnosticImageId());
        workManager.setDiagnosticImage(di);
        BeanUtils.copyProperties(workManagerDto, workManager);
        workManager = workManagerRepository.save(workManager);
        return workManagerDto;
    }
}
