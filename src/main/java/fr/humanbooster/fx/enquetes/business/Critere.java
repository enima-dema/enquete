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

    public Critere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuotat() {
        return quotat;
    }

    public void setQuotat(int quotat) {
        this.quotat = quotat;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Fait getFait() {
        return fait;
    }

    public void setFait(Fait fait) {
        this.fait = fait;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    @Override
    public String toString() {
        return "Critere{" +
                "id=" + id +
                ", quotat=" + quotat +
                ", departement=" + departement +
                ", fait=" + fait +
                ", enquete=" + enquete +
                '}';
    }
}
