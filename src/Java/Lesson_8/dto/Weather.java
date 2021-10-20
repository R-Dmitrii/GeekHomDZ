package Lesson_8.dto;

        import lombok.Getter;
        import lombok.Setter;

@Setter
@Getter
public class Weather {
    int id;
    String main;
    String description;
    String icon;
}