package it.senape.wldiag.dto;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
public class CustomerDto {

    private String name;
    private String code;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
