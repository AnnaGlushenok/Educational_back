package school.school;

import bll.bll.BLLService;
import bll.bll.services.ClassService;
import dal.dal.models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SchoolApplication {
//    @Autowired
//    private ClassService classService;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        BLLService bll = new BLLService();
        return bll.BLLService();
    }

    @GetMapping("/class/get")
    public Iterable<Class> get() {
        ClassService classService = new ClassService();
        var r = classService.get();
        return r;
    }
}
