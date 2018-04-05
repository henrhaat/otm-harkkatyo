
package sudoku.ui;

import java.util.Arrays;
import sudoku.domain.Sudoku;


public class SudokuUi{


    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int[][] numerot = sudoku.getNumbers();
        System.out.println(numerot[0][0]);
    }
    

    
}
