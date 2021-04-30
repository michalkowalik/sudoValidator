package com.bosch.sast.sudoku.validator.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController implements IValidatorController {

  @Override
  public String sayHello() {
    return "Hello World";
  }
}
