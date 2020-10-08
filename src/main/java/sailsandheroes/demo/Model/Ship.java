package sailsandheroes.demo.Model;


import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name="SHIPS")
public class Ship {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="position")
    private String position;
    @Column(name="hullQuality")
    private double hullQuality;
    @Column(name="amountOfGunRows")
    private Integer amountOfGuns;
    @Column(name="amountOfSailors")
    private Integer amountOfSailors;
    @Column(name="sailQuality")
    private double sailQuality;
    @Column(name="speed")
    private Integer speed;
    @Column(name="direction")
    private String direction;
    @Column(name="nationality")
    private String nationality;
    @Column(name="powerValue")
    private int powerValue;
    @Column(name="ammunition")
    private String ammunition;

    private Point startPos; //TODO skal dette ind i constructor
    @ElementCollection
    private List<Point> path;

    public Ship() {
    }

    public Ship(Integer id, String name, String position, Double hullQuality, Integer amountOfGuns, Integer amountOfSailors, Double sailQuality, Integer speed, String direction, String nationality, String ammunition) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hullQuality = hullQuality;
        this.amountOfGuns = amountOfGuns;
        this.amountOfSailors = amountOfSailors;
        this.sailQuality = sailQuality;
        this.speed = speed;
        this.direction = direction;
        this.nationality = nationality;
        this.ammunition = ammunition;
    }
// Lavet af William
    public void calculatePowerValue(){
        int guns = amountOfGuns / 2;
        int sailorPrGun = amountOfSailors/3;
        if(guns < sailorPrGun){
            powerValue = guns;
        }else if(guns > sailorPrGun){
            powerValue = sailorPrGun;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getHullQuality() {
        return hullQuality;
    }

    public void setHullQuality(double hullQuality) {
        this.hullQuality = hullQuality;
    }

    public Integer getAmountOfGuns() {
        return amountOfGuns;
    }

    public void setAmountOfGuns(Integer amountOfGuns) {
        this.amountOfGuns = amountOfGuns;
    }

    public Integer getAmountOfSailors() {
        return amountOfSailors;
    }

    public void setAmountOfSailors(Integer amountOfSailors) {
        this.amountOfSailors = amountOfSailors;
    }

    public double getSailQuality() {
        return sailQuality;
    }

    public void setSailQuality(double sailQuality) {
        this.sailQuality = sailQuality;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(int powerValue) {
        this.powerValue = powerValue;
    }

    public String getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(String ammunition) {
        this.ammunition = ammunition;
    }

    public Point getStartPos() {
        return startPos;
    }

    public void setStartPos(Point startPos) {
        this.startPos = startPos;
    }

    public List<Point> getPath() {
        return path;
    }

    public void setPath(List<Point> path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", hullQuality=" + hullQuality +
                ", amountOfGunRows=" + amountOfGuns +
                ", amountOfSailors=" + amountOfSailors +
                ", sailQuality=" + sailQuality +
                ", speed=" + speed +
                ", direction='" + direction + '\'' +
                ", nationality='" + nationality + '\'' +
                ", startPos=" + startPos +
                '}';
    }
}
