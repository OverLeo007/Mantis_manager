package ru.paskal.MantisManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "boards")
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_id")
  private Integer id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "last_edit")
  private Timestamp lastEdit;

  @OneToMany(mappedBy = "board")
  private List<BoardList> lists;

  @OneToMany(mappedBy = "board")
  private List<Role> roles;

  public Board(String title, Timestamp lastEdit) {
    this.title = title;
    this.lastEdit = lastEdit;
  }

  public Board() {
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

  public Timestamp getLastEdit() {
    return lastEdit;
  }

  public void setLastEdit(Timestamp lastEdit) {
    this.lastEdit = lastEdit;
  }

  public List<BoardList> getLists() {
    return lists;
  }

  public void setLists(List<BoardList> lists) {
    this.lists = lists;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "Board{" +
        "title='" + title + '\'' +
        ", lastEdit=" + lastEdit +
        ", lists=" + lists.size() +
        ", roles=" + roles.size() +
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
    Board board = (Board) o;
    return getTitle().equals(board.getTitle()) && Objects.equals(getLastEdit(),
        board.getLastEdit()) && Objects.equals(getLists(), board.getLists())
        && Objects.equals(getRoles(), board.getRoles());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTitle(), getLastEdit(), getLists(), getRoles());
  }

  // constructors, getters, and setters
}
