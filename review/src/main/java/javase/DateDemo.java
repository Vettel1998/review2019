package javase;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        //在参数的基础上加上1900年1月
        //Deprecated


        @SuppressWarnings("deprecation") Date date1 = new Date(2008-1900,8-1,8);

    }
}
