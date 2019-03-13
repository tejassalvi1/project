package com.hexaware.FTP109.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.model.OrderStatus;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;


//import com.hexaware.FTP109.model.OrderFactory;
/**
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrderDAO {
  /**
   * @param venId to initialize Vendor Id.
   * @return all the records from object.
   */

  @SqlQuery("SELECT * FROM ORDERS O, Customer C, Vendor V, Wallet W, ORDER_ITEMS OI, Menu M WHERE O.VEN_ID =:venId and O.CUS_ID = C.CUS_ID"
      + " and O.VEN_ID = V.VEN_ID and O.WAL_ID = W.WAL_ID and OI.ORD_IDF = O.ORD_ID and M.FOOD_ID=OI.FOOD_IDF")
    @Mapper(OrderMapper.class)

    List<Orders> showOrder(@Bind("venId")int venId);
/**
 * @param venId to initialize vendor id.
 * @return all matched record.
 */
  @SqlQuery("SELECT * FROM ORDERS O, Customer C, Vendor V, Wallet W, ORDER_ITEMS OI, Menu M WHERE O.VEN_ID = :venId"
      + " and O.CUS_ID = C.CUS_ID and O.VEN_ID = V.VEN_ID and O.WAL_ID = W.WAL_ID and OI.ORD_IDF = O.ORD_ID and M.FOOD_ID=OI.FOOD_IDF")
    @Mapper(OrderMapper.class)
    List<Orders> showOrderStatus(@Bind("venId")int venId);
  /**
   * @param foodId to initialize food Id.
   * @param vendorId to initialize Vendor Id.
   * @return Order price for order id and vendor id
   */
  @SqlQuery("Select FOOD_PRICE from menu_vendor where FOOD_IDF = :foodId and VEN_IDF = :vendorId ")
    double getPrice(@Bind("foodId")int foodId, @Bind("vendorId") int vendorId);
  /**
   * @param newOrder to initialize ord_price, ORD_PRICE, WAL_ID, CUS_ID, VEN_ID, COMMENTS
   * @return Order price for order id and vendor id
   */
  @SqlUpdate("insert into orders (ORD_PRICE, WAL_ID, CUS_ID, VEN_ID, COMMENTS) VALUES (:orderPrice, :walId, :cusId, :venId, :comments)")
     @GetGeneratedKeys
      int placeNewOrder(@BindBean Orders newOrder);
  /**
   * @param foodId to insert in foodId.
   * @param orderId to insert in orderId.
   * @param totalPrice to insert in order price
   * @param qty to insert in quantity.
   */
  @SqlUpdate("insert into order_items (FOOD_IDF, ORD_IDF, ORD_PRICE, ORD_QTY) VALUES (:foodId, :orderId, :totalPrice, :qty)")
      void placeOrderItems(@Bind("foodId")int foodId, @Bind("orderId") int orderId, @Bind("totalPrice") double totalPrice, @Bind("qty") int qty);
  /**
   * @param status to update in status
   * @param vendorId to update in venId.
   * @param orderId to update in orderId.
   * @param comments to update in comments.
   */
  @SqlUpdate("UPDATE ORDERS SET ORD_STATUS = :status, COMMENTS = :comments WHERE ORD_ID = :ordId AND VEN_ID = :venId;")
    void updateOrderStatus(@Bind("status") OrderStatus status, @Bind("venId") int vendorId,
      @Bind("ordId") int orderId, @Bind("comments") String comments);
  /**
   * @param vendorId to initialise in venId.
   * @param orderId to initialise in orderId.
   * @return the orderPrice.
   */
  @SqlQuery("Select ORD_PRICE from orders where ORD_ID = :orderId and VEN_ID = :vendorId ")
    double getOrderPrice(@Bind("vendorId")int vendorId, @Bind("orderId") int orderId);
  /**
   * @param orderId to initialise in orderId.
   * @return the wallet Id.
   */
  @SqlQuery("Select WAL_ID from orders where ORD_ID = :orderId")
    int getWalletId(@Bind("orderId") int orderId);
  /**
   *
   * @param custId to initialize the customer id.
   * @return the list of orders.
   */
  @SqlQuery("Select * from Orders O, Customer C, Vendor V, Wallet W, ORDER_ITEMS OI,MENU M where O.CUS_ID = C.CUS_ID "
      + " and O.VEN_ID = V.VEN_ID and O.WAL_ID = W.WAL_ID and OI.ORD_IDF = O.ORD_ID and M.FOOD_ID = OI.FOOD_IDF and O.CUS_ID = :custId")
     @Mapper(OrderMapper.class)
    List<Orders> getOrderDetails(@Bind("custId") int custId);

    /**
   *
   * @param vendorId to initialize the customer id.
   * @param status to initialize the status.
   * @return the list of orders.
   */
  @SqlQuery("select * from Orders O, Customer C, Vendor V, Wallet W, ORDER_ITEMS OI, Menu M where O.VEN_ID = :vendorId and "
      + " ord_status = :status and O.CUS_ID = C.CUS_ID and O.VEN_ID = V.VEN_ID and O.WAL_ID = W.WAL_ID and OI.ORD_IDF = O.ORD_ID "
      + " and M.FOOD_ID=OI.FOOD_IDF")
  @Mapper(OrderMapper.class)
 List<Orders> getPendingOrders(@Bind("vendorId") int vendorId, @Bind("status") OrderStatus status);
  /**
   * @param vendorId to initialise in venId.
   * @param orderId to initialise in orderId.
   * @return the count of vendorOrderId
   */
  @SqlQuery("select count(ORD_ID) from Orders where VEN_Id = :vendorId and  ORD_ID = :orderId")
    int countVendorOrderId(@Bind("vendorId")int vendorId, @Bind("orderId") int orderId);

  /**
   *
   * @param orderId to initialize the customer id.
   * @return the list of orders.
   */
  @SqlQuery("select * from Orders O, Customer C, Vendor V, Wallet W, ORDER_ITEMS OI, Menu M where O.ORD_ID = :orderId and O.CUS_ID = C.CUS_ID"
      + " and O.VEN_ID = V.VEN_ID and O.WAL_ID = W.WAL_ID and OI.ORD_IDF = O.ORD_ID and M.FOOD_ID=OI.FOOD_IDF")
     @Mapper(OrderMapper.class)
    List<Orders> getOrderAllDetails(@Bind("orderId") int orderId);

}
