package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sailsandheroes.demo.Enums.PlayerNumber;
import sailsandheroes.demo.Model.Game;
import sailsandheroes.demo.Model.Player;
import sailsandheroes.demo.Model.PlayerOrder;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Service.MovementService;
import sailsandheroes.demo.Service.ShipService;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommunicationController {

    @Autowired
    private ShipService shipService;

    @Autowired
    private MovementService movementService;

    private Game game;

    private String turnplayer = "ship1";

    @GetMapping("/board")
    public String board(Model model){
        Game game = new Game(6, 12);
        Ship ship1 = game.getPlayers().get(0).getShipList().get(0);
        Ship ship2 = game.getPlayers().get(1).getShipList().get(0);

        // todo -- ændre front end til at fungere med PlayerNumber enum og ikke turnplayer variabel
        if(game.getCurrentPlayerTurn() == PlayerNumber.PLAYER1) {
            turnplayer = "ship1";
        } else {
            turnplayer = "ship2";
        }

        model.addAttribute("ship1", ship1);
        model.addAttribute("ship2", ship2);
        model.addAttribute("turnplayer", turnplayer);
        model.addAttribute("list", game.getBoard().getHexGrid());

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

        Map<Player, Ship> shipPlayerPair = game.getShipAndPlayerFromShipId(shipId);

        Player player = shipPlayerPair.entrySet().iterator().next().getKey();
        Ship myShip = shipPlayerPair.entrySet().iterator().next().getValue();

        myShip.setPath(myPoints);

        System.out.println(myShip);
        System.out.println(myPoints);

        movementService.Move(player);

        if(game.getCurrentPlayerTurn() == PlayerNumber.PLAYER1) {
            game.setCurrentPlayerTurn(PlayerNumber.PLAYER2);
        } else {
            game.setCurrentPlayerTurn(PlayerNumber.PLAYER1);
        }

        return "redirect:/board";
    }
}
