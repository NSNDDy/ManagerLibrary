package org.example.managerdemo.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat inputDateFormat = new SimpleDateFormat(Const.INPUT_DATE_FORMAT);
    private static final SimpleDateFormat outputDateFormat = new SimpleDateFormat(Const.OUTPUT_DATE_FORMAT);

    public static String formatDate(Date date){
        return outputDateFormat.format(date);
    }

    public static Date parseDate(String dateString)throws ParseException {
        return inputDateFormat.parse(dateString);
    }

    public static String convertDateFormat(String dateString)throws ParseException{
        Date date =parseDate(dateString);
        return formatDate(date);
    }
}
