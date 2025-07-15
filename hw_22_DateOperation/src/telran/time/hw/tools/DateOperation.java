package telran.time.hw.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {

    static DateTimeFormatter df = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]");

    public static int getAge(String birthDate) {
        return (int) ChronoUnit.YEARS.between(LocalDate.parse(birthDate, df), LocalDate.now());
    }

    public static String[] sortStringDates2(String[] dates) {
        String[] resDates = Arrays.copyOf(dates, dates.length);
        Arrays.sort(resDates, Comparator.comparing( dateString -> LocalDate.parse(dateString,df)));
        return resDates;
    }

    public static String[] sortStringDates3(String[] dates) {
        String[] resDates = Arrays.copyOf(dates, dates.length);
        Comparator<String> comparator = (date1, date2) -> LocalDate.parse(date1,df).compareTo(LocalDate.parse(date2,df));
        Arrays.sort(resDates, comparator);
        return resDates;
    }

    public static String[] sortStringDates(String[] dates) {
        String[] resDates = Arrays.copyOf(dates, dates.length);

        LocalDate[] localDates = new LocalDate[dates.length];

        for (int i = 0; i < dates.length; i++) {
            localDates[i] = LocalDate.parse(dates[i],df);
        }

        Arrays.sort(localDates);

        for (int i = 0; i < localDates.length; i++) {
            for (int j = 0; j < dates.length; j++) {
                if (localDates[i].compareTo(LocalDate.parse(dates[j],df)) == 0) {
                    resDates[i] = dates[j];
                }
            }
        }

        return resDates;
    }
}
