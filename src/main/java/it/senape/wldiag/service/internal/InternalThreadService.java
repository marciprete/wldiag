package it.senape.wldiag.service.internal;

import it.senape.wldiag.jpa.model.jta.InternalThread;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
public interface InternalThreadService {

    InternalThread save(String activeThread);

}
