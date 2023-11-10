package ru.paskal.MantisManager.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paskal.MantisManager.models.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

//  @Query("SELECT DISTINCT b FROM Board b LEFT JOIN FETCH b.lists bl LEFT JOIN FETCH bl.tasks WHERE b.id = :boardId")
//  Board findBoard(@Param("boardId") Integer boardId);

  Optional<Board> findPreloadBoardById(Integer id);

}
