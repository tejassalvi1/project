package com.hexaware.FTP109.util;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.factory.OrderFactory;
import com.hexaware.FTP109.model.Customer;
import com.hexaware.FTP109.model.Wallet;
import com.hexaware.FTP109.factory.CustomerFactory;
import com.hexaware.FTP109.factory.Validators;
import com.hexaware.FTP109.factory.WalletFactory;
/**
* This class provides a REST interface for the employee entity.
*/
@Path("/customers")
public class CustomerController {
  /**
  * @param newOrder to initialise Orders object parameters.
  * @param custId to initialise food id.
  * @param foodId to initialise food id.
  * @param qty to initialise quantity.
  * @return newOrder;
  */
  @POST
  @Path("/{custId}/orders/{foodId}/{qty}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final Response createOrder(@PathParam("custId") final int custId,
        @PathParam("foodId") final int foodId, @PathParam("qty") final int qty, final Orders newOrder) {
    newOrder.setCusId(custId);
    //Validators.validateWalletId(newOrder.getWalId(), newOrder.getCusId());
    CustomerFactory.findByCustRest(custId);
    Validators.validateVendorId(newOrder.getVenId());
    int orderId = OrderFactory.placeOrder(newOrder).getOrderId();
    double foodPrice = OrderFactory.getPrice(foodId, newOrder.getVenId());
    double totalPrice = foodPrice * qty;
    OrderFactory.placeOrderItems(foodId, orderId, totalPrice, qty);
    return Response.status(Response.Status.CREATED).entity(newOrder).build();
  }

  /**
  * Returns Order details for particular customer.
  * @param cust Takes Customer Id.
  * @return the Response.
  */
  @POST
  @Path("/auth")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
    public final Response showCustomerDetails(final Customer cust) {
    List<Customer> customer = null;
    try {
      CustomerFactory.showCusId(cust.getCusId(), cust.getCusPas());
      customer = CustomerFactory.showCustomer(cust.getCusId());
    } catch (IllegalArgumentException ex) {
      return Response.status(Response.Status.FORBIDDEN).entity(customer).build();
    }
    return Response.status(Response.Status.OK).entity(customer).build();
  }

  /**
  * Returns Order details.
  * @param cusId Takes Customer Id.
  * @return the PendingOrder details.
  */
  @GET
  @Path("/{cusId}/orders")
  @Produces(MediaType.APPLICATION_JSON)
    public final Response listOrderDetCustomer(@PathParam("cusId") final int cusId) {
    CustomerFactory.findByCustRest(cusId);
    final List<Orders> orderDetails = OrderFactory.getOrderDetails(cusId);
    return Response.status(Response.Status.OK).entity(orderDetails).build();
  }

  /**
  * Returns Order details.
  * @param cusId Takes Customer Id.
  * @return the PendingOrder details.
  */
  @GET
  @Path("/{cusId}")
  @Produces(MediaType.APPLICATION_JSON)
    public final Response showCustomerDetails(@PathParam("cusId") final int cusId) {
    CustomerFactory.findByCustRest(cusId);
    final List<Customer> customer = CustomerFactory.showCustomer(cusId);
    return Response.status(Response.Status.OK).entity(customer).build();
  }

  /**
  * Returns Order details.
  * @param cusId Takes Customer Id.
  * @return the Wallet details.
  */
  @GET
  @Path("/{cusId}/wallet")
  @Produces(MediaType.APPLICATION_JSON)
    public final Response showWalletDetails(@PathParam("cusId") final int cusId) {
    final List<Wallet> wallet = WalletFactory.showWallet(cusId);
    return Response.status(Response.Status.OK).entity(wallet).build();
  }


  /**
  * Returns Order details.
  * @param orderId Takes Customer Id.
  * @return the PendingOrder details.
  */
  @GET
  @Path("/{orderId}/allorders")
  @Produces(MediaType.APPLICATION_JSON)
    public final Response listAllOrderById(@PathParam("orderId") final int orderId) {
    final List<Orders> orderDetails = OrderFactory.getOrderAllDetails(orderId);
    return Response.status(Response.Status.OK).entity(orderDetails).build();
  }
 /**
  * @param orderId Takes Customer Id.
  * @return the PendingOrder details.
  */
  @POST
  @Path("/signUp")
  @Produces(MediaType.APPLICATION_JSON)

    public final Response signNewCustomer(final Customer customer) {
    CustomerFactory.insertNewCustomer(customer);
    return Response.status(Response.Status.OK).entity(orderDetails).build();
  }
}
