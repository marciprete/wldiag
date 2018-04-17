package it.senape.wldiag.dto;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
public class EjbTransactionPropertyDto implements Serializable {

    private Long id;
    private String fqnClassName;
    private String simpleClassName;
    private String method;
    private String arguments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFqnClassName() {
        return fqnClassName;
    }

    public void setFqnClassName(String fqnClassName) {
        this.fqnClassName = fqnClassName;
    }

    public String getSimpleClassName() {
        return simpleClassName;
    }

    public void setSimpleClassName(String simpleClassName) {
        this.simpleClassName = simpleClassName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
}
