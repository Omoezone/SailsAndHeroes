package sailsandheroes.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/movement")
    public String movement(@RequestBody String data) {
        String[] test = data.split(",");
        /*List<Point> myPoints = new ArrayList<>();
        int shipId = Integer.parseInt(test[0]);

        for (int i = 1, j = 2; i < test.length; i+=2) {
            int x = Integer.parseInt(test[i]);
            int y = Integer.parseInt(test[j]);
            myPoints.add(new Point(x, y));
            j += 2;
        }*/

        List<Point> myPoints = new ArrayList<>();
        myPoints.add(new Point(2,2));
        myPoints.add(new Point(2,3));
        myPoints.add(new Point(3,3));
        myPoints.add(new Point(4,3));
        myPoints.add(new Point(4,2));
        myPoints.add(new Point(3,1));
        myPoints.add(new Point(2,2));

        Ship myShip = new Ship();
        myShip.setId(1);
        myShip.setPosition(new Point(1, 1));
        myShip.setSpeed(5);
        myShip.setDirection("SE");
        myShip.setPath(myPoints);

        movementService.Move(myShip);

        /*Ship myShip = shipService.getShipById(shipId);
        myShip.setPath(myPoints);*/

        return "redirect:/test";
    }
}
