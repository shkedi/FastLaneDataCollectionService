package model;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class HebrewConvertor implements LangConvertor {

    private Map<String, Month> monthMap = new HashMap<>();
    private Map<String, DayOfWeek> dayMap = new HashMap<>();

    public HebrewConvertor() {

    }

    @PostConstruct
    public void init() {
        monthMap.put("ינואר", Month.JANUARY);
        monthMap.put("פברואר", Month.FEBRUARY);
        monthMap.put("מרץ", Month.MARCH);
        monthMap.put("אפריל", Month.APRIL);
        monthMap.put("מאי", Month.MAY);
        monthMap.put("יוני", Month.JUNE);
        monthMap.put("יולי", Month.JULY);
        monthMap.put("אוגוסט", Month.AUGUST);
        monthMap.put("ספטמבר", Month.SEPTEMBER);
        monthMap.put("אוקטובר", Month.OCTOBER);
        monthMap.put("נובמבר", Month.NOVEMBER);
        monthMap.put("דצמבר", Month.DECEMBER);

        dayMap.put("יום ראשון", DayOfWeek.SUNDAY);
        dayMap.put("יום שני", DayOfWeek.MONDAY);
        dayMap.put("יום שלישי", DayOfWeek.TUESDAY);
        dayMap.put("יום רביעי", DayOfWeek.WEDNESDAY);
        dayMap.put("יום חמישי", DayOfWeek.THURSDAY);
        dayMap.put("יום שישי", DayOfWeek.FRIDAY);
        dayMap.put("יום שבת", DayOfWeek.SATURDAY);


    }

    @Override
    public Month monthConvertor(String hebrewMonth) {
        return monthMap.get(hebrewMonth);
    }

    @Override
    public DayOfWeek dayConvertor(String day) {
        return dayMap.get(day);
    }
}
