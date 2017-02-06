package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RepositoryCatalog;
import dao.repositories.IRepositoryCatalog;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;
import domain.model.Beer;
import domain.model.Brewery;
import domain.model.Client;


@WebServlet("/dbServlet")
public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DbServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
			IUnitOfWork uow = new UnitOfWork(connection);
			IRepositoryCatalog catalog = new RepositoryCatalog(connection, uow);
			HttpSession session = request.getSession();
			Client client = (Client) session.getAttribute("people");
			Beer beer = (Beer) session.getAttribute("beers");
			catalog.People().add(client);
			catalog.save();
			int personId = catalog.People().getLastId();
			client.setId(personId);
			catalog.Beers().add(beer);
			catalog.save();
			session.removeAttribute("people");
			session.removeAttribute("beers");
			response.sendRedirect("index.html");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	

	

}
