//This is without static import - which means you need to create object of RestAssured. See next class which is static

package restAssured.RestAssurePractice1;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test {

@org.testng.annotations.Test
	public void getRequest()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
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
}
