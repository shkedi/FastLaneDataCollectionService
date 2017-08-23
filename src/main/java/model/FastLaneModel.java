package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@JsonPropertyOrder({ "type", "id", "date", "time", "price" })
public class FastLaneModel {

    private String type;
    private String id;
    private LocalDate localDate;
    private LocalTime localTime;
    private int price;
    private DayOfWeek day;

    public FastLaneModel(LocalDate localDate, LocalTime localTime, DayOfWeek day, int price) {
        this.type = FastLaneConstant.FAST_LANE_TYPE;
        this.id = UUID.randomUUID().toString();
        this.localDate = localDate;
        this.localTime = localTime;
        this.day = day;
        this.price = price;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("date")
    public String getLocalDate() {
        return localDate.toString();
    }

    @JsonProperty("time")
    public String getLocalTime() {
        return localTime.toString();
    }

    @JsonProperty("price")
    public int getPrice() {
        return price;
    }



}
