package com.bosch.sast.sudoku.validator.model;

import javax.persistence.*;
import java.util.List;

/**
 * As JPA doesn't easily let us save the 2d arrays, the sudoku
 * board will be saved as a simple list.
 * A little bit of arithmetic will be needed to make it work
 */

@Entity
public class Board {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @ElementCollection
  private List<Integer> board;


  public List<Integer> getBoard() {
    return board;
  }


  public void setBoard(List<Integer> board) {
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

  public void setValue(int row, int column) {
    // NOOP
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
