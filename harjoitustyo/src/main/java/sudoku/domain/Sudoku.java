package sudoku.domain;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import sudoku.dao.SudokuDao;

/**
 * Luokka sisältää Sudokuun tarvittavia metodeja
 */
public class Sudoku {

    public List<SudokuDao> sudokulist;
    public Puzzle puzzle = new Puzzle();
    public Boolean[] opened = {false, false, false, false, false};
    public Color originalColor;

    /**
     * Luokan konstruktori
     *
     * @throws java.sql.SQLException
     */
    public Sudoku() throws SQLException {
        setUp();
    }

    private void setUp() throws SQLException {
        this.sudokulist = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            for (int i = 0; i < 5; i++) {
                SudokuDao sudoku = new SudokuDao(i, conn);
                this.sudokulist.add(sudoku);
            }
        } catch (SQLException ex) {
            
        }
    }

    /**
     * Metodi testaa, onko Sudoku täytetty oikein
     *
     * @param n Sudokun numero
     *
     * @return true jos Sudoku on täytetty oikein, muuten false
     */
    public boolean checkIfCorrect(int n) {

        for (int i = 0; i < 81; i++) {
            if (!(getSudokuDao(n).getJTextFieldList().get(i).getText()).equals(puzzle.getNumbersString(n)[i])) {
                return false;
            }
        }
        return true;
    }
    
    public void hint(int n) {
        for (int i = 0; i < 81; i++) {
            if (!(getSudokuDao(n).getJTextFieldList().get(i).getText()).equals(puzzle.getNumbersString(n)[i])) {
                getSudokuDao(n).getJTextFieldList().get(i).setBackground(Color.red);
            } else if (!puzzle.getShown(n)[i]){
                getSudokuDao(n).getJTextFieldList().get(i).setBackground(Color.white);
            }
        }
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
