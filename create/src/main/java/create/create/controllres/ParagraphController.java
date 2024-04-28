package create.create.controllres;

import create.create.services.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paragraph")
public class ParagraphController {
    @Autowired
    private ParagraphService paragraphService;

    @GetMapping("get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(paragraphService.findById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
