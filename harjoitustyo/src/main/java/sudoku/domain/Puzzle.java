package sudoku.domain;

public class Puzzle {

    /*private int[][] numbers = {{4, 3, 5, 2, 6, 9, 7, 8, 1},
    {6, 8, 2, 5, 7, 1, 4, 9, 3},
    {1, 9, 7, 8, 3, 4, 5, 6, 2},
    {8, 2, 6, 1, 9, 5, 3, 4, 7},
    {3, 7, 4, 6, 8, 2, 9, 1, 5},
    {9, 5, 1, 7, 4, 3, 6, 2, 8},
    {5, 1, 9, 3, 2, 6, 8, 7, 4},
    {2, 4, 8, 9, 5, 7, 1, 3, 6},
    {7, 6, 3, 4, 1, 8, 2, 5, 9}};*/
    
    private final int[] numbers1 = {4,3,5,6,8,2,1,9,7,2,6,9,5,7,1,8,3,4,7,8,1,4,9,3,5,6,2,
                                    8,2,6,3,7,4,9,5,1,1,9,5,6,8,2,7,4,3,3,4,7,9,1,5,6,2,8,
                                    5,1,9,2,4,8,7,6,3,3,2,6,9,5,7,4,1,8,8,7,4,1,3,6,2,5,9};

    private final boolean t = true;
    private final boolean f = false;

    /*private boolean[][] shown = {{f, f, f, t, t, f, t, f, t},
    {t, t, f, f, t, f, f, t, f},
    {t, t, f, f, f, t, t, f, f},
    {t, t, f, t, f, f, f, t, f},
    {f, f, t, t, f, t, t, f, f},
    {f, t, f, f, f, t, f, t, t},
    {f, f, t, t, f, f, f, t, t},
    {f, t, f, f, t, f, f, t, t},
    {t, f, t, f, t, t, f, f, f}};*/
    
    private final boolean[] shown1 = {f,f,f,t,t,f,t,t,f,t,t,f,f,t,f,f,f,t,t,f,t,f,t,f,t,f,f,
                                      t,t,f,f,f,t,f,t,f,t,f,f,t,f,t,f,f,t,f,t,f,t,f,f,f,t,t,
                                      f,f,t,f,t,f,t,f,t,t,f,f,f,t,f,f,t,t,f,t,t,f,t,t,f,f,f};
    
    public Puzzle() {

    }
    
    /*public int[][] getNumbers() {
        return this.numbers;
    }
    
    public boolean[][] getShown() {
        return this.shown;
    }*/
    
    public int[] getNumbers1() {
        return this.numbers1;
    }

    public boolean[] getShown1() {
        return this.shown1;
    }
}
