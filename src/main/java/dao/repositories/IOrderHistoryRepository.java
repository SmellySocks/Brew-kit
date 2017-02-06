package dao.repositories;

import java.util.Date;
import java.util.List;

import domain.model.Beer;
import domain.model.OrderHistory;
import domain.model.Brewery;

public interface IOrderHistoryRepository extends IRepository<OrderHistory>{

	public List<OrderHistory> fromName(String beerName);
	public List<OrderHistory> ofBrewery(String brewery);
	public List<OrderHistory> withDate(Date ofPurchase);

}
