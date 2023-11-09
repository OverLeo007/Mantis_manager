package ru.paskal.MantisManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.repositories.BoardListRepository;

@Service
@Transactional(readOnly = true)
public class BoardListService {
  private BoardListRepository repository;

  @Autowired
  public BoardListService(BoardListRepository repository) {
    this.repository = repository;
  }
}
