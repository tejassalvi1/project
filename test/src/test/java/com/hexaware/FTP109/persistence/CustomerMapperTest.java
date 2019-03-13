package com.hexaware.FTP109.persistence;
import java.sql.ResultSet;
import com.hexaware.FTP109.model.Customer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import mockit.Mocked;
import mockit.Expectations;
import mockit.Verifications;

/**
 * This is a CustomerMapperTest Class.
 */
public class CustomerMapperTest {

  /**
   * @param resultSet mock values.
   * @throws Exception ....
   */
  @Test
       public final void mapTest(@Mocked final ResultSet resultSet) throws Exception {
/**
 * This is Expectations declaration.
 */
    new Expectations() { {
        resultSet.getInt("CUS_ID"); result  = 24;
        resultSet.getString("CUS_NAME"); result  = "Vinay";
        resultSet.getString("CUS_MOB"); result  = "45345345";
        resultSet.getString("CUS_PAS"); result  = "tewrwer";
        resultSet.getDouble("TOTAL_BALANCE"); result  = 500;
      } };

    CustomerMapper customerMapper = new CustomerMapper();
    Customer customer = customerMapper.map(0, resultSet, null);
    assertEquals(24, customer.getCusId());
    assertEquals("Vinay", customer.getCusName());
    assertEquals("45345345", customer.getCusMob());
    assertEquals("tewrwer", customer.getCusPas());
    assertEquals(500, customer.getCusTotalBalance(), 0);


    new Verifications() {
      {
        resultSet.getInt("CUS_ID"); times = 1;
        resultSet.getString("CUS_NAME"); times = 1;
        resultSet.getString("CUS_MOB"); times = 1;
        resultSet.getString("CUS_PAS"); times = 1;
        resultSet.getDouble("TOTAL_BALANCE"); times  = 1;
        }
    };

  }
}
