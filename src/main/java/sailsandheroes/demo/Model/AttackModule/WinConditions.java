package sailsandheroes.demo.Model.AttackModule;

import sailsandheroes.demo.Enums.GameResult;
import sailsandheroes.demo.Model.Player;
import sailsandheroes.demo.Model.Ship;

import java.util.List;

public class WinConditions {

    public static GameResult checkWinCondition(List<Player> list){
        /*
        * Check if any ship has reach a state where it is dead. The opposite player is the winner.
        */
        GameResult value = GameResult.NONE;
        Ship playerOneShip = list.get(0).getShipList().get(0);
        Ship playerTwoShip = list.get(1).getShipList().get(0);

        for (int i = 0; i < list.size() ; i++) {
            // If both players have meet an defeat state, it will return a draw
            if ((playerOneShip.getHullQuality() <= 0 || playerOneShip.getAmountOfSailors() <= 0 || playerOneShip.getSailQuality() <= 0)
                    && (playerTwoShip.getHullQuality() <= 0 || playerTwoShip.getAmountOfSailors() <= 0 || playerTwoShip.getSailQuality() <= 0)) {
                value = GameResult.DRAW;
                // If Player 2 have reached a defeat state, it will return a player 1 win
            } else if (playerTwoShip.getHullQuality() <= 0 || playerTwoShip.getAmountOfSailors() <= 0 || playerTwoShip.getSailQuality() <= 0) {
                value = GameResult.PLAYER1_WIN;
                // If Player 1 have reached a defeat state, it will return a player 2 win
            } else if(playerOneShip.getHullQuality() <= 0 || playerOneShip.getAmountOfSailors() <= 0 || playerOneShip.getSailQuality() <= 0){
                value = GameResult.PLAYER2_WIN;
            }
        }
        return value;
    }
}
