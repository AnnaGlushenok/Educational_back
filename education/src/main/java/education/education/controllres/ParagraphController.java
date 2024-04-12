package education.education.controllres;

import education.education.dtos.ParagraphDTO;
import education.education.services.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("paragraph")
public class ParagraphController {
    @Autowired
    private ParagraphService paragraphService;

    @GetMapping("get-all")
    public List<ParagraphDTO> getAll() {
        return paragraphService.findAll();
    }
}
