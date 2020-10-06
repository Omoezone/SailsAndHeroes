package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Hex;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        List<Hex> mylist = new ArrayList<>();
        for (int i = 0; i < 102; i++) {
            mylist.add(new Hex());
        }
        model.addAttribute("list", mylist);
        return "test";
    }
}
