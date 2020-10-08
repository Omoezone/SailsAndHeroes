package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Movement.Collision;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index(Model model){
        Board hexboard = new Board();
        hexboard.fillBoard(6,12);

        Ship myShip = new Ship();
        myShip.setId(1);
        myShip.setStartPos(new Point(1, 1));
        myShip.setSpeed(5);



        model.addAttribute("ship", myShip);
        model.addAttribute("list", hexboard.getHexGrid());
        return "test";
    }

    @PostMapping("/movement")
    public String movement(@RequestBody String data) {
        String[] test = data.split(",");
        List<Point> myPoints = new ArrayList<>();
        int shipId = Integer.parseInt(test[0]);
        for (int i = 1, j = 2; i < test.length; i+=2) {
            int x = Integer.parseInt(test[i]);
            int y = Integer.parseInt(test[j]);
            myPoints.add(new Point(x, y));
            j += 2;
        }
        System.out.println("Id of ship is: " + shipId);
        System.out.println(myPoints);
        return "redirect:/test";

    }
}
