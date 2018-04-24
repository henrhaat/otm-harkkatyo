package sudoku.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sudoku.domain.Sudoku;

public class SudokuUi {

    Sudoku sudokuDomain = new Sudoku();

    private void createGrid(int n) {
        sudokuDomain.getSudokuDao(n).getJFrame().setTitle("Sudoku");
        sudokuDomain.getSudokuDao(n).getJFrame().setSize(sudokuDomain.getSudokuDao(n).getSudokuWidth() + 150, sudokuDomain.getSudokuDao(n).getSudokuHeight());
        sudokuDomain.getSudokuDao(n).getSudokuPanel().setLayout(new GridLayout(3, 3, 5, 5));
        sudokuDomain.getSudokuDao(n).getSudokuPanel().setBackground(Color.black);
        this.sudokuDomain.getSudokuDao(n).container = sudokuDomain.getSudokuDao(n).getJFrame().getContentPane();
    }

    private void setNumbers(int n) {
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

    private void setMask(int row, int col, int i, int n) {
        if (sudokuDomain.getSudokuDao(n).getShown()[3 * col + row + 9 * i]) {
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setEditable(false);
        } else {
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setText("");
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokuDomain.getSudokuDao(n).getJTextField()[row][col].setEditable(true);
        }
    }

    private void createWindow(int n) {
        sudokuDomain.getSudokuDao(n).container.add(sudokuDomain.getSudokuDao(n).getSudokuPanel(), BorderLayout.CENTER);
        this.createRightPanel(n);
        sudokuDomain.getSudokuDao(n).getJFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sudokuDomain.getSudokuDao(n).getJFrame().setLocationRelativeTo(null);
        sudokuDomain.getSudokuDao(n).getJFrame().setVisible(true);

    }

    private void createRightPanel(int n) {
        sudokuDomain.getSudokuDao(n).getRightPanel().setLayout(new BoxLayout(sudokuDomain.getSudokuDao(n).getRightPanel(), BoxLayout.Y_AXIS));
        sudokuDomain.getSudokuDao(n).container.add(sudokuDomain.getSudokuDao(n).getRightPanel(), BorderLayout.EAST);
        addCheckButton(n);
        addResetButton(n);
        addMenuButton(n);
    }

    private void addMenuButton(int n) {
        JButton button = new JButton("Main menu");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuButtonPressed(n);
            }
        });
    }

    private void addCheckButton(int n) {
        JButton button = new JButton("Ready");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkButtonPressed(n);
            }
        });
    }

    private void addResetButton(int n) {
        JButton button = new JButton("Reset");
        sudokuDomain.getSudokuDao(n).getRightPanel().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButtonPressed(n);
            }
        });
    }

    private void menuButtonPressed(int n) {
        sudokuDomain.getSudokuDao(n).getJFrame().setVisible(false);
        createMenu();
    }

    private void checkButtonPressed(int n) {
        JFrame checkFrame = new JFrame();
        checkFrame.setTitle("Result");
        this.addOkButton(checkFrame);
        if (sudokuDomain.checkIfCorrect(n)) {
            JTextArea jtext = new JTextArea("Correct!");;
            jtext.setEditable(false);
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        } else {
            JTextArea jtext = new JTextArea("Some numbers are still wrong..");
            jtext.setEditable(false);
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        }
        checkFrame.pack();
        checkFrame.setLocationRelativeTo(null);
        checkFrame.setVisible(true);
    }
    
    private void addOkButton(JFrame checkFrame) {
        JButton button = new JButton("Ok");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkFrame.setVisible(false);
            }
        });
        checkFrame.getContentPane().add(button, BorderLayout.SOUTH);
    }

    private void resetButtonPressed(int n) {
        JFrame resetframe = new JFrame();
        
        JTextArea text = new JTextArea();
        text.setText("Are you sure you want to reset this puzzle?\nYou will lose your current progress");
        text.setEditable(false);
        resetframe.setTitle("Reset");
        
        this.addYesReset(resetframe, n);
        this.addNoReset(resetframe);
        resetframe.getContentPane().add(text, BorderLayout.NORTH);

        resetframe.pack();
        resetframe.setLocationRelativeTo(null);
        resetframe.setVisible(true);
    }
    
    private void addNoReset(JFrame resetframe) {
        JButton no = new JButton("No");
        resetframe.getContentPane().add(no, BorderLayout.EAST);
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetframe.setVisible(false);
            }
        });
    }

    private void addYesReset(JFrame resetframe, int n) {
        JButton yes = new JButton("Yes");
        resetframe.getContentPane().add(yes, BorderLayout.WEST);
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetframe.setVisible(false);
                for (int i = 0; i < 81; i++) {
                    if (!sudokuDomain.getSudokuDao(n).getShown()[i]) {
                        sudokuDomain.getSudokuDao(n).getJTextFieldList().get(i).setText("");
                    }
                }

            }
        });
    }

    private void createLogin() {
        JFrame login = new JFrame();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setTitle("Login");
        JPanel lpanel = new JPanel();
        lpanel.setLayout(new GridBagLayout());
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

    private void addLoginButton(JFrame login, JTextField text1) {
        JButton button = new JButton("Login");
        button.setFont(getFont(text1, 30));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonPressed(text1);
                login.setVisible(false);
            }
        });
        login.getContentPane().add(button, BorderLayout.SOUTH);
    }

    private void loginButtonPressed(JTextField text1) {
        createMenu();
        // lisää toiminnallisuus
    }

    private void createMenu() {
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

    private void addMenuPanelButtons(JFrame menu, JPanel menupanel, JTextField text) {
        for (int i = 1; i < 6; i++) {
            JButton button = new JButton();
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

    private void levelButtonPressed(int i) {
        if (sudokuDomain.getOpened(i - 1)) {
            sudokuDomain.getSudokuDao(i - 1).getJFrame().setVisible(true);
        } else {
            createGrid(i - 1);
            setNumbers(i - 1);
            createWindow(i - 1);
            sudokuDomain.setOpened(i - 1);
        }
    }

    public Font getFont(JTextField text, float a) {
        return text.getFont().deriveFont(a);
    }

    public static void main(String[] args) {
        SudokuUi su = new SudokuUi();
        su.createLogin();
    }

}
