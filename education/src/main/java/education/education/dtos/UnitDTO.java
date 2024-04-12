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
public class UnitDTO {
    private Integer id;
    private String name;
    private SubjectDTO subject;
    private ClassDTO classEntity;
    private TestDTO test;
    private ControlWorkDTO controlWork;
    private List<ParagraphDTO> paragraphs;
}
