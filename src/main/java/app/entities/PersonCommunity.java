package app.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(PersonCommunity.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonCommunity implements Serializable {
  @Id
  @JoinColumn(name="person_name")
  @Column(length = 250)
  private String memberName;
  @Id
  @JoinColumn(name = "community_name")
  @Column(length = 250)
  private String communityName;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    PersonCommunity that = (PersonCommunity) o;
    return memberName != null && Objects.equals(memberName, that.memberName)
        && communityName != null && Objects.equals(communityName, that.communityName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberName, communityName);
  }
}
