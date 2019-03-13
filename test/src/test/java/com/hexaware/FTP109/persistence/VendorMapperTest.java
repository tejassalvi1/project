package com.hexaware.FTP109.persistence;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import mockit.Mocked;
import mockit.Verifications;
import mockit.Expectations;
import java.sql.ResultSet;
import com.hexaware.FTP109.model.Vendor;
/**
* VendorMapperTest is used to test vendor data.
*/
public class VendorMapperTest {
    /**
    * @param resultSet used for mocking.
    * @throws Exception used for moked resultSet.
    */
  @Test
    public final void mapTest(@Mocked final ResultSet resultSet) throws Exception {
    new Expectations() { {
        resultSet.getInt("VEN_ID"); result = 24;
        resultSet.getString("VEN_NAME"); result = "rasika";
        resultSet.getString("VEN_MOB"); result = "9604684464";
        resultSet.getString("VEN_PAS"); result = "BOB";
        resultSet.getDouble("VEN_BAL"); result = 5242.0d;
      } };
    VendorMapper vendorMapper = new VendorMapper();

    Vendor vendor = vendorMapper.map(0, resultSet, null);

    assertEquals(24, vendor.getVenId());

    new Verifications() { {
            resultSet.getInt("VEN_ID"); times = 1;
        }
    };
  }
}
