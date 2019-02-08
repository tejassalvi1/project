package com.hexaware.FTP109.model;

import java.util.Date;
import java.util.Objects;

/**
 * Orders class used to display menu information.
 * @author hexware
 */
public class Orders {
/**
 * OrderId to store OrderId.
 * OrderStatus to store orderStatus.
 * OrderPrice to store OrderPrice.
 * foodPrice to store foodPrice.
 * orderDate to store orderDate.
 * walid to store walId
 * cusId to store cusId.
 * VenId to store VenId.
 * comments to store comments.
 */
  private int orderId;
  private OrderStatus orderStatus;
  private double orderPrice;
  private Date orderDate;
  private int walId;
  private int cusId;
  private int venId;
  private String comments;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
/**
 * @param argOrderId to initialize food id.
   @param argOrderStatus to initialize order status.
   @param argOrderPrice to initialize order price.
   @param argOrderDate to initialize order date.
   @param argCusId to initialize customer id.
   @param argVenId to initialize vendor id.
   @param argWalId to initialize wallet id.
    used to get details through constructor.
 **/
  public Orders(final int argOrderId, final OrderStatus argOrderStatus, final double argOrderPrice,
      final Date argOrderDate, final int argWalId, final int argCusId, final int argVenId) {
    this.orderId = argOrderId;
    this.orderStatus = argOrderStatus;
    this.orderPrice = argOrderPrice;
    this.orderDate = new Date(argOrderDate.getTime());
    this.walId = argWalId;
    this.cusId = argCusId;
    this.venId = argVenId;
  }
  /**
   *
   * @param argOrderPrice to initialize the order price.
   * @param argwalId to initialize the wallet id.
   * @param argCusId to initialize the customer id.
   * @param argVenId to initialize the vendor id.
   * @param argcomments to initialize the comments.
   */
  public Orders(final double argOrderPrice, final int argwalId, final int argCusId, final int argVenId, final String argcomments) {
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
    Orders ordr = (Orders) obj;
    if (Objects.equals(orderId, ordr.getOrderId()) && Objects.equals(orderStatus, ordr.getOrderStatus())
        && Objects.equals(orderPrice, ordr.getOrderPrice()) && Objects.equals(orderDate, ordr.getOrderDate())
        && Objects.equals(cusId, ordr.getCusId()) && Objects.equals(venId, ordr.getVenId())
        && Objects.equals(comments, ordr.getComments()) && Objects.equals(walId, ordr.getWalId())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId, orderStatus, orderPrice, orderDate, walId, cusId, venId, comments);
  }
    /**
     * @return this order ID.
     */
  public final int getOrderId() {
    return orderId;
  }

  /**
     * @return this Order status.
     */
  public final OrderStatus getOrderStatus() {
    return this.orderStatus;
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
    return new Date(this.orderDate.getTime());
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
 * @param argOrderId to initialize Order id.
 *
 */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
  /**
 * @param argOrderStatus to initialize Food Name.
 *
 */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
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
    this.orderDate = new Date(argOrderDate.getTime());
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
}
