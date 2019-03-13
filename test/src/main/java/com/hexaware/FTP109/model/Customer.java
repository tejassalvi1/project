package com.hexaware.FTP109.model;

import java.util.Objects;
/**
 * Customer class used to display Customer information.
 * @author hexware
 */
public class Customer {
  private int cusId;
  private String cusName;
  private String cusMob;
  private String cusPas;
  private double cusTotalBalance;
  /**
   * Default Constructor.
   */
  public Customer() {

  }

/**
*@param argCusId to initialize customer id.
*@param argCusName to initialize customer name.
* @param argCusMob to initialize customer mobilenumber.
*@param argCusPas to initialize customer password.
*used to get details through constructor.
*/
  public Customer(final int argCusId, final String argCusName, final String argCusMob, final String argCusPas) {
    this.cusId = argCusId;
    this.cusName = argCusName;
    this.cusMob = argCusMob;
    this.cusPas = argCusPas;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(cusId, customer.getCusId()) && Objects.equals(cusName, customer.getCusName())
        && Objects.equals(cusMob, customer.getCusMob())
        && Objects.equals(cusPas, customer.getCusPas()) && Objects.equals(cusTotalBalance, customer.getCusTotalBalance())) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(cusId, cusName, cusMob, cusPas, cusTotalBalance);
  }
/**
 * @param argCusId to initialize customer id.
 */
  public final void setCusId(final int argCusId) {
    this.cusId = argCusId;
  }
/**
 * @return this customer ID.
*/
  public final int getCusId() {
    return this.cusId;
  }
/**
 * @param argCusName to initialize customer name.
 */
  public final void setCusName(final String argCusName) {
    this.cusName = argCusName;
  }
/**
 * @return this customer name.
 */
  public  final String getCusName() {
    return this.cusName;
  }
/**
 * @param argCusMob to initialize customer mobile number.
 */
  public final void setCusMob(final String argCusMob) {
    this.cusMob = argCusMob;
  }
/**
 * @return this customer mobile number.
 */
  public final String getCusMob() {
    return this.cusMob;
  }
/**
 * @param argCusPas to initialize customer password.
 */
  public final void setCusPas(final String argCusPas) {
    this.cusPas = argCusPas;
  }
/**
 * @return this customer password.
 */
  public final String getCusPas() {
    return this.cusPas;
  }
/**
 * @param argCusTotalBalance to initialize customer password.
 */
  public final void setCusTotalBalance(final double argCusTotalBalance) {
    this.cusTotalBalance = argCusTotalBalance;
  }
  /**
 * @return this customer balance.
 */
  public final double getCusTotalBalance() {
    return this.cusTotalBalance;
  }
}
