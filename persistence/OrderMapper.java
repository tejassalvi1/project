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
    return new Orders(rs.getInt("ORD_ID"), OrderStatus.valueOf(rs.getString("ORD_STATUS")),
    rs.getDouble("ORD_PRICE"), rs.getDate("ORD_DAT"), rs.getInt("WAL_ID"), rs.getInt("CUS_ID"), rs.getInt("VEN_ID"));
  }
}
