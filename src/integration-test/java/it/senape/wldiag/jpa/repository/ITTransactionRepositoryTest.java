package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.projection.ThreadedTransactionProjection;
import it.senape.wldiag.jpa.projection.TransactionProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by michele.arciprete on 07-Apr-18
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ITTransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

//    @Test
//    public void whenDiExists_findAllByDiagnosticImageId_returnValues() throws Exception {
//        assertNotNull(transactionRepository);
//
//        long count = transactionRepository.count();
//        System.out.println(count);
//
//        assertTrue(count >0);
//
//        Collection<DiagnosticImageDetailImpl> transactions = transactionRepository.findAllByDiagnosticImageId(1L);
//        assertFalse(transactions.isEmpty());
////        assertEquals(25,transactions.size());
//    }

//    @Test
//    public void findAllByDiagnosticImageId() throws Exception {
//        Transaction t = new Transaction();
//        t.setCoordinatorURL("Ciccio");
//        t.setOwnerTM("Pasticcio");
//        assertNotNull(transactionRepository);
//        t = transactionRepository.save(t);
//        assertEquals(new Long(1), t.getId());
//    }


    @Test
    public void threadedTransaction() throws Exception {
        Pageable pageRequest =  PageRequest.of(0,25);
        Page<ThreadedTransactionProjection> jess = transactionRepository.findAllThreadedTransaction(1l, pageRequest);

        assertEquals(25, jess.getTotalElements());

        //        Collection<DiagnosticImageTransaction> jess = transactionRepository.findAllThreadedTransaction(1l);
        jess.forEach(threadedTransaction -> {
            System.out.println("*****************************************");
            System.out.println(threadedTransaction.getXid());
            System.out.println(threadedTransaction.getStatus());
            System.out.println(threadedTransaction.getBeginTime());

            System.out.println(threadedTransaction.getClassName());
            System.out.println(threadedTransaction.getMethod());
            System.out.println(threadedTransaction.getArguments());

            System.out.println(threadedTransaction.getThreadName());
            System.out.println(threadedTransaction.getWlsStatus());
            System.out.println(threadedTransaction.getPoolNumber());

            System.out.println(threadedTransaction.getExtraInfo());
            System.out.println(threadedTransaction.getStartedTimeMillis());
        });
        System.out.println("*****************************************");
    }



    @Test
    public void retrieveAll() throws Exception {
        Page<TransactionProjection> resp = transactionRepository.retrieveAll(PageRequest.of(0, 10));
        assertTrue(resp.hasContent());
        resp.getContent().forEach( tp -> {
            System.out.println(tp.getEjbTransactionSignature());
            System.out.println("***");
        });
    }
}