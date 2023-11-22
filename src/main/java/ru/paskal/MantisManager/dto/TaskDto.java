package ru.paskal.MantisManager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.List;
import lombok.Data;
import ru.paskal.MantisManager.models.BoardList;


@Data
public class TaskDto {
  private Integer id;
  private String taskText;
  private Integer taskPosition;
  private Date dueDate;
  private String taskPreferences;
}
//  @JsonIgnore
//  private UserDtoForLink taskDoer;
//  @JsonIgnore
//  private List<CommentDto> comments;
//  @JsonIgnore
//  private List<LabelDtoForTask> labels;
