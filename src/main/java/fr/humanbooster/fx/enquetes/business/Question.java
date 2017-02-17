package fr.humanbooster.fx.enquetes.business;

import javax.persistence.*;

/**
 * Created by Human Booster on 17/02/2017.
 */
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String nom;
    @ManyToOne
    Enquete enquete;
}
