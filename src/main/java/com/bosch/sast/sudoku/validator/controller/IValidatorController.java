package com.bosch.sast.sudoku.validator.controller;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IValidatorController {

  @GetMapping("/sayhello")
  String sayHello();

  @GetMapping("/board/{id}")
  BoardDTO getBoard(@PathVariable("id") Long id);
}
