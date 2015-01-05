package com.outstare.arg.processor.adapter;

import com.outstare.arg.processor.flag.Flag;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This interface defines the methods
 * implemented by all adapters
 */

public interface Adapter {
    void setSupportedChars (String[] supportedChars) ;
    ArrayList<Flag> extractArgs (String[] args) ;
    String getFlagValue(String flagString) ;
}
