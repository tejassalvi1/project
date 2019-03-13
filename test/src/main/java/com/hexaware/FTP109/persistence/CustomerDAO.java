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
     * @param cusId to initialize the customer id.
     * @return the all the Customer record.
     */
  @SqlQuery("SELECT  c.*, SUM(W.WAL_BAL) AS TOTAL_BALANCE FROM wallet w inner join customer c where w.wal_cusid = c.CUS_ID "
      + " and cus_id =:cusId group by c.cus_id")
    @Mapper(CustomerMapper.class)
    List<Customer> show(@Bind("cusId")int cusId);
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
     /**
      *
      * @param cusId to initialize the customer id.
      * @return the count of customer id.
      */
  @SqlQuery("Select count(cus_id) from customer where cus_Id = :cusId")
    int countCusRest(@Bind("cusId")int cusId);

/**
   * @param newOrder to initialize customer name, customer mobile, customer password.
   */
  @SqlUpdate("insert into customer (CUS_ID, CUS_NAME, CUS_MOB, CUS_PAS) VALUES (:cusId, :cusName, :cusMob, :cusPas)")
     @GetGeneratedKeys
      void insertNewCustomer(@BindBean Customer customer);
}