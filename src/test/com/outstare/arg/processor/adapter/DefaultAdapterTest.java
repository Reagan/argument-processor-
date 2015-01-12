package com.outstare.arg.processor.adapter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DefaultAdapterTest {

    private DefaultAdapter defaultAdapter ;

    @Before
    public void setUp() throws Exception {
        defaultAdapter = Mockito.mock(DefaultAdapter.class) ;
    }

    @After
    public void tearDown() throws Exception {
        defaultAdapter = null ;
    }

    @Test
    public void testThatDefaultAdapterIsAnAdapter() throws Exception {
        assertTrue("Test that the default adapter of adapter type", defaultAdapter instanceof Adapter);
    }

    @Test
    public void testThatDefaultAdapterExtractsSupportedFlags() throws Exception {
        assertFa
    }

    @Test
    public void testExtractArgs() throws Exception {

    }

    @Test
    public void testGetFlagValue() throws Exception {

    }
}