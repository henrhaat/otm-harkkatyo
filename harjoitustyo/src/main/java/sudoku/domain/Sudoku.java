package sudoku.domain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Sudoku extends JPanel {

    private final JFrame window = new JFrame();
    private final JPanel sudokuPanel = new JPanel();
    private Container container;

    private List<JPanel> subpanelList = new ArrayList<>();
    private List<JTextField> jtfList = new ArrayList<>();

    private final int sudokuwidth = 450;
    private final int sudokuheight = 450;

    private final JTextField[][] jtf = new JTextField[3][3];

    private final int[] numbers;
    private final boolean[] shown;
    private final String[] numbersString;

    public Sudoku() {
        Puzzle puzzle = new Puzzle();
        this.numbers = puzzle.getNumbers(0);
        this.shown = puzzle.getShown(0);
        this.numbersString = puzzle.getNumbersString(0);
    }

    public void build() {
        createGrid();
        setNumbers();
        createWindow();
    }

    private void createGrid() {
        window.setTitle("Sudoku");
        window.setSize(sudokuwidth + 150, sudokuheight);
        sudokuPanel.setLayout(new GridLayout(3, 3, 5, 5));
        sudokuPanel.setBackground(Color.black);
        this.container = window.getContentPane();
    }

    private void setNumbers() {
        for (int i = 0; i < 9; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 3));
            for (int col = 0; col < 3; col++) {
                for (int row = 0; row < 3; row++) {
                    jtf[row][col] = new JTextField();
                    Font f = jtf[0][0].getFont();
                    Font f2 = f.deriveFont((float) 25);
                    jtf[row][col].setFont(f2);
                    panel.add(jtf[row][col]);
                    jtf[row][col].setText(numbersString[3 * col + row + 9 * i]);
                    setMask(row, col, i);
                    jtfList.add(jtf[row][col]);
                }
            }
            sudokuPanel.add(panel);
            subpanelList.add(panel);
        }
    }

    private void setMask(int row, int col, int i) {
        if (shown[3 * col + row + 9 * i]) {
            jtf[row][col].setHorizontalAlignment(JTextField.CENTER);
            jtf[row][col].setEditable(false);
        } else {
            jtf[row][col].setText("");
            jtf[row][col].setHorizontalAlignment(JTextField.CENTER);
            jtf[row][col].setEditable(true);
        }
    }

    private void createWindow() {
        container.add(sudokuPanel, BorderLayout.CENTER);
        this.addCheckButton();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

    private void addCheckButton() {
        JButton button = new JButton("Ready");
        container.add(button, BorderLayout.EAST);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkButtonPressed();
            }
        } );
    }
    
    private void checkButtonPressed() {
        JFrame checkFrame = new JFrame();
        JButton button = new JButton("Ok");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkFrame.setVisible(false);
            }
        } );
        checkFrame.setTitle("Result");
        checkFrame.getContentPane().add(button, BorderLayout.SOUTH);
        if (checkIfCorrect()) {
            JTextField jtext = new JTextField("Correct!");
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        } else {
            JTextField jtext = new JTextField("Some numbers are still wrong..");
            checkFrame.getContentPane().add(jtext, BorderLayout.NORTH);
        }
        checkFrame.pack();
        checkFrame.setVisible(true);
    }
    
    public boolean checkIfCorrect() {
        
        for (int i = 0; i < 81; i++) {
            if (!jtfList.get(i).getText().equals(this.numbersString[i])) {
                return false;
            }
        }
        return true;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public JFrame getJFrame() {
        return this.window;
    }

    public JPanel getSudokuPanel() {
        return this.sudokuPanel;
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

}
