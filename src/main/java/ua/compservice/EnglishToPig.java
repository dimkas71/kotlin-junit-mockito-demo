package ua.compservice;


public class EnglishToPig {

    public static final String SUFFIX = "ay";
    public static final String NULL_ARGUMENT = "Null argument";
    public static final String EMPTY_ARGUMENT = "Empty argument";

    public static String encode(String aWord) {
        if (aWord == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (aWord.isEmpty()) return SUFFIX;
        return aWord.substring(1) + aWord.substring(0,1) + SUFFIX;
    }

    public static String decode(String decoded) {
        if (decoded == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT);
        }
        if (decoded.isEmpty()) throw new IllegalArgumentException(EMPTY_ARGUMENT);


        String toConvert = decoded.substring(0, decoded.length() - 2);

        return toConvert.substring(toConvert.length() - 1) + toConvert.substring(0, toConvert.length() - 1);

    }
}