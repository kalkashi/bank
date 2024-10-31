package tdd;

import java.util.Arrays;

public class HighestNumberFinder {

    public int findHighestNumber(int[] input){
        return Arrays.stream(input).max().getAsInt();
    }
}
