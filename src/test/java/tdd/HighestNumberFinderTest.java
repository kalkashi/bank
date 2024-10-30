package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestNumberFinderTest {
    @Test
    public void verify_highest(){
        int input[] = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 10;

        int actualResult = cut.findHighestNumber(input);

        assertEquals(expectedResult,actualResult);
    }

}
