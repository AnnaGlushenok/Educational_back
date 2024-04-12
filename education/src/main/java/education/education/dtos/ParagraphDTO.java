package education.education.dtos;

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
    private List<QuestionDTO> questions;
    private List<TestDTO> tests;
    private List<ControlWorkDTO> controlWorks;
}
