package com.bosch.sast.sudoku.validator.sudoku;

import com.bosch.sast.sudoku.validator.Constants;
import java.util.List;

public class Board {

  private int[][] board;

  public Board() {
    this.board = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
  }

  public int[][] getBoard() {
    return board;
  }

  public void setBoard(int[][] board) {
    this.board = board;
  }

  public List<Integer> getRow(int row) {
    return null;
  }

  public List<Integer> getColumn(int col) {
    return null;
  }

  /**
   * There are 9 3x3 quadrants on the board. Their top-left coordinates are
   * 0x0, 3x0, 6x0
   * 0x3, 3x3, 6x3
   *  ...
   *  The getter should be able to deal with any coordinates and return the matching quadrant
   *  or throw an exception, if coordinates are out of range.
   *  The program should be able to handle exception.
   * @param row
   * @param col
   * @return
   */
  public int[][] getQuadrant(int row, int col) {
    return  null;
  }

  public void setColumn(int col, List<Integer> data) {
    // NOOP
  }

  public void setRow(int row, List<Integer> data) {
    // NOOP
  }
}
