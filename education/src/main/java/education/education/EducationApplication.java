package education.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class EducationApplication {
    public static void main(String[] args) {
        SpringApplication.run(EducationApplication.class, args);
    }

    @GetMapping("/ed")
    public String ed() {
        return "EDUCATION SERVICE";
    }

    @GetMapping("mod2/mm")
    public String sad() {
        return "/mod2/get";
    }

    @PostMapping("/add")
    public String te(@RequestBody String name) {
        return name + " mod!!!";
    }
}

