package com.hexaware.FTP109.persistence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.sql.ResultSet;
import org.junit.Test;
import mockit.Mocked;
import mockit.Verifications;
import mockit.Expectations;
import com.hexaware.FTP109.model.MenuDetails;
/**
 * MenuDetailsMapperTest class used to Test menu data.
 * @author hexware
 */
public class MenuDetailsMapperTest {
  /**
  * @param resultSet Testing The Mocked resultSet.
  * @throws Exception throws the if it not matched.
  */
  @Test
  public final void mapTest(@Mocked final ResultSet resultSet) throws Exception {
    new Expectations() { {
        resultSet.getInt("FOOD_ID"); result = 5;
        resultSet.getString("FOOD_NAME"); result = "Pizza";
        resultSet.getDouble("FOOD_PRICE"); result = 50.0d;
        resultSet.getInt("VEN_ID"); result = 10;
        resultSet.getString("VEN_NAME"); result = "HexaCafe";
        resultSet.getInt("RATINGS"); result = 5;
      }  };
    MenuDetailsMapper menuMapper = new MenuDetailsMapper();
    MenuDetails menu = menuMapper.map(0, resultSet, null);
    //Asserting FoodId.
    assertEquals(5, menu.getFoodId());
    assertNotEquals(10, menu.getFoodId());
    //Asserting FoodName.
    assertEquals("Pizza", menu.getFoodName());
    assertNotEquals("Cola", menu.getFoodName());
    //Asserting FoodPrice.
    assertEquals(50.0d, menu.getFoodPrice(), 0);
    assertNotEquals(20.5d, menu.getFoodPrice(), 0);
    //Asserting VendorId.
    assertEquals(10, menu.getVendorId());
    assertNotEquals(20, menu.getVendorId());
    //Asserting Vendor Name.
    assertEquals("HexaCafe", menu.getVendorName());
    assertNotEquals("HexaDine", menu.getVendorName());
    //Asserting Rating.
    assertEquals(5, menu.getRatings());
    assertNotEquals(10, menu.getRatings());
    new Verifications() { {
        resultSet.getInt("FOOD_ID"); times = 1;
        resultSet.getString("FOOD_NAME"); times = 1;
      }  };
  }
}
