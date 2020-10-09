package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontpageController {

    @GetMapping("/frontpage")
    public String frontPage(){
        return "frontpage";
    }
}

