package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Hex;

import java.awt.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("hex" ,new Hex(new Point(200, 200)));
        return "index";
    }
}
