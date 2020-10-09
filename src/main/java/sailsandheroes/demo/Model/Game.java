package sailsandheroes.demo.Model;

import sailsandheroes.demo.Service.ShipService;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();
    private ShipService shipService = new ShipService();

    private Board board;
    private static Game game;

    private Game(int x, int y){
        this.board = new Board();
        board.fillBoard(x,y);

        createDefaultGame();
    }

    public void createDefaultGame(){
        this.board = new Board();
        board.fillBoard(6,12);

        //create lists of ships and add to players
        List<Ship> player1Ships = new ArrayList<>();
        List<Ship> player2Ships = new ArrayList<>();

        player1Ships.add(shipService.fetchShipById(1));
        player2Ships.add(shipService.fetchShipById(2));

        players.add(new Player(player1Ships,1,"player 1"));
        players.add(new Player(player2Ships,2,"player 2"));

        //ensure ships have starting position
        ensureShipStartingPosition(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void ensureShipStartingPosition(List<Player> players){
        Ship ship1 = players.get(0).getShipList().get(0);
        Ship ship2 = players.get(1).getShipList().get(0);

        if (ship1.getPosition() == null) {
            ship1.setPosition(new Point(1, 1));
            ship1.setDirection("SE");
        }
        if (ship2.getPosition() == null) {
            ship2.setPosition(new Point(9, 3));
            ship2.setDirection("NW");
        }
    }

    public static Game getNewGame(int x, int y){
        return new Game(x,y);
    }

    public Game getGame(){
        return this.game;
    }
}
