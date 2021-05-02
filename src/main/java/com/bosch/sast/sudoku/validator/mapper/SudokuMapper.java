package com.bosch.sast.sudoku.validator.mapper;

import com.bosch.sast.sudoku.validator.Constants;
import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Any ideas how to make it smarter?
 */

@Component
public class SudokuMapper {

  public BoardDTO mapToDTO(Board board) {
    return new BoardDTO()
        .setId(board.getId())
        .setBoard(boardListToArray(board.getBoard()));
  }

  public Board mapToEntity(BoardDTO boardDTO) {
    var board = new Board();
    board.setId(boardDTO.getId());
    board.setBoard(boardToList(boardDTO.getBoard()));
    return board;
  }


  private List<Integer> boardToList(int[][] board) {
    return Arrays.stream(board)
        .flatMapToInt(Arrays::stream)
        .boxed()
        .collect(Collectors.toList());
  }

  private int[][] boardListToArray(List<Integer> board) {
    int[][] boardArray = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    for (int i = 0; i < Constants.BOARD_SIZE; i++) {
      for (int j = 0; j < Constants.BOARD_SIZE; j++) {
        boardArray[i][j] = board.get(i * Constants.BOARD_SIZE + j);
      }
    }
    return boardArray;
  }
}
