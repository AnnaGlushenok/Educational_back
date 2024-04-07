package education.education.dtos;

import education.education.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ControlWorkDTO {
    private Integer id;
    private String name;
    private List<Question> questions;
}
