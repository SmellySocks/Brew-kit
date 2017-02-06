package dao.repositories;

public interface IRepositoryCatalog {

	IClientRepository People();
	IOrderHistoryRepository BeerHistory();
	IBeerRepository Beers();
	void saveAndClose();
	void save();
}
