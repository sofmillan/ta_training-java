package com.epam.training.sofia_millan.webdriver.task3.utils;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Utility class providing functions for string manipulation and conversion.
 * @author Sofía Millán
 */
public class Utils {

    /**
     * Converts a string representation of an amount to a double.
     * The input string can contain non-numeric characters.
     *
     * @param amount the string representation of the amount
     * @return the double value of the amount
     * @throws RuntimeException if the string cannot be parsed to a number
     */
    public static double convertStringToDouble(String amount)  {
        amount = amount.replaceAll("[^\\d,\\.]", "").replace(" ", "");
        NumberFormat format = NumberFormat.getInstance();
        Number number;
        try {
            number = format.parse(amount);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return number.doubleValue();
    }
}
