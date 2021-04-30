package com.bosch.sast.sudoku.validator.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface IValidatorController {
    @GetMapping("/sayhello") String sayHello();
}
