package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Beer;

public class BeerMapper implements IMapResultSetIntoEntity<Beer>{

	public Beer map(ResultSet rs) throws SQLException {
		Beer beer = new Beer();
		beer.setId(rs.getInt("id"));
		beer.setName(rs.getString("name"));
		return beer;
	}

}
