package create.create.controllres;

import create.create.services.ControlWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("control")
public class ControlWorkController {
    @Autowired
    private ControlWorkService controlWorkService;

    @GetMapping("get-all")
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(controlWorkService.findAll(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

