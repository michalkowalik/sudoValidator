package com.bosch.sast.sudoku.validator.service;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.mapper.SudokuMapper;
import com.bosch.sast.sudoku.validator.model.Board;
import com.bosch.sast.sudoku.validator.repository.SudokuRepository;
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
    return false;
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
}
