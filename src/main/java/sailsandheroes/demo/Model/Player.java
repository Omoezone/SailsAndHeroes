package sailsandheroes.demo.Model;

import java.util.List;
// Jakob
public class Player {

    private List<Ship> shipList;
    private int playerID;
    private String playerName;

    public Player(){
    }

    public Player(List<Ship> shipList, int playerID, String playerName) {
        this.shipList = shipList;
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShip(List shipList) {
        this.shipList = shipList;
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
                "ship=" + shipList +
                ", playerID=" + playerID +
                ", playerName='" + playerName + '\'' +
                '}';
    }
}
