package create.create.controllres;

import create.create.services.ControlWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("control")
public class ControlWorkController {
    @Autowired
    private ControlWorkService controlWorkService;
}
