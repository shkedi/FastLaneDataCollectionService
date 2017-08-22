package model;

import java.time.DayOfWeek;
import java.time.Month;

public interface LangConvertor {

    Month monthConvertor(String month);

    DayOfWeek dayConvertor(String day);
}
