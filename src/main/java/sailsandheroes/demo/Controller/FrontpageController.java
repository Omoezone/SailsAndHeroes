package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// Frederik
@Controller
public class FrontpageController {

    @GetMapping("/")
    public String frontPage(){
        return "frontpage";
    }
}

