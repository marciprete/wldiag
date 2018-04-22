package it.senape.wldiag.fixtures;

import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.projection.DiagnosticImageProjection;

import java.time.LocalDateTime;

public class DiagnosticImageFixtures {

    public static final String TEST_TILE_NAME = "Test file name";
    public static final Long TEST_ID = 1L;
    public static final LocalDateTime NOW = LocalDateTime.now();
    public static final String CUSTOMER_NAME = "Test customer name";
    public static final Long CUSTOMER_ID = 1L;

    public static DiagnosticImage createDiagnosticImage() {
        DiagnosticImage diagnosticImage = new DiagnosticImage();
        diagnosticImage.setId(TEST_ID);
        diagnosticImage.setFileName(TEST_TILE_NAME);
        diagnosticImage.setAcquisitionTime(NOW);
        Customer c = new Customer();
        c.setName(CUSTOMER_NAME);
        diagnosticImage.setCustomer(c);
        return diagnosticImage;
    }

    public static DiagnosticImageProjection createProjection() {
        return new DiagnosticImageProjectionImpl(createDiagnosticImage());
    }

    private static class DiagnosticImageProjectionImpl implements DiagnosticImageProjection {
        private DiagnosticImage di;
        public DiagnosticImageProjectionImpl(DiagnosticImage di) {
            this.di = di;
        }

        @Override
        public Long getId() {
            return di.getId();
        }

        @Override
        public String getName() {
            return di.getFileName();
        }

        @Override
        public LocalDateTime getAcquisitionTime() {
            return di.getAcquisitionTime();
        }

        @Override
        public Long getCustomerId() {
            return di.getCustomer().getId();
        }

        @Override
        public String getCustomerName() {
            return di.getCustomer().getName();
        }
    }
}
