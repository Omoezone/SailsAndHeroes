package sailsandheroes.demo.Model;

public class Player {

    private Ship ship;
    private int playerID;
    private String playerName;

    public Player(){

    }

    public Player(Ship ship, int playerID, String playerName) {
        this.ship = ship;
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ship=" + ship +
                ", playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
