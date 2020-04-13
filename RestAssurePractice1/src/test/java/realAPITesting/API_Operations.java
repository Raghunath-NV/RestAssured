/*Created my own local API - refer https://github.com/typicode/json-server or https://youtu.be/IbJdcApXziU*/

package realAPITesting;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class API_Operations {

	// @Test
	public void get() {
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();

	}

	// @Test
	public void parametrizedGet() // ex :
									// http://localhost:3000/users?firstName=Anil
	{
		baseURI = "http://localhost:3000";
		given().param("firstName", "Anil").get("/users").then().statusCode(200).log().all();

	}

	// @Test
	public void post() {
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("id", 4);
		request.put("subjectid", 2);
		request.put("firstName", "Sachin");
		request.put("lastName", "T");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();

	}

	// @Test
	public void patch() // for updating a record
	{
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("lastName", "Tendulkar");

		given().contentType(ContentType.JSON).accept(ContentType.JSON).header("Content-Type", "application/json")
				.body(request.toJSONString()).when().patch("/users/4").then().statusCode(200).log().all();
	}

	@Test
	public void delte() {
		baseURI = "http://localhost:3000";
		JSONObject request = new JSONObject();
		request.put("name", "Ram");
		request.put("job", "teacher");

		when().delete("users/4").then().statusCode(200);
	}
}
