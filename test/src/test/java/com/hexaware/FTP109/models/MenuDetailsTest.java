package com.hexaware.FTP109.model;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * This class is for Testing the menuDetails class.
 */
public  class MenuDetailsTest {

  private MenuDetails menuDetails;
  private MenuDetails menu1;
  private MenuDetails menu2;
/**
 * Creating Objects.
 */
  @Before
  public final void setUp() {
    menuDetails =  new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4);
    menu1 = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4);
    menu2 = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4);
  }
  /**
  * This gives the constructor of the menuDetails class.
  */
  @Test
  public final void testMenuDetailsConstructor() {
    assertEquals(401, menuDetails.getFoodId());
    assertEquals("MASALA DOSA", menuDetails.getFoodName());
    assertEquals(201, menuDetails.getVendorId());
    assertEquals("HEXACAFE", menuDetails.getVendorName());
    assertEquals(4, menuDetails.getRatings());
  }
  /**
  * This gives the Equals test for the menudetails class.
  */
  //@Test
  public final void testEquals() {
    MenuDetails x = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4); // equals and hashCode check name field value
    MenuDetails y = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4);
    assertTrue(x.equals(y));
  }
  /**
  * This gives the NotEquals test for the menudetails class.
  */
  //@Test
  public final void testNotEquals() {
    MenuDetails x = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4); // equals and hashCode check name field value
    MenuDetails y = new MenuDetails(501, "Bhindi", 240.0, 401, "HEXARAUNT", 4);
    assertFalse(x.equals(y));
  }
  /**
  * This gives the Hashcode true test for the menudetails class.
  */
  //@Test
  public final void testHashcodetrue() {
    MenuDetails x = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4); // equals and hashCode check name field value
    MenuDetails y = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4);
    assertTrue(x.hashCode() == y.hashCode());
  }
  /**
  * This gives the Hashcode false test for the menudetails class.
  */
  @Test
  public final void testHashcodefalse() {
    MenuDetails x = new MenuDetails(401, "MASALA DOSA", 60.0, 201, "HEXACAFE", 4); // equals and hashCode check name field value
    MenuDetails y = new MenuDetails(501, "Bhindi", 240.0, 401, "HEXARAUNT", 4);
    assertFalse(x.hashCode() == y.hashCode());
  }
  /**
  * Checking EmptyObject in Equals method.
  */
  @Test
  public final void testEmptyObject() {
    assertFalse(menu2.equals(null));
  }
  /**
  * Checking getClass in Equals method.
  */
  @Test
  public final void testGetClassEquals() {
    Customer customer = new Customer();
    assertFalse(menu2.equals(customer) && customer.equals(menu2));
  }
}
