package com.bosch.sast.sudoku.validator

import com.bosch.sast.sudoku.validator.controller.ValidatorController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ValidatorControllerImplTest extends Specification {

    @Autowired (required = false)
    private ValidatorController validatorController


    def "The application context is created"() {
        expect: "The controller is created"
        validatorController
    }
}
