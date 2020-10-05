package sailsandheroes.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="SHIPS")
public class Ship {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;

    //default contructor upcoming

    //Getter and setter upcoming

}
