package rest;

import domain.model.OrderHistory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.HistoryDto;

import java.util.ArrayList;
import java.util.List;

@Path("/history")
@Stateless
public class HistoryResources {

	Mapper mapper = new DozerBeanMapper();
    @PersistenceContext
    EntityManager entityManager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<HistoryDto> result = new ArrayList<HistoryDto>();
        System.out.println("zaczynam pobierac dane");
    	for(OrderHistory h: entityManager.createNamedQuery("history.all",OrderHistory.class).getResultList()){
        	result.add(mapper.map(h, HistoryDto.class));
        }
        System.out.println("koncze");
        return Response.ok(new GenericEntity<List<HistoryDto>>(result){}).build();
    }
    
}
