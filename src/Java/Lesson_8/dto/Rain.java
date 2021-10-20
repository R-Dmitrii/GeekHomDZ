package Lesson_8.dto;

        import com.fasterxml.jackson.annotation.JsonProperty;
        import lombok.Getter;
        import lombok.Setter;

@Setter
@Getter
public class Rain {
    @JsonProperty("3h")
    float hhh;
}