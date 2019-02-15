package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.List;

import static application.model.ConstantesVitales.FIND_ALL;

@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT id FROM ConstantesVitales id")

public class ConstantesVitales {

    private DMP dmp;
    private Date date;
    private List<Integer> constances;
    @Id
    @GeneratedValue
    private Integer id;
    public static final String FIND_ALL = "ConstantesVitales.findAllConstantesVitales";

    public ConstantesVitales(DMP dmpi,Date datei,List<Integer> constancesi){

        dmp = dmpi;
        date = datei;
        constances = constancesi;



    }
    public ConstantesVitales(){

    }
    public Integer getId(){
        return id;
    }

}
