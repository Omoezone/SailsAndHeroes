package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Hex;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Movement.Collision;
import sailsandheroes.demo.Movement.Move;

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
        myShip.setSpeed(100);
        myShip.setDirection("SE");

        for (Hex hex : hexboard.getHexGrid()) {
            if (hex.getPosition().x == 4 && hex.getPosition().y == 3) {
                System.out.println("North is: " + hex.getN());
                System.out.println("South is: " + hex.getS());
                System.out.println("Northwest is: " + hex.getnW());
                System.out.println("Northeast is: " + hex.getnE());
                System.out.println("Southwest is: " + hex.getsW());
                System.out.println("Southeast is: " + hex.getsE());
            }
        }

        model.addAttribute("ship", myShip);
        model.addAttribute("list", hexboard.getHexGrid());

        Move move = new Move();
        move.moveShip();

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

        //TODO SHOOT TEST
        System.out.println("I recieved this shoot coordinate: " + test[test.length-2] + ", " + test[test.length-1]);

        return "redirect:/test";
    }
}
