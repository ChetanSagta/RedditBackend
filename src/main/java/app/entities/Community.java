package app.entities;

import app.dto.CommunityType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Community {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int communityId;
  String communityName;
  CommunityType communityType;
  Date insTs;
  Date updTs;
  @OneToOne
  @JoinColumn(name = "created_by_person_id")
  Person createdBy;


}
