package com.hexaware.FTP109.factory;
import mockit.Verifications;
import mockit.Expectations;
import static org.junit.Assert.assertEquals;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Mock;
import org.junit.Test;
import com.hexaware.FTP109.persistence.VendorDAO;
import com.hexaware.FTP109.model.Vendor;
import java.util.List;
import java.util.ArrayList;
//import com.hexaware.FTP109.factory.Validators;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

/**
* VendorFactoryTest is used to test vendor data.
*/
public class VendorFactoryTest {
    /**
    *
    @param dao used for mocking.
    testing for test by vendor id password.
    */
  @Test
    public final void testFindByVendorIdPassword(@Mocked final VendorDAO dao) {
    new Expectations() { {
        dao.countVenIdPassword(5, "RASIKA"); result = 1;
        } };
    new MockUp<VendorFactory>() {
        @Mock
            public VendorDAO dao() {
            return dao;
        } };
    VendorFactory vendorfactory = new VendorFactory();
    int count = vendorfactory.findByVendorIdPassword(5, "RASIKA");
    assertEquals(count, 1);

    new Verifications() { {
            dao.countVenIdPassword(5, "RASIKA"); times = 1;
        } };
  }
    /**
    *
    @param dao used for mocking.
    testing for test by vendor id password.
    */
  @Test
    public final void testFindByVendorId(@Mocked final VendorDAO dao) {
    new Expectations() { {
          dao.countVenId(5); result = 9;
        } };
    new MockUp<VendorFactory>() {
        @Mock
            public VendorDAO dao() {
            return dao;
        } };
    VendorFactory vendorfactory = new VendorFactory();
    int count = vendorfactory.findByVendorId(5);
    assertEquals(9, count);

    new Verifications() { {
            dao.countVenId(5); times = 1;
        } };
  }
  /**
  *@param dao testing the mocked VendorDAO.
  */
  @Test
  public final void testShowVendor(@Mocked final VendorDAO dao) {
    final Vendor ven1 = new Vendor(1, "RASIKA", "9604684464", "BOB", 863.0d);
    final Vendor ven2 = new Vendor(2, "UNNU", "9604684485", "BOB", 8593.0d);
    final List<Vendor> vendor = new ArrayList();
    new Expectations() { {
        vendor.add(ven1);
        vendor.add(ven2);
        dao.show(1); result = vendor;
      } };
    new MockUp<VendorFactory>() {
        @Mock
            public VendorDAO dao() {
            return dao;
      } };
    List<Vendor> ven3 = VendorFactory.showVendor(1);
    assertEquals(ven3.size(), 2);
    assertEquals(vendor.size(), 2);

    new Verifications() { {
            dao.show(1); times = 1;
        } };
  }
    /**
    *
    @param dao used for mocking.
    testing for test by vendor id password.
    */


  @Test
    public final void testUpdateVendorWallet(@Mocked final VendorDAO dao) {
    new Expectations() { {
          dao.updateVendorWallet(5, 564.0d);
        } };
    new MockUp<VendorFactory>() {
        @Mock
            public VendorDAO dao() {
            return dao;
        } };
    //VendorFactory vendorfactory = new VendorFactory();
    VendorFactory.updateVendorWallet(5, 564.0d);


    new Verifications() { {
            dao.updateVendorWallet(5, 564.0d); times = 1;
        } };
  }
/**
*@param dao used for mocking.
*/
  @Test
    public final void testshowVenId(@Mocked final VendorDAO dao) {
    new MockUp<Validators>() {
        @Mock
            public final void validateVendorId(final int vendorId) {
        throw new IllegalArgumentException("Invalid vendor id");
        } };
    try {
      VendorFactory.showVenId(10);
      fail("This method should throw exception.");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid vendor id", e.getMessage());
    }
  }

/**
*@param dao used for mocking.
*/
  @Test
    public final void testshowVenId1(@Mocked final VendorDAO dao) {
    new MockUp<Validators>() {
        @Mock
            public final void validateVendorId(final int vendorId) {
        } };
    try {
      VendorFactory.showVenId(10);
    } catch (IllegalArgumentException e) {
      fail("This method should throw exception.");

    }
  }
  /**
*@param dao used for mocking.
*/
  @Test
    public final void testshowVenIdPassword(@Mocked final VendorDAO dao) {
    new MockUp<Validators>() {
        @Mock
            public final void validateVendorIdPassword(final int vendorId, final String password) {
        throw new IllegalArgumentException("Invalid vendor id");
        } };
    try {
      VendorFactory.showVenIdPassword(10, "rasika");
      fail("This method should throw exception.");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      assertEquals("Invalid vendor id", e.getMessage());
    }
  }
    /**
*@param dao used for mocking.
*/
  @Test
    public final void testshowVenIdPassword1(@Mocked final VendorDAO dao) {
    new MockUp<Validators>() {
        @Mock
            public final void validateVendorIdPassword(final int vendorId, final String password) {
        } };
    try {
      VendorFactory.showVenIdPassword(10, "rasika");
    } catch (IllegalArgumentException e) {
      fail("this method should throw exception.");
    }
  }
}
