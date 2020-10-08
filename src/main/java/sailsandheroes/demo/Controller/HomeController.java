package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import sailsandheroes.demo.Model.*;
import sailsandheroes.demo.Movement.Collision;
import sailsandheroes.demo.Movement.Move;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    Game game;

    @GetMapping("/")
    public String index(Model model){
        game = new Game();
        game.createDefaultGame();
        //Board hexboard = new Board();
        //hexboard.fillBoard(6,12);

        Ship myShip = game.getPlayers().get(0).getShip();
        myShip.setId(1);
        myShip.setStartPos(new Point(1, 1));
        myShip.setSpeed(100);
        myShip.setDirection("SE");

        for (Hex hex : game.getBoard().getHexGrid()) {
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
        model.addAttribute("list", game.getBoard().getHexGrid());
        Move move = new Move();
        move.moveShip();

        return "test";
    }

    @PostMapping("/movement")
    public String movement(@RequestBody String data) {
        String[] test = data.split(",");
        List<Point> myPoints = new ArrayList<>();
        int shipId = Integer.parseInt(test[0]);
        for (int i = 1, j = 2; i < test.length - 1; i+=2) {
            int x = Integer.parseInt(test[i]);
            int y = Integer.parseInt(test[j]);
            myPoints.add(new Point(x, y));
            j += 2;
        }
        System.out.println("Id of ship is: " + shipId);
        System.out.println(data);
        System.out.println(myPoints);
        boolean isAction = false;
        if(test[test.length-1].equals("1")){
            isAction = true;
        }
        System.out.println(isAction);
        PlayerOrder playerOrder = PlayerOrderMaker.createPlayerOrder(isAction,myPoints,"" + shipId,game.getPlayers());
        System.out.println(playerOrder);
        //Send to gameController
        return "redirect:/test";
    }
}
