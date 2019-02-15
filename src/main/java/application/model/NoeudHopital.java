package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.model.NoeudHopital.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT id FROM NoeudHopital id")

public class NoeudHopital {
    public static final String FIND_ALL = "NoeudHopital.findAllNoeudHopital";

    @Id
    @GeneratedValue
    private Integer id;

    public NoeudHopital(){

    }

    public Integer getId(){
        return id;
    }

    @Override
    public String toString() {
        return "NoeudHopital{" +
                "id=" + id +
                '}';
    }
}
