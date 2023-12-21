package ru.paskal.MantisManager.dto.task;

import lombok.Data;

@Data
public class TaskCreateDto {
  private String taskText;
  private Integer taskPosition;
  private Integer listId;
}
