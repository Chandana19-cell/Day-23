package Tests;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import Setup.PostData;

public class APIcall {

	public static void main(String[] args) throws ClientProtocolException, IOException, GeneralSecurityException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		// BaseTest testbase = new BaseTest();
		String URL = "https://apigwuat.kotak.com:8443/Fulcrum_Report";
		Enc enc1 = new Enc();
		String req1 = "{\r\n"
		        + "  \"userName\": \"KMBL00005\",\r\n"
		        + "  \"sfReferenceID\": \"a0OC30000010aisMAA\",\r\n"
		        + "  \"pan\": \"AAECM9963D\",\r\n"
		        + "  \"loanAppID\": \"SME/2023-24/000950\",\r\n"
		        + "  \"empName\": \"NikitaCredit\",\r\n"
		        + "  \"empId\": \"9850\"\r\n"
		        + "}";
		String key1 = "a19446820c1e414abe277cebe01119ba";
		String req = enc1.encrypt(req1, key1);
		// System.out.println(req);
		PostData postt = new PostData();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("ApiKey", "l71301b337df5c47388fa10d740c77fbc7");
		CloseableHttpResponse closeablehttpresp = postt.post(URL, req, headermap);
		int statuscode = closeablehttpresp.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		// System.out.println(closeablehttpresp.getEntity());
		String responsestr = EntityUtils.toString(closeablehttpresp.getEntity(), "UTF-8");
		// System.out.println(responsestr);
		Dec dec1 = new Dec();
		String resp1 = dec1.decrypt(responsestr, key1);
		System.out.println(resp1);

	}

}
