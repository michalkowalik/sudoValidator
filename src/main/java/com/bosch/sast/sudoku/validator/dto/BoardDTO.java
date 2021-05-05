package com.bosch.sast.sudoku.validator.dto;

public class BoardDTO {

  private Long id;
  private int[][] board;

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
