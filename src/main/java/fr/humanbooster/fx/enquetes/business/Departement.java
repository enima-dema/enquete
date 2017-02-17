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

    public Departement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Critere> getCriteres() {
        return criteres;
    }

    public void setCriteres(List<Critere> criteres) {
        this.criteres = criteres;
    }
}
