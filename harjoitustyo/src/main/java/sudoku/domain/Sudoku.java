package sudoku.domain;

import java.util.ArrayList;
import java.util.List;
import sudoku.dao.SudokuDao;
import sudoku.ui.SudokuUi;

public class Sudoku {

    public List<SudokuDao> sudokulist;
    public Puzzle puzzle = new Puzzle();
    public Boolean[] opened = {false, false, false, false, false};

    public Sudoku() {
        setUp();
    }
    
    private void setUp() {
        this.sudokulist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SudokuDao sudoku = new SudokuDao(i);
            this.sudokulist.add(sudoku);
        }
        
    }
    
    public void launch() {
        SudokuUi su = new SudokuUi();
        su.createLogin();
        
    }
    
    public boolean checkIfCorrect(int n) {
        
        for (int i = 0; i < 81; i++) {
            if (!(getSudokuDao(n).jtfList.get(i).getText()).equals(puzzle.getNumbersString(n)[i])) {
                return false;
            }
        }
        return true;
    }
    
    public SudokuDao getSudokuDao(int n) {
        return this.sudokulist.get(n);
    }
    
    public List<SudokuDao> getSudokuDaoList() {
        return this.sudokulist;
    }
    
    public void setOpened(int n) {
        this.opened[n] = true;
    }
    
    public boolean getOpened(int n) {
        return this.opened[n];
    }
}