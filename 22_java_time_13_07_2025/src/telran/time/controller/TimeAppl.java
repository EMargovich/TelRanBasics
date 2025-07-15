package telran.time.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeAppl {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
       // System.out.println(currentDate);
        LocalTime localTime = LocalTime.now();
       // System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
       // System.out.println(localDateTime);
        LocalDate gagarin = LocalDate.of(1961, 4, 12);
        System.out.println(gagarin);
       // System.out.println(gagarin.atStartOfDay());
       // System.out.println(gagarin.getDayOfWeek());
       // System.out.println(gagarin.getDayOfYear());
       // System.out.println(gagarin.isBefore(currentDate));
        LocalDate newDate = currentDate.plusDays(100);
       // System.out.println(newDate);
       // System.out.println(currentDate);
        newDate = currentDate.plus(-1, ChronoUnit.ERAS);
        //System.out.println(currentDate);
       // System.out.println(newDate);
        //System.out.println(localTime.plus(100, ChronoUnit.MINUTES));
        //System.out.println(localDateTime.plus(5, ChronoUnit.HALF_DAYS));
        //System.out.println(ChronoUnit.DAYS.between(gagarin,currentDate));
        //System.out.println(LocalDate.EPOCH);
        System.out.println("===== Date Formatter =====");
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(gagarin.format(df));
        Locale locale = new Locale("ja");
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", locale);
        System.out.println(gagarin.format(df));
        String date = "04/02/2207";
        df = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]");
        LocalDate localDate = LocalDate.parse(date, df);
        System.out.println(localDate);

    }
}

//ДЗ - 1) Сколько лет прошло с опредленной даты
// 2) Отсортировать массив дат разных форматов
