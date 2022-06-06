package com.bosch.sast.sudoku.validator

import com.bosch.sast.sudoku.validator.dto.BoardDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

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

    @Unroll
    def "Upload and validate #isValid board"() {
        given:
        BoardDTO dto = new BoardDTO()
                .setBoard(sudokuBoard)
                .setId(id)
        mockMvc.perform(post('/board')
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
        when:
        def result = mockMvc.perform(get('/board/{id}/isvalid', id)).andDo(print())
        then:
        result.andExpect(status().isOk())

        and:
        result.andExpect(content().string(output))

        where:
        sudokuBoard                 | id | isValid   | output
        TestConstants.correctSudoku | 1  | "valid"   | "true"
        TestConstants.invalidSudoku | 2  | "invalid" | "false"
    }
}
