package sudoku.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sudoku.domain.Sudoku;

public class SudokuUi {

    Sudoku sudokudomain = new Sudoku();

    public void start() {
        createLogin();
    }

    private void createGrid(int n) {
        sudokudomain.getSudokuDao(n).window.setTitle("Sudoku");
        sudokudomain.getSudokuDao(n).window.setSize(sudokudomain.getSudokuDao(n).sudokuwidth + 150, sudokudomain.getSudokuDao(n).sudokuheight);
        sudokudomain.getSudokuDao(n).sudokuPanel.setLayout(new GridLayout(3, 3, 5, 5));
        sudokudomain.getSudokuDao(n).sudokuPanel.setBackground(Color.black);
        this.sudokudomain.getSudokuDao(n).container = sudokudomain.getSudokuDao(n).window.getContentPane();
    }

    private void setNumbers(int n) {
        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 3; row++) {
                    sudokudomain.getSudokuDao(n).jtf[row][col] = new JTextField();
                    Font f = sudokudomain.getSudokuDao(n).jtf[0][0].getFont();
                    Font f2 = f.deriveFont((float) 25);
                    sudokudomain.getSudokuDao(n).jtf[row][col].setFont(f2);
                    panel.add(sudokudomain.getSudokuDao(n).jtf[row][col]);
                    sudokudomain.getSudokuDao(n).jtf[row][col].setText(sudokudomain.getSudokuDao(n).numbersString[3 * col + row + 9 * i]);
                    setMask(row, col, i, n);
                    sudokudomain.getSudokuDao(n).jtfList.add(sudokudomain.getSudokuDao(n).jtf[row][col]);
                }
            }
            sudokudomain.getSudokuDao(n).sudokuPanel.add(panel);
            sudokudomain.getSudokuDao(n).subpanelList.add(panel);
        }
    }

    private void setMask(int row, int col, int i, int n) {
        if (sudokudomain.getSudokuDao(n).shown[3 * col + row + 9 * i]) {
            sudokudomain.getSudokuDao(n).jtf[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokudomain.getSudokuDao(n).jtf[row][col].setEditable(false);
        } else {
            sudokudomain.getSudokuDao(n).jtf[row][col].setText("");
            sudokudomain.getSudokuDao(n).jtf[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokudomain.getSudokuDao(n).jtf[row][col].setEditable(true);
        }
    }

    private void createWindow(int n) {
        sudokudomain.getSudokuDao(n).container.add(sudokudomain.getSudokuDao(n).sudokuPanel, BorderLayout.CENTER);
        this.createRightPanel(n);
        sudokudomain.getSudokuDao(n).window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sudokudomain.getSudokuDao(n).window.setVisible(true);

    }

    private void createRightPanel(int n) {
        sudokudomain.getSudokuDao(n).rightPanel.setLayout(new BoxLayout(sudokudomain.getSudokuDao(n).rightPanel, BoxLayout.Y_AXIS));
        sudokudomain.getSudokuDao(n).container.add(sudokudomain.getSudokuDao(n).rightPanel, BorderLayout.EAST);
        addCheckButton(n);
        addResetButton(n);
        addMenuButton(n);
    }

    private void addMenuButton(int n) {
        JButton button = new JButton("Main menu");
        sudokudomain.getSudokuDao(n).rightPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuButtonPressed(n);
            }
        });
    }

    private void addCheckButton(int n) {
        JButton button = new JButton("Ready");
        sudokudomain.getSudokuDao(n).rightPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkButtonPressed(n);
            }
        });
    }

    private void addResetButton(int n) {
        JButton button = new JButton("Reset");
        sudokudomain.getSudokuDao(n).rightPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButtonPressed(n);
            }
        });
    }

    private void menuButtonPressed(int n) {
        sudokudomain.getSudokuDao(n).window.setVisible(false);
        createMenu();
    }

    private void checkButtonPressed(int n) {
        JFrame checkFrame = new JFrame();
        JButton button = new JButton("Ok");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkFrame.setVisible(false);
            }
        });
        checkFrame.setTitle("Result");
        checkFrame.getContentPane().add(button, BorderLayout.SOUTH);
        if (sudokudomain.checkIfCorrect(n)) {
            JTextField jtext = new JTextField("Correct!");
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        } else {
            JTextField jtext = new JTextField("Some numbers are still wrong..");
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        }
        checkFrame.pack();
        checkFrame.setVisible(true);
    }

    private void resetButtonPressed(int n) {
        JFrame resetFrame = new JFrame();
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        JTextArea text = new JTextArea();
        text.setText("Are you sure you want to reset this puzzle?\nYou will lose your current progress");
        text.setEditable(false);
        resetFrame.setTitle("Reset");
        resetFrame.getContentPane().add(yes, BorderLayout.WEST);
        resetFrame.getContentPane().add(no, BorderLayout.EAST);
        resetFrame.getContentPane().add(text, BorderLayout.NORTH);

        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFrame.setVisible(false);
            }
        });

        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFrame.setVisible(false);
                for (int i = 0; i < 81; i++) {
                    if (!sudokudomain.getSudokuDao(n).shown[i]) {
                        sudokudomain.getSudokuDao(n).jtfList.get(i).setText("");
                    }
                }

            }
        });

        resetFrame.pack();
        resetFrame.setVisible(true);
    }

    public void createLogin() {
        JFrame login = new JFrame();
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        login.setTitle("Login");

        JPanel lpanel = new JPanel();
        lpanel.setLayout(new GridBagLayout());

        JTextField text = new JTextField("     Login or create new user     ");
        text.setEditable(false);

        JTextField text1 = new JTextField("");
        text1.setHorizontalAlignment(JTextField.CENTER);

        JButton button = new JButton("Login");

        Font f = text.getFont();
        Font f2 = f.deriveFont((float) 30);

        text.setFont(f2);
        text1.setFont(f2);
        button.setFont(f2);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonPressed(text1);
                login.setVisible(false);
            }
        });

        login.getContentPane().add(text, BorderLayout.NORTH);
        login.getContentPane().add(text1, BorderLayout.CENTER);
        login.getContentPane().add(button, BorderLayout.SOUTH);

        login.pack();
        login.setVisible(true);
    }

    private void loginButtonPressed(JTextField text) {
        createMenu();
        // lisää toiminnallisuus
    }

    private void createMenu() {
        JFrame menu = new JFrame();
        menu.setTitle("Main menu");
        menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel menupanel = new JPanel();
        menupanel.setLayout(new GridLayout(1, 5, 5, 5));
        FlowLayout flow = new FlowLayout();
        menu.getContentPane().add(menupanel, BorderLayout.CENTER);

        JTextField text = new JTextField("Choose level:");
        text.setEditable(false);
        text.setHorizontalAlignment(JTextField.CENTER);
        menu.getContentPane().add(text, BorderLayout.NORTH);

        Font f = text.getFont();
        Font f2 = f.deriveFont((float) 30);

        for (int i = 1; i < 6; i++) {
            JButton button = new JButton();
            button.setText(i + "");
            button.setFont(f2);
            menupanel.add(button);
            final int a = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    menu.setVisible(false);
                    levelButtonPressed(a);
                }
            });
        }

        text.setFont(f2);

        menu.setSize(1000, 1000);
        menu.pack();
        menu.setVisible(true);
    }

    private void levelButtonPressed(int i) {
        if (sudokudomain.getOpened(i - 1)) {
            sudokudomain.getSudokuDao(i - 1).window.setVisible(true);
        } else {
            createGrid(i - 1);
            setNumbers(i - 1);
            createWindow(i - 1);
            sudokudomain.setOpened(i - 1);
        }
    }

    private void close(int n) {
        sudokudomain.getSudokuDao(n).window.dispatchEvent(new WindowEvent(sudokudomain.getSudokuDao(n).window, WindowEvent.WINDOW_CLOSING));
    }

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        s.launch();
    }

}
