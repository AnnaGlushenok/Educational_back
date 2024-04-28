package education.education.dtos;

import education.education.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Integer id;
    private String question;
    private String answers;
    private String correctAnswer;
    private String explanation;
    private QuestionType questionType;
}
