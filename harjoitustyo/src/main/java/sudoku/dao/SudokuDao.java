package sudoku.dao;

import sudoku.domain.Puzzle;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sudoku.domain.Sudoku;

/**
 * Luokka sisältää sudokuun tarvittavia muuttujia ja yhteyden tietokantaan
 */
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

    public Connection conn;
    public String name;

    public SudokuDao(int n) {
        Puzzle puzzle = new Puzzle();
        this.shown = puzzle.getShown(n);
        this.numbersString = puzzle.getNumbersString(n);
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (SQLException ex) {
            Logger.getLogger(Sudoku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getNumbers() {
        return this.numbersString;
    }

    public JFrame getJFrame() {
        return this.window;
    }

    public JPanel getSudokuPanel() {
        return this.sudokuPanel;
    }

    public JPanel getRightPanel() {
        return this.rightPanel;
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

    /**
     * Metodi testaa, onko tämänhetkinen käyttäjä läpäissyt Sudokun numero i
     *
     * @param i Sudokun numero
     * @return true jos käyttäjä on läpäissyt Sudokun numero i, muuten false
     * @throws java.sql.SQLException
     *
     */
    public boolean getCompleted(int i) throws SQLException {
        int a = i + 1;
        PreparedStatement stmt
                = conn.prepareStatement("SELECT Completed" + a + " FROM User WHERE name = '" + name + "'");
        ResultSet tulos = stmt.executeQuery();
        tulos.next();

        return tulos.getBoolean("Completed" + a);
    }

    /**
     * Metodi asettaa Sudokun numero i suoritetuksi tämänhetkiselle käyttäjälle
     *
     * @param i Sudokun numero
     * @throws java.sql.SQLException
     *
     */
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

    /**
     * Metodi tarkistaa tietokannasta, onko kyseinen käyttäjänimi jo käytössä
     *
     * @param name käyttäjänimi
     * @return true, jos on käytössä ja false, jos ei ole käytössä
     * @throws java.sql.SQLException
     *
     */
    public boolean checkIfNameExists(String name) throws SQLException {
        PreparedStatement stmt
                = conn.prepareStatement("SELECT name FROM User WHERE name = ?");
        stmt.setString(1, name);
        ResultSet tulos = stmt.executeQuery();
        return tulos.next();
    }

    /**
     * Metodi lisää käyttäjänimen tietokantaan
     *
     * @param name käyttäjänimi
     * @throws java.sql.SQLException
     *
     */
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
    
    public void setName(String name) {
        this.name = name;
    }

    public Connection getConnection() {
        return this.conn;
    }

}
