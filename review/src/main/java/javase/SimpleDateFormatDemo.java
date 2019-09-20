package javase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        String str = "2012-12-12";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date d = simpleDateFormat.parse(str);
        System.out.println(d);

        Date d1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
        System.out.println(sdf.format(d1));

    }
}
