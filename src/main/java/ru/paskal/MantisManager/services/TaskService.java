package ru.paskal.MantisManager.services;


import static ru.paskal.MantisManager.utils.TestLogger.log;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.dao.TaskDao;
import ru.paskal.MantisManager.dto.task.TaskCreateDto;
import ru.paskal.MantisManager.dto.task.TaskDtoToSend;
import ru.paskal.MantisManager.exceptions.notFound.BoardListNotFoundException;
import ru.paskal.MantisManager.exceptions.notFound.TaskNotFoundException;
import ru.paskal.MantisManager.models.Task;
import ru.paskal.MantisManager.repositories.BoardListRepository;
import ru.paskal.MantisManager.repositories.TaskRepository;

@Service
@Transactional(readOnly = true)
public class TaskService {
  private final TaskRepository repository;

  private final BoardListRepository boardListRepository;
  private final TaskDao taskDao;


  @Autowired
  public TaskService(TaskRepository repository, TaskDao taskDao, BoardListRepository boardListRepository) {
    this.boardListRepository = boardListRepository;
    this.repository = repository;
    this.taskDao = taskDao;
  }



  public TaskDtoToSend getTaskById(Integer id) {
    return taskDao.mapTask(repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id)));
  }

  @Transactional
  public void saveTask(TaskCreateDto task) {
    repository.save(mapFromCreateDto(task));

    log(task);
//    repository.save(task);
  }

  private Task mapFromCreateDto(TaskCreateDto taskCreateDto) {
    var task = new Task();
    task.setTaskText(taskCreateDto.getTaskText());
    task.setTaskPosition(taskCreateDto.getTaskPosition());
    Integer listId = taskCreateDto.getListId();
    task.setList(
        boardListRepository.findById(listId).orElseThrow(
            () -> new BoardListNotFoundException(listId)
        )
    );
    log(task);
    return task;
  }

}
