package fr.humanbooster.fx.enquetes.business;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Human Booster on 17/02/2017.
 */
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String nom;
    String code;

    @OneToMany(mappedBy = "departement")
    List<Critere> criteres;
}
