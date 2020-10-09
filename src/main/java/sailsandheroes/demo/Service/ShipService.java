package sailsandheroes.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Repository.ShipRepository;
// Joakim
@Service
public class ShipService {

    @Autowired
    ShipRepository shipRepository;

    public Ship fetchShipById(int id) {
        return shipRepository.fetchShipById(id);
    }

    public void updateShip(Ship ship) {
        shipRepository.updateShip(ship);
    }
}
