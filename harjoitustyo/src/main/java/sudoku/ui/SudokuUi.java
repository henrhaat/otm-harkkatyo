package sudoku.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sudoku.domain.Sudoku;

/**
 * Luokka luo Sudoku-pelille käyttöliittymän
 */
public class SudokuUi {

    Sudoku sudokuDomain;

    public SudokuUi() throws SQLException {
        this.sudokuDomain = new Sudoku();
    }

    /**
     * Metodi luo sudokupohjan
     *
     * @param n Sudokun numero
     *
     */
    public void createGrid(int n) {
        sudokuDomain.getSudokuDao(n).getJFrame().setTitle("Sudoku");
        sudokuDomain.getSudokuDao(n).getJFrame().setSize(sudokuDomain.getSudokuDao(n).getSudokuWidth() + 150, sudokuDomain.getSudokuDao(n).getSudokuHeight());
        sudokuDomain.getSudokuDao(n).getSudokuPanel().setLayout(new GridLayout(3, 3, 5, 5));
        sudokuDomain.getSudokuDao(n).getSudokuPanel().setBackground(Color.black);
        this.sudokuDomain.getSudokuDao(n).container = sudokuDomain.getSudokuDao(n).getJFrame().getContentPane();
    }

    /**
     * Metodi asettaa sudokupohjaan numerot
     *
     * @param n Sudokun numero
     *
     */
    public void setNumbers(int n) {
        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 3; row++) {
                    sudokuDomain.getSudokuDao(n).getJTextField()[row][col] = new JTextField();
                    sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setFont(this.getFont(sudokuDomain.getSudokuDao(n).getJTextField()[0][0], 25));
                    panel.add(sudokuDomain.getSudokuDao(n).getJTextField()[row][col]);
                    sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setText(sudokuDomain.getSudokuDao(n).getNumbers()[3 * col + row + 9 * i]);
                    setMask(row, col, i, n);
                    sudokuDomain.getSudokuDao(n).getJTextFieldList().add(sudokuDomain.getSudokuDao(n).getJTextField()[row][col]);
                }
            }
            sudokuDomain.getSudokuDao(n).getSudokuPanel().add(panel);
            sudokuDomain.getSudokuDao(n).getSubpanelList().add(panel);
        }
    }

    /**
     * Metodi asettaa sudokupohjan numeroille maskit
     *
     * @param row rivi
     * @param col kolumni
     * @param i 3x3 ruudukon numero
     * @param n Sudokun numero
     *
     */
    public void setMask(int row, int col, int i, int n) {
        if (sudokuDomain.getSudokuDao(n).getShown()[3 * col + row + 9 * i]) {
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setEditable(false);
        } else {
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setText("");
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setEditable(true);
        }
    }

    /**
     * Metodi luo Sudoku-ikkunan
     *
     * @param n Sudokun numero
     *
     */
    public void createWindow(int n) {
        sudokuDomain.getSudokuDao(n).container.add(sudokuDomain.getSudokuDao(n).getSudokuPanel(), BorderLayout.CENTER);
        this.createRightPanel(n);
        sudokuDomain.getSudokuDao(n).getJFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sudokuDomain.getSudokuDao(n).getJFrame().setLocationRelativeTo(null);
        sudokuDomain.getSudokuDao(n).getJFrame().setVisible(true);

    }

    /**
     * Metodi luo Sudoku-ikkunalle oikean paneelin
     *
     * @param n Sudokun numero
     * 
     */
    public void createRightPanel(int n) {
        sudokuDomain.getSudokuDao(n).getRightPanel().setLayout(new BoxLayout(sudokuDomain.getSudokuDao(n).getRightPanel(), BoxLayout.Y_AXIS));
        sudokuDomain.getSudokuDao(n).container.add(sudokuDomain.getSudokuDao(n).getRightPanel(), BorderLayout.EAST);
        addCheckButton(n);
        addResetButton(n);
        addMenuButton(n);
        addHintButton(n);
    }

    /**
     * Metodi lisää Sudoku-ikkunan oikeaan paneeliin "Menu" napin
     *
     * @param n Sudokun numero
     *
     */
    public void addMenuButton(int n) {
        JButton button = new JButton("Main menu");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    menuButtonPressed(n);
                } catch (SQLException ex) {
                    Logger.getLogger(SudokuUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * Metodi lisää Sudoku-ikkunan oikeaan paneeliin "Ready" napin
     *
     * @param n Sudokun numero
     *
     */
    public void addCheckButton(int n) {
        JButton button = new JButton("Ready");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkButtonPressed(n);
            }
        });
    }

    /**
     * Metodi lisää Sudoku-ikkunan oikeaan paneeliin "Reset" napin
     *
     * @param n Sudokun numero
     *
     */
    public void addResetButton(int n) {
        JButton button = new JButton("Reset");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButtonPressed(n);
            }
        });
    }

    /**
     * Metodi lisää "Menu" napille toimivuuden
     *
     * @param n Sudokun numero
     * @throws java.sql.SQLException
     *
     */
    public void menuButtonPressed(int n) throws SQLException {
        sudokuDomain.getSudokuDao(n).getJFrame().setVisible(false);
        createMenu();
    }

    /**
     * Metodi lisää "Ready" napille toimivuuden
     *
     * @param n Sudokun numero
     *
     */
    public void checkButtonPressed(int n) {
        JFrame checkFrame = new JFrame();
        checkFrame.setTitle("Result");
        this.addOkButton(checkFrame);
        if (sudokuDomain.checkIfCorrect(n)) {
            this.correct(checkFrame, n);
        } else {
            JTextArea jtext = new JTextArea("Some numbers are still wrong..");
            jtext.setEditable(false);
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        }
        checkFrame.pack();
        checkFrame.setLocationRelativeTo(null);
        checkFrame.setVisible(true);
    }

    /**
     * Metodi luo "oikein" ikkunan
     * @param frame ikkuna
     * @param n Sudokun numero
     */
    public void correct(JFrame frame, int n) {
        JTextArea jText = new JTextArea("Correct!");;
        jText.setEditable(false);
        frame.getContentPane().add(jText, BorderLayout.NORTH);
        try {
            sudokuDomain.getSudokuDao(0).setCompleted(n);
        } catch (SQLException ex) {
            Logger.getLogger(SudokuUi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodi lisää "Ok" napin ikkunaan
     *
     * @param checkFrame ikkuna
     *
     */
    public void addOkButton(JFrame checkFrame) {
        JButton button = new JButton("Ok");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkFrame.setVisible(false);
            }
        });
        checkFrame.getContentPane().add(button, BorderLayout.SOUTH);
    }

    /**
     * Metodi lisää "Reset" napille toimivuuden
     *
     * @param n Sudokun numero
     *
     */
    public void resetButtonPressed(int n) {
        JFrame resetFrame = new JFrame();

        JTextArea text = new JTextArea();
        text.setText("Are you sure you want to reset this puzzle?\nYou will lose your current progress");
        text.setEditable(false);
        resetFrame.setTitle("Reset");

        this.addYesReset(resetFrame, n);
        this.addNoReset(resetFrame);
        resetFrame.getContentPane().add(text, BorderLayout.NORTH);

        resetFrame.pack();
        resetFrame.setLocationRelativeTo(null);
        resetFrame.setVisible(true);
    }

    /**
     * Metodi lisää "Reset" ikkunalle "No" napin ja sen toimivuuden
     *
     * @param resetFrame ikkuna
     *
     */
    public void addNoReset(JFrame resetFrame) {
        JButton no = new JButton("No");
        resetFrame.getContentPane().add(no, BorderLayout.EAST);
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFrame.setVisible(false);
            }
        });
    }

    /**
     * Metodi lisää "Reset" ikkunalle "Yes" napin ja sen toimivuuden
     *
     * @param resetFrame ikkuna
     * @param n Sudokun numero
     *
     */
    public void addYesReset(JFrame resetFrame, int n) {
        JButton yes = new JButton("Yes");
        resetFrame.getContentPane().add(yes, BorderLayout.WEST);
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFrame.setVisible(false);
                for (int i = 0; i < 81; i++) {
                    if (!sudokuDomain.getSudokuDao(n).getShown()[i]) {
                        sudokuDomain.getSudokuDao(n).getJTextFieldList().get(i).setText("");
                        sudokuDomain.getSudokuDao(n).getJTextFieldList().get(i).setBackground(Color.white);
                    }
                }

            }
        });
    }

    /**
     * Metodi lisää Sudoku-ikkunan oikeaan paneeliin "Hint" napin
     *
     * @param n Sudokun numero
     *
     */

    public void addHintButton(int n) {
        JButton button = new JButton("Hint");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sudokuDomain.hint(n);
                JFrame hint = new JFrame();
                hint.setTitle("Hint");
                JTextField hintText = new JTextField("All wrongly filled cells are colored red");
                hintText.setEditable(false);
                hint.getContentPane().add(hintText, BorderLayout.NORTH);
                addOkButton(hint);
                hint.pack();
                hint.setLocationRelativeTo(null);
                hint.setVisible(true);
            }
        });
    }

    /**
     * Metodi luo kirjautumisikkunan
     * @throws java.sql.SQLException
     */
    public void createLogin() throws SQLException {
        JFrame login = new JFrame();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setTitle("Login");
        JTextField text = new JTextField("     Login or create new user     ");
        text.setEditable(false);
        JTextField text1 = new JTextField("");
        text1.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(getFont(text, 30));
        text1.setFont(getFont(text, 30));
        login.getContentPane().add(text, BorderLayout.NORTH);
        login.getContentPane().add(text1, BorderLayout.CENTER);
        this.addLoginButton(login, text1);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    /**
     * Metodi lisää kirjautumisikkunalle "Login" napin
     *
     * @param login ikkuna
     * @param text1 textfield
     *
     */
    public void addLoginButton(JFrame login, JTextField text1) {
        JButton button = new JButton("Login");
        button.setFont(getFont(text1, 30));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    loginButtonPressed(login, text1);
                } catch (SQLException ex) {
                    Logger.getLogger(SudokuUi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        login.getContentPane().add(button, BorderLayout.SOUTH);
    }

    /**
     * Metodi lisää "Login" napille toimivuuden
     *
     * @param login ikkuna
     * @param text1 textfield
     * @throws java.sql.SQLException
     *
     */
    public void loginButtonPressed(JFrame login, JTextField text1) throws SQLException {
        if (text1.getText().length() < 3) {
            this.creteShortWarning();
        } else {
            sudokuDomain.getSudokuDao(0).setName(text1.getText());
            if (!sudokuDomain.getSudokuDao(0).checkIfNameExists(text1.getText())) {
                sudokuDomain.getSudokuDao(0).addNameToDatabase(text1.getText());
            }
            createMenu();
            login.setVisible(false);
        }
    }

    public void creteShortWarning() {
        JFrame warning = new JFrame();
        JTextField text = new JTextField("Username has to be at least 3 characters long");
        text.setEditable(false);
        warning.getContentPane().add(text, BorderLayout.NORTH);
        this.addOkButton(warning);
        warning.pack();
        warning.setLocationRelativeTo(null);
        warning.setVisible(true);
    }

    /**
     * Metodi luo päävalikkoikkunan
     * @throws java.sql.SQLException
     */
    public void createMenu() throws SQLException {
        JFrame menu = new JFrame();
        menu.setTitle("Main menu");
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel menupanel = new JPanel();
        menupanel.setLayout(new GridLayout(1, 5, 5, 5));
        menu.getContentPane().add(menupanel, BorderLayout.CENTER);

        JTextField text = new JTextField("Choose level:");
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(getFont(text, 30));
        menu.getContentPane().add(text, BorderLayout.NORTH);

        this.addMenuPanelButtons(menu, menupanel, text);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    /**
     * Metodi lisää päävalikkoikkunalle sen napit
     *
     * @param menu ikkuna
     * @param menupanel paneeli napeille
     * @param text textfield
     * @throws java.sql.SQLException
     *
     */
    public void addMenuPanelButtons(JFrame menu, JPanel menupanel, JTextField text) throws SQLException {
        for (int i = 1; i < 6; i++) {
            JButton button = new JButton();
            if (sudokuDomain.getSudokuDao(0).getCompleted(i - 1)) {
                button.setBackground(Color.GREEN);
            }
            button.setText(i + "");
            button.setFont(getFont(text, 30));
            menupanel.add(button);
            final int a = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menu.setVisible(false);
                    levelButtonPressed(a);
                }
            });
        }
    }

    /**
     * Metodi lisää päävalikon napeille toimivuudet
     *
     * @param i Sudokun numero
     * 
     */
    public void levelButtonPressed(int i) {
        if (sudokuDomain.getOpened(i - 1)) {
            sudokuDomain.getSudokuDao(i - 1).getJFrame().setVisible(true);

        } else {
            createGrid(i - 1);
            setNumbers(i - 1);
            createWindow(i - 1);
            sudokuDomain.setOpened(i - 1);
        }
    }

    /**
     * Metodi palauttaa fontin textfieldistä, kun sen kokoa muutetaan kertoimen
     * verran
     *
     * @param text textfield
     * @param a kerroin
     * @return fontti koon muutoksen jälkeen
     */
    public Font getFont(JTextField text, float a) {
        return text.getFont().deriveFont(a);
    }

    public static void main(String[] args) throws SQLException {
        SudokuUi su = new SudokuUi();
        su.createLogin();

    }

}
