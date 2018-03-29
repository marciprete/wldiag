package it.senape.wldiag.dto;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
public class EjbTransactionPropertyDto implements Serializable {
    private Long id;
    private String className;
    private String method;
    private String arguments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
