package com.hexaware.FTP109.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
import com.hexaware.FTP109.model.MenuDetails;

/**
 * OrderMapper class used to fetch menu data from database.
 * @author hexware
 */
public class MenuDetailsMapper implements ResultSetMapper<MenuDetails> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final MenuDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return MenuDetails
       */
    int foodId = rs.getInt("FOOD_ID");
    String foodName = rs.getString("FOOD_NAME");
    double foodPrice = rs.getDouble("FOOD_PRICE");
    int venId = rs.getInt("VEN_ID");
    String venName = rs.getString("VEN_NAME");
    int rate = rs.getInt("RATINGS");
    return new MenuDetails(foodId, foodName, foodPrice, venId, venName, rate);
  }
}
