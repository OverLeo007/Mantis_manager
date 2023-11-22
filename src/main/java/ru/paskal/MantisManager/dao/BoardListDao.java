package ru.paskal.MantisManager.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.exceptions.notFound.BoardListNotFoundException;
import ru.paskal.MantisManager.models.BoardList;
import ru.paskal.MantisManager.models.Task;
import ru.paskal.MantisManager.utils.TestLogger;

public class BoardListDao {

  @PersistenceContext
  EntityManager entityManager;

  @Transactional(readOnly = true)
  public BoardList getList(int id) {
    Session session = entityManager.unwrap(Session.class);
    BoardList boardList = session.get(BoardList.class, id);
    if (boardList == null) {
      throw new BoardListNotFoundException(id);
    }

    List<Task> tasks = session.createQuery(
        "SELECT t from Task t WHERE t.list = :list",
        Task.class
    ).setParameter("list", boardList).getResultList();
    boardList.setTasks(tasks);
    TestLogger.log(boardList);
    return boardList;
  }

}
