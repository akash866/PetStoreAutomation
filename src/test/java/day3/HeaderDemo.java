package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;

public class HeaderDemo {
	
	//@Test(priority=1)
		void testHeader()
		{
			given()
			
			.when()
				.get("https://www.google.com/")
			
			.then()
				.header("Content-Type","text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding","gzip")
				.and()
				.header("Server","gws")
				.log().all();		
		}

		@Test(priority=1)
		void getHeader()
		{
			Response res = given()
			
			.when()
				.get("https://www.google.com/");
			
			//get single header info				
			//String headervalue = res.getHeader("Content-Type");
			//System.out.println("The value of Content-type header is :"+ headervalue );
				
			//get all headers info
				
			Headers myheaders=res.getHeaders();
				
			for(Header hd:myheaders )
			{
				System.out.println(hd.getName()+"   "+hd.getValue());
			}
				
				
				
			
			
			
			
			
			
			
			
			
			
			
			
				
				
				
				
		}
		
		
}
