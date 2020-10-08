package sailsandheroes.demo.Controller;
import org.springframework.stereotype.Controller;
import sailsandheroes.demo.Enums.*;
import sailsandheroes.demo.Enums.PlayerNumber;
import sailsandheroes.demo.Model.AttackModule.AttackMain;
import sailsandheroes.demo.Model.PlayerOrder;
import sailsandheroes.demo.Model.Player;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    private PlayerOrder currentPlayerOrder;
    private Action action;
    private PlayerNumber playerNumber;
    private Player player;
    private List<Player> playerListForAttackLayer = new ArrayList<>();
    private GameResult gameResult = GameResult.NONE;

    // tag imod playerOrder objekt. Instantier enums og switch på PlayerNumber og Action enums.
    // Kald metoder fra Movement og Attack "lag".
    // Modtag GameResult enum fra Attack
    // Kommuniker op igen til Game eller CommmunicationController

    public void etellerandet() {
        playerListForAttackLayer = new ArrayList<>();
    }

    public GameResult recievePlayerOrder(PlayerOrder playerOrder){
        currentPlayerOrder = playerOrder;
        action = playerOrder.getAction();
        playerNumber = designatePlayerNumber();
        player = playerOrder.getPlayer();

        return gameResult = routeAndAskForGameResult();
    }

    public GameResult routeAndAskForGameResult() {
        switch (playerNumber) {
            case PLAYER1:
                switch (action){
                    case MOVE:
                        // todo -- send Player til move laget
                        System.out.println("move");
                        break;
                    case ATTACK:
                        playerListForAttackLayer.add(player);
                        System.out.println("til angreb din landkrabbe");
                        return gameResult;
                }
                break;

            case PLAYER2:
                switch (action){
                    case MOVE:
                        // todo -- send Player til move laget
                        System.out.println("move");
                        break;
                    case ATTACK:
                        playerListForAttackLayer.add(player);
                        return AttackMain.informationToAttack(playerListForAttackLayer);
                }
                break;
        }

        return null;
    }

    public PlayerNumber designatePlayerNumber() {
        if (currentPlayerOrder.getPlayer().getPlayerID() == 1){
            return PlayerNumber.PLAYER1;
        }
        else if (currentPlayerOrder.getPlayer().getPlayerID() == 2){
            return PlayerNumber.PLAYER2;
        }
        else {
            System.out.println("palyerID ikke gyldigt");
        }
        return null;
    }
}