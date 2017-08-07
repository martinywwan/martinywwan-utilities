package com.martinywwan.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


//TODO test with all punctuations
public class TestStringUtil {

    private String testInputString;
    private Character[] punctuationsToKeep;

    @Before
    public void setUp(){
        testInputString = "The new IT movie adaption looks so scary!! " +
                "Looking forward to watching it in Odeon hopefully it is not too pricey. #TangoIceBlasters #SweetPopcorn #odeon";
        punctuationsToKeep = new Character[] { '#' } ;
    }

    @Test
    public void isPunctuation_True_NoFilter(){
        assertTrue(StringUtil.isPunctuation('#'));
        assertTrue(StringUtil.isPunctuation(','));
    }

    @Test
    public void isPunctuation_False_NoFilter(){
        assertFalse(StringUtil.isPunctuation('a'));
        assertFalse(StringUtil.isPunctuation('P'));
    }

    @Test
    public void isPunctuation_True_WithFilter(){
        Character inputChar = '@';
        Character toKeep = '#';
        assertTrue(StringUtil.isPunctuation(inputChar, toKeep));

        Character [] toKeepConditions =  {',' ,'#' ,'.'};
        assertTrue(StringUtil.isPunctuation(inputChar, toKeepConditions));
    }

    @Test
    public void isPunctuation_False_WithFilter(){
        Character inputChar = '#';
        Character toKeep = '#';
        assertFalse(StringUtil.isPunctuation(inputChar, toKeep));

        Character [] toKeepConditions =  {',', '#', '.'};
        assertFalse(StringUtil.isPunctuation(inputChar, toKeepConditions));
    }

    @Test
    public void removePunctuation_NoFilter(){
        String expected = "The new IT movie adaption looks so scary Looking forward to watching it in Odeon hopefully it is not too pricey TangoIceBlasters SweetPopcorn odeon";
        assertEquals(expected, StringUtil.removePunctuation(testInputString));
    }

    @Test
    public void removePunctuation_WithFilter(){
        String expected = "The new IT movie adaption looks so scary Looking forward to watching it in Odeon hopefully it is not too pricey #TangoIceBlasters #SweetPopcorn #odeon";
        assertEquals(expected, StringUtil.removePunctuation(testInputString, '#'));
    }

}
