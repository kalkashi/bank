package tdd;

import java.util.Arrays;

public class HighestNumberFinder {

    public int findHighestNumber(int[] input){

            if(input==null || input.length ==0){
                //throw new IllegalArgumentException("Array must not be empty");
            }


        return Arrays.stream(input).max().getAsInt();
    }


}
