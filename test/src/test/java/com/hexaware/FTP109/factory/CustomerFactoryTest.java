package com.hexaware.FTP109.factory;
import mockit.Mocked;
import mockit.Verifications;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mock;
import org.junit.Test;
import com.hexaware.FTP109.persistence.CustomerDAO;
import com.hexaware.FTP109.model.Customer;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
/**
 * CustomerFactoryTest class used to Test the CustomerFactory.
 * @author hexware
 */

public class CustomerFactoryTest {
/**
  * @param dao Testing The Mocked CustomerDAO.
  */
  @Test
  public final void testFindByCustomerId(@Mocked final CustomerDAO dao) {
    new Expectations() { {
        dao.countCustId(1, "poo123"); result = 25;
      }  };
    new MockUp<CustomerFactory>() {
        @Mock
        public CustomerDAO dao() {
        return dao;
      }  };
    int count = CustomerFactory.findByCustomerId(1, "poo123");
    assertEquals(25, count);

    new Verifications() { {
        dao.countCustId(1, "poo123"); times = 1;
      }  };
  }
/**
  * @param dao Testing The Mocked CustomerDAO.
  */
  @Test
  public final void testShowCustomer(@Mocked final CustomerDAO dao) {
    final Customer cust1 = new Customer(1, "Pooja", "1234569874", "poo123");
    final Customer cust2 = new Customer(2, "Yashu", "1236547895", "yash123");
    final Customer cust3 = new Customer(3, "Gagan", "1258746934", "gagan123");
    final List<Customer> customer = new ArrayList();
    new Expectations() { {
        customer.add(cust1);
        customer.add(cust2);
        customer.add(cust3);
        dao.show(1); result = customer;
      }  };
    new MockUp<CustomerFactory>() {
        @Mock
        public CustomerDAO dao() {
        return dao;
      }  };
    final CustomerFactory custfactory = new CustomerFactory();
    List<Customer> customer1 = CustomerFactory.showCustomer(1);
    assertEquals(customer1.size(), 3);
    assertEquals(customer.size(), 3);
    assertEquals(customer1.size(), customer.size());
    assertEquals(customer.get(1).getCusId(), customer1.get(1).getCusId());
    assertNotEquals(customer.get(2).getCusId(), customer1.get(1).getCusId());
    new Verifications() { {
        dao.show(1); times = 1;
      }  };
  }

/**
  * Testing The Mocked Validators For Valid Customer.
  */
  @Test
  public final void testshowCusIdValid() {
    new MockUp<Validators>() {
      @Mock
      public void validateCustomerId(final int custId, final String password) { }
    };
    try {
      CustomerFactory.showCusId(10, "Pooja123");
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }

/**
  * Testing The Mocked Validators For Invalid Customer.
  */
  @Test
  public final void testshowCusIdInvalid() {
    new MockUp<Validators>() {
      @Mock
    public void validateCustomerId(final int custId, final String password) {
        throw new IllegalArgumentException("Invalid Customer Id and Password");
      }
    };
    try {
      CustomerFactory.showCusId(20, "pooja111");
      fail("Exception not thrown");
    } catch (IllegalArgumentException e) {
      assertNotNull(e);
      System.out.println(e.getMessage());
    }
  }

/**
  * Testing The Mocked Validators For Invalid Customer.
  */
  @Test
  public final void testshowCusIdEmptyToEnd() {
    new MockUp<Validators>() {
      @Mock
    public void validateCustomerId(final int custId, final String password) {
      }  };
    try {
      CustomerFactory.showCusId(20, "pooja111");
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
  }

/**
  * @param dao Testing The Mocked CustomerDAO.
  */
  @Test
  public final void testfindByCustRest(@Mocked final CustomerDAO dao) {
    new Expectations() { {
        dao.countCusRest(1); result = 25;
      }  };
    new MockUp<CustomerFactory>() {
        @Mock
        public CustomerDAO dao() {
        return dao;
      }  };
    new MockUp<Validators>() {
      @Mock
      public void validateCustRest(final int custId) { }
    };
    try {
      CustomerFactory.findByCustRest(1);
    } catch (IllegalArgumentException e) {
      fail("Exception not thrown");
    }
    new Verifications() { {
        dao.countCusRest(1); times = 1;
      }  };
  }
}

