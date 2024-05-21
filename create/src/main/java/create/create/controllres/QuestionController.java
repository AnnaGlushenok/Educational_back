package create.create.controllres;

import create.create.dtos.QuestionDTO;
import create.create.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("add")
    public ResponseEntity<?> create(@RequestBody QuestionDTO questionDTO) {
        try {
            return new ResponseEntity<>(questionService.create(questionDTO), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("edit")
    public ResponseEntity<?> update(@RequestBody QuestionDTO questionDTO) {
        try {
            return new ResponseEntity<>(questionService.update(questionDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            questionService.delete(id);
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
