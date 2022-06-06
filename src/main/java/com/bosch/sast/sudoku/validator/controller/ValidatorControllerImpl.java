package com.bosch.sast.sudoku.validator.controller;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;
import com.bosch.sast.sudoku.validator.service.ValidatorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ValidatorControllerImpl implements ValidatorController {

  private final ValidatorService validatorService;

  public ValidatorControllerImpl(ValidatorService validatorService) {
    this.validatorService = validatorService;
  }

  @Override
  public BoardDTO getBoard(@PathVariable("id") Long id) {
    // ... fill the gaps
    return validatorService.getBoard(id);
  }

  @Override
  public boolean validateBoard(Long id) {
    return validatorService.isValidSudoku(id);
  }

  @Override
  public Board addBoard(@RequestBody BoardDTO boardDTO) {
    return validatorService.saveBoard(boardDTO);
  }
}
