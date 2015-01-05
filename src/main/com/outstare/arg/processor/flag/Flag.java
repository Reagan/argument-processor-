package com.outstare.arg.processor.flag;

import com.outstare.arg.processor.flag.flagtypes.FlagType;

/**
 * ${FILE_NAME}
 * Created by rmbitiru on 1/3/15.
 */
public class Flag {

    private FlagType flagType ;
    private String flag ;
    private String value ;

    public Flag () {}

    public Flag (FlagType flagType, String flag, String value) {
        setFlagType(flagType);
        setFlag(flag);
        setValue(value);
    }

    public FlagType getFlagType() {
        return flagType;
    }

    public void setFlagType(FlagType flagType) {
        this.flagType = flagType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
