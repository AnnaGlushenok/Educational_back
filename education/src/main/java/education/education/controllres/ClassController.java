package education.education.controllres;

import education.education.models.Class;
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

    @GetMapping("test")
    public List<Class> test() {
        return classService.findAll();
    }
}
