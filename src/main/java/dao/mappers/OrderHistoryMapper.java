package dao.mappers;

import domain.model.OrderHistory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by L on 16.11.2016.
 */
public class OrderHistoryMapper implements IMapResultSetIntoEntity<OrderHistory> {
    public OrderHistory map(ResultSet rs) throws SQLException {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setId(rs.getInt("id"));
        orderHistory.setDate(rs.getDate("date"));
        orderHistory.setAmount(rs.getDouble("amount"));

        return orderHistory;
    }
}
