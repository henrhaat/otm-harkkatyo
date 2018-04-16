
package sudoku.ui;

import java.util.Arrays;
import sudoku.dao.SudokuDao;


public class SudokuUi {


    public static void main(String[] args) {
        SudokuDao sudokuDao = new SudokuDao();
        sudokuDao.launch(0);
    }
    
    
    
}
