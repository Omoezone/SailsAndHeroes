package sailsandheroes.demo.Utility;

import sailsandheroes.demo.Enums.Action;
import sailsandheroes.demo.Model.Player;

import java.awt.*;
import java.util.List;
// Jakob
public class PlayerOrderMaker {

    public static PlayerOrder createPlayerOrder(boolean isAction, List<Point> coords, String shipID, List<Player> players) throws NullPointerException{
        Action action = Action.MOVE;
        if(!isAction){
            action = Action.MOVE;
        }else if(isAction){
            action = Action.ATTACK;
        }
        for (Player player : players) {
            if (Integer.parseInt(shipID) == player.getShipList().get(0).getId()) {
                return new PlayerOrder(player, action, coords);
            }
        }
        return null;
    }
}
