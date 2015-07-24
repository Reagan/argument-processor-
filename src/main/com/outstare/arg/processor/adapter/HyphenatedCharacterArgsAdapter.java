package com.outstare.arg.processor.adapter;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by IBM Research Lab, Copyright 2015.
 */
public class HyphenatedCharacterArgsAdapter extends DefaultAdapter {

    private HashMap<String, String> args;
    private final String HYPHEN = "-" ;

    public HyphenatedCharacterArgsAdapter(String[] supportedChars, String[] defaultValues)
        throws IllegalArgumentException {
        if (null != supportedChars && null != defaultValues) {
            initializeStorage() ;
            setDefaultKeysValues(supportedChars, defaultValues);
        }
    }

    private void setDefaultKeysValues(String[] supportedKeys, String[] defaultValues) {
        if (supportedKeys.length != defaultValues.length)
            throw new IllegalArgumentException("Different lengths for supported keys and default values") ;

        for (int keysCounter = 0 ; keysCounter < supportedKeys.length ; keysCounter++) {
            args.put(supportedKeys[keysCounter], defaultValues[keysCounter]) ;
        }
    }

    public void extractArgs(String argsString) {
        String[] argsAndValues = argsString.split(" ") ;
        String currKey ;

        Iterator<String> argValues = args.keySet().iterator() ;
        while (argValues.hasNext()) {
            String cKey = argValues.next() ;
            for (int argsAndValuesCounter = 0 ; argsAndValuesCounter < argsAndValues.length; argsAndValuesCounter++) {
                String currArg = argsAndValues[argsAndValuesCounter] ;
                if (currArg.startsWith(HYPHEN)) {
                    currArg = currArg.substring(1) ;
                    if (currArg.equals(cKey)) {
                        args.put(cKey, argsAndValues[argsAndValuesCounter + 1]) ;
                    }
                }
            }
        }
    }

    public String getFlagValue(String flag) {
        return (args.containsKey(flag)) ? args.get(flag) : "" ;
    }

    private void initializeStorage () {
        args = new HashMap<String, String>();
    }
}

