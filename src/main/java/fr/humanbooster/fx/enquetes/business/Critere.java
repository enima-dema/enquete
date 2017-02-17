package fr.humanbooster.fx.enquetes.business;

import javax.persistence.*;

/**
 * Created by Human Booster on 17/02/2017.
 */
@Entity
public class Critere {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int quotat;
    @ManyToOne
    Departement departement;
    @ManyToOne
    Fait fait;
    @ManyToOne
    Enquete enquete;


}
