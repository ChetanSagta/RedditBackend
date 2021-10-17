package app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person {

  @Id
  private int personId;
  private int personName;
  private Date insTs;
  private Date updTs;

}
