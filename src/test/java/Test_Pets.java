
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class Test_Pets {
	int petId = 0;
	
	  @Test
		public void addPet()
		
		{
		String myJson = "{ \"id\": \"50607080\", \"category\": { \"id\": 0, \"name\": \"string\" }, \"name\": \"doggie\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"available\"}";
	    	RestAssured.baseURI  = "https://petstore.swagger.io/v2";	

	    	Response r = 
	    	given().
	    	//log().all().
	    	contentType("application/json").
	    	body(myJson).
	        when().
	        post("/pet");
	    	
	    	int statusCode = r.getStatusCode();
	    	Assert.assertEquals(statusCode,200);

	    	String body = r.getBody().asString();
	    	System.out.println( "added pet is " + body);
	    	
	    	JSONObject jsonObj = new JSONObject(body);

	    	petId = jsonObj.getInt("id");


		}
	
	  
	  @Test
		public void editPet()
		
		{
		
		  String myJson = "{ \"id\": \"97979797\", \"category\": { \"id\": 10, \"name\": \"rex\" }, \"name\": \"ziz\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"available\"}";
	    	RestAssured.baseURI  = "https://petstore.swagger.io/v2";	

	    	Response r = 
	    	given().
	    	//log().all().
	    	contentType("application/json").
	    	body(myJson).
	        when().
	        put("/pet");
	    	
	    	int statusCode = r.getStatusCode();
	    	Assert.assertEquals(statusCode,200);


	    	String body = r.getBody().asString();
	    	System.out.println( "edited pet is " + body);
	    	
	    	JSONObject jsonObj = new JSONObject(body);

	    	petId = jsonObj.getInt("id");


		}
	  
	
	
	@Test
	void findByStatus () {
		
		Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending");
		
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode,200);
		
		System.out.println("find by status is " +response.asString());
		
	}
	
	@Test
	void getPet() {
		
		Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/"+ petId);
		
		int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode,200);

		System.out.println("get pet is " + response.asString());
		
		
	}
	
	@Test
	public void deletePet()
	
	{

    	Response r = 
    	given().
    	//log().all().
    	contentType("application/json").
        when().
        delete("/pet" + petId);

    	r.getBody().asString();
    	
    	System.out.println( "deleted pet is " + petId );
    	

	}

}
