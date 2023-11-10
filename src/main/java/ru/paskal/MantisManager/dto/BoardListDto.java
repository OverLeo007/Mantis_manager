package ru.paskal.MantisManager.dto;

import java.util.List;
import lombok.Data;
import ru.paskal.MantisManager.models.Task;

@Data
public class BoardListDto {
  private Integer id;
  private String title;
  private Integer listPosition;
  private List<TaskDto> tasks;

}
