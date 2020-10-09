package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Repository.ShipRepository;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {

        return "index";
    }
}
