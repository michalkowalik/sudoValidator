package com.bosch.sast.sudoku.validator.repository;

import com.bosch.sast.sudoku.validator.model.SudokuUser;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface SudokuUserRepository extends CrudRepository<SudokuUser, UUID> {
  Optional<SudokuUser> findById(UUID id);
}
