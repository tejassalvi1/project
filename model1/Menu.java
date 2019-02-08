package com.hexaware.FTP109.model;

//import com.hexaware.FTP109.persistence.DbConnection;
//import com.hexaware.FTP109.persistence.OrdersDAO;

import java.util.Objects;
//import java.util.List;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 * foodName to store foodName.
 * foodType to store foodType.
 */
  private int foodId;
  private String foodName;
  private String foodType;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argFoodId to initialize food id.
   @param argFoodName to initialize food name.
   @param argFoodType to initialize food type.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId, final String argFoodName, final String argFoodType) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.foodType = argFoodType;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.getFoodId()) && Objects.equals(foodName, menu.getFoodName())
        && Objects.equals(foodType, menu.getFoodType())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId, foodName, foodType);
  }
    /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }

  /**
     * @return this food Name.
     */
  public final String getFoodName() {
    return foodName;
  }

  /**
     * @return this food Type.
     */
  public final String getFoodType() {
    return foodType;
  }

  /**
 * @param argFoodId to initialize Food id.
 *
 */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
 * @param argFoodName to initialize Food Name.
 *
 */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  /**
 * @param argFoodType to initialize Food Type.
 *
 */
  public final void setFoodType(final String argFoodType) {
    this.foodType = argFoodType;
  }
}
