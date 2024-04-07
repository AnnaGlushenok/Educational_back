package education.education.dtos;
import education.education.models.Question;
import education.education.models.Test;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParagraphDTO {
    private Integer id;
    private String name;
    private String text;
    private List<Question> questions;
//    private List<Test> tests;
}
