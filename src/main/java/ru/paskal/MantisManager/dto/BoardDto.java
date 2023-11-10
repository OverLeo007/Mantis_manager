package ru.paskal.MantisManager.dto;

import java.util.List;
import lombok.Data;

@Data
public class BoardDto {
  private Integer id;
  private String title;
  private List<UserDtoForLink> users;
  private List<BoardListDto> lists;
}
