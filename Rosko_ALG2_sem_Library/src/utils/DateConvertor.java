/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author Matouš
 */
public class DateConvertor {

    /**
     * converts a unix timestamp into a date
     *
     * @param unixSeconds timestamp
     * @return date
     */
    public static String unixToSimpleDate(long unixSeconds) {
        Date date = new java.util.Date(unixSeconds * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy.dd.MM");
        return sdf.format(date);
    }

    /**
     * converts a date into unix timestamp
     *
     * @param simpleDate date
     * @return timestamp
     * @throws ParseException
     */
    public static long simpleDateToUnix(String simpleDate) throws ParseException {
        SimpleDateFormat dfm = new SimpleDateFormat("yyyy.dd.MM");
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
        long a = dfm.parse(simpleDate).getTime();
        return a / 1000L;
    }

    /*
    public static void main(String[] args) throws ParseException {
        System.out.println(unixToSimpleDate(465782400));
        System.out.println(simpleDateToUnix("1984.05.10"));
    }
     */
}
