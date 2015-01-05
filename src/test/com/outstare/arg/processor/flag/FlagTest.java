package com.outstare.arg.processor.flag;

import com.outstare.arg.processor.flag.flagtypes.FlagType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.mockito.Mockito;

public class FlagTest {

    public Flag firstFlag ;
    public Flag secondFlag ;

    private FlagType flagType ;

    @Before
    public void setUp() throws Exception {
        firstFlag = new Flag() ;
        flagType = Mockito.mock(FlagType.class) ;
        secondFlag = new Flag(flagType, "n", "3") ; // imaginary flag for number
        // of times something should
        // be done
    }

    @After
    public void tearDown() throws Exception {
        firstFlag = null ;
        secondFlag = null ;
    }

    @Test
    public void testGetFlagType() throws Exception {
        assertEquals("Test the returned flagType", null, firstFlag.getFlagType());
        assertEquals("Test the second returned flag type", flagType, secondFlag.getFlagType());
    }

    @Test
    public void testSetFlagType() throws Exception {
        assertEquals("Test initial value for flag type", null, firstFlag.getFlagType());

        firstFlag.setFlagType(flagType);
        assertEquals("Test that the flag type is set correctly", flagType, firstFlag.getFlagType());

        assertEquals("Test that the flag type is set in constructor correctly", flagType,  secondFlag.getFlagType());
    }

    @Test
    public void testGetFlag() throws Exception {
        assertEquals("Test the returned flag", null, firstFlag.getFlag());
        assertEquals("Test the second returned flag", "n", secondFlag.getFlag());
    }

    @Test
    public void testSetFlag() throws Exception {
        assertEquals("Test that a flag is set", null, firstFlag.getFlag());
        firstFlag.setFlag("x");
        assertEquals("Test that a flag has been set", "x", firstFlag.getFlag());
        assertEquals("Test flag set in constructor",  "n", secondFlag.getFlag());
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals("Test the value", null, firstFlag.getValue());
        firstFlag.setValue("40");
        assertEquals("Test set value", "40", firstFlag.getValue());
        assertEquals("Test the value set in the constructor", "3", secondFlag.getValue());
        assertEquals("Test the type of value set", String.class, secondFlag.getValue().getClass());
    }

}