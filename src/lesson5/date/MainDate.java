package lesson5.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainDate {
    public static void main(String[] args) throws ParseException{

        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yy");
        Date birthday = format1.parse("06.03.85");
        System.out.println(format.format(birthday));
        Calendar c = new GregorianCalendar();
        c.setTime(birthday);
        SimpleDateFormat mount = new SimpleDateFormat("EEEE");
        System.out.println(mount.format(birthday));

    }

}
