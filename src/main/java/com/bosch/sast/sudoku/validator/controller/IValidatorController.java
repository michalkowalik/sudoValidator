package com.bosch.sast.sudoku.validator.controller;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import com.bosch.sast.sudoku.validator.model.Board;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface IValidatorController {

  @GetMapping("/board/{id}")
  BoardDTO getBoard(@PathVariable("id") Long id);

  @GetMapping("/board/{id}/isvalid")
  boolean validateBoard(@PathVariable("id") Long id);

  @PostMapping("/board")
  Board addBoard(BoardDTO boardDTO);
}
