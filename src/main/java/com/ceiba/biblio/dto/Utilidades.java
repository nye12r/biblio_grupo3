package com.ceiba.biblio.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author ingdanilosegura
 */
public class Utilidades {

    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Utilidades");
    public static boolean isPalindrome(String isbn) { //Bien
        String isbnTemporal = isbn.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, isbnTemporal.length() / 2)
                .noneMatch(i -> isbnTemporal.charAt(i) != isbnTemporal.charAt(isbnTemporal.length() - i - 1));
    }

    public static String getOnlyDigits(String s) { //bien
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(s);
        String number = matcher.replaceAll("");
        return number;
    }

    public static boolean isOverThirty(String cadena) {//bien
        boolean isOver = false;
        int calculate = 0;
        cadena = getOnlyDigits(cadena);
        int ini = 0;
        while (ini < (cadena.length() - 1)) {
            calculate = calculate + (Integer.parseInt(String.valueOf(cadena.charAt(ini))));
            ini++;
        }
        if (calculate > 30) {
            isOver = true;
        }
        return isOver;
    }

    public static Date addDaysDate(Date date, int days) {//bien
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int days) {//bien
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = 0;
        while (i < days) {
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                i++;
            }
            if (i < days) {
                calendar.add(Calendar.DAY_OF_YEAR, 1);
            }
        }
        return calendar.getTime();
    }

    public static Date convertStringToDate(String date) {//bien
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date outDate = null;
        try {
            outDate = format.parse(date);
        } catch (ParseException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return outDate;
    }

    public static String convertDatetoString(Date date) {//bien
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = sdf.format(date);
        return stringDate;
    }

    public static Calendar convertDateToCalendar(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public static int getSundayDays(Calendar fechaInicial, Calendar fechaFinal) {
        int diffDays = 0;
        while (fechaInicial.before(fechaFinal) || fechaInicial.equals(fechaFinal)) {
            if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                diffDays++;
            }
            fechaInicial.add(Calendar.DATE, 1);
        }
        return diffDays;
    }

    public static boolean isSunday(Date date) {
        boolean isSund = false;
        Calendar fechaInicial = convertDateToCalendar(date);
        if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            isSund = true;

        }

        return isSund;
    }
}
