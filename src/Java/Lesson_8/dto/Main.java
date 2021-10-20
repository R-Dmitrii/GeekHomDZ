package Lesson_8.dto;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
public class Main {
    float temp;
    float feels_like;
    float temp_min;
    float temp_max;
    float pressure;
    int sea_level;
    int grnd_level;
    int humidity;
    float temp_kf;

    public float getTemp(){
        return temp-273.15f;
    }
}