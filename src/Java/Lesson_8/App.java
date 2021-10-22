package Lesson_8;


  import dto.Sys;
  import dto.WeatherData;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static database.DBRepository.*;

    public class App {
        public static void main(String[] args) throws IOException, InterruptedException {
            Weather weather = new Weather();
            Scanner scanner = new Scanner(System.in);
            init();
            String currentCity = "";
            while (true) {

                System.out.println("Введите название города: ");
                currentCity = scanner.nextLine();
                if (currentCity.equals("exit")){
                    break;
                }
                if (currentCity.equals("getAll")) {
                    List<WeatherData> allData = getAllSavedData();
                    for (WeatherData weatherData : allData) {
                        System.out.println(weatherData.toString());
                    }
                }
                else {
                    if (currentCity.contains(" ")) {
                        // меняем пробел на специальный символ
                        currentCity = currentCity.replaceAll(" ", "%20");
                    }
                    weather.getWeatherFor5DaysInCity(currentCity);
                }
            }
            System.out.println("Завершение программы");
            close();
            System.exit(0);
        }
    }