package com.bosch.sast.sudoku.validator.controller

import com.bosch.sast.sudoku.validator.service.IValidatorService
import com.bosch.sast.sudoku.validator.service.ValidatorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


 class IValidatorServiceTest extends Specification {

   @Autowired
   IValidatorService validatorService


    private boardJson = '''\
    {"board": [
        [1,2,3,4,5,6,7,8,9],
        [9,8,7,1,2,3,4,5,6],
        [4,5,6,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0,0,0]
    ]}'''


    def "save board"() {
        when: "save valid board"
        def response = mockMvc.perform(post("/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(boardJson))
        then:
        response.andExpect(status().isCreated())
    }

    def "validate board"() {
        expect:
        true
    }
}
