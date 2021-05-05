package com.bosch.sast.sudoku.validator.controller;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorControllerImpl implements ValidatorController {

  @Override
  public BoardDTO getBoard(Long id) {
    return null;
  }

  @Override
  public boolean validateBoard(Long id) {
    return false;
  }

  @Override
  public Board addBoard(BoardDTO boardDTO) {
    return null;
  }
}
