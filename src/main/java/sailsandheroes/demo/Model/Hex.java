package sailsandheroes.demo.Model;

import java.awt.*;

public class Hex {

    private Point position = new Point(0,0);

    public Hex() {
    }

    public Hex(Point position) {
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "position=" + position +
                '}';
    }
}
