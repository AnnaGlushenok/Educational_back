package education.education.controllres;

import education.education.dtos.ClassDTO;
import education.education.dtos.SubjectDTO;
import education.education.services.SubjectService;
import education.education.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private UnitService unitService;

    @GetMapping("get-all")
    public List<SubjectDTO> getAll() {
        return subjectService.findAll();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            SubjectDTO subjectDTO = subjectService.findById(id);
            return new ResponseEntity<>(subjectDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-subjects-and-classes")
    public ResponseEntity<Map<SubjectDTO, Set<ClassDTO>>> getSubjectsAndClasses() {
        return new ResponseEntity<>(unitService.findAllClassesAndSubjects(), HttpStatus.OK);
    }
}
