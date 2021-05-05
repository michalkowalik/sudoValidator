package com.bosch.sast.sudoku.validator.service;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {

  @Override
  public boolean isValidSudoku(Long boardId) {
    return false;
  }

  @Override
  public boolean isValidSudoku(int[][] board) {
    return false;
  }

  @Override
  public Board saveBoard(BoardDTO boardDTO) {
    return null;
  }

  @Override
  public BoardDTO getBoard(Long id) {
    return null;
  }
}
