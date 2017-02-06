package dao;

import dao.mappers.OrderHistoryMapper;
import dao.mappers.ClientMapper;
import dao.mappers.BeerMapper;
import dao.repositories.*;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryCatalog implements IRepositoryCatalog {

    private IUnitOfWork uow;
    private Connection connection;

    private OrderHistoryRepository historyRepo;
    private ClientRepository personRepo;
    private BeerRepository beerRepo;

    public RepositoryCatalog(Connection connection,IUnitOfWork uow)
    {
        this.connection = connection;
        this.uow = uow;
    }
    
    public IClientRepository People() {
        if (personRepo == null) {
            personRepo = new ClientRepository(connection, new ClientMapper(), uow);
        }
        return personRepo;
    }


    public IOrderHistoryRepository BeerHistory() {
        if (historyRepo == null) {
            historyRepo = new OrderHistoryRepository(connection, new OrderHistoryMapper(), uow);
        }
        return historyRepo;
    }

    public IBeerRepository Beers() {
        if (beerRepo == null) {
            beerRepo = new BeerRepository(connection, new BeerMapper(), uow);
        }
        return beerRepo;
    }

    public void saveAndClose() {
        uow.saveChanges();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getNewConnection(String connectionString) throws SQLException {

        return DriverManager.getConnection(connectionString);
    }

    private IUnitOfWork getNewUow() {
        return new UnitOfWork(connection);
    }

    private void setUow(IUnitOfWork uow) {
        this.uow = uow;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

	public void save() {
        uow.saveChanges();
		
	}

}
