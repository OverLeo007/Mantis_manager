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
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lists")
public class BoardList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "list_id")
  private Integer id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "list_position")
  private Integer listPosition;

  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;

  @OneToMany(mappedBy = "list")
  private List<Task> tasks;


  public BoardList(String title, Integer listPosition, Board board) {
    this.title = title;
    this.listPosition = listPosition;
    this.board = board;
  }

  public BoardList() {
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

  public Integer getListPosition() {
    return listPosition;
  }

  public void setListPosition(Integer listPosition) {
    this.listPosition = listPosition;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "BoardList{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", listPosition=" + listPosition +
        ", board=" + board +
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
    BoardList boardList = (BoardList) o;
    return getTitle().equals(boardList.getTitle()) && getListPosition().equals(
        boardList.getListPosition()) && getBoard().equals(boardList.getBoard());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTitle(), getListPosition(), getBoard());
  }
}
