package sailsandheroes.demo.Model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();
    private Board board;


    public Game(){

    }

    public Game(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public void createDefaultGame(){
        Ship player1Ship = new Ship(1,"HMS Victory","1,1", 100.0, 3, 340, 100.0, 10, "North","England","Canonball");
        Ship player2Ship = new Ship(2,"HMS Victory","5,1", 100.0, 3, 340, 100.0, 10, "South","England","Canonball");
        players.add(new Player(player1Ship,1,"player 1"));
        players.add(new Player(player2Ship,2,"player 2"));
        this.board = new Board();
        board.fillBoard(6,12);
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
}
