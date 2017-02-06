package rest;

import domain.model.Beer;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.BeerDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/beers")
@Stateless
public class BeerResources {

    private Mapper mapper = new DozerBeanMapper();
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BeerDto> getAll(){
        List<BeerDto> result = new ArrayList<BeerDto>();
        System.out.println("pobieram dane");
        for(Beer t: entityManager.createNamedQuery("beers.all", Beer.class).getResultList()){
            result.add(mapper.map(t, BeerDto.class));
        }
        System.out.println("done");
        return result;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Beer result = entityManager.createNamedQuery("beers.id", Beer.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        BeerDto result2 = mapper.map(result, BeerDto.class);
        return Response.ok(result2).build();
    }
}
