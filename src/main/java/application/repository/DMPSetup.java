package application.repository;

import application.model.DMP;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class DMPSetup {

  @EJB
  private DMPRepository repository;


}
