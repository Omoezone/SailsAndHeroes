package sailsandheroes.demo.Model.AttackModule;

import sailsandheroes.demo.Enums.GameResult;
import sailsandheroes.demo.Model.Player;
import sailsandheroes.demo.Model.Ship;
import java.util.ArrayList;

import java.util.List;

public class AttackMain {
    public static GameResult informationToAttack(List<Player> list){
        Ship playerOneShip = list.get(0).getShipList().get(0);
        Ship playerTwoShip = list.get(1).getShipList().get(0);

        //Set power values
        playerOneShip.calculatePowerValue();
        playerTwoShip.calculatePowerValue();

        //Player one shoots
        CheckHit.checkHit(playerOneShip, playerTwoShip, null /*TODO POINT (HVOR VI SKYDER*/);
        //Player two shoots
        CheckHit.checkHit(playerTwoShip, playerOneShip, null/*TODO POINT (HVOR VI SKYDER*/);

        //none - no result
        return WinConditions.checkWinCondition(list);
    }
}
