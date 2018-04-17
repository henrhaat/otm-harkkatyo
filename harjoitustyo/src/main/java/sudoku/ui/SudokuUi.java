
package sudoku.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
        int n = 0;
        createGrid(n);
        setNumbers(n);
        createWindow(n);
    }

    private void createGrid(int n) {
        sudokudomain.getSudoku(n).window.setTitle("Sudoku");
        sudokudomain.getSudoku(n).window.setSize(sudokudomain.getSudoku(n).sudokuwidth + 150, sudokudomain.getSudoku(n).sudokuheight);
        sudokudomain.getSudoku(n).sudokuPanel.setLayout(new GridLayout(3, 3, 5, 5));
        sudokudomain.getSudoku(n).sudokuPanel.setBackground(Color.black);
        this.sudokudomain.getSudoku(n).container = sudokudomain.getSudoku(n).window.getContentPane();
    }

    private void setNumbers(int n) {
        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 3; row++) {
                    sudokudomain.getSudoku(n).jtf[row][col] = new JTextField();
                    Font f = sudokudomain.getSudoku(n).jtf[0][0].getFont();
                    Font f2 = f.deriveFont((float) 25);
                    sudokudomain.getSudoku(n).jtf[row][col].setFont(f2);
                    panel.add(sudokudomain.getSudoku(n).jtf[row][col]);
                    sudokudomain.getSudoku(n).jtf[row][col].setText(sudokudomain.getSudoku(n).numbersString[3 * col + row + 9 * i]);
                    setMask(row, col, i, n);
                    sudokudomain.getSudoku(n).jtfList.add(sudokudomain.getSudoku(n).jtf[row][col]);
                }
            }
            sudokudomain.getSudoku(n).sudokuPanel.add(panel);
            sudokudomain.getSudoku(n).subpanelList.add(panel);
        }
    }

    private void setMask(int row, int col, int i, int n) {
        if (sudokudomain.getSudoku(n).shown[3 * col + row + 9 * i]) {
            sudokudomain.getSudoku(n).jtf[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokudomain.getSudoku(n).jtf[row][col].setEditable(false);
        } else {
            sudokudomain.getSudoku(n).jtf[row][col].setText("");
            sudokudomain.getSudoku(n).jtf[row][col].setHorizontalAlignment(JTextField.CENTER);
            sudokudomain.getSudoku(n).jtf[row][col].setEditable(true);
        }
    }

    private void createWindow(int n) {
        sudokudomain.getSudoku(n).container.add(sudokudomain.getSudoku(n).sudokuPanel, BorderLayout.CENTER);
        this.createRightPanel(n);
        sudokudomain.getSudoku(n).window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        sudokudomain.getSudoku(n).window.setVisible(true);

    }

    private void createRightPanel(int n) {
        sudokudomain.getSudoku(n).rightPanel.setLayout(new BoxLayout(sudokudomain.getSudoku(n).rightPanel, BoxLayout.Y_AXIS));
        sudokudomain.getSudoku(n).container.add(sudokudomain.getSudoku(n).rightPanel, BorderLayout.EAST);
        addCheckButton(n);
        addExitButton(n);
    }

    private void addExitButton(int n) {
        JButton button = new JButton("Main menu");
        sudokudomain.getSudoku(n).rightPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonPressed(n);
            }
        });
    }
    
    private void addCheckButton(int n) {        
        JButton button = new JButton("Ready");
        sudokudomain.getSudoku(n).rightPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkButtonPressed(n);
            }
        });
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
    
    private void exitButtonPressed(int n) {
        JFrame exitFrame = new JFrame();
        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");
        JTextArea text = new JTextArea();
        text.setText("Are you sure you want to exit?\nYou will lose your current progress");
        text.setEditable(false);
        exitFrame.setTitle("Exit");
        exitFrame.getContentPane().add(yes, BorderLayout.WEST);
        exitFrame.getContentPane().add(no, BorderLayout.EAST);
        exitFrame.getContentPane().add(text, BorderLayout.NORTH);
        
        no.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitFrame.setVisible(false);
            }
        });
        
        yes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitFrame.setVisible(false);
                sudokudomain.getSudoku(n).window.setVisible(false);
                close(n);
            }
        });
        
        
        
        exitFrame.pack();
        exitFrame.setVisible(true);
    }
    
    private void close(int n) {
        sudokudomain.getSudoku(n).window.dispatchEvent(new WindowEvent(sudokudomain.getSudoku(n).window, WindowEvent.WINDOW_CLOSING));
    }
    
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        s.launch(0);
    }
    
}
