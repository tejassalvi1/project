package com.hexaware.FTP109.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.hexaware.FTP109.model.MenuDetails;


public class MenuDetailsTest {

    private MenuDetails menuDetails;

    @Before
    public void setUp(){
        menuDetails =  new MenuDetails(401, "MASALA DOSA", 60, 201, "HEXACAFE", 4) ;
    }
    @Test
    public void testMenuDetailsConstructor() {
        assertEquals(401, menuDetails.getFoodId());
        assertEquals("MASALA DOSA", menuDetails.getFoodName());
       // assertEquals(60, menuDetails.getFoodPrice());
        assertEquals(201, menuDetails.getVendorId());
        assertEquals("HEXACAFE", menuDetails.getVendorName());
        assertEquals(4, menuDetails.getRatings());

    }
    
    @Test
    public void testsetFoodId() {
        assertEquals(401, menuDetails.getFoodId());
    }

}