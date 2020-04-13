package restAssured.RestAssurePractice1;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostPatchDeleteRequest {

	//all code is same as post, instead of post you call put or patch methods
	
	@Test
	public void putRequest()
	{
		JSONObject request=new JSONObject();
		request.put("name", "Ram");
		request.put("job", "teacher");
		
		given().body(request).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void patchRequest()
	{
		JSONObject request=new JSONObject();
		request.put("name", "Ram");
		request.put("job", "teacher");
		
		given().body(request).when().patch("https://reqres.in/api/users/2").then().statusCode(200);
	}
	
	@Test
	public void delteRequest()
	{
		JSONObject request=new JSONObject();
		request.put("name", "Ram");
		request.put("job", "teacher");
		
		when().delete("https://reqres.in/api/users/2").then().statusCode(204);
	}
}
