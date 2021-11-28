package app.service;

import app.dto.CommunityDTO;
import app.dto.LoggedInUser;
import app.entities.Community;
import app.entities.Person;
import app.repository.CommunityRepo;
import app.repository.PersonRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class CommunityService {

  @Autowired
  CommunityRepo communityRepo;

  @Autowired
  LoggedInUser loggedInUser;

  @Autowired
  PersonRepo personRepo;

  public boolean isUnique(String name){
    log.info("Name: {}", name);
    Community communityName = communityRepo.findCommunityByCommunityName(name);
    return communityName == null;
  }

  public void createCommunity(CommunityDTO communityDTO){

    log.info(loggedInUser.getUser());

    Person person = personRepo.getByPersonName(loggedInUser.getUser());
    Community community = new Community();
    community.setCommunityType(communityDTO.getCommunityType());
    community.setCommunityName(communityDTO.getCommunityName());
    community.setInsTs(new Date());
    community.setPerson(person);
    communityRepo.save(community);
  }

  public List<String> getSubscribedCommunities() {
//    return communityRepo.findAllByMemberName(loggedInUser.getUser());
    return null;
  }
}
