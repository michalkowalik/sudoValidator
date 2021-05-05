package com.bosch.sast.sudoku.validator.model;

import javax.persistence.*;
import java.util.List;

/**
 * As JPA/H2 doesn't easily let us save the 2d arrays, the sudoku
 * board will be saved as a simple list.
 */

@Entity
public class Board {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @ElementCollection
  private List<Integer> board;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Integer> getBoard() {
    return board;
  }

  public void setBoard(List<Integer> board) {
    this.board = board;
  }

}
