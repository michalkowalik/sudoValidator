package com.bosch.sast.sudoku.validator.service;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;

public interface IValidatorService {

  public boolean isValidSudoku(Long boardId);

  Board saveBoard(BoardDTO boardDTO);

  BoardDTO getBoard(Long id);
}
