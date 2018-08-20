package utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils {

    public static LocalDateTime convetDateToLocalDateTime(Date data){
        return data.toInstant().atZone(ZoneId.of("GMT-03:00")).toLocalDateTime();
    }

    public static LocalDate convetDateToLocalDate(Date data){
        return data.toInstant().atZone(ZoneId.of("GMT-03:00")).toLocalDate();
    }

    public static LocalDateTime convetTimestampToLocalDateTime(Timestamp dataHora){
        return dataHora.toLocalDateTime();
    }
}
