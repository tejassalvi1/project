package com.hexaware.FTP109.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
//import com.hexaware.FTP109.model.Customer;
   /**
   *for objects.
   */
public class CustomerTest {

  private Customer h1;
  private Customer h2;
  private Customer customer;
   /**
   *for setup.
   */
  @Before
    public final void setUp() {
    customer = new Customer(100, "praisy", "897456321", "pra123");
    h1 = new Customer(100, "praisy", "897456321", "pra123");
    h2 = new Customer(100, "praisy", "897456321", "pra123");
  }

  /**
   *for testing.
   */
  @Test
    public final void testSetupCustomer() {
    assertEquals(100, customer.getCusId());
    assertEquals("praisy", customer.getCusName());
    assertEquals("897456321", customer.getCusMob());
    assertEquals("pra123", customer.getCusPas());
  }

  /**
   *for testing.
   */
  @Test
    public final void testNonParamCustomer() {
    customer = new Customer();
    int cusId = 0;
    assertEquals(cusId, customer.getCusId(), 0.0);
    String cusName = null;
    assertEquals(cusName, customer.getCusName(), null);
    String cusMob = null;
    assertEquals(cusMob, customer.getCusMob(), null);
    String cusPas = null;
    assertEquals(cusPas, customer.getCusPas(), null);
  }

/**
  * Checking EmptyObject in Equals method.
  */
  @Test
  public final void testEmptyObject() {
    assertFalse(h2.equals(null));
  }

/**
  * Checking getClass in Equals method.
  */
  @Test
  public final void testGetClassEquals() {
    Vendor vendor = new Vendor();
    assertFalse(h2.equals(vendor) && vendor.equals(h2));
  }

  /**
   *for testing.
   */
  @Test
    public final void testSetCusId() {
    assertEquals(100, customer.getCusId());
    customer.setCusId(800);
    assertNotEquals(400, customer.getCusId());
  }

  /**
   *for testing.
   */
  @Test
    public final void testSetCusName() {
    assertEquals("praisy", customer.getCusName());
    customer.setCusName("yashu");
    assertNotEquals("yashvi", customer.getCusName());
  }

  /**
   *for testing.
   */
  @Test
    public final void testSetCusMob() {
    assertEquals("897456321", customer.getCusMob());
    customer.setCusMob("45879632");
    assertNotEquals("458894632", customer.getCusMob());
  }

  /**
   *for testing.
   */
  @Test
    public final void testSetCusPas() {
    assertEquals("pra123", customer.getCusPas());
    customer.setCusPas("fgdh576");
    assertNotEquals("45387hf", customer.getCusPas());
  }

  /**
   *for testing.
   */
  @Test
    public final void testSetCusTotalBalance() {
    customer.setCusTotalBalance(800.90);
    assertEquals(800.90, customer.getCusTotalBalance(), 0.0);
    customer.setCusTotalBalance(623.00);
    assertNotEquals(400, customer.getCusId());
  }

  /**
   *for testing.
   */
  @Test
    public final void cusIdHashcode() {
    assertTrue(h1.hashCode() == h2.hashCode());
    h2.setCusId(200);
    assertFalse(h1.hashCode() == h2.hashCode());
  }

  /**
   *for testing.
   */
  @Test
    public final void cusNametestHashcode() {
    assertTrue(h1.hashCode() == h2.hashCode());
    h2.setCusName("praise");
    assertFalse(h1.hashCode() == h2.hashCode());
  }

  /**
   *for testing.
   */
  @Test
    public final void cusMobtestHashcode() {
    assertTrue(h1.hashCode() == h2.hashCode());
    h2.setCusMob("897456300");
    assertFalse(h1.hashCode() == h2.hashCode());
  }



  /**
   *for testing.
   */
  @Test
    public final void cusPastestHashcode() {
    assertTrue(h1.hashCode() == h2.hashCode());
    h2.setCusPas("pra345");
    assertFalse(h1.hashCode() == h2.hashCode());
  }

  /**
   *for testing.
   */
  @Test
    public final void cusBalancetestHashcode() {
    h1.setCusTotalBalance(800.90);
    h2.setCusTotalBalance(800.90);
    assertTrue(h1.hashCode() == h2.hashCode());
    h2.setCusTotalBalance(600.00);
    assertFalse(h1.hashCode() == h2.hashCode());
  }

  /**
   *for testing.
   */
  @Test
    public final void cusIdTestEquals() {
    assertTrue(h1.equals(h2) && h2.equals(h1));
    h2.setCusId(101);
    assertFalse(h1.equals(h2) && h2.equals(h1));
  }

  /**
   *for testing.
   */
  @Test
    public final void cusNameTestEquals() {
    assertTrue(h1.equals(h2) && h2.equals(h1));
    h2.setCusName("joker");
    assertFalse(h1.equals(h2) && h2.equals(h1));
  }

  /**
   *for testing.
   */
  @Test
    public final void cusMobTestEquals() {
    assertTrue(h1.equals(h2) && h2.equals(h1));
    h2.setCusMob("598741236");
    assertFalse(h1.equals(h2) && h2.equals(h1));
  }

  /**
   *for testing.
   */
  @Test
    public final void cusPasTestEquals() {
    assertTrue(h1.equals(h2) && h2.equals(h1));
    h2.setCusPas("ghi789");
    assertFalse(h1.equals(h2) && h2.equals(h1));
  }

  /**
   *for testing.
   */
  @Test
    public final void cusBalanceTestEquals() {
    h1.setCusTotalBalance(800.90);
    h2.setCusTotalBalance(800.90);
    assertTrue(h1.equals(h2) && h2.equals(h1));
    h2.setCusTotalBalance(600.00);
    assertFalse(h1.equals(h2) && h2.equals(h1));
  }
}

