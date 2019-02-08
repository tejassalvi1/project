package com.hexaware.FTP109.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP109.model.Wallet;
import org.skife.jdbi.v2.sqlobject.Bind;
/**
 * WalletDAO class used to fetch data from data base.
 * @author hexware
 */
public interface WalletDAO {
  /**
   *
   * @param custId to initialize Cust Id.
   * @return custId
   */
  @SqlQuery("select * from Wallet where wal_cusid=:custId ")
  @Mapper(WalletMapper.class)
  List<Wallet> showWallet(@Bind("custId")int custId);
  /**
   *
   * @param walId to initialize WalId.
   * @return walId
   */
  @SqlQuery("select WAL_BAL from Wallet where wal_id=:walId")
  double getBalance(@Bind("walId")int walId);
  /**
   *
   * @param totalPrice to initialize Price.
   * @param custId to initialize CustId.
   * @param vendorId to initialize Vendor Id.
   * @param comments to initialize comments.
   */
  @SqlUpdate("insert into orders (ORD_PRICE,CUS_ID, VEN_ID, COMMENTS) VALUES (:totalPrice, :custId, :vendorId, :comments)")
  void placeOrder(@Bind("totalPrice")double totalPrice, @Bind("custId") int custId,
      @Bind("vendorId")int vendorId, @Bind("comments") String comments);
  /**
   *
   * @param price to initialize Price.
   * @param walId to initialize wallet Id.
   */
  @SqlUpdate("update Wallet set wal_bal = wal_bal - :price where wal_id=:walId")
  void cusDebit(@Bind("price")double price, @Bind("walId")int walId);
  /**
   *
   * @param walId to initialize Wallet Id.
   * @param custId to initialize customer Id.
   * @return count of wallet Id.
   */
  @SqlQuery("select count(wal_id) from Wallet where wal_id=:walId and wal_cusid =:custId")
  int countWalletId(@Bind("walId")int walId, @Bind("custId")int custId);
}
