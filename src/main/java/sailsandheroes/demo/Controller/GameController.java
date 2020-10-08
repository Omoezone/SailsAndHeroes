package sailsandheroes.demo.Controller;
import sailsandheroes.demo.Enums.*;
import sailsandheroes.demo.Model.PlayerOrder;

public class GameController {

    public GameController() {
    }

    public void recievePlayerOrder(PlayerOrder playerOrder){

        Action action = playerOrder.getAction();
        Player player = null;
        if (playerOrder.getPlayer().getPlayerID() == 1){
            player = Player.PLAYER1;
        }
        else if (playerOrder.getPlayer().getPlayerID() == 2){
            player = Player.PLAYER2;
        }
        else {
            System.out.println("palyerID ikke gyldigt");
        }

        switch (player) {
            case PLAYER1:
                switch (action){
                    case MOVE:
                        //noget med send ned til move
                        System.out.println("move");
                        break;
                    case ATTACK:
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
                        System.out.println("noget andet");
                        break;
                }
                break;
        }
    }


}
