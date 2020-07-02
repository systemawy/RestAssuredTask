
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Test01_GET {
	int petId = 0;
	
//	  @Test
//		public void addPet()
//		{
//		String myJson = "{ \"id\": \"100100100\", \"category\": { \"id\": 0, \"name\": \"string\" }, \"name\": \"doggie\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"available\"}";
//	    	RestAssured.baseURI  = "https://petstore.swagger.io/v2";	
//
//	    	Response r = 
//	    	given()
//	    	.contentType("application/json").
//	    	body(myJson).
//	        when().
//	        post("/pet");
//
//	    	String body = r.getBody().asString();
//	    	System.out.println("added pet is " + body);
//	    	
//	    	JSONObject jsonObj = new JSONObject(body);
//
//	    	petId = jsonObj.getInt("id");
//
//
//		}
	
	@Test
		public void addPet() {
		
		JSONObject request = new JSONObject();
		JSONArray addArray = new JSONArray();
		
		request.put("id", 7447);
		addArray.add(0, 0);
		addArray.add(1, "dog");
				
		given().
			header("api_key", "special-key").
			contentType(ContentType.JSON)
			.accept(ContentType.JSON).
			body (request.toJSONString()).
			when().
			post ("https://petstore.swagger.io/v2/pet").
			then().
			statusCode(201);
	
	}
	
	
	
//	@Test
//	public void RegistrationSuccessful()
//	{		
////		RestAssured.baseURI ="https://petstore.swagger.io/v2";
////		RequestSpecification request = RestAssured.given();
//		
////		//Main Object
////		JSONObject requestParams = new JSONObject();
////		
////		
////		
////		requestParams.put("id", 25555); // Cast
////		requestParams.put("name", "Dogo");
////		
////		//PhotoURLs
////		JSONArray photoUrlsArray = new JSONArray();
////		photoUrlsArray.put("https://image.com");
////		requestParams.put("photoUrls", photoUrlsArray);
////
////		//Tags
////		JSONObject tagsObject = new JSONObject();
////		tagsObject.put("id", "522");
////		tagsObject.put("name", "Doe");
////		
////		JSONArray tagsArray = new JSONArray();
////		tagsArray.put(tagsObject);
////		requestParams.put("tags", tagsArray);
////		
////		//Categories
////		JSONObject categoryObject = new JSONObject();
////		categoryObject.put("id", "522");
////		categoryObject.put("name", "Doe");
////		requestParams.put("category", categoryObject);
//		
////		request.body(requestParams.toString());
//		
//		
//		
//		
////		request.body("{ \"id\": \"96989\", \"category\": { \"id\": 0, \"name\": \"string\" }, \"name\": \"doggie\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"available\"}");
//		Response response = request.post("/pet");
// 
//		int statusCode = response.getStatusCode();
////		Assert.assertEquals(statusCode, "200");
////		String successCode = response.jsonPath().get("SuccessCode");
////		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
//		
//		System.out.println("output is: " +statusCode);
//	}
	
	
	@Test
	void findByStatus () {
		
		Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending");
		//Response response2 = RestAssured.post("https://petstore.swagger.io/v2/pet");
		
		//response2.body();
		
		System.out.println("find by status is " +response.asString());
		
	}
	
	@Test
	void getPet() {
		
		Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/"+ petId);

		System.out.println("get pet is " + response.asString());
		
		
	}

}
