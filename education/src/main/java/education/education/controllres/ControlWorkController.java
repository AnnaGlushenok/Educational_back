package education.education.controllres;

import education.education.dtos.ControlWorkDTO;
import education.education.services.ControlWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controlWork")
public class ControlWorkController {
    @Autowired
    private ControlWorkService controlWorkService;

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            ControlWorkDTO controlWorkDTO = controlWorkService.findById(id);
            return new ResponseEntity<>(controlWorkDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
