package dal.dal;

import dal.dal.interfases.ClassRepository;
import dal.dal.models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/class")
public class Controller {
    @Autowired
    private ClassRepository classRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String add(@RequestBody Class className) {
        classRepository.save(className);
        return "Saved";
    }

    @GetMapping("/hell")
    public String hell() {
        return "hello";
    }

    @GetMapping("/class/get")
    public Iterable<Class> get() {
        var r = classRepository.findAll();
        return r;
    }
}
