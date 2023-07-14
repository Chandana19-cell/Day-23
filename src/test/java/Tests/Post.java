package Tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseTest;
import Setup.PostData;



public class Post extends BaseTest {
	BaseTest testbase;
	String URL;
	PostData postt;
	String req;
	CloseableHttpResponse closeablehttpresp;
	@BeforeMethod 	
	public void setUp() {
		testbase = new BaseTest();
		URL = prop.getProperty("URL");
		req = prop.getProperty("Request");
	}
	
	@Test
	public void postAPItest() throws ClientProtocolException, IOException {
		postt = new PostData();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("ApiKey", "28bcb6bfb2038144ca5aa3f84d7f3c7a");
		closeablehttpresp = postt.post(URL, req, headermap);
		int statuscode = closeablehttpresp.getStatusLine().getStatusCode();
		System.out.println(closeablehttpresp.toString());
	}
	/*public static void main(String[] args) {
		postt = new PostData();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("ApiKey", "28bcb6bfb2038144ca5aa3f84d7f3c7a");
		closeablehttpresp = postt.post(URL, req, headermap);
		int statuscode = closeablehttpresp.getStatusLine().getStatusCode();
		System.out.println(closeablehttpresp.toString());
	}*/

}
