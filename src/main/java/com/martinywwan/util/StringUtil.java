package com.martinywwan.util;

import java.io.StringWriter;
import java.util.Arrays;

/**Collection of methods to perform common functions
 *
 * @author martinywwan
 */
public class StringUtil {

    //ASCII punctuation ranges to remove/detect
    private static final int[][] PUNCTUATION_RANGE = {
            {33, 47}, {58,64}, {91, 96}, {123, 126}
    };

    /**Checks whether the input character is a punctuation
     *
     * @param c is the character input
     * @param punctuationToKeep is the array of punctuation to preserve
     * @return true if character input is a punctuation
     */
    public final static boolean isPunctuation(Character c, Character ... punctuationToKeep){

        if(Arrays.asList(punctuationToKeep).contains(c)){ return false; }

        for(int i = 0; i<PUNCTUATION_RANGE.length; i++){
            if( ((int)c.charValue()>=PUNCTUATION_RANGE[i][0]) && ((int)c.charValue()<=PUNCTUATION_RANGE[i][1])){
                return true;
            }
        }
        return false;
    }

    /** Strips out all punctuation in a string but preserves when stated
     * @param orig - input String
     * @param punctuationToKeep - array of punctuation to keep
     * @return a String without punctuation
     */
    public final static String removePunctuation(String orig, Character ... punctuationToKeep){
        Character[] charObjectArray = orig.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        return Arrays.stream(charObjectArray)
                .filter( c -> !isPunctuation(c, punctuationToKeep))
                .mapToInt(c -> c)
                .collect(StringWriter::new, StringWriter::write, (swl, swr) -> swl.write(swr.toString())).toString();
    }
}
