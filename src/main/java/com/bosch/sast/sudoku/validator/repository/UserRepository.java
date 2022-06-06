package com.bosch.sast.sudoku.validator.repository;

import com.bosch.sast.sudoku.validator.model.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findById(UUID id);
}
