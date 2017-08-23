package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FastLaneModelCreator implements ModelCreator<FastLaneModel> {

    @Autowired
    private LangConvertor hebrewConvertor;

    public FastLaneModelCreator() {

    }

    @Override
    public boolean isValid(String data) {
        return false;
    }

    @Override
    public FastLaneModel create(String data) {
        FastLaneModel fastLaneModel;
        Document doc = Jsoup.parse(data);
        int price = getValue(x ->  Integer.valueOf(doc.getElementsByAttributeValue(FastLaneConstant.ID_ELEMENT,x).text()), FastLaneConstant.PRICE_ATTR);
        DayOfWeek day = getValue(x ->  hebrewConvertor.dayConvertor(doc.getElementsByAttributeValue(FastLaneConstant.ID_ELEMENT,x).text()), FastLaneConstant.DAY_ATTR);

        LocalDate localDate = LocalDate.of(
                getValue(x ->  Integer.valueOf(doc.getElementsByAttributeValue(FastLaneConstant.ID_ELEMENT,x).text()) ,FastLaneConstant.YEAR_ATTR),
                (Month) getValue(x ->  hebrewConvertor.monthConvertor(doc.getElementsByAttributeValue(FastLaneConstant.ID_ELEMENT,x).text()) ,FastLaneConstant.MONTH_ATTR),
                getValue(x ->  Integer.valueOf(doc.getElementsByAttributeValue(FastLaneConstant.ID_ELEMENT,x).text()) ,FastLaneConstant.DAY_OF_MONTH_ATTR));

        String[] timeNum = getValue(x -> doc.getElementsByAttributeValue(FastLaneConstant.ID_ELEMENT, x).text(), FastLaneConstant.TIME_ATTR).split(":");
        LocalTime localTime = LocalTime.of(Integer.parseInt(timeNum[0]), Integer.parseInt(timeNum[1]));

        fastLaneModel = new FastLaneModel(localDate, localTime, day, price);

        return fastLaneModel;

    }

    private <T> T getValue(Function<String, T> func, String attr) {
        return func.apply(attr);
    }


}
