package ru.paskal.MantisManager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.dto.BoardListDto;
import ru.paskal.MantisManager.exceptions.notFound.BoardNotFoundException;
import ru.paskal.MantisManager.models.Board;
import ru.paskal.MantisManager.models.BoardList;
import ru.paskal.MantisManager.models.Task;
import ru.paskal.MantisManager.models.User;

@Component
public class BoardDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Transactional(readOnly = true)
  public Board getBoard(int id) {
    Session session = entityManager.unwrap(Session.class);

    Board board = session.get(Board.class, id);

    if (board == null) {
      throw new BoardNotFoundException(id);
    }
    List<BoardList> lists = session.createQuery(
        "SELECT l FROM BoardList l LEFT JOIN FETCH l.tasks t  WHERE l.board = :board",
        BoardList.class
    ).setParameter("board", board).getResultList();

    List<User> users = session.createQuery(
        "SELECT u FROM User u JOIN u.boards b WHERE b.id = :boardId",
        User.class
    ).setParameter("boardId", id).getResultList();
    board.setLists(lists);
    board.setUsers(users);

//    System.out.println("\033[32m" + board.getLists() + "\033[0m");
//    System.out.println("\033[32m" + board.getUsers() + "\033[0m");
//    System.out.println("\033[32m" + board.getLists().get(0).getTasks().get(0).getLabels() + "\033[0m");
    return board;
  }

  @Transactional(readOnly = true)
  public void testHql() {


  }
}
