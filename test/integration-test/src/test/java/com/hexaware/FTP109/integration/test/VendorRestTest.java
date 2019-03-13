package com.hexaware.FTP109.integration.test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class VendorRestTest {
    //Testing the status code for the Vendor Details.
    @Test
	public void testVendorDetailsByStatusCode() throws AssertionError, URISyntaxException {
	    given().accept(ContentType.JSON).when()
        .get(CommonUtil.getURI("/api/vendors/201")).then().assertThat().statusCode(200);
	}

	@Test
	public void testVendorDetailsById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/vendors/7000")).then().assertThat().statusCode(400);
	}

	@Test
	public void testVendorAcceptedOrderDetails() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/vendors/202/status?vstatus=accepted")).then().assertThat().statusCode(200);
	}

	@Test
	public void testVendorAllOrderDetails() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/vendors/202/status?vstatus=")).then().assertThat().statusCode(200);
	}

    @Test
	public void testVendorByIdAndPassword() throws AssertionError, URISyntaxException {
		given().when().contentType(ContentType.JSON).body("{\"venId\":\"201\", \"venPass\":\"HEX123\"}")
		.post(CommonUtil.getURI("/api/vendors/auth")).then().assertThat().statusCode(200);
	}

    @Test
	public void testVendorByIdAndPassword400() throws AssertionError, URISyntaxException {
		given().when().contentType(ContentType.JSON).body("{\"venId\":\"201\", \"venPass\":\"PYG123\"}")
		.post(CommonUtil.getURI("/api/vendors/auth")).then().assertThat().statusCode(403);
	}
}
