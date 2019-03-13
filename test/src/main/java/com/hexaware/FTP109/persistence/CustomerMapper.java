package com.hexaware.FTP109.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP109.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * CustomerMapper class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    int cusId = rs.getInt("CUS_ID");
    String cusName = rs.getString("CUS_NAME");
    String cusMob = rs.getString("CUS_MOB");
    String cusPas = rs.getString("CUS_PAS");
    Customer customer =  new Customer(cusId, cusName, cusMob, cusPas);
    customer.setCusTotalBalance(rs.getDouble("TOTAL_BALANCE"));
    return customer;
  }
}
