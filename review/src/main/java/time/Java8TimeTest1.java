package time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Java8TimeTest1 {
    public static void main(String[] args) {
        /*LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear());
        LocalDate localDate1 = LocalDate.of(2019,10,1);
        System.out.println(localDate1);


        LocalDate localDate2 = LocalDate.of(2010,3,25);
        MonthDay monthDay = MonthDay.of(localDate2.getMonth(),localDate2.getDayOfMonth());
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2011,3,25));
        if (monthDay.equals(monthDay1))
            System.out.println("equals");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime localTime1 = localTime.plusMinutes(20);
        System.out.println(localTime1);


        LocalDate localDate3 = LocalDate.now().plus(10, ChronoUnit.CENTURIES);
        System.out.println(localDate3);


        Set<String> set = ZoneId.getAvailableZoneIds();
        Set<String> set1 = new TreeSet<String>(){
            {
                addAll(set);
            }
        };*/
        //set1.forEach(System.out::println);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime,zoneId);
        System.out.println(zonedDateTime);

        YearMonth yearMonth = YearMonth.now();
    }
}
