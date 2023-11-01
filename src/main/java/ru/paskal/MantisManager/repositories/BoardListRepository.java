package ru.paskal.MantisManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paskal.MantisManager.models.BoardList;

@Repository
public interface BoardListRepository extends JpaRepository<BoardList, Integer> {

}
