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

public class CustomerRestTest {

	@Test
	public void testCustomerList() throws AssertionError, URISyntaxException {
	Customers[] res = given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/customers/101")).getBody().as(Customers[].class);
	assertEquals(1, res.length);
	assertEquals(101, res[0].getCusId());
	assertEquals("BHAGYA", res[0].getCusName());
	assertEquals("8809839695", res[0].getCusMob());
	assertEquals("ABC123", res[0].getCusPas());
	}


	@Test
	public void testMenuById404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
		.get(CommonUtil.getURI("/api/customers/1")).then().assertThat().statusCode(400);
	}
	
    	@Test
	public void testCustomersAuth() throws URISyntaxException {
		given().when().contentType(ContentType.JSON).body("{\"cusId\":\"101\", \"cusPas\":\"ABCJGHBJ123\"}")
		.post(CommonUtil.getURI("/api/customers/auth")).then().assertThat().statusCode(403);
	}
	//Test place order Rest.
	@Test
	public void testPlaceOrder() throws URISyntaxException {
		given().when().contentType(ContentType.JSON).body("{\"orderPrice\":\"200\", \"walId\":\"001\",\"venId\":\"201\"}")
		.post(CommonUtil.getURI("/api/customers/101/orders/402/2")).then().assertThat().statusCode(201);
	}
}
