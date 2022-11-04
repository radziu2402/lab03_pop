package app.common;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSimulator {
    private static LocalDateTime localDateTime = LocalDateTime.now();


    public static LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public static void addLocalDateTime() {
        int randDays = (int)Math.floor(Math.random()*(7-1+1)+1);
        int randHours = (int)Math.floor(Math.random()*(30-1+1)+1);
        int randMinutes = (int)Math.floor(Math.random()*(80-1+1)+1);
        TimeSimulator.localDateTime = TimeSimulator.localDateTime.plusDays(randDays).plusHours(randHours).plusMinutes(randMinutes);
    }
}
