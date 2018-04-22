package it.senape.wldiag.service.jpa;

import it.senape.wldiag.jpa.bridge.TransactionMessageMapper;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.Jta;
import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.model.jvm.Jvm;
import it.senape.wldiag.jpa.model.workmanager.WorkManager;
import it.senape.wldiag.jpa.projection.ThreadedTransactionProjection;
import it.senape.wldiag.jpa.projection.TopClassProjection;
import it.senape.wldiag.jpa.projection.TopMethodProjection;
import it.senape.wldiag.jpa.projection.TransactionProjection;
import it.senape.wldiag.jpa.repository.EjbTransactionRepository;
import it.senape.wldiag.jpa.repository.TransactionRepository;
import it.senape.wldiag.message.DiagnosticImagesTransactionsMessage;
import it.senape.wldiag.message.TransactionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by michele.arciprete on 07-Apr-18
 */
@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private EjbTransactionRepository ejbTransactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository,
                              EjbTransactionRepository ejbTransactionRepository) {
        this.transactionRepository = transactionRepository;
        this.ejbTransactionRepository = ejbTransactionRepository;
    }

    public Page<ThreadedTransactionProjection> findAllThreadedTransaction(Long diagnosticImageId, Pageable pageRequest) {
        return transactionRepository.findAllThreadedTransaction(diagnosticImageId, pageRequest);
    }

    public long count() {
        return transactionRepository.count();
    }

    public List<TopMethodProjection> getTopMethods() {
        return ejbTransactionRepository.getTopMethods();
    }

    public List<TopClassProjection> getTopClasses() {
        return ejbTransactionRepository.getTopClasses();
    }


    public Page<TransactionMessage> findAll(Pageable pageRequest) {
        Page<TransactionProjection> projection = transactionRepository.retrieveAll(pageRequest);
        return TransactionMessageMapper.mapProjectionPageIntoDTOPage(projection, pageRequest);
    }
}
