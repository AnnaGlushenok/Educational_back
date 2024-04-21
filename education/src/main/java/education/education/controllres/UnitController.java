package education.education.controllres;

import education.education.dtos.UnitDTO;
import education.education.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping("get-units-and-paragraphs/{subjectId}/{classId}")
    public List<UnitDTO> getUnitsAndParagraphsBySubjectIdAndClassId(@PathVariable int subjectId, @PathVariable int classId) {
        return unitService.findUnitsAndParagraphsBySubjectIdAndClassId(subjectId, classId);
    }
}
