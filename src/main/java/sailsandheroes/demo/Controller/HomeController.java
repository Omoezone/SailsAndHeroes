package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){

        Board hexboard = new Board();
        hexboard.fillBoard(6,12);

        Ship myShip = new Ship();
        myShip.setId(1);
        myShip.setPosition(new Point(1, 1));
        myShip.setSpeed(100);
        myShip.setDirection("SE");

        model.addAttribute("ship", myShip);
        model.addAttribute("list", hexboard.getHexGrid());


        return "test";
    }
}
