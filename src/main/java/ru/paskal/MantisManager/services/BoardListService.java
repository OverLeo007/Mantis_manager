package ru.paskal.MantisManager.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.models.BoardList;
import ru.paskal.MantisManager.repositories.BoardListRepository;

@Service
@Transactional(readOnly = true)
public class BoardListService {
  private final BoardListRepository repository;

  @Autowired
  public BoardListService(BoardListRepository repository) {
    this.repository = repository;
  }

  public List<BoardList> getByBoardId(Integer boardId) {
    return repository.findByBoardId(boardId);
  }
}
