package dao.repositories;

import java.util.List;

import domain.model.Beer;
import domain.model.Client;

public interface IBeerRepository extends IRepository<Beer>{

	public List<Beer> byPerson(Client client);
}
