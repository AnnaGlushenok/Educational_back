package create.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class CreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreateApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "CREATE SERVICE1";
    }
}
