package dao.repositories;

import java.util.List;

import domain.model.Client;

public interface IClientRepository extends IRepository<Client> {

	public List<Client> withName(String name);
	public List<Client> withSurname(String surname);

}
