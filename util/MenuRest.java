package com.hexaware.FTP109.util;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP109.model.MenuDetails;
import com.hexaware.FTP109.factory.MenuFactory;


/**
* This class provides a REST interface for the employee entity.
*/
@Path("/menu")
public class MenuRest {
  /**
  * Returns Menu details.
  * @return the menu details
  */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
    public final List<MenuDetails> listMenu() {
    final List<MenuDetails> menu = MenuFactory.getMenuDetails();
    return menu;
  }
}
