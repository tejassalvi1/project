package com.hexaware.FTP109.factory;
import com.hexaware.FTP109.persistence.OrderDAO;
import com.hexaware.FTP109.persistence.DbConnection;
import com.hexaware.FTP109.model.Orders;
import java.util.List;
import com.hexaware.FTP109.model.OrderStatus;
//import com.hexaware.FTP109.util.Validators;

/**
 * MenuFactory class used to fetch Order data from database.
 * @author hexware
 */
public class OrderFactory {
  /**
   *  Protected constructor.
   */
  protected OrderFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }
  /**
   * Call the data base connection.
   * @param venId  to initialize Vendor Id.
   * @return List of Orders.
   */
  public static List<Orders> showOrder(final int venId) {
    List<Orders> orders = dao().showOrder(venId);
    return orders;
  }
  /**
   * Call the data base connection.
   * @param venId to initialize Vendor Id.
   * @return List of orders
   */
  public static List<Orders> showOrderStatus(final int venId) {
    List<Orders> orders = dao().showOrderStatus(venId);
    return orders;
  }
  /**
   * Call the data base connection.
   * @param foodId initialize Food Id.
   * @param vendorId initialize Vendor Id.
   * @return price for that particular foodId and vendorId
   */
  public static double getPrice(final int foodId, final int vendorId) {
    double price = dao().getPrice(foodId, vendorId);
    return price;
  }
  /**
   *
   * @param newOrder to initialize the new order
   * @return the order id.
   */
  public static int placeOrder(final Orders newOrder) {
    int orderId = dao().placeNewOrder(newOrder);
    return orderId;
  }
  /**
   * Call the data base connection.
   * @param foodId to initialize the food id.
   * @param orderId to initialize the order id.
   * @param totalPrice to initialize the total price.
   * @param qty to initialize the quantity.
   */
  public static void placeOrderItems(final int foodId, final int orderId, final double totalPrice, final int qty) {
    dao().placeOrderItems(foodId, orderId, totalPrice, qty);
  }
  /**
   * Call the data base connection.
   * @param status to initialize the status.
   * @param venId to initialize the vendor id.
   * @param ordId to initialize the order id.
   * @param comments to initialize the comments.
   */
  public static void updateOrderStatus(final OrderStatus status, final int venId, final int ordId, final String comments) {
    System.out.println("Order status :: " + status);
    System.out.println("vendorid :: " + venId);
    System.out.println("order id :: " + ordId);
    System.out.println("comments :: " + comments);
    dao().updateOrderStatus(status, venId, ordId, comments);
  }
  /**
   * Call the data base connection.
   * @param vendorId to initialize Vendor id.
   * @param orderId to initialize Order id.
   * @return OrderPrice for that VendorId and OrderId
   */
  public static double getOrderPrice(final int vendorId, final int orderId) {
    double orderPrice = dao().getOrderPrice(vendorId, orderId);
    return orderPrice;
  }
  /**
   * Call the data base connection.
   * @param orderId to initialize order id.
   * @return walletId
   */
  public static int getWalletId(final int orderId) {
    int walletId = dao().getWalletId(orderId);
    return walletId;
  }
  /**
   * Call the data base connection.
   * @param custId to initialize customer id.
   * @return list of orders.
   */
  public static List<Orders> getOrderDetails(final int custId) {
    List<Orders> orders = dao().getOrderDetails(custId);
    return orders;
  }
  /**
   * Call the data base connection.
   * @param vendorId to initialize vendor id.
   * @param status to initialize status.
   * @return list of orders.
   */
  public static List<Orders> getPendingOrders(final int vendorId, final OrderStatus status) {
    List<Orders> orders = dao().getPendingOrders(vendorId, status);
    return orders;
  }
  /**
   * Call the data base connection.
   * @param vendorId to initialize VendorId.
   * @param orderId to initialize OrderId
   * @return count if both VendorId and OrderId is Present.
   */
  public static int findbyVendorOrderId(final int vendorId, final int orderId) {
    int count = dao().countVendorOrderId(vendorId, orderId);
    return count;
  }
}
