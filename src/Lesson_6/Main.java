package Lesson_6;

import java.io.IOException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Weather weather = new Weather();
        String result = weather.getWeatherFor5DaysInCity("Saint%20Petersburg");
        System.out.println(result);
    }
}