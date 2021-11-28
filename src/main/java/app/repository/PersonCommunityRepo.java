package app.repository;

import app.entities.PersonCommunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonCommunityRepo extends JpaRepository<PersonCommunity, Integer> {

//  @Query(value = "select community_name from person_communities pc where person_name=:personName")
//  List<String> findCommunityName(@Param("personName") String member);

}
