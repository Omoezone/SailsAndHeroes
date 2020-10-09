package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Service.ShipService;

@Controller
public class HomeController {

    @Autowired
    ShipService shipService;

    @GetMapping("/index")
    public String index() {
        return "/index";

    }
}
