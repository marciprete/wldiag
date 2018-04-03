package it.senape.wldiag.jpa.model.internal;

import it.senape.wldiag.jpa.model.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Entity
public class Customer extends AbstractEntity<Long> {

   private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private Set<DiagnosticImage> diagnosticImages;

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

    public Set<DiagnosticImage> getDiagnosticImages() {
        return diagnosticImages;
    }

    public void setDiagnosticImages(Set<DiagnosticImage> diagnosticImages) {
        this.diagnosticImages = diagnosticImages;
    }
}
