package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Hex;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
