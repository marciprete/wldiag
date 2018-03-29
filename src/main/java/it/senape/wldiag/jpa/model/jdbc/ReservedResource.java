package it.senape.wldiag.jpa.model.jdbc;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
//FIXME: Inheritance doesn't work with the one to many
@Entity
@PrimaryKeyJoinColumn(name="reserved_resource_id", referencedColumnName = "jdbc_resource_id")
public class ReservedResource extends JdbcResource {

}
