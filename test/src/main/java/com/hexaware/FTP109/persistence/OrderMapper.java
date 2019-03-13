package com.hexaware.FTP109.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.Date;

import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.model.OrderStatus;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrderMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OrderMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Order
       */
    Orders order = new Orders(rs.getDouble("ORD_PRICE"), rs.getInt("WAL_ID"), rs.getInt("CUS_ID"), rs.getInt("VEN_ID"), rs.getString("comments"));
    order.setOrderId(rs.getInt("ORD_ID"));
    order.setOrderStatus(OrderStatus.valueOf(rs.getString("ORD_STATUS")));
    order.setOrderDate(rs.getTimestamp("ORD_DAT"));
    order.setCusName(rs.getString("CUS_NAME"));
    order.setVenName(rs.getString("VEN_NAME"));
    order.setWalName(rs.getString("MOD_PAY"));
    order.setQty(rs.getInt("ORD_QTY"));
    order.setFoodName(rs.getString("FOOD_NAME"));
    return order;
  }
}
