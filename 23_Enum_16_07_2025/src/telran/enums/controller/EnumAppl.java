package telran.enums.controller;

import telran.enums.model.Day;
import telran.enums.model.Priority;

public class EnumAppl {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println(today);

        switch (today) {
            case MONDAY -> System.out.println("יום שני");
            case TUESDAY -> System.out.println("יום שלישי");
            case FRIDAY -> System.out.println("יום שישי");
        }

        Priority task = Priority.MEDIUM;
        System.out.println(task.getLevel());

        System.out.println(Priority.values().length);
        for (int i = 0; i < Priority.values().length; i++) {
            Priority priority = Priority.values()[i];
            System.out.println(priority.ordinal());
        }
    }
}
