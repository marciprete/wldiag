package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.Server;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Repository
public interface DiagnosticImageRepository extends PagingAndSortingRepository<DiagnosticImage, Long> {

    DiagnosticImage findByFileName(String fileName);

    DiagnosticImage findByFileNameAndCustomerId(String fileName, Long customerId);

    /**
     * Retrieves all the DiagnosticImages, paged, joined with the customer object
     * and the server object
     *
     * @param pageable
     * @return a Page with the DiagnosticImage
     */
    @Query(value = "select di from DiagnosticImage di "
           + "join fetch di.customer as c "
//         +   "left join fetch di.server as s"
    ,countQuery = "select count(di) from DiagnosticImage di")
    Page<DiagnosticImage> findAll(Pageable pageable);


//    /**
//     * Returns a page with all the diagnostic images, joined with the customer object
//     * and the server object, filtered by server
//     * @param server
//     * @param pageable
//     * @return
//     */
//    @Query(value = "select di from DiagnosticImage di " +
//            "join fetch di.customer as c " +
//            "left join fetch di.server as s " +
//            "where s = :server",
//            countQuery = "select count(di) from DiagnosticImage di " +
//                    "where di.server = :server")
//    Page<DiagnosticImage> findAllByServer(Server server, Pageable pageable);


}
