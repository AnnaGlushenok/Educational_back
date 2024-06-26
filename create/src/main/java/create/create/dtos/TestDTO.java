package create.create.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDTO {
    private Integer id;
    private String name;
    private boolean isFinal;
    private List<QuestionDTO> questions;
}
