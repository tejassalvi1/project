package com.hexaware.FTP109.integration.test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import com.hexaware.FTP109.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
* MenuFactory class used to fetch menu data from database.
* @author hexware.
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu {
    /**
     * foodId to store foodId.
     * foodName to store foodName.
     * foodPrice to store foodPrice.
     * venId to store venId
     * venName to store
     * rating to store
     */
  private int foodId;
  private String foodName;
  private double foodPrice;
  private int venId;
  private String venName;
  private int ratings;
  /**
   * @param argFoodId to initialize food id.
   * @param argFoodName to initialize food name.
   * @param argFoodPrice to initialize food price.
   * @param argVenId to initialize vendor id.
   * @param argVenName to initialize Vendor Name.
   * @param argRatings to initialize rating.
   */
  public Menu(final int argFoodId, final String argFoodName, final double argFoodPrice,
      final int argVenId, final String argVenName, final int argRatings) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.foodPrice = argFoodPrice;
    this.venId = argVenId;
    this.venName = argVenName;
    this.ratings = argRatings;
  }
/**
 * @param argFoodName to initialize vendor name.
 *
 */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  /**
   *
   * @return foodName
   */
  public final String getFoodName() {
    return this.foodName;
  }
    /**
     *
     * @return this food id
     */
  public final int getFoodId() {
    return this.foodId;
  }
    /**
     *
     * @return this food price
     */
  public final double getFoodPrice() {
    return this.foodPrice;
  }
    /**
     *
     * @return this vendor id
     */
  public final int getVendorId() {
    return this.venId;
  }
    /**
     *
     * @return this vendor name
     */
  public final String getVendorName() {
    return this.venName;
  }
    /**
     *
     * @return this rating
     */
  public final int getRatings() {
    return this.ratings;
  }
}
