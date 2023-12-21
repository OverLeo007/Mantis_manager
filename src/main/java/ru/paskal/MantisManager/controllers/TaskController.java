package ru.paskal.MantisManager.controllers;


import static ru.paskal.MantisManager.utils.TestLogger.log;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.paskal.MantisManager.dao.TaskDao;
import ru.paskal.MantisManager.dto.task.TaskCreateDto;
import ru.paskal.MantisManager.dto.task.TaskDtoToSend;
import ru.paskal.MantisManager.exceptions.notCreated.TaskNotCreatedException;
import ru.paskal.MantisManager.exceptions.notDeleted.TaskNotDeletedException;
import ru.paskal.MantisManager.exceptions.notFound.TaskNotFoundException;
import ru.paskal.MantisManager.exceptions.notUpdated.TaskNotUpdatedException;
import ru.paskal.MantisManager.models.Task;
import ru.paskal.MantisManager.services.TaskService;
import ru.paskal.MantisManager.utils.CrudErrorHandlers;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/tasks")
public class TaskController extends
    CrudErrorHandlers<
        TaskNotCreatedException,
        TaskNotFoundException,
        TaskNotUpdatedException,
        TaskNotDeletedException
        > {

  private final TaskService taskService;

  private final TaskDao taskDao;

  private final ModelMapper mm;


  @Autowired
  public TaskController(TaskService taskService, TaskDao taskDao, ModelMapper mm) {
    this.taskService = taskService;
    this.taskDao = taskDao;
    this.mm = mm;
  }

  @GetMapping
  public ResponseEntity<List<TaskDtoToSend>> getByList(@RequestParam(name = "list_id") Integer listId) {
    return okResponseWrapper(taskDao.getTasksByListId(listId));
  }

  @GetMapping("{id}")
  public ResponseEntity<TaskDtoToSend> getById(@PathVariable(name = "id") Integer taskId) {
    return okResponseWrapper(taskService.getTaskById(taskId));
  }

  @PostMapping
  public ResponseEntity<HttpStatus> createTask(@RequestBody TaskCreateDto taskCreateDto) {
    taskService.saveTask(taskCreateDto);
    return ResponseEntity.ok().build();
  }

  private <T> ResponseEntity<T> okResponseWrapper(T toWrap) {
    return new ResponseEntity<>(toWrap, HttpStatus.OK);
  }

}
