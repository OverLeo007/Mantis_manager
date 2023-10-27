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
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "task_id")
  private Task task;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "text")
  private String text;

  @Column(name = "comment_date")
  private Timestamp commentDate;

  public Comment(Task task, User user, String text, Timestamp commentDate) {
    this.task = task;
    this.user = user;
    this.text = text;
    this.commentDate = commentDate;
  }

  public Comment() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getCommentDate() {
    return commentDate;
  }

  public void setCommentDate(Timestamp commentDate) {
    this.commentDate = commentDate;
  }

  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", task=" + task +
        ", user=" + user +
        ", text='" + text + '\'' +
        ", commentDate=" + commentDate +
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
    Comment comment = (Comment) o;
    return getTask().equals(comment.getTask()) && getUser().equals(comment.getUser())
        && getText().equals(comment.getText()) && getCommentDate().equals(comment.getCommentDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTask(), getUser(), getText(), getCommentDate());
  }
}
