package joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

public class JodaTest3 {
    public static void main(String[] args) {
        System.out.println(convertUTC2Date("2019-10-02T01:00:00.000Z"));
        System.out.println(convertDate2UTC(new Date()));
        System.out.println(convertDate2LocalByDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
    }

    //标准的UTC时间 2019-10-01T09:11:11.789Z
    public static Date convertUTC2Date(String s ){
        DateTime dateTime = DateTime.parse(s, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return dateTime.toDate();
    }

    public static String convertDate2UTC(Date date){
        DateTime dateTime = new DateTime(date, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDate2LocalByDateFormat(Date date,String dateFormat){
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(dateFormat);
    }
}
