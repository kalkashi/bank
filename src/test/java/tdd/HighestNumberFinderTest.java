package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HighestNumberFinderTest {
    @Test
    public void verify_highest(){
        int input[] = {10};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 10;

        int actualResult = cut.findHighestNumber(input);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public  void    find_highest_in_array_of_two_descending_expect_first_element(){
        int input[] = {13,7};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 13;

        int actualResult = cut.findHighestNumber(input);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public  void    find_highest_in_array_of_two_ascending_expect_second_element(){
        int input[] = {7,13};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 13;

        int actualResult = cut.findHighestNumber(input);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void find_highest_in_array_if_several_equal_and_max(){
        int input[] = {2,23,4,23,23,1};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = 23;

        int actualResult = cut.findHighestNumber(input);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void find_highest_in_array_if_negative(){
        int input[] = {-2,-23,-4,-23,-23,-1};
        HighestNumberFinder cut = new HighestNumberFinder();
        int expectedResult = -1;

        int actualResult = cut.findHighestNumber(input);

        assertEquals(expectedResult,actualResult);
    }



//    @Test
//    public void find_highest_in_empty_array() {
//        int input[] = {};
//        HighestNumberFinder cut = new HighestNumberFinder();
//
//        Exception e = assertThrows(IllegalArgumentException.class,() -> {
//            cut.findHighestNumber(input);
//        });
//
//        assertEquals("Array must not be empty",e.getMessage());
//
//    }

//    @Test
//    public void find_highest_in_empty_array_should_throw_exception() {
//        // Arrange
//        int input[] = {};
//        HighestNumberFinder cut = new HighestNumberFinder();
//        // Act
//        try {
//            cut.findHighestNumber(input);
//            fail("Expected IllegalArgumentException to be thrown");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Array must not be empty", e.getMessage());
//        }
//    }



}
