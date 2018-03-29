package it.senape.wldiag.dto;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 17-Jan-18.
 */
public class SystemPropertyDto implements Serializable {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
