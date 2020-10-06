package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Hex;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("Hex", new Hex(0, 0, 0));
        return "index";
    }
}
