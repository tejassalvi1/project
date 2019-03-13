package com.hexaware.FTP109.persistence;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.sql.ResultSet;
import mockit.Mocked;
import mockit.Verifications;
import mockit.Expectations;
import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.model.OrderStatus;
   /**
   *OrderMapperTest is used for testing OrderMapper.
   */
public class OrderMapperTest {

   /**
   *@param resultSet for mock object.
   *@throws Exception used for mock resultset.
   */
  @Test
   public final void mapTest(@Mocked final ResultSet resultSet) throws Exception {

    new Expectations() { {
        resultSet.getDouble("ORD_PRICE"); result = 150;
        resultSet.getInt("WAL_ID"); result = 20;
        resultSet.getInt("CUS_ID"); result = 10;
        resultSet.getInt("VEN_ID"); result = 30;
        resultSet.getString("comments"); result = "this is to test comments";
        resultSet.getInt("ORD_ID"); result = 40;
        resultSet.getString("ORD_STATUS"); result = "REJECTED";
      } };

    OrderMapper orderMapper = new OrderMapper();
    Orders order = orderMapper.map(0, resultSet, null);
    assertEquals(40, order.getOrderId());
    assertNotEquals(78, order.getOrderId());

    assertEquals(OrderStatus.REJECTED, order.getOrderStatus());
    assertNotEquals(OrderStatus.ACCEPTED, order.getOrderStatus());

    assertEquals(150, order.getOrderPrice(), 0);
    assertNotEquals(160, order.getOrderPrice(), 0);

    assertEquals(20, order.getWalId());
    assertNotEquals(80, order.getWalId());

    assertEquals(10, order.getCusId());
    assertNotEquals(100, order.getCusId());

    assertEquals(30, order.getVenId());
    assertNotEquals(90, order.getVenId());

    assertEquals("this is to test comments", order.getComments());
    assertNotEquals("this is to test", order.getComments());
    new Verifications() {
      {
        resultSet.getInt("WAL_ID"); times = 1;
        resultSet.getString("comments"); times = 1;
        resultSet.getString("ORD_STATUS"); times = 1;
        resultSet.getInt("CUS_ID"); times = 1;
        resultSet.getInt("VEN_ID"); times = 1;
        resultSet.getDouble("ORD_PRICE"); times = 1;
        resultSet.getInt("ORD_ID"); times = 1;
        }
    };

  }


}
