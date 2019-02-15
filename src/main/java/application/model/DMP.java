package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import static application.model.DMP.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT id FROM DMP id")

public class DMP {
    public static final String FIND_ALL = "DMP.findAllDMP";

    @Id
    @GeneratedValue
    private Integer id;
    private String ss;

    public DMP(){

    }

    public DMP(String ss){
        this.ss = ss;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "DMP{" +
                "id=" + id +
                ", ss='" + ss + '\'' +
                '}';
    }
}
