package Lesson_7;

import dto.Sys;

        import java.io.IOException;
        import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Weather weather = new Weather();
        Scanner scanner = new Scanner(System.in);
        String currentCity = "";
        while (true) {
            System.out.println("Введите название города: ");
            currentCity = scanner.nextLine();
            if (currentCity.equals("exit")){
                break;
            }
            if (currentCity.contains(" ")) {
                // меняем пробел на специальный символ
                currentCity = currentCity.replaceAll(" ", "%20");
            }
            String result = weather.getWeatherFor5DaysInCity(currentCity);
            System.out.println(result);
        }
        System.out.println("Завершение программы");
        System.exit(0);
    }
}