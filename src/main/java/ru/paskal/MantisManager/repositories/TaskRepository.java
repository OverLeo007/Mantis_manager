package ru.paskal.MantisManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paskal.MantisManager.models.Task;

@Repository

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
