package it.senape.wldiag.fixtures;

import it.senape.wldiag.dto.ResourceDto;
import it.senape.wldiag.message.JdbcResourcePoolMessage;

/**
 * Created by michele.arciprete on 29-Mar-18
 */
public final class JdbcResourceFixtures {

    public final static String NAME = "TEST_NAME";
    public static final String TEST_STATE = "TEST_STATE";
    public static final String TEST_XID = "TEST_XID";
    public static final boolean BUSY = true;


    private JdbcResourceFixtures() {}

    public static ResourceDto createJdbcResourceDto() {
        ResourceDto dto = new ResourceDto();
        dto.setName(NAME);
        dto.setState(TEST_STATE);
        dto.setXid(TEST_XID);
        dto.setBusy(BUSY);
        return dto;
    }

    public static JdbcResourcePoolMessage createJdbcResourcePoolMessage() {
        JdbcResourcePoolMessage message = new JdbcResourcePoolMessage();
        message.setId(1L);
        message.setCurrentCapacity(1);
        message.setDeadResources(1);
        message.setAvailableResources(1);
        message.setReservedResources(1);
        message.setPoolname("Test Pool Name");
        return message;
    }
}
