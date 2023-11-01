package ru.paskal.MantisManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "usr_password", nullable = false)
  private String password;

  @Column(name = "preferences")
  private String preferences;

  @OneToMany(mappedBy = "user")
  private List<Comment> comments;

  @OneToMany(mappedBy = "taskDoer")
  private List<Task> tasks;

  @ManyToMany
  @JoinTable(
      name = "board_roles",
      joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "board_id")}
  )
  private List<Board> boards;

  @ManyToMany
  @JoinTable(
      name = "board_roles",
      joinColumns = {@JoinColumn(name = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")}
  )
  private List<Role> roles;

//  @OneToMany(mappedBy = "user")
//  private List<BoardRole> boardRoles;

  public User(String username, String email, String password, String preferences) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.preferences = preferences;
  }

  public User() {
  }

  public List<Board> getBoards() {
    return boards;
  }

  public void setBoards(List<Board> boards) {
    this.boards = boards;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPreferences() {
    return preferences;
  }

  public void setPreferences(String preferences) {
    this.preferences = preferences;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", preferences='" + preferences + '\'' +
        ", comments=" + comments +
        ", tasks=" + tasks +
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
    User user = (User) o;
    return getUsername().equals(user.getUsername()) && getEmail().equals(user.getEmail())
        && getPassword().equals(user.getPassword()) && Objects.equals(getPreferences(),
        user.getPreferences()) && Objects.equals(getComments(), user.getComments())
        && Objects.equals(getTasks(), user.getTasks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUsername(), getEmail(), getPassword(), getPreferences(), getComments(),
        getTasks());
  }
}

