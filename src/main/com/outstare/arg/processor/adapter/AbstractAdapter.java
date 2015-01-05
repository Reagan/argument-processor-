package com.outstare.arg.processor.adapter;

import com.outstare.arg.processor.flag.Flag;
import com.outstare.arg.processor.flag.flagtypes.HyphenatedFlagType;

import java.util.ArrayList;
import java.util.IllegalFormatFlagsException;

/**
 * ${FILE_NAME}
 * Created by rmbitiru on 1/5/15.
 */
public abstract class AbstractAdapter implements Adapter {

    public String[] supportedChars;

    public void setSupportedChars (String[] supportedChars) throws IllegalFormatFlagsException {
        boolean allFlagsValid = true ;
        String invalidFlag = "%s is not a valid flag" ;

        if (null != supportedChars && supportedChars.length > 0) {
            for (String supportedChar : supportedChars) {
                char[] containedChars = supportedChar.toCharArray() ;
                for (char currChar : containedChars) {
                    if (currChar < 20 && currChar > 90) {
                        allFlagsValid = false;
                        String.format(invalidFlag, supportedChar);
                        break;
                    }
                }
            }

            if (!allFlagsValid)
                throw new IllegalFormatFlagsException(invalidFlag) ;
            else
                this.supportedChars = supportedChars ;
        }
    }

    public ArrayList<Flag> extractArgs (String[] args) {
        ArrayList<Flag> vars = new ArrayList<Flag>() ;
        String currArgString ;
        String value ;

        for (String supportedChar : supportedChars) {
            for (int argsCounter = 0 ;
                 argsCounter < args.length ; argsCounter++) {

                currArgString = args[argsCounter].substring(1, args[argsCounter].length()) ;

                if (currArgString.equals(supportedChar)
                        && args.length - 1 > argsCounter) {
                    Flag currFlag = new Flag () ;
                    value = getFlagValue (currArgString) ;
                    currFlag.setFlagType(new HyphenatedFlagType());
                    currFlag.setFlag(currArgString);
                    currFlag.setValue(value);

                    vars.add(currFlag);
                }
            }
        }

        return vars ;
    }

    public String getFlagValue (String flag) {
        return flag ;
    }

}
