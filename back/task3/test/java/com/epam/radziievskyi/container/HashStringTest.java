package com.epam.radziievskyi.container;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class HashStringTest {
    @Test
    public void testHashByElements() {
        //given
        HashString hashString = new HashString("JAVA");
        String string = "JAVA";


        //when
        int result = hashString.hashByElements(string);


        //then
        assertEquals(result, 290);
    }

    @Test
    public void testHashByLength() {
        //given
        HashString hashString = new HashString("JAVA");
        String string = "JAVA";


        //when
        int result = hashString.hashByLength(string);


        //then
        assertEquals(result, 4);

    }

}