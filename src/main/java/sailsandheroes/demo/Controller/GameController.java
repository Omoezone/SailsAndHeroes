package sailsandheroes.demo.Controller;
import org.springframework.stereotype.Controller;
import sailsandheroes.demo.Enums.*;
import sailsandheroes.demo.Enums.PlayerNumber;
import sailsandheroes.demo.Model.PlayerOrder;
import sailsandheroes.demo.Model.Player;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    // tag imod playerOrder objekt. Instantier enums og switch på PlayerNumber og Action enums.
    // Kald metoder fra Movement og Attack "lag".
    // Modtag GameResult enum fra Attack
    // Kommuniker op igen til Game eller CommmunicationController
    public void recievePlayerOrder(PlayerOrder playerOrder){
        Action action = playerOrder.getAction();
        PlayerNumber playerNumber = null;
        Player player = playerOrder.getPlayer();
        List<Player> playerListForAttackLayer = new ArrayList<>();

        if (playerOrder.getPlayer().getPlayerID() == 1){
            playerNumber = PlayerNumber.PLAYER1;
        }
        else if (playerOrder.getPlayer().getPlayerID() == 2){
            playerNumber = PlayerNumber.PLAYER2;
        }
        else {
            System.out.println("playerID ikke gyldigt");
        }

        GameResult gameResult = GameResult.NONE;

        switch (playerNumber) {
            case PLAYER1:
                switch (action){
                    case MOVE:
                        //noget med send ned til move
                        System.out.println("move");
                        break;
                    case ATTACK:
                        playerListForAttackLayer.add(player);
                        System.out.println("til angreb din landkrabbe");
                        break;
                }
                break;
            case PLAYER2:
                switch (action){
                    case MOVE:
                        //noget med send ned til move
                        System.out.println("move");
                        break;
                    case ATTACK:
                        playerListForAttackLayer.add(player);
                        System.out.println("noget andet");
                        // todo -- kald attack metode og pass playerListForAttackLayer
                        break;
                }
                break;
        }
    }
}
