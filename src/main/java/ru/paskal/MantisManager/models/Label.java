package ru.paskal.MantisManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "labels")
public class Label {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "label_id")
  private Integer id;

  @Column(name = "title")
  private String title;

  @Column(name = "label_info")
  private String info;

  @ManyToMany(mappedBy = "task_labels")
  private List<Task> tasks;

  public Label(String title, String info, Task task) {
    this.title = title;
    this.info = info;
  }

  public Label() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "Label{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", info='" + info + '\'' +
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
    Label label = (Label) o;
    return getTitle().equals(label.getTitle()) && Objects.equals(getInfo(), label.getInfo());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTitle(), getInfo());
  }
}
