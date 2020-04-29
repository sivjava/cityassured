package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CityStepDefination {

	RestTemplate restTemplate = new RestTemplate();
	
	
	ResponseEntity<City> response ;	
	@When("user sends POST HTTP request")
	public void user_sends_POST_HTTP_request() {
		
		String url =  "http://localhost" + ":" + 9090 + "/city" + "/add";
		System.out.println(url);
		
	   	}

	@Then("user adds  id {}, name {}, pincode {} and state {}")
	public void user_adds_1(Long id,String name,String pincode,String state) {
		 
		String url =  "http://localhost" + ":" + 9090 + "/city" + "/add";
		
		City city = new City();
		city.setId(id);
		city.setName(name);
		city.setPincode(pincode);
        city.setState(state);
        Response res= given().header("Content-Type", "application/json").content(city).post(url);//get()
        assertNotNull(res);
		assertEquals(HttpStatus.OK.value(), res.getStatusCode());
	}
	
	
	@Given("user launches the application and sends a delete request")
	public void user_launches_the_application_and_sends_a_delete_request() throws Exception{
	    String url = "http://localhost" + ":" + 9090;
	}

	@When("user gives id {} to delete a record")
	public void user_gives_id_to_delete_a_record(Long id) {
		String url = "http://localhost" + ":" + 9090 + "/city/" + id;
		Response res= given().delete(url);
			assertNotNull(res);
			assertEquals(HttpStatus.OK.value(), res.getStatusCode());
		
	}

	@Then("recevies HttpStatus as OK")
	public void recevies_HttpStatus_as_OK() throws Exception{
		System.out.println("OK");
	}

	
	@Given("user launches the application and send getById request")
	public void user_launches_the_application_and_send_getById_request() throws Exception{
	    
		String url = "http://localhost" + ":" + 9090 + "/swagger-ui.html";
		System.out.println(url);
	}

	@When("user gives id {} to see a particular record")
	public void user_gives_id_to_see_a_particular_record(String id) throws Exception{
	    
		String url = "http://localhost" + ":" + 9090 + "/city/" + id;
		
		Response res=given().get(url);
		assertNotNull(res);
		assertEquals(HttpStatus.OK.value(), res.getStatusCode());
		
	}

	@Then("user recevies the id {},name {},pincode {},state {}")
	public void user_recevies_the_id_name_pincode_state	(Integer id,String name,String pincode,String state) throws Exception {
		String url = "http://localhost" + ":" + 9090 + "/city/" + id;
		Response res=given().get(url);//.statusCode()body("id", equalTo(id+""));
		assertNotNull(res);
		assertEquals(HttpStatus.OK.value(), res.getStatusCode());
		assertEquals(id, res.jsonPath().get("id"));
		assertEquals(name, res.jsonPath().get("name"));
		assertEquals(pincode, res.jsonPath().get("pincode"));
		assertEquals(state, res.jsonPath().get("state"));
		
	}
	
}
