package com.hexaware.FTP109.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP109.model.Wallet;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrderMapper class used to fetch menu data from database.
 * @author hexware
 */
public class WalletMapper implements ResultSetMapper<Wallet> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Wallet map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Wallet
       */
    int walId = rs.getInt("WAL_ID");
    String modeOfPay = rs.getString("MOD_PAY");
    double walBal = rs.getDouble("WAL_BAL");
    int custId = rs.getInt("WAL_CUSID");
    return new Wallet(walId, modeOfPay, walBal, custId);
  }
}
