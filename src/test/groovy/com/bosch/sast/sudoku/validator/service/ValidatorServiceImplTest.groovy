package com.bosch.sast.sudoku.validator.service

import com.bosch.sast.sudoku.validator.mapper.SudokuMapper
import com.bosch.sast.sudoku.validator.repository.SudokuRepository
import spock.lang.Specification
import spock.lang.Unroll

class ValidatorServiceImplTest extends Specification {

    static int[][] correctSudoku =
            [[1, 2, 3, 4, 5, 6, 7, 8, 9],
             [9, 8, 7, 1, 2, 3, 4, 5, 6],
             [4, 5, 6, 0, 0, 0, 0, 0, 0],

             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0],

             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0]]

    static int[][] invalidSudoku =
            [[1, 2, 3, 4, 5, 6, 7, 8, 9],
             [9, 8, 7, 1, 2, 3, 4, 5, 6],
             [4, 5, 6, 0, 0, 0, 0, 0, 0],

             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0],

             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [0, 0, 0, 0, 0, 0, 0, 0, 0],
             [9, 0, 0, 0, 0, 0, 0, 0, 0]]

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
        correctSudoku | true
        invalidSudoku | false
    }
}
