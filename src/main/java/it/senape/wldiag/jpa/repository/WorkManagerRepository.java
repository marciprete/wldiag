package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.workmanager.WorkManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Repository
public interface WorkManagerRepository extends CrudRepository<WorkManager, Long> {

}