package sailsandheroes.demo.Controller;
import org.springframework.stereotype.Controller;
import sailsandheroes.demo.Enums.*;
import sailsandheroes.demo.Enums.PlayerNumber;
import sailsandheroes.demo.Model.AttackModule.AttackMain;
import sailsandheroes.demo.Model.PlayerOrder;
import sailsandheroes.demo.Model.Player;
import sailsandheroes.demo.Movement.*;
import sailsandheroes.demo.Utility.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    private PlayerOrder currentPlayerOrder;
    private Action action;
    private PlayerNumber playerNumber;
    private Player player;
    private List<Player> playerListForAttackLayer;
    private PlayerOrderResult playerOrderResult;

    Move movementLayer = new Move();

    // tag imod playerOrder objekt. Instantier enums og switch på PlayerNumber og Action enums.
    // Kald metoder fra Movement og Attack "lag".
    // Modtag GameResult enum fra Attack
    // Kommuniker op igen til Game eller CommmunicationController

    public PlayerOrderResult recievePlayerOrder(PlayerOrder playerOrder){
        currentPlayerOrder = playerOrder;
        action = playerOrder.getAction();
        playerNumber = designatePlayerNumber();
        player = playerOrder.getPlayer();

        return playerOrderResult = routeAndAskForGameResult();
    }

    public PlayerOrderResult routeAndAskForGameResult(){
        PlayerOrderResult playerOrderResult = new PlayerOrderResult();

        switch (playerNumber) {
            case PLAYER1:
                switch (action){
                    case MOVE:
                        // todo -- send Player til move laget
                        System.out.println("move");
                        boolean movementResult = movementLayer.moveShip(player);

                        if(!movementResult){
                            playerOrderResult.setTurnResult(TurnResult.FAILED);
                        }

                        return playerOrderResult;
                    case ATTACK:
                        playerListForAttackLayer = new ArrayList<>();
                        playerListForAttackLayer.add(player);

                        System.out.println("til angreb din landkrabbe");

                        return playerOrderResult;
                }
                break;

            case PLAYER2:
                switch (action){
                    case MOVE:
                        // todo -- send Player til move laget
                        System.out.println("move");

                        boolean movementResult = movementLayer.moveShip(player);

                        if(!movementResult){
                            playerOrderResult.setTurnResult(TurnResult.FAILED);
                        }
                        return playerOrderResult;

                    case ATTACK:
                        playerListForAttackLayer.add(player);
                        playerOrderResult.setGameResult(AttackMain.informationToAttack(playerListForAttackLayer));

                        return playerOrderResult;
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
            System.out.println("playerID ikke gyldigt");
        }
        return null;
    }
}