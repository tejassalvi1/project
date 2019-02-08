package com.hexaware.FTP109.factory;

import com.hexaware.FTP109.persistence.WalletDAO;
import com.hexaware.FTP109.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP109.model.Wallet;
//import com.hexaware.FTP109.util.Validators;
/**
 * WalletFactory class used to fetch wallet data from database.
 * @author hexware
 */
public class WalletFactory {
  /**
   *  Protected constructor.
   */
  protected WalletFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static WalletDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(WalletDAO.class);
  }
  /**
   * Call the data base connection.
   * @param custId to initialize cust id.
   * @return list of wallet
   */
  public static List<Wallet> showWallet(final int custId) {
    List<Wallet> wallet = dao().showWallet(custId);
    return wallet;
  }
  /**
   * Call the data base connection.
   * @param walId to initialize Wal id.
   * @return Balance if the wallet id is parsent.
   */
  public static double getBalance(final int walId) {
    double bal = dao().getBalance(walId);
    return bal;
  }
  /**
   *
   * @param updateBal to initialize update Bal id.
   * @param walId to initialize Wal id.
   */
  public static void cusDebit(final double updateBal, final int walId) {
    dao().cusDebit(updateBal, walId);
  }
  /**
   * Call the data base connection.
   * @param walId to initialize Wallet id to get the count.
   * @param custId to initialize Customer id to get the count.
   * @return count more than if that wallet Id is present.
   */
  public static int findByWalletId(final int walId, final int custId) {
    int count = dao().countWalletId(walId, custId);
    return count;
  }
}

