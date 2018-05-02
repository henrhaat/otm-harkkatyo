package sudoku.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokka sisältää tiedon kaikista Sudokujen numeroista ja peitettävistä ruuduista
 */
public class Puzzle {

    private final List<boolean[]> shownList;
    private final List<String[]> numberList;

    private final boolean t = true;
    private final boolean f = false;

    public final String[] numberString1 = {"4", "3", "5", "6", "8", "2", "1", "9", "7", "2", "6", "9", "5", "7", "1", "8", "3", "4", "7", "8", "1", "4", "9", "3", "5", "6", "2",
        "8", "2", "6", "3", "7", "4", "9", "5", "1", "1", "9", "5", "6", "8", "2", "7", "4", "3", "3", "4", "7", "9", "1", "5", "6", "2", "8",
        "5", "1", "9", "2", "4", "8", "7", "6", "3", "3", "2", "6", "9", "5", "7", "4", "1", "8", "8", "7", "4", "1", "3", "6", "2", "5", "9"};

    public final String[] numberString2 = {"1", "5", "2", "7", "3", "9", "4", "6", "8", "4", "8", "9", "2", "5", "6", "3", "7", "1", "3", "7", "6", "8", "4", "1", "2", "9", "5",
        "3", "8", "7", "5", "9", "1", "2", "4", "6", "1", "2", "4", "7", "6", "3", "8", "9", "5", "6", "5", "9", "4", "2", "8", "7", "1", "3",
        "9", "1", "4", "6", "2", "5", "8", "7", "3", "6", "3", "7", "9", "4", "8", "5", "1", "2", "5", "8", "2", "1", "3", "7", "9", "6", "4"};

    public final String[] numberString3 = {"1", "2", "3", "5", "8", "4", "9", "6", "7", "6", "7", "8", "2", "3", "9", "1", "4", "5", "9", "4", "5", "7", "6", "1", "3", "2", "8",
        "3", "7", "2", "6", "9", "1", "4", "5", "8", "4", "6", "1", "5", "8", "3", "7", "9", "2", "5", "8", "9", "2", "7", "4", "6", "1", "3",
        "8", "3", "6", "2", "1", "9", "7", "4", "5", "9", "2", "4", "8", "5", "7", "3", "1", "6", "1", "5", "7", "4", "3", "6", "8", "9", "2"};

    public final String[] numberString4 = {"5", "8", "1", "7", "9", "2", "3", "6", "4", "6", "7", "2", "8", "4", "3", "5", "9", "1", "4", "3", "9", "6", "5", "1", "7", "8", "2",
        "4", "3", "8", "2", "5", "6", "1", "7", "9", "9", "5", "7", "1", "8", "4", "3", "2", "6", "2", "1", "6", "9", "7", "3", "8", "4", "5",
        "8", "4", "5", "9", "1", "3", "6", "2", "7", "2", "1", "9", "7", "6", "8", "4", "3", "5", "3", "6", "7", "5", "2", "4", "1", "9", "8"};

    public final String[] numberString5 = {"2", "7", "6", "8", "5", "4", "9", "1", "3", "3", "1", "4", "9", "6", "2", "8", "7", "5", "9", "5", "8", "7", "1", "3", "2", "6", "4",
        "4", "6", "8", "5", "9", "7", "1", "3", "2", "1", "2", "7", "4", "3", "8", "5", "9", "6", "3", "9", "5", "6", "2", "1", "4", "8", "7",
        "3", "2", "5", "6", "4", "1", "7", "8", "9", "7", "8", "9", "2", "5", "3", "6", "4", "1", "1", "4", "6", "8", "7", "9", "5", "3", "2"};

    public final boolean[] shown1 = {f, f, f, t, t, f, t, t, f, t, t, f, f, t, f, f, f, t, t, f, t, f, t, f, t, f, f,
        t, t, f, f, f, t, f, t, f, t, f, f, t, f, t, f, f, t, f, t, f, t, f, f, f, t, t,
        f, f, t, f, t, f, t, f, t, t, f, f, f, t, f, f, t, t, f, t, t, f, t, t, f, f, f};

    public final boolean[] shown2 = {t, f, f, t, t, f, f, f, f, t, t, t, f, f, f, f, f, t, f, f, t, f, t, f, t, t, t,
        f, f, t, t, f, f, f, f, t, t, t, f, t, f, t, f, t, t, t, f, f, f, f, t, t, f, f,
        t, t, t, f, t, f, t, f, f, t, f, f, f, f, f, t, t, t, f, f, f, f, t, t, f, f, t};

    public final boolean[] shown3 = {f, t, f, t, t, f, f, f, f, t, f, t, f, f, t, f, t, f, f, f, f, t, f, f, f, f, f,
        t, t, f, t, f, f, f, f, t, f, f, f, f, f, f, f, f, f, t, f, f, f, f, t, f, t, t,
        f, f, f, f, f, t, f, f, f, f, t, f, t, f, f, t, f, t, f, f, f, f, t, t, f, t, f};
    
    public final boolean[] shown4 = {f, f, f, t, f, f, f, f, f, t, f, f, f, f, t, f, t, t, t, f, f, t, f, f, f, t, f,
        f, f, f, f, t, f, f, f, f, f, f, f, t, t, f, t, f, t, f, f, f, f, f, t, f, t, t,
        f, t, f, t, f, t, f, t, f, t, f, f, f, f, f, f, f, f, f, t, f, f, f, f, t, f, f};
    
    public final boolean[] shown5 = {t, f, f, t, f, t, f, t, t, t, f, f, f, t, t, t, f, f, f, f, f, f, f, t, t, f, f,
        f, f, f, t, f, t, f, t, t, f, t, f, f, f, f, f, f, t, t, t, f, t, t, t, f, f, f,
        f, t, f, t, f, t, f, f, f, f, f, t, t, t, f, f, f, t, t, t, f, t, f, t, f, f, t};
    
    public Puzzle() {
        this.numberList = new ArrayList<>();
        this.shownList = new ArrayList<>();
        setUpNumberList();
        setUpShownList();
    }

    private void setUpNumberList() {
        this.numberList.add(numberString1);
        this.numberList.add(numberString2);
        this.numberList.add(numberString3);
        this.numberList.add(numberString4);
        this.numberList.add(numberString5);
    }
    
    private void setUpShownList() {
        this.shownList.add(shown1);
        this.shownList.add(shown2);
        this.shownList.add(shown3);
        this.shownList.add(shown4);
        this.shownList.add(shown5);
    }

    public boolean[] getShown(int n) {
        return this.shownList.get(n);
    }

    public String[] getNumbersString(int n) {
        return this.numberList.get(n);
    }
}
