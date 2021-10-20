package Lesson_8.dto;

        import lombok.Getter;
        import lombok.Setter;

@Setter
@Getter
public class City {
    int id;
    String name;
    Coord coord;
    String country;
    int timezone;
    int sunrise;
    int population;
    int sunset;
}