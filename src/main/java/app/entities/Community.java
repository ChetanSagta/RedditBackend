package app.entities;

import app.dto.CommunityType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Community {

  @Id
  int communityId;
  String name;
  boolean adultContent;
  CommunityType communityType;
  @OneToOne
  @JoinColumn(name = "created_by_person_id")
  Person createdBy;


}
