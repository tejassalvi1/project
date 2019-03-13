package com.hexaware.FTP109.factory;
import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.persistence.OrderDAO;
import java.util.List;
import mockit.Mocked;
import mockit.Mock;
import java.util.ArrayList;
import com.hexaware.FTP109.model.OrderStatus;
import mockit.MockUp;
import org.junit.Test;
import mockit.Expectations;
import mockit.Verifications;
import static org.junit.Assert.assertEquals;

/**
 * This is a Class for the MenuFactoryTest.
 */
public final class OrderFactoryTest {
  /**
   * @param dao for DAO Test.
   * Testing the VendorOrderId.
   */
  @Test
  public void testFindbyVendorOrderId(@Mocked final OrderDAO dao) {
    new Expectations() { {
          dao.countVendorOrderId(2, 8); result = 2;
      } };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    int count = OrderFactory.findbyVendorOrderId(2, 8);
    assertEquals(2, count);

    new Verifications() { {
          dao.countVendorOrderId(2, 8); times = 1;
      } };
  }


  /**
   * Testing for GetPrice.
   * @param dao for DAO Test.
   */
  @Test
  public void testgetPrice(@Mocked final OrderDAO dao) {
    new Expectations() { {
          dao.getPrice(241, 451); result = 2;
      } };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    double value = OrderFactory.getPrice(241, 451);
    assertEquals(2, value, 0);

    new Verifications() { {
          dao.getPrice(241, 451); times = 1;
      } };
  }

    /**
     * Testing for Place order.
     * @param dao for DAO Test.
     */
  @Test
  public void testplaceOrder(@Mocked final OrderDAO dao) {
    final Orders orders = new Orders(100.00, 424, 12, 24, "gjsdsj");
    new Expectations() { {
          dao.placeNewOrder(orders); result = 0;
      } };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    int count = OrderFactory.placeOrder(orders).getOrderId();
    assertEquals(0, count);

    new Verifications() { {
          dao.placeNewOrder(orders); times = 1;
      } };
  }
/**
 * Testing for Place Order Items.
 * @param dao for DAO Test.
 */
  @Test
    public void testplaceOrderItems(@Mocked final OrderDAO dao) {
    new Expectations() { {
          dao.placeOrderItems(101, 210, 244d, 2);
        } };
    new MockUp<OrderFactory>() {
        @Mock
        public OrderDAO dao() {
          return dao;
        }
      };
    OrderFactory.placeOrderItems(101, 210, 244.0d, 2);
    new Verifications() { {
            dao.placeOrderItems(101, 210, 244.0d, 2); times = 1;
        } };
  }
      /**
       * Testing for update order status.
       * @param dao for DAO Test.
       */
  @Test
      public void testupdateOrderStatus(@Mocked final OrderDAO dao) {
    new Expectations() { {
            dao.updateOrderStatus(OrderStatus.PENDING, 212, 141, "BJDF");
        } };
    new MockUp<OrderFactory>() {
          @Mock
          public OrderDAO dao() {
            return dao;
          }
        };
    OrderFactory.updateOrderStatus(OrderStatus.PENDING, 212, 141, "BJDF");
    new Verifications() { {
          dao.updateOrderStatus(OrderStatus.PENDING, 212, 141, "BJDF"); times = 1;
      } };
  }
/**
 * Testing for Get Order Price.
 * @param dao for DAO Test.
 */
  @Test
        public void testgetOrderPrice(@Mocked final OrderDAO dao) {
    new Expectations() { {
          dao.getOrderPrice(42, 48); result = 2;
        } };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
            return dao;
      }
      };
    double count = OrderFactory.getOrderPrice(42, 48);
    assertEquals(2, count, 0);

    new Verifications() { {
          dao.getOrderPrice(42, 48); times = 1;
      } };
  }

/**
 * Testing for Get Wallet Id.
 * @param dao for DAO Test.
 */
  @Test
    public void testgetWalletId(@Mocked final OrderDAO dao) {
    new Expectations() { {
        dao.getWalletId(42); result = 2;
      } };
    new MockUp<OrderFactory>() {
      @Mock
       public OrderDAO dao() {
        return dao;
        }
    };
    double count = OrderFactory.getWalletId(42);
    assertEquals(2, count, 0);

    new Verifications() { {
        dao.getWalletId(42); times = 1;
      } };
  }

/**
 * Testing for Show order.
 * @param dao for DAO Test.
 */
  @Test
  public void testShowOrder(@Mocked final OrderDAO dao) {
    final Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
    final Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
    List<Orders> orders = new ArrayList();
    new Expectations() {
      {
        Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
        Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
        List<Orders> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        dao.showOrder(25); result = orders;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    List<Orders> ord1 = OrderFactory.showOrder(25);
    assertEquals(ord1.size(), 2);
    new Verifications() {
      {
        dao.showOrder(25); times = 1;
      }
    };
  }

  /**
   * Testing for Show Order Status List.
   * @param dao for DAO Test.
   */
  @Test
  public void testShowOrderStatus(@Mocked final OrderDAO dao) {
    final Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
    final Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
    List<Orders> orders = new ArrayList();
    new Expectations() {
      {
        Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
        Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
        List<Orders> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        dao.showOrderStatus(25); result = orders;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    List<Orders> ord1 = OrderFactory.showOrderStatus(25);
    assertEquals(ord1.size(), 2);
    new Verifications() {
      {
        dao.showOrderStatus(25); times = 1;
      }
    };
  }
/**
 * Testing for Get order Details list.
 * @param dao for DAO Test.
 */
  @Test
  public void testgetOrderDetails(@Mocked final OrderDAO dao) {
    final Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
    final Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
    List<Orders> orders = new ArrayList();
    new Expectations() {
      {
        Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
        Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
        List<Orders> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        dao.getOrderDetails(14); result = orders;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    List<Orders> ord1 = OrderFactory.getOrderDetails(14);
    assertEquals(ord1.size(), 2);
    new Verifications() {
      {
        dao.getOrderDetails(14); times = 1;
      }
    };
  }
/***
 * Testing for Get Pending order List.
 * @param dao for DAO Test.
 */
  @Test
  public void testgetPendingOrders(@Mocked final OrderDAO dao) {
    final Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
    final Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
    List<Orders> orders = new ArrayList();
    new Expectations() {
      {
        Orders order1 = new Orders(100d, 424, 12, 24, "gjsdsj");
        Orders order2 = new Orders(200d, 414, 14, 21, "sdxdv");
        List<Orders> orders = new ArrayList();
        orders.add(order1);
        orders.add(order2);
        dao.getPendingOrders(24, OrderStatus.PENDING); result = orders;
      }
    };
    new MockUp<OrderFactory>() {
      @Mock
      public OrderDAO dao() {
        return dao;
      }
    };
    final OrderFactory ord = new OrderFactory();
    List<Orders> ord1 = OrderFactory.getPendingOrders(24, OrderStatus.PENDING);
    assertEquals(ord1.size(), 2);
    new Verifications() {
      {
        dao.getPendingOrders(24, OrderStatus.PENDING); times = 1;
      }
    };

  }
}
