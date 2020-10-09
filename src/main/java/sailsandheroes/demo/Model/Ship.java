package sailsandheroes.demo.Model;

import java.awt.*;
import java.util.List;

public class Ship {

    private Integer id;
    private String name;
    private Point position;
    private double hullQuality;
    private Integer amountOfGuns;
    private Integer gunsPerRow;
    private Integer amountOfSailors;
    private double sailQuality;
    private Integer speed;
    private String direction;
    private String nationality;
    private int powerValue;
    private String ammunition;
    private List<Point> path;

    public Ship() {
    }

    public Ship(Integer id, String name, Point position, Double hullQuality, Integer amountOfGuns, Integer gunsPerRow, Integer amountOfSailors, Double sailQuality, Integer speed, String direction, String nationality, String ammunition) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hullQuality = hullQuality;
        this.amountOfGuns = amountOfGuns;
        this.gunsPerRow = gunsPerRow;
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

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
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

    public List<Point> getPath() {
        return path;
    }

    public void setPath(List<Point> path) {
        this.path = path;
    }

    public Integer getGunsPerRow() {
        return gunsPerRow;
    }

    public void setGunsPerRow(Integer gunsPerRow) {
        this.gunsPerRow = gunsPerRow;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", hullQuality=" + hullQuality +
                ", amountOfGuns=" + amountOfGuns +
                ", gunsPerRow=" + gunsPerRow +
                ", amountOfSailors=" + amountOfSailors +
                ", sailQuality=" + sailQuality +
                ", speed=" + speed +
                ", direction='" + direction + '\'' +
                ", nationality='" + nationality + '\'' +
                ", powerValue=" + powerValue +
                ", ammunition='" + ammunition + '\'' +
                '}';
    }
}
