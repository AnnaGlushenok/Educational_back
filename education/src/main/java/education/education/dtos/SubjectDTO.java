package education.education.dtos;

import education.education.models.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Integer id;
    private String name;
    private Image image;
}
