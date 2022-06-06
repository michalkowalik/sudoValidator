package com.bosch.sast.sudoku.validator.service

import com.bosch.sast.sudoku.validator.TestConstants
import com.bosch.sast.sudoku.validator.mapper.SudokuMapper
import com.bosch.sast.sudoku.validator.repository.SudokuRepository
import spock.lang.Specification
import spock.lang.Unroll

class ValidatorServiceSpec extends Specification {

    private ValidatorService validatorService

    private SudokuRepository sudokuRepository = Mock(SudokuRepository)
    private SudokuMapper sudokuMapper = Mock(SudokuMapper)

    def setup() {
        validatorService = new ValidatorServiceImpl(sudokuRepository, sudokuMapper)
    }

    @Unroll
    def "validation correct when board validity is #isValid "(int[][] board, boolean isValid) {
        expect:
        validatorService.isValidSudoku(board) == isValid

        where:
        board         | isValid
        TestConstants.correctSudoku | true
        TestConstants.invalidSudoku | false
    }
}
