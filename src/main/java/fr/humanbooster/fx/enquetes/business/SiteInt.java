package fr.humanbooster.fx.enquetes.business;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Human Booster on 17/02/2017.
 */
@Entity
public class SiteInt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String nom;
    String url;

    @ManyToMany(mappedBy="sites", fetch = FetchType.EAGER)
    List<EnqueteInt> enqueteInts;

    public SiteInt() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<EnqueteInt> getEnqueteInts() {
        return enqueteInts;
    }

    public void setEnqueteInts(List<EnqueteInt> enqueteInts) {
        this.enqueteInts = enqueteInts;
    }
}
