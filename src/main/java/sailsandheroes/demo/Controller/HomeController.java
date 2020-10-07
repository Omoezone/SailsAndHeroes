package sailsandheroes.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Hex;
import sailsandheroes.demo.Model.Ship;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        List<Hex> mylist = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                mylist.add(new Hex(new Point(j, i)));
            }
        }
        Board hexboard = new Board();
        hexboard.fillBoard(6);
        Ship ship = new Ship();
        ship.setStartPos(new Point(1, 1));
        System.out.println(ship);
        /*for (Hex h : mylist) {
            if (h.getPosition().x == ship.getStartPos().x && h.getPosition().y == ship.getStartPos().y) {
                System.out.println("Equal");
            }
            else System.out.println("Not equal" + h.getPosition() + " and " + ship.getStartPos());
        }*/
        model.addAttribute("startpos", ship);
        model.addAttribute("list", hexboard.getHexGrid());

        return "test";
    }
}
