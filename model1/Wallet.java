package com.hexaware.FTP109.model;

//import com.hexaware.FTP109.persistence.DbConnection;
//import com.hexaware.FTP109.persistence.OrdersDAO;

import java.util.Objects;
//import java.util.List;
/**
 * Wallet class used to display wallet information.
 * @author hexware
 */
public class Wallet {
/**
 * wal_fd to store wal_fd.
 * mod_pay to store modeofpayment.
 * wal_bal to store walletbalance.
 * wal_cusId to store Walletcustomerid.
 */
  private int walId;
  private String modPay;
  private double walBal;
  private int walCusId;
  /**
   * Default Constructor.
   */
  public Wallet() {

  }
/**
 * @param argWalId to initialize wallet id.
   @param argModPay to initialize mode of payment.
   @param argWalBal to initialize wallet balance.
   @param argWalCusId to initialize wallet customerid.
 * used to get details through constructor.
 */
  public Wallet(final int argWalId, final String argModPay, final double argWalBal, final int argWalCusId) {
    this.walId = argWalId;
    this.modPay = argModPay;
    this.walBal = argWalBal;
    this.walCusId = argWalCusId;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wallet wallet = (Wallet) obj;
    if (Objects.equals(walId, wallet.getWalId()) && Objects.equals(modPay, wallet.getModPay())
        && Objects.equals(walId, wallet.getWalId())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(walId, modPay, walBal, walCusId);
  }
    /**
     * @return this wallet ID.
     */
  public final int getWalId() {
    return walId;
  }

  /**
     * @return this Mode of pay.
     */
  public final String getModPay() {
    return modPay;
  }

  /**
     * @return this wallet balance.
     */
  public final double getWalBal() {
    return walBal;
  }

  /**
     * @return this Wallet customer id.
     */
  public final float getWalCusId() {
    return walCusId;
  }
  /**
 * @param argWalId to initialize wallet id.
 *
 */
  public final void setWalId(final int argWalId) {
    this.walId = argWalId;
  }
  /**
 * @param argModPay to initialize Mode of payment.
 *
 */
  public final void setModPay(final String argModPay) {
    this.modPay = argModPay;
  }
  /**
 * @param argWalBal to initialize wallet Balance.
 *
 */
  public final void setWalBal(final double argWalBal) {
    this.walBal = argWalBal;
  }
  /**
 * @param argWalCusId to initialize Wallet customer Id.
 *
 */
  public final void setWalCusId(final int argWalCusId) {
    this.walCusId = argWalCusId;
  }
}
