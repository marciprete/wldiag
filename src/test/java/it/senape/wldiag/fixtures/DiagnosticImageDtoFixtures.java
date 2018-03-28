package it.senape.wldiag.fixtures;

import it.senape.wldiag.dto.DiagnosticImageDto;

public class DiagnosticImageDtoFixtures {

    public static final String TEST_TILE_NAME = "Test file name";
    public static final String TEST_CUSTOMER_NAME = "Test Customer Name";

    public static DiagnosticImageDto createDiagnosticImageDto() {
        DiagnosticImageDto dto = new DiagnosticImageDto();
        dto.setFileName(TEST_TILE_NAME);
        dto.setCustomerName(TEST_CUSTOMER_NAME);
        dto.setImageId(1L);
        return dto;
    }
}
