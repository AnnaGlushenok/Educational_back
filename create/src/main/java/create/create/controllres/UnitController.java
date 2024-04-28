package create.create.controllres;

import create.create.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("get/{subjectId}/{classId}")
    public ResponseEntity<?> getUnitsBySubjectIdAndClassId(@PathVariable int subjectId, @PathVariable int classId) {
        try {
            return new ResponseEntity<>(unitService.findUnitsBySubjectIdAndClassId(subjectId, classId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-subjects-and-classes")
    public ResponseEntity<?> getSubjectsAndClasses() {
        try {
            return new ResponseEntity<>(unitService.findAllClassesAndSubjects(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
