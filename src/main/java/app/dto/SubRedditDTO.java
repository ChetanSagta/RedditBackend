package app.dto;

import app.entities.Post;

import java.util.List;
import java.util.Map;

public class SubRedditDTO {
  private List<MemberDTO> membersList;
  private Map<Post, Boolean> postList;
}
