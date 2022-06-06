package com.bosch.sast.sudoku.validator.repository;

import com.bosch.sast.sudoku.validator.model.Board;
import com.bosch.sast.sudoku.validator.model.User;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SudokuRepository extends CrudRepository<Board, Long> {
    Optional<Board> findById(Long id);
    Set<Board> findByUser(User user);
}
