package ru.paskal.MantisManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.paskal.MantisManager.models.Board;
import ru.paskal.MantisManager.repositories.BoardRepository;
import ru.paskal.MantisManager.services.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {
  private final BoardService boardService;


  @Autowired
  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/{id}")
  public Board getBoard(@PathVariable Integer id) {
    return boardService.getOne(id);
  }



}
