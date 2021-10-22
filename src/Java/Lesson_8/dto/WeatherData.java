package Lesson_8.dto;

import lombok.Data;

@Data
public class WeatherData {
    private String city;
    private String localDate;
    private String text;
    private Double temperature;

    @Override
    public String toString() {
        return "В городе " + city + " на дату " + localDate + " ожидается " + text + ", температура " + temperature;
    }
}