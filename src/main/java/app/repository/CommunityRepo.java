package app.repository;

import app.entities.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepo extends JpaRepository<Community, Integer> {
  Community findCommunityByCommunityName(String name);
}
