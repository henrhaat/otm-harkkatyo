
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
        addExitButton(n);
    }

    private void addExitButton(int n) {
        JButton button = new JButton("Main menu");
        sudokudomain.getSudokuDao(n).rightPanel.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonPressed(n);
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
                sudokudomain.getSudokuDao(n).window.setVisible(false);
                close(n);
            }
        });
        
        
        
        exitFrame.pack();
        exitFrame.setVisible(true);
    }
    
    private void close(int n) {
        sudokudomain.getSudokuDao(n).window.dispatchEvent(new WindowEvent(sudokudomain.getSudokuDao(n).window, WindowEvent.WINDOW_CLOSING));
    }
    
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        s.launch(0);
    }
    
}
