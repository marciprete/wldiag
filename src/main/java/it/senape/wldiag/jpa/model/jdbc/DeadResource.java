package it.senape.wldiag.jpa.model.jdbc;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Entity
@PrimaryKeyJoinColumn(name="dead_resource_id", referencedColumnName = "jdbc_resource_id")
public class DeadResource extends JdbcResource {

}
