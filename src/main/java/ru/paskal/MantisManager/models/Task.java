package ru.paskal.MantisManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
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

  @ManyToOne
  @JoinColumn(name = "list_id")
  private BoardList list;

  @Column(name = "due_date")
  private Date dueDate;

  @ManyToOne
  @JoinColumn(name = "task_doer_id")
  private User taskDoer;

  @Column(name = "task_preferences")
  private String taskPreferences;

  @OneToMany(mappedBy = "task")
  private List<Label> labels;

  @OneToMany(mappedBy = "task")
  private List<Comment> comments;

  public Task(String taskText, Integer taskPosition, BoardList list, Date dueDate, User taskDoer,
      String taskPreferences) {
    this.taskText = taskText;
    this.taskPosition = taskPosition;
    this.list = list;
    this.dueDate = dueDate;
    this.taskDoer = taskDoer;
    this.taskPreferences = taskPreferences;
  }

  public Task() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTaskText() {
    return taskText;
  }

  public void setTaskText(String taskText) {
    this.taskText = taskText;
  }

  public Integer getTaskPosition() {
    return taskPosition;
  }

  public void setTaskPosition(Integer taskPosition) {
    this.taskPosition = taskPosition;
  }

  public BoardList getList() {
    return list;
  }

  public void setList(BoardList list) {
    this.list = list;
  }

  public Date getDueDate() {
    return dueDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  public User getTaskDoer() {
    return taskDoer;
  }

  public void setTaskDoer(User taskDoer) {
    this.taskDoer = taskDoer;
  }

  public String getTaskPreferences() {
    return taskPreferences;
  }

  public void setTaskPreferences(String taskPreferences) {
    this.taskPreferences = taskPreferences;
  }

  public List<Label> getLabels() {
    return labels;
  }

  public void setLabels(List<Label> labels) {
    this.labels = labels;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "Task{" +
        "id=" + id +
        ", taskText='" + taskText + '\'' +
        ", taskPosition=" + taskPosition +
        ", list=" + list +
        ", dueDate=" + dueDate +
        ", taskDoer=" + taskDoer +
        ", taskPreferences='" + taskPreferences + '\'' +
        ", labels=" + labels.size() +
        ", comments=" + comments.size() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return getTaskText().equals(task.getTaskText()) && getTaskPosition().equals(
        task.getTaskPosition()) && getList().equals(task.getList()) && Objects.equals(
        getDueDate(), task.getDueDate()) && Objects.equals(getTaskDoer(),
        task.getTaskDoer()) && Objects.equals(getTaskPreferences(),
        task.getTaskPreferences()) && Objects.equals(getLabels(), task.getLabels())
        && Objects.equals(getComments(), task.getComments());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTaskText(), getTaskPosition(), getList(), getDueDate(), getTaskDoer(),
        getTaskPreferences());
  }
}
