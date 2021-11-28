package app.controller;

import app.dto.CommunityDTO;
import app.entities.Community;
import app.service.CommunityService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/v1")
public class CommunityController {

  @Autowired
  CommunityService communityService;

  @PostMapping("/createCommunity")
  public void createCommunity(@RequestBody CommunityDTO communityDTO){
    if(isUniqueName(communityDTO.getCommunityName()) && communityDTO.getCommunityType() != null){
      communityService.createCommunity(communityDTO);
    }
  }

  @PostMapping("/uniqueCommunity")
  public boolean isUniqueName(@RequestBody String name){
    log.info("Name: {}",name);
    return communityService.isUnique(name);
  }

  @GetMapping("/createdCommunity")
  public List<Community> getCreatedCommunity(){
    throw new UnsupportedOperationException();
  }

  @GetMapping("/subscribedCommunities")
  public List<String> getSubscribedCommunities(){
    return communityService.getSubscribedCommunities();
  }

}
