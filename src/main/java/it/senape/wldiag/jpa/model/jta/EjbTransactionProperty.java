package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 16-Dec-17.
 */
@Entity
@Table(name = "ejb_transaction")
@PrimaryKeyJoinColumn(name="ejb_transaction_id", referencedColumnName = "property_id")
public class EjbTransactionProperty extends Property {
    private String className;

    @Column(length = 750)
    private String method;

    @Column(length = 750)
    private String arguments;

    public EjbTransactionProperty() {}

    public EjbTransactionProperty(Property property) {
        super.setName(property.getName());
        super.setValue(property.getValue());
        super.setTransaction(property.getTransaction());
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

    @Override
    public String toString() {
        return "EjbTransaction{" +
                "className='" + className + '\'' +
                ", method='" + method + '\'' +
                ", arguments='" + arguments + '\'' +
                '}';
    }
}
