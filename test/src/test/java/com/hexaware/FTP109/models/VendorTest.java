package com.hexaware.FTP109.model;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

  /**
  * This class is for testing the vendor class.
  */
public class VendorTest {

  private Vendor vendor;

  /**
  * This gives the settingup of vendor class.
  */
  @Before
  public final void setup() {
    vendor = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
  }
  /**
  * This gives the constructor of vendor class.
  */
  @Test
  public final void testVendorConstructor() {
    assertEquals(201, vendor.getVenId());
    assertEquals("HEXACAFE", vendor.getVenName());
    assertEquals("7887820221", vendor.getVenMob());
    assertEquals("HEX123", vendor.getVenPass());
    assertEquals(2000.0d, vendor.getVenBal(), 0);
  }

  /**
  * Testing the vendor id.
  */

  @Test
  public final void testSetVenId() {
    assertEquals(201, vendor.getVenId());
    vendor.setVenId(501);
    assertNotEquals(201, vendor.getVenId());
    assertEquals(501, vendor.getVenId());
  }

  /**
  * Testing the vendor Name.
  */

  @Test
  public final void testSetVenName() {
    assertEquals("HEXACAFE", vendor.getVenName());
    vendor.setVenName("HOTEL");
    assertNotEquals("HEXACAFE", vendor.getVenName());
    assertEquals("HOTEL", vendor.getVenName());
  }

  /**
  * Test the vendor Mobile Number.
  */

  @Test
  public final void testSetVenMob() {
    assertEquals("7887820221", vendor.getVenMob());
    vendor.setVenMob("9687825841");
    assertNotEquals("7887820221", vendor.getVenMob());
    assertEquals("9687825841", vendor.getVenMob());
  }

  /**
  * Testing the vendor Password.
  */

  @Test
  public final void testSetVenPass() {
    assertEquals("HEX123", vendor.getVenPass());
    vendor.setVenPass("HENA853");
    assertNotEquals("HEX123", vendor.getVenPass());
    assertEquals("HENA853", vendor.getVenPass());
  }

  /**
  * Testing the vendor Balance.
  */

  @Test
  public final void testSetVenBal() {
    assertEquals(2000.0d, vendor.getVenBal(), 0);
    vendor.setVenBal(2500.0d);
    assertNotEquals(2000.0d, vendor.getVenBal(), 0);
    assertEquals(2500.0d, vendor.getVenBal(), 0);
  }

  /**
  * Testing the Equal value vendor values.
  */

  @Test
  public final void testEquals() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    Vendor v2 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    v1.setVenId(201);
    v2.setVenId(201);
    assertTrue(v1.equals(v2) && v2.equals(v1));
  }

  /**
  * Testing the NotEqual value vendor values.
  */

  @Test
  public final void testNotEquals() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    Vendor v2 = new Vendor(501, "HOTEL", "9687825841", "HENA853", 2500.0d);
    v1.setVenId(201);
    v2.setVenId(501);
    assertFalse(v1.equals(v2) && v2.equals(v1));
  }

  /**
  * Testing the True vendor values.
  */

  @Test
  public final void testTrue() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    Vendor v2 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    v1.setVenId(201);
    v2.setVenId(201);
    assertTrue(v1.hashCode() == v2.hashCode());
  }

  /**
  * Testing the False vendor values.
  */

  @Test
  public final void testFalse() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    Vendor v2 = new Vendor(501, "HOTEL", "9687825841", "HENA853", 2500.0d);
    v1.setVenId(201);
    v2.setVenId(501);
    assertFalse(v1.hashCode() == v2.hashCode());
  }
  /**
  * Checking EmptyConstructor in Equals method.
  */
  @Test
  public final void testNull() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    Vendor v3 = null;
    v1.setVenId(201);
    assertFalse(v1.equals(v3) && v3.equals(v1));
  }
    /**
   *for testing.
   */
  @Test
    public final void testNonParamVendor() {
    vendor = new Vendor();
    int venId = 0;
    assertEquals(venId, vendor.getVenId(), 0.0);
    String venName = null;
    assertEquals(venName, vendor.getVenName(), null);
    String venMob = null;
    assertEquals(venMob, vendor.getVenMob(), null);
    String venPass = null;
    assertEquals(venPass, vendor.getVenPass(), null);
    double venBal = 0.0d;
    assertEquals(venBal, vendor.getVenBal(), 0.0d);
  }
  /**
  * Checking getClass in Equals method.
  */
  @Test
  public final void testGetClassEquals() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    Customer customer = new Customer();
    assertFalse(v1.equals(customer) && customer.equals(v1));
  }
  /**
  * Checking EmptyObject in Equals method.
  */
  @Test
  public final void testEmptyObject() {
    Vendor v1 = new Vendor(201, "HEXACAFE", "7887820221", "HEX123", 2000.0d);
    assertFalse(v1.equals(null));
  }

}
