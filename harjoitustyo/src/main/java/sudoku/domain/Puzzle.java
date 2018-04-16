package sudoku.domain;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

    
    private List<int[]> numberList;
    private List<boolean[]> shownList;
    
    private final int[] numbers = {4,3,5,6,8,2,1,9,7,2,6,9,5,7,1,8,3,4,7,8,1,4,9,3,5,6,2,
                                    8,2,6,3,7,4,9,5,1,1,9,5,6,8,2,7,4,3,3,4,7,9,1,5,6,2,8,
                                    5,1,9,2,4,8,7,6,3,3,2,6,9,5,7,4,1,8,8,7,4,1,3,6,2,5,9};
    
    private final String[] numbersString = {"4","3","5","6","8","2","1","9","7","2","6","9","5","7","1","8","3","4","7","8","1","4","9","3","5","6","2",
                                            "8","2","6","3","7","4","9","5","1","1","9","5","6","8","2","7","4","3","3","4","7","9","1","5","6","2","8",
                                            "5","1","9","2","4","8","7","6","3","3","2","6","9","5","7","4","1","8","8","7","4","1","3","6","2","5","9"};

    private final boolean t = true;
    private final boolean f = false;
    
    private final boolean[] shown = {f,f,f,t,t,f,t,t,f,t,t,f,f,t,f,f,f,t,t,f,t,f,t,f,t,f,f,
                                      t,t,f,f,f,t,f,t,f,t,f,f,t,f,t,f,f,t,f,t,f,t,f,f,f,t,t,
                                      f,f,t,f,t,f,t,f,t,t,f,f,f,t,f,f,t,t,f,t,t,f,t,t,f,f,f};
    
    public Puzzle() {
        this.numberList = new ArrayList<>();
        this.shownList = new ArrayList<>();
        setUp();
    }
    
    private void setUp() {
        this.numberList.add(numbers);
        this.shownList.add(shown);
    }
    
    public int[] getNumbers(int i) {
        return this.numberList.get(i);
    }

    public boolean[] getShown(int i) {
        return this.shownList.get(i);
    }
    
    public String[] getNumbersString(int i) {
        return this.numbersString;
    }
}
