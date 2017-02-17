package fr.humanbooster.fx.enquetes.business;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Human Booster on 17/02/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Enquete {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String nom;
    float prix;
    Date date;
    @OneToMany(mappedBy = "enquete")
    List<Question> questions;
    @OneToMany(mappedBy="enquete")
    List<Critere> criteres;

}
