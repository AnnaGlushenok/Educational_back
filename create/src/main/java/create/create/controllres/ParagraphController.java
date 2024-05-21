package create.create.controllres;

import create.create.dtos.ParagraphDTO;
import create.create.services.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("paragraph")
public class ParagraphController {
    @Autowired
    private ParagraphService paragraphService;

    @PostMapping("add/{unitId}")
    public ResponseEntity<?> create(@RequestBody ParagraphDTO paragraphDTO, @PathVariable int unitId) {
        try {
            return new ResponseEntity<>(paragraphService.create(paragraphDTO,unitId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody ParagraphDTO paragraphDTO) {
        try {
            return new ResponseEntity<>(paragraphService.update(paragraphDTO), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            paragraphService.delete(id);
            return new ResponseEntity<>("Paragraph deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
