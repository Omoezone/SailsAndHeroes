package sailsandheroes.demo.Model;

import java.awt.*;

public class Hex {
    int radius;
    Point center;
    Point cornerA;
    Point cornerB;
    Point cornerC;
    Point cornerD;
    Point cornerE;
    Point cornerF;

    public Hex(Point point){
        radius = 100;
        center = point;
        cornerA = new Point(100,0);
        cornerB = new Point(50, 87);
        cornerC = new Point(-50, 87);
        cornerD = new Point(-100, -0);
        cornerE = new Point(-50,-87);
        cornerF = new Point(50, -87);
    }
}
