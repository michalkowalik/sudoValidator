package com.bosch.sast.sudoku.validator.service;

import com.bosch.sast.sudoku.validator.Constants;
import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.mapper.SudokuMapper;
import com.bosch.sast.sudoku.validator.model.Board;
import com.bosch.sast.sudoku.validator.repository.SudokuRepository;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService implements IValidatorService {

  private final SudokuRepository sudokuRepository;
  private final SudokuMapper sudokuMapper;

  public ValidatorService(SudokuRepository sudokuRepository,
      SudokuMapper sudokuMapper) {
    this.sudokuRepository = sudokuRepository;
    this.sudokuMapper = sudokuMapper;
  }

  @Override
  public boolean isValidSudoku(Long boardId) {
    // ... fill the gaps
    Board board = sudokuRepository.findById(boardId).orElseThrow();
    BoardDTO boardDTO = sudokuMapper.mapToDTO(board);
    return isValidSudoku(boardDTO.getBoard());
  }

  @Override
  public boolean isValidSudoku(int[][] board) {
    return validateRows(board) && validateColumns(board) && validateQuadrants(board);
  }


  @Override
  public Board saveBoard(BoardDTO boardDTO) {
    Board board = sudokuMapper.mapToEntity(boardDTO);
    return sudokuRepository.save(board);
  }

  @Override
  public BoardDTO getBoard(Long id) {
    Board board = sudokuRepository.findById(id).orElseThrow();
    return sudokuMapper.mapToDTO(board);
  }

  // get 9 sub-arrays, pack them into a 1D arrays & validate the vectors
  private boolean validateQuadrants(int[][] board) {
    return true;
  }

  private boolean validateColumns(int[][] board) {
    int[][] pivotedArray = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    for (int i = 0; i < Constants.BOARD_SIZE; i++) {
      for (int j =0; j < Constants.BOARD_SIZE; j++) {
        pivotedArray[j][i] = board[i][j];
      }
    }
    return validateRows(pivotedArray);
  }

  private boolean validateRows(int[][] board) {
    var digitsInRows = Arrays.stream(board)
        .map(this::validateVector)
        .reduce((a, b) -> a && b);
    return digitsInRows.orElseThrow();
  }

  private boolean validateVector(int[] vector) {
    var groupedDigits = Arrays.stream(vector).boxed()
        .collect(Collectors.groupingBy(Function.identity()));

    AtomicBoolean isValid = new AtomicBoolean(true);
    groupedDigits.forEach((k, v) -> {
      if ((k != 0) && (v.size() > 1))
        isValid.set(false);
    });
    return isValid.get();
  }
}
