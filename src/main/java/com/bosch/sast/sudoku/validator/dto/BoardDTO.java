package com.bosch.sast.sudoku.validator.dto;

import static com.bosch.sast.sudoku.validator.Constants.BOARD_SIZE;

import java.util.List;

public class BoardDTO {

  private Long id;
  private int[][] board;

  public int[][] getBoardConverted(List<Integer> board) {
    // ... fill the gaps

    // ... fill the gaps
    return new int[BOARD_SIZE][BOARD_SIZE];
  }

  public int[][] getBoard() {
    return board;
  }

  public BoardDTO setBoard(int[][] board) {
    this.board = board;
    return this;
  }

  public Long getId() {
    return id;
  }

  public BoardDTO setId(Long id) {
    this.id = id;
    return this;
  }
}
