package Lesson_7;

import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.SerializationConfig;
        import dto.WeatherResponse;

        import java.io.IOException;
        import java.net.URI;
        import java.net.http.HttpClient;
        import java.net.http.HttpRequest;
        import java.net.http.HttpResponse;
        import java.text.SimpleDateFormat;
        import java.util.Date;

public class Weather {
    private static final String URL = "https://community-open-weather-map.p.rapidapi.com/forecast?q=";
    private static final String token = "9ebfb0d7bbmsh106242ff387b285p1584c0jsn1db8ba3de666";

    public String getWeatherFor5DaysInCity(String city) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + city))
                .header("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .header("x-rapidapi-key", token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        // convert to object to pretty json string
        Object json = mapper.readValue(response.body(), Object.class);
        // return pretty string
        WeatherResponse weatherResponse = mapper.readValue(response.body(), WeatherResponse.class);
        int currentDay = 0;
        // получаем первую дату для вывода прогноза на 5 дней, тк сервис возвращает на 6 дней
        int startDate = new Date(weatherResponse.getList().get(0).getDt() * 1000L).getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();
        // перебираем все прогнозы
        for (int i = 0; i < weatherResponse.getList().size(); i++) {
            Date date = new Date(weatherResponse.getList().get(i).getDt() * 1000L);
            // условие выхода из цикла
            if (date.getDate() > startDate + 4) {
                break;
            }
            // если в прогнозе повторяется дата, то пропускаем этот прогноз
            if (date.getDate() == currentDay) {
                continue;
            } else {
                currentDay = date.getDate();
            }
            sb.append("В городе " + weatherResponse.getCity().getName() +
                    " на дату " + sdf.format(date) + " ожидается " + weatherResponse.getList().get(i).getWeather().get(0).getDescription() +
                    ", температура - " + weatherResponse.getList().get(i).getMain().getTemp() + "\n");
        }

        return sb.toString();
    }
}