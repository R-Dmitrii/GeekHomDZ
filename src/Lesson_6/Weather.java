package Lesson_6;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.SerializationConfig;

        import java.io.IOException;
        import java.net.URI;
        import java.net.http.HttpClient;
        import java.net.http.HttpRequest;
        import java.net.http.HttpResponse;

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
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }
}