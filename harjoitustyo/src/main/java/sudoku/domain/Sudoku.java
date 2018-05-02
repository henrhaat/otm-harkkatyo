package sudoku.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sudoku.dao.SudokuDao;

public class Sudoku {

    public List<SudokuDao> sudokulist;
    public Puzzle puzzle = new Puzzle();
    public Boolean[] opened = {false, false, false, false, false};
    public Connection conn;
    public String name;

    public Sudoku() throws SQLException {
        setUp();
    }

    private void setUp() throws SQLException {
        this.sudokulist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SudokuDao sudoku = new SudokuDao(i);
            this.sudokulist.add(sudoku);
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void setName(String name) {
        this.name = name;
    }

    public Connection getConnection() {
        return this.conn;
    }

    public boolean getCompleted(int i) throws SQLException {
        int a = i+1;
        PreparedStatement stmt
                = conn.prepareStatement("SELECT Completed" + a +" FROM User WHERE name = '" + name+ "'");
        ResultSet tulos = stmt.executeQuery();
        tulos.next();
        
        
        return tulos.getBoolean("Completed" + a);
    }
    
    public void setCompleted(int i) throws SQLException {
        List<Boolean> list = new ArrayList<>();
        for (int b = 0; b < 5; b++) {
            if (b == i) {
                list.add(true);
            } else {
                list.add(getCompleted(b));
            }
        }
        
        PreparedStatement stmt
                = conn.prepareStatement("DELETE FROM User WHERE name = ?");
        stmt.setString(1, name);
        stmt.executeUpdate();
        PreparedStatement stmt1
                = conn.prepareStatement("INSERT INTO User (name, completed1, completed2, completed3, completed4, completed5) "
                        + "VALUES (?,?,?,?,?,?)");
        stmt1.setString(1, name);
        stmt1.setBoolean(2, list.get(0));
        stmt1.setBoolean(3, list.get(1));
        stmt1.setBoolean(4, list.get(2));
        stmt1.setBoolean(5, list.get(3));
        stmt1.setBoolean(6, list.get(4));
        stmt1.executeUpdate();
        
    }
    
    public boolean checkIfNameExists(String name) throws SQLException {
        PreparedStatement stmt
                = conn.prepareStatement("SELECT name FROM User WHERE name = ?");
        stmt.setString(1, name);
        ResultSet tulos = stmt.executeQuery();
        return tulos.next();
    }
    
    public void addNameToDatabase(String name) throws SQLException {
        PreparedStatement stmt
                = conn.prepareStatement("INSERT INTO User (name, completed1, completed2, completed3, completed4, completed5) "
                        + "VALUES (?,?,?,?,?,?)");
        stmt.setString(1, name);
        stmt.setBoolean(2, false);
        stmt.setBoolean(3, false);
        stmt.setBoolean(4, false);
        stmt.setBoolean(5, false);
        stmt.setBoolean(6, false);
        stmt.executeUpdate();
    }
}
