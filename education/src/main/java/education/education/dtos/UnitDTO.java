package education.education.dtos;

import education.education.models.Class;
import education.education.models.*;
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
    private Subject subject;
    private Class aClass;
    private Test test;
    private ControlWork controlWork;
    private List<Paragraph> paragraphs;
}
