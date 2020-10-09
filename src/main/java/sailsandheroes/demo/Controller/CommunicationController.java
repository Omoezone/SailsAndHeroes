package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sailsandheroes.demo.GameModul.Board;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Service.MovementService;
import sailsandheroes.demo.Service.ShipService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Joakim
@Controller
public class CommunicationController {

    @Autowired
    ShipService shipService;

    @Autowired
    MovementService movementService;

    @GetMapping("/board")
    public String board(Model model){

        Board hexboard = new Board();
        hexboard.fillBoard(6,12);

        Ship ship1 = shipService.fetchShipById(1);
        Ship ship2 = shipService.fetchShipById(2);
        String turnplayer = "ship1";

        if (ship1.getPosition() == null) {
            ship1.setPosition(new Point(1, 1));
            ship1.setDirection("SE");
        }
        if (ship2.getPosition() == null) {
            ship2.setPosition(new Point(9, 3));
            ship2.setDirection("NW");
        }

        model.addAttribute("ship1", ship1);
        model.addAttribute("ship2", ship2);
        model.addAttribute("turnplayer", turnplayer);
        model.addAttribute("list", hexboard.getHexGrid());

        return "/test";
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

        Ship myShip = shipService.fetchShipById(shipId);
        myShip.setPath(myPoints);

        System.out.println(myShip);
        System.out.println(myPoints);

        movementService.Move(myShip);

        return "redirect:/board";
    }

}
