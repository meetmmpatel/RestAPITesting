package ApiService;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.apache.http.HttpStatus.*;

public class DemoTest {
  
  
  @Test
  public void makeSureItWorks() {
	
	final String url = "http://services.groupkt.com/state/get/USA/all";
	
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class, SC_OK);
	System.out.println(result);
	
	
  }
  
  final String url = "http://dummy.restapiexample.com/api/v1/employees";
  
  @Test
  public void empApiTestCall() {
	
	
	RestTemplate restTemplate = new RestTemplate();
	String result = restTemplate.getForObject(url, String.class);
	System.out.println(result);
	
	
  }
  
  @Test
  public void empStatusCode() {
	
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> responseEntity =
			restTemplate.getForEntity(url, String.class);
	
	String code = String.valueOf(responseEntity.getStatusCode());
	
	Assert.assertEquals("200 OK", code);
	
	
  }
  
  
}
