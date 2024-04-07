package education.education;

import education.education.dtos.SubjectDTO;
import education.education.mappers.SubjectMapper;
import education.education.models.Subject;
import education.education.repositories.SubjectRepository;
import education.education.services.SubjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EducationApplicationTests {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    @DisplayName("Map subject to dto")
    void test() {
        Subject subject = subjectRepository.findById(2).get();
        SubjectDTO subjectDTO = subjectMapper.toDTO(subject);

        Assertions.assertNotNull(subject);
        Assertions.assertNotNull(subjectDTO);
        Assertions.assertEquals(subjectDTO.getId(), subject.getId());
        Assertions.assertEquals(subjectDTO.getName(), subject.getName());
//        Assertions.assertEquals(subjectDTO.getImage(), subject.getImage());
    }
}
