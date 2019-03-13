package com.hexaware.FTP109.factory;
import mockit.MockUp;
import mockit.Mock;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
/**
  * This ValidatorsTest class test all the functions.
  */
public class ValidatorsTest {
/**
  * Testing The Mocked Validators For Valid Vendor.
  */
  @Test
  public final void testValidateVendorIdvalid() {
    new MockUp<VendorFactory>() {
      @Mock
      public int findByVendorId(final int venId) {
          return 5;
        }  };
    try {
      Validators.validateVendorId(10);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
  /**
  * Testing The Mocked Validators For Valid Vendor.
*/
  @Test
  public final void testValidateVendorIdInvalid() {
    new MockUp<VendorFactory>() {
      @Mock
      public int findByVendorId(final int venId) {
          return 0;
        }  };
    try {
      Validators.validateVendorId(20);
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Valid Vendor.
  */
  @Test
  public final void testValidateVendorIdPasswordValid() {
    new MockUp<VendorFactory>() {
      @Mock
      public int findByVendorIdPassword(final int vendorId, final String password) {
          return 5;
        }  };
    try {
      Validators.validateVendorIdPassword(10, "pooja");
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
/**
 * Testing The Mocked Validators For Valid Vendor.
 */
  @Test
  public final void testInValidateVendorIdPassword() {
    new MockUp<VendorFactory>() {
      @Mock
      public int findByVendorIdPassword(final int vendorId, final String password) {
          return 0;
        }  };
    try {
      Validators.validateVendorIdPassword(10, "pooja");
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Valid Food.
  */
  @Test
  public final void testValidateFoodId() {
    new MockUp<MenuFactory>() {
      @Mock
      public int findByFoodId(final int foodId) {
          return 5;
        }  };
    try {
      Validators.validateFoodId(50);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
/**
  * Testing The Mocked Validators For InValid Food.
  */
  @Test
  public final void testInValidateFoodId() {
    new MockUp<MenuFactory>() {
      @Mock
      public int findByFoodId(final int foodId) {
          return 0;
        }  };
    try {
      Validators.validateFoodId(10);
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Valid Customer.
  */
  @Test
  public final void testValidateCustomerId() {
    new MockUp<CustomerFactory>() {
      @Mock
      public int findByCustomerId(final int customerId, final String password) {
          return 5;
        }  };
    try {
      Validators.validateCustomerId(10, "pooja");
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
/**
 * Testing The Mocked Validators For Valid Customer.
 */
  @Test
  public final void testInValidateCustomerId() {
    new MockUp<CustomerFactory>() {
      @Mock
      public int findByCustomerId(final int customerId, final String password) {
          return 0;
        }  };
    try {
      Validators.validateCustomerId(30, "pooja123");
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Valid VendorId and Food Id.
  */
  @Test
  public final void testValidateVenFoodId() {
    new MockUp<MenuFactory>() {
      @Mock
      public int findByVenFoodId(final int venId, final int foodId) {
          return 5;
        }  };
    try {
      Validators.validateVenFoodId(10, 5);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
  /**
  * Testing The Mocked Validators For InValid VendorId and FoodId.
*/
  @Test
  public final void testInValidateVenFoodId() {
    new MockUp<MenuFactory>() {
      @Mock
      public int findByVenFoodId(final int venId, final int foodId) {
          return 0;
        }  };
    try {
      Validators.validateVenFoodId(20, 30);
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }


/**
  * Testing The Mocked Validators For Valid Wallet Id and Customer Id.
  */
  @Test
  public final void testValidateWalletId() {
    new MockUp<WalletFactory>() {
      @Mock
      public int findByWalletId(final int walId, final int custId) {
          return 5;
        }  };
    try {
      Validators.validateWalletId(10, 5);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
/**
* Testing The Mocked Validators For InValid Walletid and Customer.
*/
  @Test
  public final void testInValidateWalletId() {
    new MockUp<WalletFactory>() {
      @Mock
      public int findByWalletId(final int walId, final int custId) {
          return 0;
        }  };
    try {
      Validators.validateWalletId(20, 30);
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }


/**
  * Testing The Mocked Validators For Valid VendorId and Order Id.
  */
  @Test
  public final void testValidateVendorOrderId() {
    new MockUp<OrderFactory>() {
      @Mock
      public int findbyVendorOrderId(final int venId, final int orderId) {
          return 5;
        }  };
    try {
      Validators.validateVendorOrderId(10, 5);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
/**
  * Testing The Mocked Validators For InValid VendorId and Order.
  */
  @Test
  public final void testInValidateVendorOrderId() {
    new MockUp<OrderFactory>() {
      @Mock
      public int findbyVendorOrderId(final int venId, final int orderId) {
          return 0;
        }  };
    try {
      Validators.validateVendorOrderId(20, 30);
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Valid Vendor Id only.
  */
  @Test
  public final void testInValidateCustRest() {
    try {
      Validators.validateCustRest(0);
      fail("Exception thrown");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Valid Vendor Id only.
  */
  @Test
  public final void testValidateCustRest() {
    try {
      Validators.validateCustRest(10);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }
}
