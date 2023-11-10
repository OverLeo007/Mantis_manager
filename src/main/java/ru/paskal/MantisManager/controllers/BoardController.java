package ru.paskal.MantisManager.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.paskal.MantisManager.dto.BoardListDto;
import ru.paskal.MantisManager.models.Board;
import ru.paskal.MantisManager.models.BoardList;
import ru.paskal.MantisManager.models.Task;
import ru.paskal.MantisManager.services.BoardListService;
import ru.paskal.MantisManager.services.BoardService;
import ru.paskal.MantisManager.services.TaskService;
import ru.paskal.MantisManager.utils.Converter;

@RestController
@RequestMapping("/api/board")
public class BoardController {
  private final BoardService boardService;
  private final BoardListService boardListService;
  private final TaskService taskService;

  private final Converter converter;

  private final ModelMapper modelMapper;


  @Autowired
  public BoardController(BoardService boardService, BoardListService boardListService,
      TaskService taskService, Converter converter, ModelMapper modelMapper) {
    this.boardService = boardService;
    this.boardListService = boardListService;
    this.taskService = taskService;
    this.converter = converter;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/{id}")
  public Board getBoard(@PathVariable Integer id) {
    Board board = modelMapper.map(boardService.getOne(id), Board.class);
    board.setLists(boardListService.getByBoardId(id));
    for (BoardList list: board.getLists()) {
      List<Task> curTasks = taskService.getByListId(list.getId());
      list.setTasks(taskService.getByListId(list.getId()));
    }
    return board;
  }

//  @GetMapping("/{id}")
//  public BoardDto getBoard(@PathVariable Integer id) {
//    BoardDto boardDto = modelMapper.map(boardService.getOne(id), BoardDto.class);
//
//    boardDto.setLists(
//        boardListService
//            .getByBoardId(id)
//            .stream()
//            .map(
//                boardList -> modelMapper.map(boardList, BoardListDto.class)
//            )
//            .collect(Collectors.toList())
//    );
//    for (BoardListDto list : boardDto.getLists()) {
//      list.setTasks(
//          taskService
//              .getByListId(list.getId())
//              .stream()
//              .map(
//                  task -> modelMapper.map(task, TaskDto.class)
//              )
//              .collect(Collectors.toList())
//      );
//    }
//    return boardDto;
//  }
}
