package app.dto;

import app.entities.Post;

import java.util.List;
import java.util.Map;

public class SubRedditDTO {
  List<MemberDTO> membersList;
  Map<Post, Boolean> postList;
}
