package com.bosch.sast.sudoku.validator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

  @GetMapping("/sayhello")
  public String sayHello() {
    return "Hello World";
  }
}
