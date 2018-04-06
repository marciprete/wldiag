package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jvm.Jvm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 06-Apr-18
 */
@Repository
public interface JvmRepository extends CrudRepository<Jvm, Long> {
}