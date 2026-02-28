package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static String date(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = localDateTime.format(myFormatObj);

        return formattedDate;
    }
}
