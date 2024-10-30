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
    interface IRegister
    {
        String getDelegate(int idx);
        int getNumberRegistered();
    }

    class Register implements IRegister
    {
        private ArrayList<String> delegates = new ArrayList<>();  // simulates a DB table

        public Register()
        {
            delegates.add("Selvyn");
            delegates.add("Lonyin");
            delegates.add("Julia");
        }

        public String getDelegate(int idx)
        {
            return delegates.get(idx-1);
        }

        public int getNumberRegistered()
        {
            return delegates.size();
        }
    }

    class   Course
    {
        private IRegister reg;

        public Course( IRegister register)
        {
            reg = register;
        }

        public String getLastPersonRegistered()
        {
            String result = reg.getDelegate(reg.getNumberRegistered());

            return result;
        }
    }

    @Test
    public  void    verify_lastName_returned_is_lastName_in_register()
    {
        // arrange
        IRegister reg = mock(IRegister.class);
        Course cut = new Course( reg );
        String expectedResult = "Julia";
        when(reg.getDelegate(anyInt())).thenReturn("Julia");

        // act
        String actualResult = cut.getLastPersonRegistered();

        //assert
        assertEquals(expectedResult, actualResult);
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
        IDataStore dataStore = mock(IDataStore.class);
        when(dataStore.getItemsInDB()).thenReturn(basket);
        Session cut = new Session(dataStore);

        // act
        String actualResult = cut.getItems();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_last_item_is_correct(){

        Basket basket = mock(Basket.class);
        Item item3 = new Item("Paneer", 1, 1.27);
        ObjectMapper objectMapper = new ObjectMapper();

        String expectedResult = "";

        try {
            expectedResult = objectMapper.writeValueAsString(item3);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        IDataStore dataStore = mock(IDataStore.class);
        when(dataStore.getItemsInDB()).thenReturn(basket);
        when(basket.getLastItem()).thenReturn(item3);
        Session cut = new Session(dataStore);
        String actualResult = cut.getLastItemSold();
        assertEquals(expectedResult, actualResult);

//        verify(basket,times(1)).size();
//        verify(basket,times(1)).add(any());
    }






}
