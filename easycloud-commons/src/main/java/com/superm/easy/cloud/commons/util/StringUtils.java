package com.superm.easy.cloud.commons.util;

final public class StringUtils {
    private StringUtils() {
    }

    public static final String EMPTY = "";

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    public static String trim(String source) {
        if (null == source || "null".equalsIgnoreCase(source)) {
            return EMPTY;
        }
        return source.trim();
    }

    public static boolean isEmpty(String source) {
        return trim(source).isEmpty();
    }

    public static boolean isNotEmpty(String source) {
        return !isEmpty(source);
    }

}
