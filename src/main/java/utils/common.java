package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class common {
    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }


}
