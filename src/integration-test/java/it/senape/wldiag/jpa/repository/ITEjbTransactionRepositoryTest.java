package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.projection.TopMethodProjection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by michele.arciprete on 14-Apr-18
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ITEjbTransactionRepositoryTest {

    @Autowired
    EjbTransactionRepository repo;

    @Test
    public void findTopMethods() {

        List<TopMethodProjection> topMethods = repo.getTopMethods();

        assertEquals(5, topMethods.size());
    }
}