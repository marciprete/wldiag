package it.senape.wldiag.controller;

import it.senape.wldiag.jpa.bridge.TransactionMessageMapper;
import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.repository.TransactionRepository;
import it.senape.wldiag.message.TransactionsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @ResponseBody
    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public List<TransactionsMessage> showByJtaId(@PathVariable("id") Long jtaId) {
        List<Transaction> entities = transactionRepository.findCompleteTransactionFromJtaId(jtaId);
        return TransactionMessageMapper.mapEntitiesIntoDTOs(entities);
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Page<TransactionsMessage> list(Pageable pageRequest) {
        Page<Transaction> entities = transactionRepository.findAll(pageRequest);
        return TransactionMessageMapper.mapEntityPageIntoDTOPage(pageRequest, entities);
    }

}
