package sudoku.dao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sudoku.domain.Sudoku;
import sudoku.domain.Puzzle;

public class SudokuDao {

    public List<Sudoku> sudokulist;
    private Sudoku sudoku = new Sudoku();
    private Puzzle puzzle = new Puzzle();

    public SudokuDao() {
        this.sudokulist = new ArrayList<>();
        this.sudokulist.add(sudoku);
    }
    
    public void launch(int n) {
        this.sudokulist.get(n).build();
    }

}
