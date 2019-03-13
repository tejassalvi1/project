package com.hexaware.FTP109.integration.test;
import com.hexaware.FTP109.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Date;
import java.util.Objects;
//import canteenmanagement.src.main.java.com.hexaware.FTP109.model.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Orders class used to display menu information.
 * @author hexware
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
/**
 * OrderId to store OrderId.
 * OrderStatus to store orderStatus.
 * OrderPrice to store OrderPrice.
 * foodPrice to store foodPrice.
 * orderDate to store orderDate.
 * walid to store walId
 * cusId to store cusId.
 * VenId to store VenId.
 * cusName to store customer name.
 * venName to store vendor name.
 * comments to store comments.
 */
  private int orderId;
  //private OrderStatus orderStatus;
  private double orderPrice;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private Date orderDate;
  private int walId;
  private int cusId;
  private int venId;
  private String comments;
  private String cusName;
  private String venName;
  private String walName;
  private int qty;
  /**
   * Default Constructor.
   */
  public Order() {

  }

  /**
   *
   * @param argOrderPrice to initialize the order price.
   * @param argwalId to initialize the wallet id.
   * @param argCusId to initialize the customer id.
   * @param argVenId to initialize the vendor id.
   * @param argcomments to initialize the comments.
   */
  public Order(final double argOrderPrice, final int argwalId, final int argCusId, final int argVenId,
      final String argcomments) {
    this.orderPrice = argOrderPrice;
    this.walId = argwalId;
    this.cusId = argCusId;
    this.venId = argVenId;
    this.comments = argcomments;
    this.orderDate = new Date();
  }

  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Order ordr = (Order) obj;
    if (Objects.equals(orderId, ordr.getOrderId())
        && Objects.equals(orderPrice, ordr.getOrderPrice()) && Objects.equals(orderDate, ordr.getOrderDate())
        && Objects.equals(cusId, ordr.getCusId()) && Objects.equals(venId, ordr.getVenId())
        && Objects.equals(comments, ordr.getComments()) && Objects.equals(walId, ordr.getWalId())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId, orderPrice, orderDate, walId, cusId, venId, comments, cusName, venName, walName, qty);
  }
    /**
     * @return this order ID.
     */
  public final int getOrderId() {
    return orderId;
  }
  /**
     * @return this order Price.
     */
  public final double getOrderPrice() {
    return this.orderPrice;
  }

  /**
     * @return this orderDate.
     */
  public final Date getOrderDate() {
    return this.orderDate;
  }
  /**
   * @return this walId
   */
  public final int getWalId() {
    return walId;
  }
  /**
     * @return this Customer Id.
     */
  public final int getCusId() {
    return cusId;
  }

  /**
     * @return this Vendor Id.
     */
  public final int getVenId() {
    return venId;
  }

  /**
     * @return this comments.
     */
  public final String getComments() {
    return comments;
  }

  /**
     * @return this customer name.
     */
  public final String getCusName() {
    return cusName;
  }

  /**
     * @return this vendor name.
     */
  public final String getVenName() {
    return venName;
  }

  /**
     * @return this wallet name.
     */
  public final String getWalName() {
    return walName;
  }

  /**
     * @return this quantity.
     */
  public final int getQty() {
    return qty;
  }
  /**
 * @param argOrderId to initialize Order id.
 *
 */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
  /**
 * @param argOrderPrice to initialize Order price.
 *
 */
  public final void setOrderPrice(final double argOrderPrice) {
    this.orderPrice = argOrderPrice;
  }
  /**
 * @param argOrderDate to initialize Order Date
 *
 */
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }
  /**
 * @param argWalId to initialize Customer Id.
  *
    */
  public final void setWalId(final int argWalId) {
    this.walId = argWalId;
  }
  /**
 * @param argCusId to initialize Customer Id.
 *
 */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
  /**
 * @param argVenId to initialize Vendor Id.
 *
 */
  public final void setVenId(final int argVenId) {
    this.venId = argVenId;
  }
  /**
 * @param argcomments to initialize Food Price.
 *
 */
  public final void setComments(final String argcomments) {
    this.comments = argcomments;
  }

  /**
 * @param argCusName to initialize Customer Name.
 *
 */
  public final void setCusName(final String argCusName) {
    this.cusName = argCusName;
  }

  /**
 * @param argVenName to initialize vendor Name.
 *
 */
  public final void setVenName(final String argVenName) {
    this.venName = argVenName;
  }
  /**
 * @param argWalName to initialize wallet Name.
 *
 */
  public final void setWalName(final String argWalName) {
    this.walName = argWalName;
  }
  /**
 * @param argQty to initialize quantity.
 *
 */
  public final void setQty(final int argQty) {
    this.qty = argQty;
  }
}
