package ru.paskal.MantisManager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.paskal.MantisManager.repositories.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService {
  private UserRepository repository;

  @Autowired
  public UserService(UserRepository repository) {
    this.repository = repository;
  }


}
