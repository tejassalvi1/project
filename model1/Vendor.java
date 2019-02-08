package com.hexaware.FTP109.model;

//import com.hexaware.FTP109.persistence.DbConnection;
//import com.hexaware.FTP109.persistence.MenuDAO;

import java.util.Objects;
//import java.util.List;
/**
 * Vendor class used to display Customer information.
 * @author hexware
 */
public class Vendor {
  private int venId;
  private String venName;
  private String venMob;
  private String venPass;
  private double venBal;
  /**
   * Default Constructor.
   */
  public Vendor() {

  }
/**
 * @param argVenId to initialize vendor id.
 * @param argVenName to initialize vendor name.
 * @param argVenMob to initialize vendor mobilenumber.
 * @param argVenPass to initialize vendor password.
 * @param argVenBal to initialize vendor Balance.
 * used to get details through constructor.
 */
  public Vendor(final int argVenId, final String argVenName, final String argVenMob, final String argVenPass, final double argVenBal) {
    this.venId = argVenId;
    this.venName = argVenName;
    this.venMob = argVenMob;
    this.venPass = argVenPass;
    this.venBal = argVenBal;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.getVenId()) && Objects.equals(venName, vendor.getVenName())
        && Objects.equals(venMob, vendor.getVenMob()) && Objects.equals(venPass, vendor.getVenPass())
        && Objects.equals(venBal, vendor.getVenBal())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(venId, venName, venMob, venPass, venBal);
  }
/**
 * @param argVenId to initialize vendor id.
 *
 */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
/**
 * @return this Vendor ID.
 */
  public final int getVenId() {
    return this.venId;
  }
/**
 * @param argVenName to initialize vendor name.
 *
 */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
/**
 * @return this Vendor Name.
 */
  public final String getVenName() {
    return this.venName;
  }
/**
 * @param argVenMob to initialize vendor mobilenumber.
 *
 */
  public final void setVenMob(final String argVenMob) {
    this.venMob = argVenMob;
  }
/**
 * @return this Vendor Mobile Number.
 */
  public final String getVenMob() {
    return this.venMob;
  }
/**
 * @param argVenPass to initialize vendor id.
 *
 */
  public final void setVenPass(final String argVenPass) {
    this.venPass = argVenPass;
  }
/**
 * @return this Vendor Password.
 */
  public final String getVenPass() {
    return this.venPass;
  }
/**
 * @param argvenBal to  vendor balance.
 *
 */
  public final void setVenBal(final int argvenBal) {
    this.venBal = argvenBal;
  }
/**
 * @return this Vendor Balance.
 */
  public final double getVenBal() {
    return this.venBal;
  }
}
