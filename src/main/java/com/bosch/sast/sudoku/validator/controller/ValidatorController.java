package com.bosch.sast.sudoku.validator.controller;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;
import com.bosch.sast.sudoku.validator.service.IValidatorService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController implements IValidatorController {

  private final IValidatorService validatorService;

  public ValidatorController(IValidatorService validatorService) {
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
