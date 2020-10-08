package sailsandheroes.demo.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sailsandheroes.demo.Enums.Action;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerOrderMakerTest {
    boolean isMove;
    boolean isAttack;
    List<Point> coords;
    String shipID;
    List<Player> players;

    @BeforeEach
    public void setupForTests(){
        isMove = false;
        isAttack= true;
        coords = new ArrayList<>();
        players = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            coords.add(new Point(0,i));
        }
        for(int j = 1; j <= 2; j++){
            Ship ship = new Ship();
            ship.setId(j);
            Player player = new Player();
            player.setPlayerID(j);
            player.setShip(ship);
            players.add(player);
        }
        shipID = "1";
    }

    @Test
    public void createPOtest1() throws NullPointerException{
        PlayerOrder playerOrder = PlayerOrderMaker.createPlayerOrder(isMove,isAttack,coords,shipID,players);
        assertEquals(Action.MOVE,playerOrder.getAction());
    }

    @Test
    public void createPOtest2() throws NullPointerException{
        PlayerOrder playerOrder = PlayerOrderMaker.createPlayerOrder(isMove,isAttack,coords,shipID,players);
        assertEquals(Action.ATTACK,playerOrder.getAction());
    }

}