package application.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static application.model.DonneesSociales.FIND_ALL;


@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT id FROM DonneesSociales id")
public class DonneesSociales {

    public static final String FIND_ALL = "DonneesSociales.findAllDonneesSociales";

    @Id
    @GeneratedValue
    @NotNull
    private Integer id;
    private String nom;
    private String prenom;
    private String addresse;
    private String genre;



    public DonneesSociales(){

    }

    public DonneesSociales(String nom, String prenom, String addresse,String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
        this.genre =genre;
    }

    public Integer getId() {
        return id;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "DonneesSociales{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adressse='" + addresse + '\'' +
                '}';
    }
}
