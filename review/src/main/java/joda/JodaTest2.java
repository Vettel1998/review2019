package joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaTest2 {
    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrowe = today.plusDays(1);
        System.out.println(today);
        DateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1);

        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        localDate = localDate.plusMonths(3).dayOfMonth().withMaximumValue();
        System.out.println(localDate);

        DateTime dateTime = new DateTime();
        dateTime = dateTime.minusYears(2).withMonthOfYear(3).dayOfMonth().withMaximumValue();
        System.out.println(dateTime.toString("yyyy-MM-dd"));
    }
}
