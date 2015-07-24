package com.outstare.arg.processor.adapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by IBM Research Lab, Copyright 2015.
 */
public class HyphenatedCharacterArgsAdapterTest {

    private HyphenatedCharacterArgsAdapter hyphenatedCharacterArgsAdapter ;
    private String[] charFlags = {"c"} ;
    private String[] defaultValues =  {} ;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        hyphenatedCharacterArgsAdapter = null ;
    }

    @Test
    public void testThatArgsAreCorrectlyExtracted () {
        try {
            String[] charFlags = {"c"};
            String[] defaultValues = {};
            hyphenatedCharacterArgsAdapter = new HyphenatedCharacterArgsAdapter(charFlags, defaultValues);
            fail("Should have thrown an IllegalArgumentException but did not");
        } catch (final IllegalArgumentException e) {
            final String errorMsg = "Different lengths for supported keys and default values" ;
            assertEquals("test that correct error message is returned", errorMsg, e.getMessage());
        }
    }

    @Test
    public void testThatCorrectFlagValuesAreExtracted () {
        String[] charFlags = {"no", "email", "d"} ;
        String[] defaultValues = {"254", "rmbitiru@ke.ibm.com", "DE"} ;
        String argsString = "-no 245 -email rmugo@andrew.cmu.edu -d CH" ;

        hyphenatedCharacterArgsAdapter = new HyphenatedCharacterArgsAdapter(charFlags, defaultValues) ;

        assertEquals("test that correct default no is returned", "254", hyphenatedCharacterArgsAdapter.getFlagValue("no")) ;
        assertEquals("test that correct default email is returned", "rmbitiru@ke.ibm.com", hyphenatedCharacterArgsAdapter.getFlagValue("email")) ;
        assertEquals("test that correct defualt d is retrurned", "DE", hyphenatedCharacterArgsAdapter.getFlagValue("d")) ;

        hyphenatedCharacterArgsAdapter.extractArgs(argsString);

        assertEquals("test that correct no is returned", "245", hyphenatedCharacterArgsAdapter.getFlagValue("no")) ;
        assertEquals("test that correct email is returned", "rmugo@andrew.cmu.edu", hyphenatedCharacterArgsAdapter.getFlagValue("email")) ;
        assertEquals("test that correct d is retrurned", "CH", hyphenatedCharacterArgsAdapter.getFlagValue("d")) ;
    }
}