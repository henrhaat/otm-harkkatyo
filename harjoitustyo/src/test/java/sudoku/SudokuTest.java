package sudoku;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.dao.SudokuDao;


/**
 *
 * @author Henri
 */
public class SudokuTest {
    
    SudokuDao sudoku;
    
    public void setUp() {
        sudoku = new SudokuDao();
    }
    
    
    public void boxPassesRules(int n) {
        setUp();
        int[] numbers = sudoku.getNumbers1();
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        for(int i = 1; i < 10; i++) {
            list1.add(i);
        }
        for(int i = 0; i < 9; i++) {
            list2.add(numbers[n*9 +i]);
        }
        Collections.sort(list2);
        
        assertEquals(list1,list2);
    }
    
    @Test
    public void allBoxesPassRules() {
        for (int i = 0; i < 9; i++) {
            boxPassesRules(i);
        }
    }
    
}
