package app.entities;

import app.dto.CommunityType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "community")
public class Community {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private int communityId;
  @Id
  @Column(length = 250)
  private String communityName;
  private CommunityType communityType;
  @CreatedDate
  private Date insTs = new Date();
  @UpdateTimestamp
  private Date updTs = new Date();
  @OneToOne
  @JoinColumn(name = "created_by_person_name")
  @CreatedBy
  Person person;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Community community = (Community) o;
    return Objects.equals(communityName, community.communityName);
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
