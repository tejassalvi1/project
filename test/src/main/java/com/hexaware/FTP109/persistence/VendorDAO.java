package com.hexaware.FTP109.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP109.model.Vendor;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @param vendorId to initialise vendor id.
     * @return the all the vendor record.
     */
  @SqlQuery("Select * from vendor where VEN_ID = :vendorId;")
    @Mapper(VendorMapper.class)
    List<Vendor> show(@Bind("vendorId")int vendorId);
    /**
     *@param vendorId get the vendor Id.
     *@param price get the price.
     */
  @SqlUpdate("update Vendor set VEN_BAL = VEN_BAL + :price where VEN_ID = :vendorId;")
    void updateVendorWallet(@Bind("vendorId")int vendorId, @Bind("price")double price);
    /**
     *@param venId get the vendor Id.
     * @return the count of vendor Id.
     */
  @SqlQuery("Select count(ven_id) from vendor where ven_Id = :venId")
    int countVenId(@Bind("venId")int venId);
     /**
     *@param venId get the vendor Id.
     *@param password get the vendor password0.
     *@return the count of vendor Id.
     */
  @SqlQuery("Select count(ven_id) from vendor where ven_Id = :venId and ven_pas = :password")
    int countVenIdPassword(@Bind("venId")int venId, @Bind("password")String password);
}
