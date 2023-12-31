package ru.paskal.MantisManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.paskal.MantisManager.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
