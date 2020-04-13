package restAssured.RestAssurePractice1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

public class PostRequest {

	@Test
	public void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Raghu");
		map.put("job", "engineer");
		
		JSONObject jsonObject=new JSONObject(map);    // converting map to json object for put POST

		
		given()
		   .body(jsonObject.toJSONString())
		.when()
		    .post("https://reqres.in/api/users")
		.then()
		     .statusCode(201)
		     .log().all();  //just to print response which is optional
		
		
		
		//Another way without using map object 
		
		JSONObject request=new JSONObject();
		request.put("name", "Rahul");
		request.put("job", "teacher");
		
		given().body(request).when().post("https://reqres.in/api/users").then().statusCode(201);
	}
	
	

}
