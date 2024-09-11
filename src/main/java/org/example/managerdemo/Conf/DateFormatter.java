package org.example.managerdemo.Conf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    private static final String INPUT_DATE_FORMAT = "dd/YY/MM";
    private static final String OUTPUT_DATE_FORMAT = "dd-MM-YYYY";


    private static final SimpleDateFormat inputDateFormat = new SimpleDateFormat(INPUT_DATE_FORMAT);
    private static final SimpleDateFormat outputDateFormat = new SimpleDateFormat(OUTPUT_DATE_FORMAT);

    public static String formatDate(Date date){
        return outputDateFormat.format(date);
    }

    public static Date parseDate(String dateString)throws ParseException{
        return inputDateFormat.parse(dateString);
    }

    public static String convertDateFormat(String dateString)throws ParseException{
         Date date =parseDate(dateString);
        return formatDate(date);
    }

}
