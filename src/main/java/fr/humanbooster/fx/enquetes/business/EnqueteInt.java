package fr.humanbooster.fx.enquetes.business;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Human Booster on 17/02/2017.
 */
@Entity
public class EnqueteInt extends Enquete {
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<SiteInt> sites;

    public EnqueteInt() {
    }

    public List<SiteInt> getSites() {
        return sites;
    }

    public void setSites(List<SiteInt> sites) {
        this.sites = sites;
    }
}
