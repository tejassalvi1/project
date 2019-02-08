package com.hexaware.FTP109.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP109.model.Customer;
/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the Customer record.
     */
  @SqlQuery("Select * from customer")
    @Mapper(CustomerMapper.class)
    List<Customer> show();
     /**
      *
      * @param cusId to initialize the customer id.
      * @return customer id.
      */
  @SqlQuery("Select count(cus_id) from customer where cus_Id = :cusId")
    int showCusId(@Bind("cusId")int cusId);
     /**
      *
      * @param cusId to initialize the customer id.
      * @param password to initialize the customer password.
      * @return the count of customer id.
      */
  @SqlQuery("Select count(cus_id) from customer where cus_Id = :cusId and cus_pas = :password")
    int countCustId(@Bind("cusId")int cusId, @Bind("password")String password);

}
