package it.senape.wldiag.controller;

import it.senape.wldiag.jpa.bridge.TransactionMessageMapper;
import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.projection.ThreadedTransaction;
import it.senape.wldiag.jpa.repository.TransactionRepository;
import it.senape.wldiag.message.DiagnosticImagesTransactionsMessage;
import it.senape.wldiag.message.TransactionMessage;
import it.senape.wldiag.service.jpa.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
@Controller
@RequestMapping(value = "api/transactions")
@CrossOrigin("http://localhost:4200")
public class TransactionController {

    //FIXME: the repository must be moved to the service
    private TransactionRepository transactionRepository;

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService,
                                 TransactionRepository transactionRepository) {
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
    }


    @Deprecated
    @ResponseBody
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public List<TransactionMessage> showByJtaId(@PathVariable("id") Long jtaId) {
        List<Transaction> entities = transactionRepository.findCompleteTransactionFromJtaId(jtaId);
        return TransactionMessageMapper.mapEntitiesIntoDTOs(entities);
    }

    @Deprecated
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<TransactionMessage> list(Pageable pageRequest) {
        Page<Transaction> entities = transactionRepository.findAll(pageRequest);
        return TransactionMessageMapper.mapEntityPageIntoDTOPage(pageRequest, entities);
    }

    @ResponseBody
    @RequestMapping(value = "/OLDdiagnosticImage/{diagnosticImageId}", method = RequestMethod.GET)
    public ResponseEntity<DiagnosticImagesTransactionsMessage> getTransactions(@PathVariable("diagnosticImageId") Long diId) {
        return ResponseEntity.ok().body(transactionService.getDiagnosticImageTransactions(diId));
    }

    @ResponseBody
    @RequestMapping(value = "diagnosticImage/{diagnosticImageId}", method = RequestMethod.GET)
    public ResponseEntity<Collection<ThreadedTransaction>> getTransactionsByDiagnosticImageId(@PathVariable("diagnosticImageId") Long diId) {
        Collection<ThreadedTransaction> allThreadedTransaction = transactionService.findAllThreadedTransaction(diId);
        return ResponseEntity.ok().body(allThreadedTransaction);
    }
}
