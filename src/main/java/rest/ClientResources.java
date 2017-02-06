package rest;

import domain.model.Client;
import domain.model.Beer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.PersonDto;
import rest.dto.BeerDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 18.01.2017.
 */
@Path("/people")
@Stateless
public class ClientResources {

	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<PersonDto> result = new ArrayList<PersonDto>();
        System.out.println("zaczynam pobierac dane");
    	for(Client p: entityManager.createNamedQuery("person.all",Client.class).getResultList()){
        	result.add(mapper.map(p, PersonDto.class));
        }
    	
        System.out.println("koncze");
        return Response.ok(new GenericEntity<List<PersonDto>>(result){}).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/accounts") 
    public Response getClient(@PathParam("id") int personId){
    	Client p = entityManager.createNamedQuery("person.id", Client.class)
    			.setParameter("id", personId)
    			.getSingleResult();
    	if(p==null)
    		return Response.status(Status.NOT_FOUND).build();
    	List<BeerDto> results = new ArrayList<BeerDto>();
    	for(Beer w: p.getBeers()){
    		results.add(mapper.map(w, BeerDto.class));
    	}
    	return Response.ok(new GenericEntity<List<BeerDto>>(results){}).build();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Client client) {
        entityManager.persist(client);
        return Response.ok(client.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Client p) {
        Client result = entityManager.createNamedQuery("person.id", Client.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        p.setName(p.getName());
        p.setSurname(p.getSurname());
        entityManager.persist(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Client result = entityManager.createNamedQuery("person.id", Client.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Client result = entityManager.createNamedQuery("person.id", Client.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }
}
