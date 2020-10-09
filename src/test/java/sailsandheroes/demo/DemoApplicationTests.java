package sailsandheroes.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sailsandheroes.demo.Model.Hex;

import java.awt.*;
import java.util.ArrayList;

@SpringBootTest
class DemoApplicationTests {

    ArrayList<Hex> hexGrid;

    @BeforeEach
    void hexCouplingTest(){
        hexGrid = new ArrayList<>();
        for(int i = 0; i <=4; i++){
            for(int j = 0; j <= 4; j++){
                Hex hex = new Hex(new Point(j,i));
                hexGrid.add(hex);
            }
        }
        for (Hex hex: hexGrid) {
            //hvis ulige y
            if(hex.getPosition().getY() % 2 != 0){
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
                //hvis y er lige
            }else if(hex.getPosition().getY() % 2 == 0 || hex.getPosition().getY() == 0){
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
            System.out.println(hex);
        }
    }

    @Test
    void check1(){
        Assertions.assertEquals(1,hexGrid.get(1).getS().getPosition().getX());
    }

    @Test
    void check7(){
        Assertions.assertEquals(2,hexGrid.get(7).getsW().getPosition().getY());
    }

    @Test
    void check9(){
        Assertions.assertEquals(1,hexGrid.get(10).getnE().getPosition().getX());
    }

}
