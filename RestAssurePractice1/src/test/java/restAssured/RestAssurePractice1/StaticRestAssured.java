package restAssured.RestAssurePractice1;

import org.testng.Assert;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class StaticRestAssured {

	//@org.testng.annotations.Test
	public void getRequest()
	{
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("Status Code : "+response.getStatusCode());
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Headers "+response.getHeaders());
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Content type "+response.getHeader("content-type"));
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Time "+response.getTime());
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Status Code "+response.getStatusCode());
		System.out.println("-------------------------------");
		System.out.println();
		System.out.println("Body "+response.getBody().asString());
		
		int statusCode = response.getStatusCode();
		
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@org.testng.annotations.Test
	public void advanced() {
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);  //This is like assert
	
		given().get("https://reqres.in/api/users?page=2").then().body("data.id[0]",equalTo(7));   //check in url that first id is 7 or not
		
		
		//we can join above both into 1
		
		given()
		    .get("https://reqres.in/api/users?page=2")
		.then()
		   .statusCode(200)
		   .body("data.id[0]", equalTo(7));
	}
}
