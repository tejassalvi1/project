package com.hexaware.FTP109.model;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
//import static org.junit.Assert.;
 /**
 * Test class for Wallet.
 */
public class WalletTest {
  private Wallet wallet;
  /**
  * setup method.
  */
  @Before
    public final void setUp() {
    wallet = new Wallet(1, "CREDIT", 2000.0d, 101);
  }
  /**
  *test for default constructors.
  */
  @Test
  public final void testDefaultWalletConstructor() {
    Wallet w2 = new Wallet();
    assertNotNull(w2);
    Wallet w3 = null;
    assertNull(w3);
  }
  /**
  *test for constructors.
  */
  @Test
  public final void testWalletConstructor() {
    assertEquals(1, wallet.getWalId());
    assertEquals("CREDIT", wallet.getModPay());
    assertEquals(2000.0d, wallet.getWalBal(), 0);
    assertEquals(101, wallet.getWalCusId());
  }
  /**
  *test for setting wallet id.
  */
  @Test
    public final void testSetWalletId() {
    assertEquals(1, wallet.getWalId());
    wallet.setWalId(344);
    assertNotEquals(1, wallet.getWalId());
    assertEquals(344, wallet.getWalId());
  }
  /**
  *test for setting mode of pay.
  */
  @Test
  public final void testSetWalletModePay() {
    assertEquals("CREDIT", wallet.getModPay());
    wallet.setModPay("DEBIT");
    assertNotEquals("CREDIT", wallet.getModPay());
    assertEquals("DEBIT", wallet.getModPay());
  }
  /**
  * test for setting Wallet balance.
  */
  @Test
    public final void testSetWalletBalance() {
    assertEquals(2000.0d, wallet.getWalBal(), 0);
    wallet.setWalBal(2563.0d);
    assertNotEquals(2000.0d, wallet.getWalBal(), 0);
    assertEquals(2563.0d, wallet.getWalBal(), 0);
  }
  /**
  * test for setting customer id.
  */
  @Test
    public final void testSetCustomerId() {
    assertEquals(101, wallet.getWalCusId());
    wallet.setWalCusId(963);
    assertNotEquals(101, wallet.getWalCusId());
    assertEquals(963, wallet.getWalCusId());
  }
  /**
  * testing hashcode methods.
  */
  @Test
    public final void testHashCode() {
    Wallet x = new Wallet(1, "CREDIT", 2000.0d, 101);
    Wallet y = new Wallet(1, "CREDIT", 2000.0d, 101);
    assertEquals(x.hashCode(), y.hashCode());
  }
  /**
  * testing equals methods.
  */
  @Test
    public final void testEqualsTrue() {
    Wallet x = new Wallet(1, "CREDIT", 2000.0d, 101);
    Wallet y = new Wallet(1, "CREDIT", 2000.0d, 101);
    x.setWalId(1);
    y.setWalId(1);
    assertTrue(x.equals(y) && y.equals(x));
    y.setWalId(100);
    assertFalse(x.equals(y) && y.equals(x));
  }
  /**
  * test for testing Empty object.
  */
  @Test
    public final void testEmptyObject() {
    Wallet w1 = null;
    assertFalse(wallet.equals(w1) && w1.equals(wallet));
  }
  /**
  * test for testing Empty class.
  */
  @Test
    public final void testGetClass() {
    Vendor v = new Vendor(1, "rasika", "9604684464", "BOB", 500.0d);
    assertFalse(wallet.equals(v) && v.equals(wallet));
  }


}


