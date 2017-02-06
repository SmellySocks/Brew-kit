package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Client;

public class ClientMapper implements IMapResultSetIntoEntity<Client>{

	public Client map(ResultSet rs) throws SQLException {
		Client client = new Client();
		client.setId(rs.getInt("id"));
		client.setName(rs.getString("name"));
		client.setSurname(rs.getString("surname"));
		return client;
	}

}
