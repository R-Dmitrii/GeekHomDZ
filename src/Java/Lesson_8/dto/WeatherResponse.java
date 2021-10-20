package Lesson_8.dto;

        import lombok.Getter;
        import lombok.Setter;

        import java.util.List;

@Getter
@Setter
public class WeatherResponse {
    String cod;
    int message;
    int cnt;

    List<WeatherDto> list;
    City city;
}