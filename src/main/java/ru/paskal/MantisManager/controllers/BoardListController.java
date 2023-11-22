package ru.paskal.MantisManager.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.paskal.MantisManager.exceptions.notCreated.BoardListNotCreatedException;
import ru.paskal.MantisManager.exceptions.notDeleted.BoardListNotDeletedException;
import ru.paskal.MantisManager.exceptions.notFound.BoardListNotFoundException;
import ru.paskal.MantisManager.exceptions.notUpdated.BoardListNotUpdatedException;
import ru.paskal.MantisManager.services.BoardListService;
import ru.paskal.MantisManager.utils.CrudErrorHandlers;

@Controller
public class BoardListController extends
    CrudErrorHandlers<
        BoardListNotCreatedException,
        BoardListNotFoundException,
        BoardListNotUpdatedException,
        BoardListNotDeletedException
        > {

  private final BoardListService boardListService;
  private final BoardListController boardListController;
  private final ModelMapper modelMapper;

  @Autowired
  public BoardListController(BoardListService boardListService,
      BoardListController boardListController, ModelMapper modelMapper) {
    this.boardListService = boardListService;
    this.boardListController = boardListController;
    this.modelMapper = modelMapper;
  }
}
