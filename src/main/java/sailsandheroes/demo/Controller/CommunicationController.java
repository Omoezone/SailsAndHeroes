package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sailsandheroes.demo.Model.Board;
import sailsandheroes.demo.Model.Game;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Service.MovementService;
import sailsandheroes.demo.Service.ShipService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommunicationController {

    @Autowired
    ShipService shipService;

    @Autowired
    MovementService movementService;



    private String turnplayer = "ship1";

    @GetMapping("/board")
    public String board(Model model){

        model.addAttribute("ship1", game.getPlayers().get(0).getShipList().get(0));
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

        if (turnplayer.equals("ship1")) {
            turnplayer = "ship2";
        } else turnplayer = "ship1";

        return "redirect:/board";
    }
}
