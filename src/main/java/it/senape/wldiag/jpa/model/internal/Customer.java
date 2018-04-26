package it.senape.wldiag.jpa.model.internal;

import it.senape.wldiag.jpa.model.AbstractEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Data
@Entity
@ToString(exclude = {"diagnosticImages"})
public class Customer extends AbstractEntity<Long> {

   private String name;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private Set<DiagnosticImage> diagnosticImages;

}
