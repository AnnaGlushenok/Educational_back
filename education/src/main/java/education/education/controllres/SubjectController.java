package education.education.controllres;

import education.education.dtos.SubjectDTO;
import education.education.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("get-all")
    public List<SubjectDTO> getAll() {
        var r = subjectService.findAll();
        return subjectService.findAll();
    }
}
