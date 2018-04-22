package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextField;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.dao.SudokuDao;
import sudoku.domain.Puzzle;
import sudoku.domain.Sudoku;


public class SudokuTest {

    SudokuDao sudokuDao;
    Sudoku sudoku;
    Puzzle puzzle;

    public void setUp() {
        sudokuDao = new SudokuDao(0);
        sudoku = new Sudoku();
        puzzle = new Puzzle();
    }
    

    public void boxPassesRules(int n) {
        setUp();
        String[] numbers = sudokuDao.getNumbers();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            list1.add(i + "");
        }
        for (int i = 0; i < 9; i++) {
            list2.add(numbers[n * 9 + i] + "");
        }
        Collections.sort(list2);

        assertEquals(list1, list2);
    }

    @Test
    public void allBoxesPassRules() {
        for (int i = 0; i < 9; i++) {
            boxPassesRules(i);
        }
    }
    
    @Test
    public void getShown() {
        setUp();
        boolean t = true;
        boolean f = false;
        boolean[] shown = {f, f, f, t, t, f, t, t, f, t, t, f, f, t, f, f, f, t, t, f, t, f, t, f, t, f, f,
                                     t, t, f, f, f, t, f, t, f, t, f, f, t, f, t, f, f, t, f, t, f, t, f, f, f, t, t,
                                     f, f, t, f, t, f, t, f, t, t, f, f, f, t, f, f, t, t, f, t, t, f, t, t, f, f, f};
        assertEquals(Arrays.toString(shown), Arrays.toString(puzzle.getShown(0)));
    }
    
    @Test
    public void getNumbers() {
        setUp();
        String[] numbersString = {"4", "3", "5", "6", "8", "2", "1", "9", "7", "2", "6", "9", "5", "7", "1", "8", "3", "4", "7", "8", "1", "4", "9", "3", "5", "6", "2",
                                            "8", "2", "6", "3", "7", "4", "9", "5", "1", "1", "9", "5", "6", "8", "2", "7", "4", "3", "3", "4", "7", "9", "1", "5", "6", "2", "8",
                                            "5", "1", "9", "2", "4", "8", "7", "6", "3", "3", "2", "6", "9", "5", "7", "4", "1", "8", "8", "7", "4", "1", "3", "6", "2", "5", "9"};
        assertEquals(Arrays.toString(numbersString), Arrays.toString(puzzle.getNumbersString(0)));
    }
    
    @Test
    public void getSudoku() {
        setUp();
        SudokuDao sudoku1 = sudoku.getSudokuDaoList().get(0);
        
        assertEquals(sudoku1, sudoku.getSudokuDao(0));
    }
    
    @Test
    public void getSudokuList() {
        setUp();
        List<SudokuDao> list = sudoku.sudokulist;
        
        assertEquals(list, sudoku.getSudokuDaoList());
    }

    @Test
    public void getJFrame() {
        setUp();
        assertEquals(sudokuDao.window,sudokuDao.getJFrame());
    }
    
    @Test
    public void getSudokuPanel() {
        setUp();
        assertEquals(sudokuDao.sudokuPanel,sudokuDao.getSudokuPanel());
    }
    
    @Test
    public void getContainer() {
        setUp();
        assertEquals(sudokuDao.container,sudokuDao.getContainer());
    }
    
    @Test
    public void getSubPanelList() {
        setUp();
        assertEquals(sudokuDao.subpanelList,sudokuDao.getSubpanelList());
    }
    
    @Test
    public void getSudokuWidth() {
        setUp();
        assertEquals(sudokuDao.sudokuwidth,sudokuDao.getSudokuWidth());
    }
    
    @Test
    public void getSudokuHeight() {
        setUp();
        assertEquals(sudokuDao.sudokuheight,sudokuDao.getSudokuHeight());
    }
    
    @Test
    public void getJTextField() {
        setUp();
        Assert.assertArrayEquals(sudokuDao.jtf,sudokuDao.getJTextField());
    }
    
    @Test
    public void getShownDao() {
        setUp();
        assertEquals(sudokuDao.shown,sudokuDao.getShown());
    }
    
    @Test
    public void getJTextFieldList() {
        setUp();
        assertEquals(sudokuDao.jtfList,sudokuDao.getJTextFieldList());
    }
    
    @Test
    public void getOpened() {
        setUp();
        assertEquals(sudoku.getOpened(0),false);
    }
    
    @Test
    public void setOpened() {
        setUp();
        sudoku.setOpened(2);
        assertEquals(sudoku.opened[2], true);
    }
    
    @Test
    public void checkIfCorrectTrue() {
        setUp();
        
        sudoku.getSudokuDao(0).jtfList.clear();
        for (int i = 0; i < 81; i++) {
            JTextField j = new JTextField(puzzle.getNumbersString(0)[i]);
            sudoku.getSudokuDao(0).jtfList.add(j);
        }
        
        assertEquals(sudoku.checkIfCorrect(0), true);
    }
    
    @Test
    public void checkIfCorrectFalse() {
        setUp();
        
        sudoku.getSudokuDao(0).jtfList.clear();
        for (int i = 0; i < 81; i++) {
            JTextField j = new JTextField(puzzle.getNumbersString(0)[i]);
            sudoku.getSudokuDao(0).jtfList.add(j);
        }
        
        sudoku.getSudokuDao(0).jtfList.get(30).setText(10 + "");
        
        assertEquals(sudoku.checkIfCorrect(0), false);
    }
    
    
}
