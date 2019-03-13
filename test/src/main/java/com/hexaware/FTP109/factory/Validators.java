package com.hexaware.FTP109.factory;

/** This Validators class validate all the functions called by it.
 */
public final class Validators {

  /**
  *non parameterised constructor intialize the vendor id.
   */
  private Validators() {

  }
  /**
  *@param vendorId intialize the vendor id.
   */
  public static void validateVendorId(final int vendorId) {
    int size = VendorFactory.findByVendorId(vendorId);
    if (size == 0) {
      throw new IllegalArgumentException("Invaild Credentials...");
    }
  }
 /**
  *@param vendorId intialize the vendor id.
  *@param password intialize the password.
   */
  public static void validateVendorIdPassword(final int vendorId, final String password) {
    int size = VendorFactory.findByVendorIdPassword(vendorId, password);
    if (size == 0) {
      throw new IllegalArgumentException("Invaild Credentials...");
    }
  }
  /**
  *@param foodId intialize the food id.
   */
  public static void validateFoodId(final int foodId) {
    int size = MenuFactory.findByFoodId(foodId);
    if (size == 0) {
      throw new IllegalArgumentException("Invaild Food ID");
    }
  }
  /**
  *@param vendorId intialize the vendor id
  *@param foodId initialize the food id.
   */
  public static void validateVenFoodId(final int vendorId, final int foodId) {
    int size = MenuFactory.findByVenFoodId(vendorId, foodId);
    if (size == 0) {
      throw new IllegalArgumentException("This Food is not prepared by this Vendor");
    }
  }
  /**
  *@param custId intialize the customer id.
  *@param password intialize the customer password.

   */
  public static void validateCustomerId(final int custId, final String password) {
    int count = CustomerFactory.findByCustomerId(custId, password);
    if (count == 0) {
      throw new IllegalArgumentException("Invalid Credentials...");
    }
  }
  /**
  *@param count intialize the count.
   */
  public static void validateCustRest(final int count) {
    if (count == 0) {
      throw new IllegalArgumentException("Customer Not Found");
    }
  }
  /**
  *@param walId intialize the wallet id.
  *@param custId intialize the customer id.
   */
  public static void validateWalletId(final int walId, final int custId) {
    int size = WalletFactory.findByWalletId(walId, custId);
    if (size == 0) {
      throw new IllegalArgumentException("Invalid Wallet id ");
    }
  }
  /**
  *@param orderId intialize the order id.
  *@param vendorId intialize the vendor id
   */
  public static void validateVendorOrderId(final int vendorId, final int orderId) {
    int count = OrderFactory.findbyVendorOrderId(vendorId, orderId);
    if (count == 0) {
      throw new IllegalArgumentException("Invalid Vendor Id and Order Id Entered..");
    }
  }
}
