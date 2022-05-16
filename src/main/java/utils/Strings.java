package utils;

/**
 * @author Mateus N V Satelis
 * @since 15/05/2022
 */
public class Strings {

    private Strings() {
    }

    public static String defaultIfBlank(String value, String defaultValue) {
        return value == null || value.isBlank() ? defaultValue : value;
    }

    public static String defaultIfBlank(String value) {
        return defaultIfBlank(value, "");
    }
}
