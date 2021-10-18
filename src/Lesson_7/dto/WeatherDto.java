package Lesson_7.dto;


        import lombok.Getter;
        import lombok.Setter;

        import java.util.List;

@Getter
@Setter
public class WeatherDto {
    long dt;
    Main main;
    List<Weather> weather;
    Clouds clouds;
    Wind wind;
    int visibility;
    float pop;
    Rain rain;
    Sys sys;
    String dt_txt;
    Object snow;
}