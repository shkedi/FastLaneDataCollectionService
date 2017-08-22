package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class FastLaneModel {

    private String type;
    private String id;
    private LocalDate localDate;
    private LocalTime localTime;
    private int price;
    private DayOfWeek day;

    public FastLaneModel(LocalDate localDate, LocalTime localTime, DayOfWeek day, int price) {
        this.type = FastLaneConstant.FAST_LANE_TYPE;
        this.id = "";
        this.localDate = localDate;
        this.localTime = localTime;
        this.day = day;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public int getPrice() {
        return price;
    }



}
