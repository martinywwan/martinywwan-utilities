package com.martinywwan.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


//TODO Need to define more test cases e.g. variable PUNCTUATION_RANGE contains only punctuation
public class TestStringUtil {

    private String testInputString;
    private Character[] punctuationsToKeep;

    @Before
    public void setUp(){
        testInputString = "The new IT movie adaption looks so scary!! " +
                "Looking forward to watching it in Odeon hopefully it is not too pricey. #TangoIceBlasters #SweetPopcorn #odeon";
        punctuationsToKeep = new Character[] { '#' } ;
    }

    //Test if the punctuation input is valid (is accepted as a punctuation)
    @Test
    public void isPunctuation_True_NoFilter(){
        assertTrue(StringUtil.isPunctuation('#'));
        assertTrue(StringUtil.isPunctuation(','));
    }

    //Test that the character input is not a punctuation
    @Test
    public void isPunctuation_False_NoFilter(){
        assertFalse(StringUtil.isPunctuation('a'));
        assertFalse(StringUtil.isPunctuation('P'));
    }

    //Check whether the input punctuation is a valid punctuation
    @Test
    public void isPunctuation_True_WithFilter(){
        Character inputChar = '@';
        Character toKeep = '#';
        assertTrue(StringUtil.isPunctuation(inputChar, toKeep));

        Character [] toKeepConditions =  {',' ,'#' ,'.'};
        assertTrue(StringUtil.isPunctuation(inputChar, toKeepConditions));
    }


    //Check whether the input punctuation is not filtered out when we want to keep it
    @Test
    public void isPunctuation_False_WithFilter(){
        Character inputChar = '#';
        Character toKeep = '#';
        assertFalse(StringUtil.isPunctuation(inputChar, toKeep));

        Character [] toKeepConditions =  {',', '#', '.'};
        assertFalse(StringUtil.isPunctuation(inputChar, toKeepConditions));
    }

    //Test that all punctuation is removed from the given input string
    @Test
    public void removePunctuation_NoFilter(){
        String expected = "The new IT movie adaption looks so scary Looking forward to watching it in Odeon hopefully it is not too pricey TangoIceBlasters SweetPopcorn odeon";
        assertEquals(expected, StringUtil.removePunctuation(testInputString));
    }


    //Test that all punctuation is removed from the given input string apart from '#'
    @Test
    public void removePunctuation_WithFilter(){
        String expected = "The new IT movie adaption looks so scary Looking forward to watching it in Odeon hopefully it is not too pricey #TangoIceBlasters #SweetPopcorn #odeon";
        assertEquals(expected, StringUtil.removePunctuation(testInputString, '#'));
    }

}
