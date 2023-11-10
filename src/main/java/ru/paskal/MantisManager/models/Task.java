package ru.paskal.MantisManager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private Integer id;

  @Column(name = "task_text")
  private String taskText;

  @Column(name = "task_position")
  private Integer taskPosition;

  @Column(name = "due_date")
  private Date dueDate;
  @Column(name = "task_preferences")
  private String taskPreferences;

  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne
  @JoinColumn(name = "list_id")
  private BoardList list;

  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToOne
  @JoinColumn(name = "task_doer_id")
  private User taskDoer;

  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "task")
  private List<Comment> comments;

  @JsonIgnore
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "task_labels",
      joinColumns = @JoinColumn(name = "task_id"),
      inverseJoinColumns = @JoinColumn(name = "label_id")
  )
  private List<Label> labels;


  public Task(String taskText, Integer taskPosition, BoardList list, Date dueDate, User taskDoer,
      String taskPreferences) {
    this.taskText = taskText;
    this.taskPosition = taskPosition;
    this.list = list;
    this.dueDate = dueDate;
    this.taskDoer = taskDoer;
    this.taskPreferences = taskPreferences;
  }

}
