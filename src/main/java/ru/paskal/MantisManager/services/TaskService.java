package ru.paskal.MantisManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.repositories.TaskRepository;

@Service
@Transactional(readOnly = true)
public class TaskService {
  private TaskRepository repository;

  @Autowired
  public TaskService(TaskRepository repository) {
    this.repository = repository;
  }
}
