package ru.paskal.MantisManager.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;

  @Column(name = "role_name")
  private String roleName;

  @Column(name = "role_permissions")
  private String rolePermissions;

  public Role(Board board, String roleName, String rolePermissions) {
    this.board = board;
    this.roleName = roleName;
    this.rolePermissions = rolePermissions;
  }

  public Role() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Board getBoard() {
    return board;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getRolePermissions() {
    return rolePermissions;
  }

  public void setRolePermissions(String rolePermissions) {
    this.rolePermissions = rolePermissions;
  }

  @Override
  public String toString() {
    return "Role{" +
        "id=" + id +
        ", board=" + board +
        ", roleName='" + roleName + '\'' +
        ", rolePermissions='" + rolePermissions + '\'' +
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
    Role role = (Role) o;
    return getBoard().equals(role.getBoard()) && getRoleName().equals(role.getRoleName())
        && getRolePermissions().equals(role.getRolePermissions());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getBoard(), getRoleName(), getRolePermissions());
  }
}


