package it.senape.wldiag.controller;

import it.senape.wldiag.jpa.bridge.TransactionMessageMapper;
import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.projection.ThreadedTransactionProjection;
import it.senape.wldiag.jpa.projection.TopClassProjection;
import it.senape.wldiag.jpa.projection.TopMethodProjection;
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
        return transactionService.findAll(pageRequest);
    }

    @ResponseBody
    @RequestMapping(value = "diagnosticImage/{diagnosticImageId}", method = RequestMethod.GET)
    public ResponseEntity<Page<ThreadedTransactionProjection>> getTransactionsByDiagnosticImageId(@PathVariable("diagnosticImageId") Long diId,
                                                                                                  Pageable pageRequest) {
        Page<ThreadedTransactionProjection> allThreadedTransaction = transactionService.findAllThreadedTransaction(diId,pageRequest);
        return ResponseEntity.ok().body(allThreadedTransaction);
    }

    @ResponseBody
    @RequestMapping(value = "/topClasses", method=RequestMethod.GET)
    public ResponseEntity<List<TopClassProjection>> getTopClasses() {
        return ResponseEntity.ok(transactionService.getTopClasses());
    }

    @ResponseBody
    @RequestMapping(value = "/topMethods", method=RequestMethod.GET)
    public ResponseEntity<List<TopMethodProjection>> getTopMethods() {
        return ResponseEntity.ok(transactionService.getTopMethods());
    }

    @ResponseBody
    @RequestMapping(value = "/count", method=RequestMethod.GET)
    public long count() {
        return transactionService.count();
    }


    @ResponseBody
    @RequestMapping(value = "/threads", method=RequestMethod.GET)
    public String findAllThreads() {
//        return transactionService.findAllThreads();
        return null;
    }
}
