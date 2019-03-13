package com.hexaware.FTP109.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
/**
 * Test class for Orders.
 */
public class OrdersTest {

  private Orders order1;
  private Orders order2;
  private Orders order3;
  /**
  * SetUp Method.
  */
  @Before
  public final void setUp() {
    order1 = new Orders(200d, 5, 101, 201, "AVB");
    order2 = new Orders(200d, 5, 101, 201, "AVB");
    order3 = new Orders(200d, 5, 101, 201, "AVB");
  }
/**
  * Checking constructor.
  */
  @Test
  public final void testOrdersConstructor() {
    assertEquals(200d, order1.getOrderPrice(), 0);
    assertEquals(5, order1.getWalId());
    assertEquals(101, order1.getCusId());
    assertEquals(201, order1.getVenId());
    assertEquals("AVB", order1.getComments());
  }
/**
  * Tests the Order Price.
  */
  @Test
  public final void testSetOrderPrice() {
    assertEquals(200d, order1.getOrderPrice(), 0);
    order1.setOrderPrice(50.5d);
    assertNotEquals(200d, order1.getOrderPrice(), 0);
    assertEquals(50.5d, order1.getOrderPrice(), 0);
  }
/**
  * Tests the Wallet Id.
  */
  @Test
  public final void testWalletId() {
    assertEquals(5, order1.getWalId());
    order1.setWalId(100);
    assertNotEquals(5, order1.getWalId());
    assertEquals(100, order1.getWalId());
  }
/**
  * Tests the Customer Id.
  */
  @Test
  public final void testCustomerId() {
    assertEquals(101, order1.getCusId());
    order1.setCusId(202);
    assertNotEquals(101, order1.getCusId());
    assertEquals(202, order1.getCusId());
  }
/**
  * Tests the Vendor Id.
  */
  @Test
  public final void testVendorId() {
    assertEquals(201, order1.getVenId());
    order1.setVenId(300);
    assertNotEquals(201, order1.getVenId());
    assertEquals(300, order1.getVenId());
  }

/**
  * Tests the Comments.
  */
  @Test
  public final void testComments() {
    order1.setComments("NICE FOOD");
    assertEquals("NICE FOOD", order1.getComments());
  }

/**
  * Tests the Order Id.
  */
  @Test
  public final void testOrderId() {
    order1.setOrderId(1);
    assertEquals(1, order1.getOrderId());
    assertNotEquals(2, order1.getOrderId());
  }

/**
  * Tests the Order Status.
  */
  @Test
  public final void testOrderStatus() {
    order1.setOrderStatus(OrderStatus.PENDING);
    assertEquals(OrderStatus.PENDING, order1.getOrderStatus());
    assertNotEquals(OrderStatus.ACCEPTED, order1.getOrderStatus());
  }

/**
  * Checking HashCode method.
  */
  @Test
  public final void testHashCode() {
    assertTrue(order2.hashCode() == order3.hashCode());
    order2.setVenId(300);
    assertFalse(order2.hashCode() == order3.hashCode());
  }

/**
  * Checking Equals method.
  */
  @Test
  public final void testEqualMethod() {
    assertTrue(order2.equals(order3) && order3.equals(order2));
    order2.setVenId(300);
    assertFalse(order2.equals(order3) && order3.equals(order2));
  }
/**
  * Checking Date method.
  */
  @Test
  public final void testDateMethod() {
    order1.setOrderDate(new Date(05, 10, 17));
    assertEquals(new Date(05, 10, 17), order1.getOrderDate());
    assertNotEquals(new Date(20, 02, 18), order1.getOrderDate());
  }
/**
  * Checking EmptyObject in Equals method.
  */
  @Test
  public final void testEmptyObject() {
    assertFalse(order2.equals(null));
  }

/**
  * Checking EmptyConstructor.
  */
  @Test
  public final void testEmptyConstructor() {
    Orders order4 = new Orders();
    assertNotNull(order4);
  }

/**
  * Checking getClass in Equals method.
  */
  @Test
  public final void testGetClassEquals() {
    Customer customer = new Customer(1, "Pooja", "12345678", "poo123");
    assertFalse(order2.equals(customer) && customer.equals(order2));
  }
}
