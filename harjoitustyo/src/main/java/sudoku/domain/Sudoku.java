package sudoku.domain;

import javax.swing.*;
import java.awt.*;

public class Sudoku extends JPanel {

    private final JFrame window = new JFrame();
    private final JPanel sudokuPanel = new JPanel();
    private Container container;

    private final int sudokuwidth = 450;
    private final int sudokuheight = 450;

    //private final JTextField[][] jtf = new JTextField[grid][grid];
    private final JTextField[][] jtf1 = new JTextField[3][3];

    //private final int[][] numbers;
    private final int[] numbers1;
    //private boolean[][] shown;
    private final boolean[] shown1;

    public Sudoku() {
        Puzzle puzzle = new Puzzle();
        //this.numbers = puzzle.getNumbers();
        //this.shown = puzzle.getShown();
        this.numbers1 = puzzle.getNumbers1();
        this.shown1 = puzzle.getShown1();
    }

    public void build() {
        createGrid();
        setNumbers2();
        createWindow();
    }

    private void createGrid() {
        window.setTitle("Sudoku");
        window.setSize(sudokuwidth + 150, sudokuheight);
        sudokuPanel.setLayout(new GridLayout(3, 3, 5, 5));
        sudokuPanel.setBackground(Color.black);
        this.container = window.getContentPane();
    }

    /*private void setNumbers() {
        for (int row = 0; row < grid; row++) {
            for (int column = 0; column < grid; column++) {
                jtf[row][column] = new JTextField();
                Font f = jtf[0][0].getFont();
                Font f2 = f.deriveFont((float) 25);
                jtf[row][column].setFont(f2);
                sudokuPanel.add(jtf[row][column]);
                jtf[row][column].setText("" + numbers[row][column] + "");
            }
        }
    }*/

    private void setNumbers2() {
        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 3; row++) {
                    jtf1[row][col] = new JTextField();
                    Font f = jtf1[0][0].getFont();
                    Font f2 = f.deriveFont((float) 25);
                    jtf1[row][col].setFont(f2);
                    panel.add(jtf1[row][col]);
                    jtf1[row][col].setText(numbers1[3 * col + row + 9 * i] + " ");
                    setMask1(row,col,i);
                }
            }
            sudokuPanel.add(panel);
        }
    }

    /*private void setMasks() {
        for (int row = 0; row < grid; row++) {
            for (int column = 0; column < grid; column++) {
                if (shown[row][column]) {
                    jtf[row][column].setHorizontalAlignment(JTextField.CENTER);
                    jtf[row][column].setEditable(false);
                } else {
                    jtf[row][column].setText("");
                    jtf[row][column].setHorizontalAlignment(JTextField.CENTER);
                    jtf[row][column].setEditable(true);
                }

            }
        }
    }*/

    private void setMask1(int row, int col, int i) {
        if (shown1[3 * col + row + 9 * i]) {
            jtf1[row][col].setHorizontalAlignment(JTextField.CENTER);
            jtf1[row][col].setEditable(false);
        } else {
            jtf1[row][col].setText("");
            jtf1[row][col].setHorizontalAlignment(JTextField.CENTER);
            jtf1[row][col].setEditable(true);
        }
    }

    private void createWindow() {
        container.add(sudokuPanel, BorderLayout.CENTER);
        JButton button = new JButton("toiminnallisuus tähän");
        container.add(button, BorderLayout.EAST);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    public int[] getNumbers1() {
        return numbers1;
    }
}
