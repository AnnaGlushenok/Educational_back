package create.create.controllres;

import create.create.dtos.UnitDTO;
import create.create.services.UnitService;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @PostMapping("add")
    public ResponseEntity<?> createUnit(@RequestBody UnitDTO unitDTO) {
        try {
            return new ResponseEntity<>(unitService.add(unitDTO), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("edit")
    public ResponseEntity<?> editUnit(@RequestBody UnitDTO unitDTO) {
        try {
            return new ResponseEntity<>(unitService.edit(unitDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable int id) {
        try {
            unitService.remove(id);
            return new ResponseEntity<>("Unit deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
