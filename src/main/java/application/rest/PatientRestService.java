package application.rest;

import application.model.DMP;
import application.model.DonneesSociales;
import application.model.NoeudHopital;
import application.model.Patient;

import javax.ejb.EJB;
import javax.ejb.NoSuchEntityException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/Patient")
public class PatientRestService {

    @EJB
    private application.repository.PatientRepository repository;

    @EJB
    private application.repository.DMPRepository dmprepo;
    @EJB
    private application.repository.NoeudHopitalRepository noeudrepo;
    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatients() {
        List<Patient> Patients = repository.list();
        return Response.ok(Patients).build();
    }

    @GET
    @Path("PatientByID")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientByID(@PathParam("id") Integer id) {
        Patient Patient = repository.find(id);
        if (Patient == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(Patient).build();
    }

    @GET
    @Path("PatientByNom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientByNom(@QueryParam("nom") String nom) {

        List<Patient> toSend = repository.findByDsNom(nom);


        if (toSend == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(toSend).build();
    }

    @GET
    @Path("PatientByNomPrenom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientNomPrenom(@PathParam("nom") String nom,@PathParam("prenom") String prenom) {

        List<Patient> toSend = repository.findByDsNomPrenom(nom,prenom);
        if (toSend == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(toSend).build();
    }

    @GET
    @Path("newPatient")
    @Produces(MediaType.APPLICATION_JSON)

    public Response createPatient(@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,@QueryParam("addresse") String addresse, @QueryParam("genre") String genre, @QueryParam("ss") String SS){

        NoeudHopital noeud = new NoeudHopital();
        DMP dmp = new DMP();

        if(dmp == null || noeud == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        noeudrepo.save(noeud);
        dmprepo.save(dmp);

        DonneesSociales ds = new DonneesSociales(nom,prenom,addresse,genre);
        Patient patient = new Patient(noeud,dmp,ds);
        if(patient == null)
            return Response.status(Response.Status.NOT_FOUND).build();





        repository.save(patient);
        return Response.ok(patient).build();

    }

    @DELETE
    @Path("deletePatient")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePatient(@QueryParam("id") Integer id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
