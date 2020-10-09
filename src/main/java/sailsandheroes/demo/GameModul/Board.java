package sailsandheroes.demo.GameModul;

import sailsandheroes.demo.Model.Hex;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
// Jakob
public class Board {

    private List<Hex> hexGrid;

    public Board() {
    }

    public List<Hex> getHexGrid() {
        return hexGrid;
    }

    public void setHexGrid(List<Hex> hexGrid) {
        this.hexGrid = hexGrid;
    }

    public void fillBoard(int sizeX, int sizeY){
        this.hexGrid = new ArrayList<>();
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                Hex hex = new Hex(new Point(j,i));
                hexGrid.add(hex);
            }
        }
        coupleTogether(hexGrid);
    }

    private void coupleTogether(List<Hex> hexGrid) {
        for (Hex hex: hexGrid) {
            //hvis ulige y
            if(hex.getPosition().getY() % 2 != 0){
                // hvis lige x
                if (hex.getPosition().getX() % 2 == 0) {
                    for(int i = 0; i < hexGrid.size(); i++){
                        if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() -1){
                            //hvis det passer med NW
                            hex.setnW(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() - 1){
                            //hvis det passer med N
                            hex.setN(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() -1){
                            //hvis det passer med NE
                            hex.setnE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med SE
                            hex.setsE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() + 1){
                            //hvis det passer med S
                            hex.setS(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med SW
                            hex.setsW(hexGrid.get(i));
                        }
                    }
                }
                // hvis ulige x
                else if (hex.getPosition().getX() % 2 != 0) {
                    for(int i = 0; i < hexGrid.size(); i++){
                        if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med NW
                            hex.setnW(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() - 1){
                            //hvis det passer med N
                            hex.setN(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med NE
                            hex.setnE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() + 1){
                            //hvis det passer med SE
                            hex.setsE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() + 1){
                            //hvis det passer med S
                            hex.setS(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() + 1){
                            //hvis det passer med SW
                            hex.setsW(hexGrid.get(i));
                        }
                    }
                }

                //hvis y er lige
            }else if(hex.getPosition().getY() % 2 == 0 || hex.getPosition().getY() == 0){
                // hvis lige x
                if (hex.getPosition().getX() % 2 == 0) {
                    for(int i = 0; i < hexGrid.size(); i++){
                        if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() - 1){
                            //hvis det passer med NW
                            hex.setnW(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() - 1){
                            //hvis det passer med N
                            hex.setN(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() - 1){
                            //hvis det passer med NE
                            hex.setnE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med SE
                            hex.setsE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() + 1){
                            //hvis det passer med S
                            hex.setS(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med SW
                            hex.setsW(hexGrid.get(i));
                        }
                    }
                }
                // hvis ulige x
                else if (hex.getPosition().getX() % 2 != 0) {
                    for(int i = 0; i < hexGrid.size(); i++){
                        if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med NW
                            hex.setnW(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() - 1){
                            //hvis det passer med N
                            hex.setN(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY()){
                            //hvis det passer med NE
                            hex.setnE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() + 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() +1){
                            //hvis det passer med SE
                            hex.setsE(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() + 1){
                            //hvis det passer med S
                            hex.setS(hexGrid.get(i));
                        }else if(hexGrid.get(i).getPosition().getX() == hex.getPosition().getX() - 1 && hexGrid.get(i).getPosition().getY() == hex.getPosition().getY() +1){
                            //hvis det passer med SW
                            hex.setsW(hexGrid.get(i));
                        }
                    }
                }
            }
        }
    }
}
