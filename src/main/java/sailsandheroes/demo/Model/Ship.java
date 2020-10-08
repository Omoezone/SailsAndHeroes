package sailsandheroes.demo.Model;


import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
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
    private Integer hullQuality;
    @Column(name="amountOfGunRows")
    private Integer amountOfGunRows;
    @Column(name="amountOfSailors")
    private Integer amountOfSailors;
    @Column(name="sailQuality")
    private Integer sailQuality;
    @Column(name="speed")
    private Integer speed;
    @Column(name="direction")
    private String direction;
    @Column(name="nationality")
    private String nationality;

    private Point startPos;

   @ElementCollection
    private List<Point> PointList;

    public List getPointList() {
        return PointList;
    }

    public void setPointList(List pointList) {
        PointList = pointList;
    }

    public Point getStartPos() {
        return startPos;
    }

    public void setStartPos(Point startPos) {
        this.startPos = startPos;
    }

    public Ship() {
    }




    public Ship(Integer id, String name, String position, Integer hullQuality, Integer amountOfGunRows, Integer amountOfSailors, Integer sailQuality, Integer speed, String direction, String nationality) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hullQuality = hullQuality;
        this.amountOfGunRows = amountOfGunRows;
        this.amountOfSailors = amountOfSailors;
        this.sailQuality = sailQuality;
        this.speed = speed;
        this.direction = direction;
        this.nationality = nationality;
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

    public Integer getHullQuality() {
        return hullQuality;
    }

    public void setHullQuality(Integer hullQuality) {
        this.hullQuality = hullQuality;
    }

    public Integer getAmountOfGunRows() {
        return amountOfGunRows;
    }

    public void setAmountOfGunRows(Integer amountOfGunRows) {
        this.amountOfGunRows = amountOfGunRows;
    }

    public Integer getAmountOfSailors() {
        return amountOfSailors;
    }

    public void setAmountOfSailors(Integer amountOfSailors) {
        this.amountOfSailors = amountOfSailors;
    }

    public Integer getSailQuality() {
        return sailQuality;
    }

    public void setSailQuality(Integer sailQuality) {
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

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", hullQuality=" + hullQuality +
                ", amountOfGunRows=" + amountOfGunRows +
                ", amountOfSailors=" + amountOfSailors +
                ", sailQuality=" + sailQuality +
                ", speed=" + speed +
                ", direction='" + direction + '\'' +
                ", nationality='" + nationality + '\'' +
                ", startPos=" + startPos +
                '}';
    }
}
