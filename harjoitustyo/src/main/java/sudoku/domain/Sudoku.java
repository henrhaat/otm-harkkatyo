package sudoku.domain;

import java.util.ArrayList;
import java.util.List;
import sudoku.dao.SudokuDao;
import sudoku.ui.SudokuUi;

public class Sudoku {

    public List<SudokuDao> sudokulist;
    public SudokuDao sudoku = new SudokuDao();
    public Puzzle puzzle = new Puzzle();

    public Sudoku() {
        this.sudokulist = new ArrayList<>();
        this.sudokulist.add(sudoku);
    }
    
    public void launch(int n) {
        SudokuUi su = new SudokuUi();
        su.start();
    }
    
    public SudokuDao getSudoku(int n) {
        return this.sudokulist.get(n);
    }
}