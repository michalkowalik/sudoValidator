package com.bosch.sast.sudoku.validator.service;

import com.bosch.sast.sudoku.validator.repository.SudokuRepository;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService implements IValidatorService {

  private SudokuRepository sudokuRepository;

  public ValidatorService(SudokuRepository sudokuRepository) {
    this.sudokuRepository = sudokuRepository;
  }

}
