package com.epam.training.sofia_millan.webdriver.task3.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Utils {
    public static double convertStringToDouble(String amount)  {
        amount = amount.replaceAll("[^\\d,\\.]", "").replace(" ", "");
        NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
        Number number;
        try {
            number = format.parse(amount);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return number.doubleValue();
    }
}
