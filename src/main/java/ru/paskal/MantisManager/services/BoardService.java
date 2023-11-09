package ru.paskal.MantisManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.exceptions.BoardNotFoundException;
import ru.paskal.MantisManager.models.Board;
import ru.paskal.MantisManager.repositories.BoardRepository;

@Service
@Transactional(readOnly = true)
public class BoardService {

  private final BoardRepository repository;


  @Autowired
  public BoardService(BoardRepository repository) {
    this.repository = repository;
  }


  public Board getOne(int id) {
    Board board = repository.findPreloadBoardById(id).orElseThrow(BoardNotFoundException::new);

    return board;
  }

}
