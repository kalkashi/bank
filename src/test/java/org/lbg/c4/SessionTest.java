package org.lbg.c4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SessionTest
{

    @Test
    public void how_mocks_work()
    {
        //arrange
        ArrayList<String> names = mock(ArrayList.class);
        names.add("Kalki");
//        names.add("Kal");
//        names.add("KK");
        int expectedResult = 3;
        when(names.size()).thenReturn(3);
        //act
        int actual = names.size();

        //assert
        assertEquals(expectedResult,actual);

        verify(names,times(1)).size();
        verify(names,times(1)).add(any());

    }
    @Test
    public void verify_if_basket_has_correct_items()
    {
        // arrange
        Basket basket = new Basket();
        Item item1 = new Item("Bananas", 6, 0.19); // 1.14
        Item item2 = new Item("Avocado", 3, 0.89); // 2.67
        Item item3 = new Item("Spinach", 1, 1.27); // 1.27
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try
        {
            expectedResult = objectMapper.writeValueAsString(basket);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        DataStore dataStore = new DataStore();
        Session cut = new Session(dataStore);

        // act
        String actualResult = cut.getItems();

        // assert
        assertEquals(expectedResult, actualResult);
    }

}
