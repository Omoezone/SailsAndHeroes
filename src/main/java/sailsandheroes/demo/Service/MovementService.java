package sailsandheroes.demo.Service;

import org.springframework.stereotype.Service;
import sailsandheroes.demo.Enums.TurnResult;
import sailsandheroes.demo.Model.Ship;
import sailsandheroes.demo.Movement.Move;

@Service
public class MovementService {

    private Move move;

    public MovementService() {
        move = new Move();
    }

    /*public TurnResult Move(Ship ship) {
        return move.moveShip(ship);
    }*/


}
