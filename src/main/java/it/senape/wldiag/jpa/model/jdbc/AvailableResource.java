package it.senape.wldiag.jpa.model.jdbc;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Entity
@PrimaryKeyJoinColumn(name="available_resource_id", referencedColumnName = "jdbc_resource_id")
public class AvailableResource extends JdbcResource {

}
