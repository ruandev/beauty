package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
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
    
     public static LocalDateTime convetDateAndStringHourToLocalDateTime(Date data, String hora){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataHora = dateFormat.format(data)+" "+hora;
        System.out.println(dataHora);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseStrict()
            .appendPattern("dd/MM/uuuu HH:mm")
            .toFormatter()
            .withResolverStyle(ResolverStyle.STRICT);
        return LocalDateTime.parse(dataHora, formatter);
    }
}
