package com.hexaware.FTP109.factory;

import com.hexaware.FTP109.persistence.VendorDAO;
import com.hexaware.FTP109.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP109.model.Vendor;
import com.hexaware.FTP109.util.Validators;
/**
 * MenuFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * @param vendorId to initialize vendor id.
   * @param totalPrice to initialize total price.
   */
  public static void updateVendorWallet(final int vendorId, final double totalPrice) {
    dao().updateVendorWallet(vendorId, totalPrice);
  }
  /**
   * Call the data base connection.
   * @return the updated vendor wallet.
   */
  public static List<Vendor> showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor;
  }
  /**
   * Checking for Validator for Vendor.
   * @param vendorId to initialize the  vendor id.
   */
  public static void showVenId(final int vendorId) {
    Validators.validateVendorId(vendorId);
  }
  /**
   * Checking for Validator for Vendor.
   * @param vendorId to initialize the  vendor id.
   * @param password to initialize the  password.
   */
  public static void showVenIdPassword(final int vendorId, final String password) {
    Validators.validateVendorIdPassword(vendorId, password);
  }
  /**
   * Call the data base connection.
   * @param vendorId to initialize the  vendor id.
   * @return the size of vendor.
   */
  public static int findByVendorId(final int vendorId) {
    int count = dao().countVenId(vendorId);
    return count;
  }
  /**
   * Call the data base connection.
   * @param vendorId to initialize the  vendor id.
   * @param password to initialize the  password.
   * @return the size of vendor.
   */
  public static int findByVendorIdPassword(final int vendorId, final String password) {
    int count = dao().countVenIdPassword(vendorId, password);
    return count;
  }
}
