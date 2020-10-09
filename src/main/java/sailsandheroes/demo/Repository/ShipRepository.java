package sailsandheroes.demo.Repository;

import org.springframework.stereotype.Repository;
import sailsandheroes.demo.Model.Ship;

import java.util.ArrayList;
import java.util.List;
// Joakim
@Repository
public class ShipRepository {

    List<Ship> ships = new ArrayList<>();

    {
        ships.add(new Ship(1, "Brig", null,25.0, 8, 60, 4.0, 2, null, null, null));
        ships.add(new Ship(2, "Ship of the Line", null, 60.0, 16, 160, 10.0, 5, null, null, null));
        ships.add(new Ship(3, "Man at War", null, 140.0, 28, 340, 24.0, 4, null, null, null)) ;
    }

    public Ship fetchShipById(int id) {
        for (Ship ship : ships) {
            if (ship.getId() == id) {
                return ship;
            }
        }
        System.out.println("Couldn't find a ship with that ID");
        return new Ship();
    }

    public List<Ship> fetchAllShips() {
        return ships;
    }

    public void updateShip(Ship s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).getId().equals(s.getId())) {
                ships.set(i, s);
            }
        }
    }
}
