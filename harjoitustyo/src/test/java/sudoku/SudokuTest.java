package sudoku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import sudoku.dao.SudokuDao;
import sudoku.domain.Puzzle;
import sudoku.domain.Sudoku;

public class SudokuTest {

    SudokuDao sudokuDao;
    Sudoku sudoku;
    Puzzle puzzle;
    Connection conn;
    String name;

    @Before
    public void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        name = "Testimies";
        sudokuDao = new SudokuDao(0, conn);
        sudoku = new Sudoku();
        puzzle = new Puzzle();
        setUpDatabase();
    }

    @After
    public void closeConnection() throws SQLException {
        conn.close();
    }

    public void setUpDatabase() throws SQLException {
        PreparedStatement stmt
                = conn.prepareStatement("DELETE FROM User WHERE name = ?");
        stmt.setString(1, name);
        stmt.executeUpdate();
        PreparedStatement stmt1
                = conn.prepareStatement("INSERT INTO User (name, completed1, completed2, completed3, completed4, completed5) "
                        + "VALUES (?,?,?,?,?,?)");
        stmt1.setString(1, name);
        stmt1.setBoolean(2, true);
        stmt1.setBoolean(3, true);
        stmt1.setBoolean(4, false);
        stmt1.setBoolean(5, false);
        stmt1.setBoolean(6, false);
        stmt1.executeUpdate();
    }

    public void boxPassesRules(int n) {
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
        boolean t = true;
        boolean f = false;
        boolean[] shown = {f, f, f, t, t, f, t, t, f, t, t, f, f, t, f, f, f, t, t, f, t, f, t, f, t, f, f,
            t, t, f, f, f, t, f, t, f, t, f, f, t, f, t, f, f, t, f, t, f, t, f, f, f, t, t,
            f, f, t, f, t, f, t, f, t, t, f, f, f, t, f, f, t, t, f, t, t, f, t, t, f, f, f};
        assertEquals(Arrays.toString(shown), Arrays.toString(puzzle.getShown(0)));
    }

    @Test
    public void getNumbers() {
        String[] numbersString = {"4", "3", "5", "6", "8", "2", "1", "9", "7", "2", "6", "9", "5", "7", "1", "8", "3", "4", "7", "8", "1", "4", "9", "3", "5", "6", "2",
            "8", "2", "6", "3", "7", "4", "9", "5", "1", "1", "9", "5", "6", "8", "2", "7", "4", "3", "3", "4", "7", "9", "1", "5", "6", "2", "8",
            "5", "1", "9", "2", "4", "8", "7", "6", "3", "3", "2", "6", "9", "5", "7", "4", "1", "8", "8", "7", "4", "1", "3", "6", "2", "5", "9"};
        assertEquals(Arrays.toString(numbersString), Arrays.toString(puzzle.getNumbersString(0)));
    }

    @Test
    public void getSudoku() {
        SudokuDao sudoku1 = sudoku.getSudokuDaoList().get(0);
        assertEquals(sudoku1, sudoku.getSudokuDao(0));
    }

    @Test
    public void getSudokuList() {
        List<SudokuDao> list = sudoku.sudokulist;
        assertEquals(list, sudoku.getSudokuDaoList());
    }

    @Test
    public void getJFrame() {
        assertEquals(sudokuDao.window, sudokuDao.getJFrame());
    }

    @Test
    public void getSudokuPanel() {
        assertEquals(sudokuDao.sudokuPanel, sudokuDao.getSudokuPanel());
    }

    @Test
    public void getContainer() {
        assertEquals(sudokuDao.container, sudokuDao.getContainer());
    }

    @Test
    public void getSubPanelList() {
        assertEquals(sudokuDao.subpanelList, sudokuDao.getSubpanelList());
    }

    @Test
    public void getSudokuWidth() {
        assertEquals(sudokuDao.sudokuwidth, sudokuDao.getSudokuWidth());
    }

    @Test
    public void getSudokuHeight() {
        assertEquals(sudokuDao.sudokuheight, sudokuDao.getSudokuHeight());
    }

    @Test
    public void getJTextField() {
        Assert.assertArrayEquals(sudokuDao.jtf, sudokuDao.getJTextField());
    }

    @Test
    public void getShownDao() {
        assertEquals(sudokuDao.shown, sudokuDao.getShown());
    }

    @Test
    public void getJTextFieldList() {
        assertEquals(sudokuDao.jtfList, sudokuDao.getJTextFieldList());
    }

    @Test
    public void getRightPanel() {
        assertEquals(sudokuDao.rightPanel, sudokuDao.getRightPanel());
    }

    @Test
    public void getOpened() {
        assertFalse(sudoku.getOpened(0));
    }

    @Test
    public void setOpened() {
        sudoku.setOpened(2);
        assertTrue(sudoku.opened[2]);
    }

    @Test
    public void checkIfCorrectTrue() {
        sudoku.getSudokuDao(0).jtfList.clear();
        for (int i = 0; i < 81; i++) {
            JTextField j = new JTextField(puzzle.getNumbersString(0)[i]);
            sudoku.getSudokuDao(0).jtfList.add(j);
        }

        assertTrue(sudoku.checkIfCorrect(0));
    }

    @Test
    public void checkIfCorrectFalse() {
        sudoku.getSudokuDao(0).jtfList.clear();
        for (int i = 0; i < 81; i++) {
            JTextField j = new JTextField(puzzle.getNumbersString(0)[i]);
            sudoku.getSudokuDao(0).jtfList.add(j);
        }

        sudoku.getSudokuDao(0).jtfList.get(30).setText(10 + "");

        assertFalse(sudoku.checkIfCorrect(0));
    }

    @Test
    public void setName() {
        sudokuDao.setName("Testimies");
        assertEquals(sudokuDao.name, "Testimies");
    }

    @Test
    public void getCompleted() throws SQLException {
        sudokuDao.setName("Testimies");
        assertTrue(sudokuDao.getCompleted(0));
    }

    @Test
    public void setCompleted() throws SQLException {
        sudokuDao.setName("Testimies");
        assertFalse(sudokuDao.getCompleted(3));
        sudokuDao.setCompleted(3);
        assertTrue(sudokuDao.getCompleted(3));
    }

    @Test
    public void getConnection() {
        assertEquals(sudokuDao.conn, sudokuDao.getConnection());
    }

    @Test
    public void checkIfNameExistsTrue() throws SQLException {
        assertTrue(sudokuDao.checkIfNameExists(name));
    }

    @Test
    public void checkIfNameExistsFalse() throws SQLException {
        assertFalse(sudokuDao.checkIfNameExists("EiOlemassa"));
    }

    @Test
    public void addNameToDatabase() throws SQLException {
        String testname = "testname";
        sudokuDao.addNameToDatabase(testname);
        assertTrue(sudokuDao.checkIfNameExists("testname"));
        PreparedStatement stmt
                = conn.prepareStatement("DELETE FROM User WHERE name = ?");
        stmt.setString(1, testname);
        stmt.executeUpdate();
    }

}
