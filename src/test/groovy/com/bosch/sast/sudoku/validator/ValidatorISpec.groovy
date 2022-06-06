package com.bosch.sast.sudoku.validator

import com.bosch.sast.sudoku.validator.dto.BoardDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class ValidatorISpec extends Specification {

    @Autowired
    protected MockMvc mockMvc

    @Autowired
    ObjectMapper objectMapper

    def "Upload a board and expect 201"() {
        given:
        BoardDTO dto = new BoardDTO()
                .setBoard(TestConstants.correctSudoku)
                .setId(1)

        when:
        def result = mockMvc.perform(post('/board')
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))

        then:
        result.andExpect(status().isCreated())

        and:
        result.andExpect(jsonPath('$.id').value('1'))
    }

    def "Upload and validate uploaded board"() {
        given:
        BoardDTO dto = new BoardDTO()
                .setBoard(TestConstants.correctSudoku)
                .setId(1)
        mockMvc.perform(post('/board')
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
        when:
        def result = mockMvc.perform(get('/board/1/isvalid')).andDo(print())
        then:
        result.andExpect(status().isOk())

        and:
        result.andExpect(content().string("true"))
    }

    def "Upload and validate invalid board"() {
        given:
        BoardDTO dto = new BoardDTO()
                .setBoard(TestConstants.invalidSudoku)
                .setId(1)
        mockMvc.perform(post('/board')
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
        when:
        def result = mockMvc.perform(get('/board/1/isvalid')).andDo(print())
        then:
        result.andExpect(status().isOk())

        and:
        result.andExpect(content().string("false"))
    }


}
