package restAssured.RestAssurePractice1;
import  static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class GetRequest {

	@org.testng.annotations.Test
	public void test1()
	{
		given()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		  .statusCode(200)  // this will check response code
		  .body("data.id[1]", equalTo(8))  //check whether second id in response is 8 or not
		  .body("data.first_name", hasItems("Rachel","Lindsay"))  //check whether first names in response has these or not
		  .log().all();   // this will print response
	}
}
