package education.education.controllres;

import education.education.dtos.ClassDTO;
import education.education.mappers.ClassMapper;
import education.education.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("class")
public class ClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    private ClassMapper classMapper;

    @GetMapping("get-all")
    public List<ClassDTO> getAll() {
        return classService.findAll();
    }
}
