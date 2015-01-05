package com.outstare.arg.processor.adapter;

/**
 * The Default Argument Processor adapter requires flags to be
 * defined with a hyphen, char/chars symbol and a value
 *
 * e.g. -l 20
 *
 * Default values for specific flags may be specified using this adapter
 *
 */
public class DefaultAdapter extends AbstractAdapter {

    private String[] defaultValues ;

    public DefaultAdapter (String[] supportedChars, String[] defaultValues) {
        if (null != supportedChars && null != defaultValues
                && supportedChars.length == defaultValues.length) {
            setSupportedChars(supportedChars) ;
            setDefaultValues (defaultValues) ;
        }
    }

    public String[] getDefaultValues () {
        return defaultValues ;
    }

    public void setDefaultValues (String[] defaultValues) {
        this.defaultValues = defaultValues ;
    }

}