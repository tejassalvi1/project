package com.hexaware.FTP109.persistence;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP109.model.MenuDetails;
import org.skife.jdbi.v2.sqlobject.Bind;

/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
  /**
   * @return all the parameters in the query.
   */
  @SqlQuery("SELECT M.FOOD_ID, M.FOOD_NAME, MV.FOOD_PRICE, V.VEN_ID, V.VEN_NAME,MV.RATINGS "
      + " FROM (( MENU AS M INNER JOIN MENU_VENDOR AS MV ON M.FOOD_ID = MV.FOOD_IDF) "
      + " INNER JOIN VENDOR V ON V.VEN_ID = MV.VEN_IDF)")
    @Mapper(MenuDetailsMapper.class)
    List<MenuDetails> getMenuDetails();
  /**
   * @param foodId to initialize in where clause to get count.
   * @return the count of food id if foodId is present.
   */
  @SqlQuery("Select count(food_id) from menu where FOOD_ID = :foodId")
    int countFoodId(@Bind("foodId")int foodId);
  /**
   * @param foodId to initialize in where clause to get count.
   * @param vendorId to initialize in where clause to get count.
   * @return the count of foodId if foodId and Vendor is present.
   */
  @SqlQuery("Select count(FOOD_IDF) from menu_vendor where VEN_IDF = :vendorId and FOOD_IDF = :foodId")
    int countVenFoodId(@Bind("vendorId")int vendorId, @Bind("foodId") int foodId);

  /**
   * @param foodId to initialize food Name.
   * @return all the parameters in the query.
   */
  @SqlQuery("select * from menu m, menu_vendor mv, vendor v where m.food_id= mv.food_idf and "
      + " v.ven_id = mv.ven_idf and m.food_id = :foodId")
    @Mapper(MenuDetailsMapper.class)
    List<MenuDetails> findVendorByFoodName(@Bind("foodId")int foodId);
}
