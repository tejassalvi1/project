package com.hexaware.FTP109.util;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP109.model.MenuDetails;
import com.hexaware.FTP109.factory.MenuFactory;
import com.hexaware.FTP109.factory.OrderFactory;

/**
* This class provides a REST interface for the employee entity.
*/
@Path("/menudetails")
public class MenuDetailsController {
  /**
  * Returns Menu details.
  * @return the menu details.
  */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
    public final List<MenuDetails> showMenu() {
    List<MenuDetails> menuDetails = MenuFactory.getMenuDetails();
    return menuDetails;
  }

  /**
  * @param foodId to set foodId.
    * @param vendorId to set foodId.
  * @return the menu details.
  */
  @GET
  @Path("{foodId}/{vendorId}")
  @Produces(MediaType.APPLICATION_JSON)
    public final double showPrice(@PathParam("foodId") final int foodId, @PathParam("vendorId") final int vendorId) {
    double foodPrice = OrderFactory.getPrice(foodId, vendorId);
    return foodPrice;
  }

  /**
  * @param foodid to set foodId.
  * @return Returns Vendor details for food.
  */
  @GET
  @Path("/{foodid}")
  @Produces(MediaType.APPLICATION_JSON)
    public final List<MenuDetails> showVendorFood(@PathParam("foodid") final int foodid) {
    List<MenuDetails> vendorFood = MenuFactory.findVendorByFoodName(foodid);
    return vendorFood;
  }
}
