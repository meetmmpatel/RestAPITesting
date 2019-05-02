package ApiService;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class UsStatesAPIDemo {
  
  
  String URL_USSTATES = "http://services.groupkt.com/state/get/USA/";
  static RestTemplate restTemplate = new RestTemplate();
  
  
  @Test
  public void testApiEndPoint() {
	
	Scanner scanner = new Scanner(System.in);
	String stateName = scanner.nextLine();
	String URL = URL_USSTATES + stateName;
	System.out.println(URL);
	String result = restTemplate.getForObject(URL, String.class);
	System.out.println(result);

	JsonParser parser = new JsonParser();
	JsonObject jsonObject = (JsonObject) parser.parse(result).getAsJsonObject();
	String restResponse = jsonObject.getAsJsonObject("RestResponse")
			.get("messages").getAsString();
	System.out.println("My code: " + restResponse);
	
	
  }
  
  
}
