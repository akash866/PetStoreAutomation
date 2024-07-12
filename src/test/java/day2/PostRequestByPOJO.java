package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
/*
 Different way to create POST request body
 1]Using Hashmap
 2]Org.JSON
 3]POJO Class
 4]External json file Data 
 */
public class PostRequestByPOJO {
		
	
 
		@Test(priority=1)	
		void testPostUsingPOJO() 
		{
			Pojo_PostRequest data = new Pojo_PostRequest();
			
			data.setName("Scott");
			data.setLocation("France");
			data.setPhone("123456");
			
			String coursesArr[]= {"C","C++"};
			data.setCourses(coursesArr);
			
			
			
			given()			
				.contentType("application/json")
				.body(data)				
			
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("name",equalTo( "Scott"))
				.body("location", equalTo("France"))
				.body("phone",equalTo( "123456"))
				.body("courses[0]",equalTo( "C"))
				.body("courses[1]",equalTo("C++"))
				//.header("Content-Type","application/json; charset=uft-8")
				.log().all();		
		}
					
		}
	
