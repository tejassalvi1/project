package com.hexaware.FTP109.factory;
import com.hexaware.FTP109.persistence.MenuDAO;
import com.hexaware.FTP109.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP109.model.MenuDetails;
/**
* MenuFactory class used to fetch menu data from database.
* @author hexware
*/
public class MenuFactory {
  /**
  *  Protected constructor.
  */
  protected MenuFactory() {
  }
  /**
  * Call the data base connection.
  * @return the connection object.
  */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
  * Call the data base connection.
  * @return the array of menu object.
  */
  public static List<MenuDetails> getMenuDetails() {
    List<MenuDetails> menuDetails = dao().getMenuDetails();
    return menuDetails;
  }
  /**
  * Call the data base connection.
   * @param foodId initialize food id.
   * @return size of the foodId if it is present.
   */
  public static int findByFoodId(final int foodId) {
    int count = dao().countFoodId(foodId);
    return count;
  }

  /**
   * Call the data base connection.
   * @param vendorId initialize Vendor id.
   * @param foodId initialize food id.
   * @return size of the foodId if it is present.
   */
  public static int findByVenFoodId(final int vendorId, final int foodId) {
    int count = dao().countVenFoodId(vendorId, foodId);
    return count;
  }
}
