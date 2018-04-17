package sudoku.dao;

import sudoku.domain.Puzzle;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SudokuDao extends JPanel {

    public final JFrame window = new JFrame();
    public final JPanel sudokuPanel = new JPanel();
    public final JPanel rightPanel = new JPanel();

    public Container container;

    public List<JPanel> subpanelList = new ArrayList<>();
    public List<JTextField> jtfList = new ArrayList<>();

    public final int sudokuwidth = 450;
    public final int sudokuheight = 450;

    public final JTextField[][] jtf = new JTextField[3][3];

    public final boolean[] shown;
    public final String[] numbersString;

    public SudokuDao() {
        Puzzle puzzle = new Puzzle();
        this.shown = puzzle.getShown(0);
        this.numbersString = puzzle.getNumbersString(0);
    }
    public boolean checkIfCorrect(int n) {
        
        for (int i = 0; i < 81; i++) {
            if (!jtfList.get(i).getText().equals(numbersString[i])) {
                return false;
            }
        }
        return true;
    }

    public JFrame getJFrame() {
        return this.window;
    }

    public JPanel getSudokuPanel() {
        return this.sudokuPanel;
    }

    public Container getContainer() {
        return this.container;
    }

    public List<JPanel> getSubpanelList() {
        return this.subpanelList;
    }

    public int getSudokuWidth() {
        return this.sudokuwidth;
    }

    public int getSudokuHeight() {
        return this.sudokuheight;
    }

    public JTextField[][] getJTextField() {
        return this.jtf;
    }

    public boolean[] getShown() {
        return this.shown;
    }

    public List<JTextField> getJTextFieldList() {
        return this.jtfList;
    }

}