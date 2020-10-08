package sailsandheroes.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Repository.ShipRepositoryI;

import java.awt.*;
import java.util.List;

@Service
public class ShipService {

    @Autowired
    ShipRepositoryI shipRepositoryI;

    public String createShip(Ship ship) {
        shipRepositoryI.save(ship);
        return("redirect:/index");
    }

    public Ship readOneShip (Integer id) {
        return shipRepositoryI.findById(id).orElse(null);
    }


    public List<Ship> readAllShips(){
        return (List<Ship>) shipRepositoryI.findAll();
    }

    public void deleteShip(Integer id){
        shipRepositoryI.deleteById(id);
    }

    public Ship getShipById(int id) {
        Ship ship = new Ship();
        ship.setId(1);
        ship.setPosition(new Point(1, 1));
        ship.setSpeed(100);
        ship.setDirection("SE");

        return ship;
    }
}
