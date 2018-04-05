package sudoku.domain;

import javax.swing.*;
import java.awt.*;

public class Sudoku extends JFrame {
    
    private JFrame window = new JFrame();
    private Container container;
    
    private final int grid = 9;

    private final int numbersize = 50;
    private final int sudokuwidth = 450;
    private final int sudokuheight = 450;

    private JTextField[][] jtf = new JTextField[grid][grid];

    private final int[][] numbers = {{4, 3, 5, 2, 6, 9, 7, 8, 1},
    {6, 8, 2, 5, 7, 1, 4, 9, 3},
    {1, 9, 7, 8, 3, 4, 5, 6, 2},
    {8, 2, 6, 1, 9, 5, 3, 4, 7},
    {3, 7, 4, 6, 8, 2, 9, 1, 5},
    {9, 5, 1, 7, 4, 3, 6, 2, 8},
    {5, 1, 9, 3, 2, 6, 8, 7, 4},
    {2, 4, 8, 9, 5, 7, 1, 3, 6},
    {7, 6, 3, 4, 1, 8, 2, 5, 9}};

    private boolean t = true;
    private boolean f = false;

    private boolean[][] shown = {{f, f, f, t, t, f, t, f, t},
    {t, t, f, f, t, f, f, t, f},
    {t, t, f, f, f, t, t, f, f},
    {t, t, f, t, f, f, f, t, f},
    {f, f, t, t, f, t, t, f, f},
    {f, t, f, f, f, t, f, t, t},
    {f, f, t, t, f, f, f, t, t},
    {f, t, f, f, t, f, f, t, t},
    {t, f, t, f, t, t, f, f, f}};

    
    public Sudoku() {
        
    }
    
    public void build() {
        createGrid();
        setNumbers();
        setMasks();
        createWindow();
    }
    
    private void createGrid() {
        window = new JFrame();
        window.setTitle("Sudoku");
        window.setSize(sudokuwidth, sudokuheight);
        this.container = window.getContentPane();
    }
    
    private void setNumbers() {
        
        container.setLayout(new GridLayout(grid,grid));
        for (int row = 0; row < grid; row++) {
            for (int column = 0; column < grid; column++) {
                jtf[row][column] = new JTextField();
                container.add(jtf[row][column]);
                jtf[row][column].setText(numbers[row][column]+"");
            }
        }
    }
    
    private void setMasks() {
        for (int row = 0; row < grid; row++) {
            for (int column = 0; column < grid; column++) {
                if (shown[row][column]) {
                    jtf[row][column].setEditable(false);
                } else {
                    jtf[row][column].setText("");
                    jtf[row][column].setEditable(true);
                }
                
                
            }
        }
    }
    
    private void createWindow() {
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    public int[][] getNumbers(){
        return numbers;
    }
}
