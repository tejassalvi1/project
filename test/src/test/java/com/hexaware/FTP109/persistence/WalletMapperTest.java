package com.hexaware.FTP109.persistence;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import com.hexaware.FTP109.model.Wallet;
import org.junit.Test;
import mockit.Mocked;
import mockit.Expectations;
import mockit.Verifications;


/**
 * Testing the WalletMapper.
 */
public class WalletMapperTest {
  /**
  * Testing for the mapping.
  * @param resultSet is the refence object.
  * @throws Exception gives the expected values.
   */
  @Test
  public final void mapTest(@Mocked final ResultSet resultSet) throws Exception {

    new Expectations() { {
        resultSet.getInt("WAL_ID"); result  = 100;
        resultSet.getString("MOD_PAY"); result  = "COD";
        resultSet.getDouble("WAL_BAL"); result  = 8000.0d;
        resultSet.getInt("WAL_CUSID"); result  = 657;
      } };

    WalletMapper walletMapper = new WalletMapper();

    Wallet wallet = walletMapper.map(0, resultSet, null);

    assertEquals(100, wallet.getWalId());
    assertEquals("COD", wallet.getModPay());
    assertEquals(8000.0d, wallet.getWalBal(), 0.0d);
    assertEquals(657, wallet.getWalCusId());

    new Verifications() {
      {
        resultSet.getInt("WAL_ID"); times = 1;
        resultSet.getInt("WAL_ID"); times = 1;
        resultSet.getString("MOD_PAY"); times = 1;
        resultSet.getDouble("WAL_BAL"); times = 1;
        resultSet.getInt("WAL_CUSID"); times = 1;
      }
    };
  }
}
