package day4;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParsingJSONResponseData {
	@Test(priority = 1)
	void testJsonResponse() {
		// approach
	/*	given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/book")		
		
		.then()
			.statusCode(200)
			.header("Content-type", "application/json; charset=uft-8");
		*/
		
	//approach 2
		
		Response res = given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("http://localhost:3000/store");
		
	/*	Assert.assertEquals(res.getStatusCode(),200);   //validation 1
		Assert.assertEquals(res.header(Content-Type),"application/json; charset=utf-8");
		
		String bookname =res.jsonPath().get("book[3].title").toString();		
		Assert.assertEquals(bookname, "The Lord of the Rings");
		
		*/	
		
		
	//approach 3  JSONObject class
		
		JSONObject jo = new JSONObject (res.toString()); //converting response to json object type
		
	/*	for(int i=0;i<jo.getJSONArray("book").length();i++)			
		{
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(bookTitle);
	*/	
		boolean status = false;	
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			
			if (bookTitle.equals("The Lord Of the Rings")) 
			{
				status = true;
				break;
			}
		}
			
		
			
			//not found
			
			Assert.assertEquals(status, true);
			
		//validate the price of books
			
			double totalprice =0;
			for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String price = jo.getJSONArray("books").getJSONObject(i).get("price").toString();
				totalprice = totalprice+ Double.parseDouble(price);
				System.out.println("Total Price is : "+totalprice);
				
				Assert.assertEquals(status, true);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
					
	}
}