package sailsandheroes.demo.Model;

import java.awt.*;

public class Hex {

    private Point position = new Point(0,0);
    private Hex nW;
    private Hex n;
    private Hex nE;
    private Hex sE;
    private Hex s;
    private Hex sW;

    public Hex() {
    }

    public Hex(Point position) {
        this.position = position;
    }

    public Hex(Point position, Hex nW, Hex n, Hex nE, Hex sE, Hex s, Hex sW) {
        this.position = position;
        this.nW = nW;
        this.n = n;
        this.nE = nE;
        this.sE = sE;
        this.s = s;
        this.sW = sW;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Hex getnW() {
        return nW;
    }

    public void setnW(Hex nW) {
        this.nW = nW;
    }

    public Hex getN() {
        return n;
    }

    public void setN(Hex n) {
        this.n = n;
    }

    public Hex getnE() {
        return nE;
    }

    public void setnE(Hex nE) {
        this.nE = nE;
    }

    public Hex getsE() {
        return sE;
    }

    public void setsE(Hex sE) {
        this.sE = sE;
    }

    public Hex getS() {
        return s;
    }

    public void setS(Hex s) {
        this.s = s;
    }

    public Hex getsW() {
        return sW;
    }

    public void setsW(Hex sW) {
        this.sW = sW;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "position=" + position +
                '}';
    }
}
