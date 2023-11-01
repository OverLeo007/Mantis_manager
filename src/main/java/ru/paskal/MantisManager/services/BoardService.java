package ru.paskal.MantisManager.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.models.Board;
import ru.paskal.MantisManager.repositories.BoardRepository;

@Service
@Transactional(readOnly = true)
public class BoardService {

  private final BoardRepository boardRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }


  public Board getOne(int id) {
    Board board = boardRepository.findById(id).orElse(null);
    System.out.println(board);
    assert board != null;
    System.out.println(board.getLists());
    System.out.println(board.getRoles());
    return board;
  }

}
