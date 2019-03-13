package com.hexaware.FTP109.factory;

import com.hexaware.FTP109.persistence.CustomerDAO;
import com.hexaware.FTP109.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP109.model.Customer;
/**
 * CustomerFactory class used to fetch customer data from database.
 * @author hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @param custId to initialize the customer id.
   * @return the array of customer object.
   */
  public static List<Customer> showCustomer(final int custId) {
    List<Customer> customer = dao().show(custId);
    return customer;
  }
  /**
   *
   * @param custId to initialize customer id.
   * @param password to initialize the customer password.
   */
  public static void showCusId(final int custId, final String password) {
    Validators.validateCustomerId(custId, password);
  }
  /**
   * Call the data base connection.
   * @param custId to initialize customer id.
   * @param password to initialize the customer password.
   * @return the size of the customers
   */
  public static int findByCustomerId(final int custId, final String password) {
    int count = dao().countCustId(custId, password);
    return count;
  }

  /**
   * Call the data base connection.
   * @param custId to initialize the customer id.
   */
  public static void findByCustRest(final int custId) {
    int count = dao().countCusRest(custId);
    Validators.validateCustRest(count);
  }

/**
   * @param cusName to initialize customer name.
   * @param cusMob to initialize customer mobile.
   * @param cusPas to initialize customer password.
   */
  public static void insertNewCustomer(final Customer customer) {
    dao().insertNewCustomer(customer);
  }
}
