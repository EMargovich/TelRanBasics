package telran.dates;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DatesSortTest {

    @Test
    void test() {
        String[] dates = { "07-05-1990", "28-01-2010", "11-08-1990", "15-01-2010", "16/06/1970" };
        String[] expected = { "16/06/1970", "07-05-1990", "11-08-1990", "15-01-2010", "28-01-2010" };
        Comparator<String> comp = (d1, d2) -> {
            LocalDate date1 = parseDateString2(d1);
            LocalDate date2 = parseDateString2(d2);
            return date1.compareTo(date2);
        };
        Arrays.sort(dates, comp);
        assertArrayEquals(expected, dates);
    }

    private LocalDate parseDateString(String dateString) {
        try {
            LocalDate date = LocalDate.of(Integer.parseInt(dateString.substring(6, 9)),
                    Integer.parseInt(dateString.substring(4, 5)),
                    Integer.parseInt(dateString.substring(1, 2)));
            return date;
        } catch (DateTimeParseException e) {}
        return null;
    }

    private LocalDate parseDateString2(String dateString) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate d = LocalDate.parse(dateString, formatter1);
            return d;
        } catch (DateTimeParseException e) {}

        try {
            return LocalDate.parse(dateString, formatter2);
        } catch (DateTimeParseException e) {}

        return null;
    }
}
