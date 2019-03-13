package com.hexaware.FTP109.factory;

import mockit.Mocked;
import mockit.Mock;
import mockit.MockUp;
import mockit.Verifications;
import org.junit.Test;
import mockit.Expectations;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
import com.hexaware.FTP109.persistence.WalletDAO;
import java.util.List;
import java.util.ArrayList;
import com.hexaware.FTP109.model.Wallet;


/**
 * This is a WalletFactoryTest Class.
 */
public class WalletFactoryTest {

  /**
   * @param dao mock values.
   */
  @Test
       public final void testFindByWalletId(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.countWalletId(10, 20); result = 5;
      } };
    new MockUp<WalletFactory>() {
      @Mock
    public WalletDAO dao() {
        return dao;
      }  };
    int count = WalletFactory.findByWalletId(10, 20);
    assertEquals(5, count);

    new Verifications() { {
        dao.countWalletId(10, 20); times = 1;
      } };
  }


  /**
   * @param dao mock values.
   */
  @Test
       public final void testGetBalance(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.getBalance(10); result = 5000.02;
      } };
    new MockUp<WalletFactory>() {
      @Mock
    public WalletDAO dao() {
        return dao;
      }  };
    final WalletFactory wallet = new WalletFactory();
    double count = WalletFactory.getBalance(10);
    assertEquals(5000.02, count, 0.0);

    new Verifications() { {
        dao.getBalance(10); times = 1;
      } };
  }

  /**
   * @param dao mock values.
   */
  @Test
       public final void testShowWallet(@Mocked final WalletDAO dao) {
    new Expectations() { {
        final Wallet wallet = new Wallet(10, "debit", 23000.20, 20);
        final List<Wallet> wallet1 = new ArrayList();
        wallet1.add(wallet);
        dao.showWallet(10); result = wallet1;
      } };
    new MockUp<WalletFactory>() {
      @Mock
    public WalletDAO dao() {
        return dao;
      }  };
    final List<Wallet> count = WalletFactory.showWallet(10);
    assertEquals(count.size(), 1);

    new Verifications() { {
        dao.showWallet(10); times = 1;
      } };
  }


  /**
   * @param dao mock values.
   */
  @Test
       public final void test(@Mocked final WalletDAO dao) {
    new Expectations() { {
        dao.cusDebit(100.0d, 20);
      } };
    new MockUp<WalletFactory>() {
      @Mock
      public WalletDAO dao() {
        return dao;
      }  };
    WalletFactory.cusDebit(100.0d, 20);
    new Verifications() { {
        dao.cusDebit(100.0d, 20); times = 1;
      } };
  }
}
