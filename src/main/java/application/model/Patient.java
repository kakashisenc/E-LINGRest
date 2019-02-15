package application.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static application.model.Patient.FIND_ALL;


@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Patient b")
public class Patient {

    public static final String FIND_ALL = "Patients.findAllPatients";

    @Id @GeneratedValue
    private Integer id;
    private NoeudHopital noeudHopital;

    private DMP dmp;
    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn

    private DonneesSociales donneesSociales;

    public Patient(){

    }

    public Patient(NoeudHopital noeudHopital, DMP dmp,DonneesSociales donneesSocialesi) {
        this.noeudHopital = noeudHopital;
        this.dmp = dmp;
        donneesSociales = donneesSocialesi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NoeudHopital getNoeudHopital() {
        return noeudHopital;
    }

    public void setNoeudHopital(NoeudHopital noeudHopital) {
        this.noeudHopital = noeudHopital;
    }

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public DonneesSociales getDonneesSociales() {
        return donneesSociales;
    }

    public void setDonneesSociales(DonneesSociales donneesSociales) {
        this.donneesSociales = donneesSociales;
    }

    /*
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", noeudHopital=" + noeudHopital +
                ", dmp=" + dmp +
                ", donneesSociales=" + donneesSociales +
                '}';
    }*/
}
