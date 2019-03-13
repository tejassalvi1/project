package com.hexaware.FTP109.util;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP109.model.Vendor;
import com.hexaware.FTP109.model.Orders;
import com.hexaware.FTP109.model.OrderStatus;
import com.hexaware.FTP109.factory.Validators;
import com.hexaware.FTP109.factory.OrderFactory;
import com.hexaware.FTP109.factory.VendorFactory;

/**
*
* This class provides a REST interface for the employee entity.
*/
@Path("/vendors")
public class VendorController {
  /**
  * @param venId to initialise vendor Id.
  * @return vendor details.
  */
  @GET
  @Path("/{venId}/")
  @Produces(MediaType.APPLICATION_JSON)
    public final Response showVendorById(@PathParam ("venId") final int venId) {
    Validators.validateVendorId(venId);
    List<Vendor> vendorDetails = VendorFactory.showVendor(venId);
    return Response.status(Response.Status.OK).entity(vendorDetails).build();
  }
 /**
  * Updated order Status.
  * @param vendorId Takes Vendor Id.
  * @param orderId Takes Vendor Id.
  * @param order to pass Orders Object.
  * @return response if it is updated.
  */
  @PUT
  @Path("/{vendorId}/orders/{orderId}")
  @Consumes(MediaType.APPLICATION_JSON)
  public final Response updateOrder(@PathParam("vendorId") final int vendorId, @PathParam("orderId") final int orderId, final Orders order) {
    Validators.validateVendorOrderId(vendorId, orderId);
    OrderFactory.updateOrderStatus(order.getOrderStatus(), vendorId, orderId, order.getComments());
    return Response.status(Response.Status.NO_CONTENT).entity("Updated").build();
  }

  /**
  * Returns Order details.
  * @param vend Takes Customer Id.
  * @return the Response.
  */
  @POST
  @Path("/auth")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
    public final Response showVendorDetails(final Vendor vend) {
    List<Vendor> vendor = null;
    try {
      VendorFactory.showVenIdPassword(vend.getVenId(), vend.getVenPass());
      vendor = VendorFactory.showVendor(vend.getVenId());
    } catch (IllegalArgumentException ex) {
      return Response.status(Response.Status.FORBIDDEN).entity(vendor).build();
    }
    return Response.status(Response.Status.OK).entity(vendor).build();
  }



  /**
  * Returns PendingOrder details.
  * @param venId Takes Vendor Id.
  * @param vstatus to get the status.
  * @return the Pending Order details.
  */
  @GET
  @Path("/{venId}/status")
  @Produces(MediaType.APPLICATION_JSON)
    public final Response listOfPendingOrders(@PathParam("venId") final int venId, @QueryParam("vstatus") final String vstatus) {
    //String vstatus = info.getQueryParameters().getFirst("status");
    OrderStatus status = OrderStatus.PENDING;
    List<Orders> orders;
    Validators.validateVendorId(venId);
    if (vstatus.equals("pending")) {
      status = OrderStatus.PENDING;
    } else if (vstatus.equals("accepted")) {
      status = OrderStatus.ACCEPTED;
    } else if (vstatus.equals("rejected")) {
      status = OrderStatus.REJECTED;
    }
    if (vstatus.equals("pending") || vstatus.equals("accepted") || vstatus.equals("rejected")) {
      orders = OrderFactory.getPendingOrders(venId, status);
    } else {
      orders = OrderFactory.showOrderStatus(venId);
    }
    return Response.status(Response.Status.OK).entity(orders).build();
  }
}
