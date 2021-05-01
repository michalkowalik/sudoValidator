package com.bosch.sast.sudoku.validator.controller;

import com.bosch.sast.sudoku.validator.dto.BoardDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController implements IValidatorController {

  @Override
  public String sayHello() {
    return "Hello World";
  }

  @Override
  public BoardDTO getBoard(@PathVariable("id") Long id) {
    // ... fill the gaps
    return new BoardDTO()
        .setBoard(List.of(
            List.of(1,2,3,4,5), List.of(0,0,0,0)))
        .setId(1L);
  }
}
