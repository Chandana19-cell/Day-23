package Tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import BaseClass.BaseTest;
import Setup.PostData;

public class actualtest extends BaseTest {
	
	
	/*public void setUp() {
		testbase = new BaseTest();
		URL = prop.getProperty("URL");
		req = prop.getProperty("Request");
	}*/
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		//BaseTest testbase = new BaseTest();
		String URL = "https://apigwuat.kotak.com:8443/v3/Pan_Bank";
		//String req = "GJsdUPqMiK8jVtFv9NPIKgW6JdF2DcpYrDIVzkulwTYLytDJD78+VFNkJdwF8cezW/42r83Di8NuJtco7zydoSPq/fXdg9JkzEjvfFa4OiV0q8o3KYKbIvKFZEP/rdJejU/3GVE2rEcp6wq/QFG5k9gV6ubIL2TSNoiH6T+rB8nOsqx0YhtU7xK09+8kp4DTQ8fu/F5wa3b5O+mi78elsRoQmZNzmtvGJ17rkLRHv8iQ0vqLfAO8xPIrDn0WMogjLohxBQw9vgScu6dNue56KA==";
		String req = "GJsdUPqMiK8jVtFv9NPIKgW6JdF2DcpYrDIVzkulwTYLytDJD78+VFNkJdwF8cezW/42r83Di8NuJtco7zydoSPq/fXdg9JkzEjvfFa4OiV0q8o3KYKbIvKFZEP/rdJejU/3GVE2rEcp6wq/QFG5k7Ej/ecX2SlEWwSmdTE/V07GepyZAIu1rxHbYI4Oj+CcoBTc8KBVYkw8nbZNilqPDzMBZDmgbUstM8DMdRnSxQ08VUwNCRuNRyN5ncnCE3WdX36ygFqCE43EewDOStOA/g==\r\n";
		PostData postt = new PostData();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("ApiKey", "28bcb6bfb2038144ca5aa3f84d7f3c7a");
		CloseableHttpResponse closeablehttpresp = postt.post(URL, req, headermap);
		int statuscode = closeablehttpresp.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		//System.out.println(closeablehttpresp.getEntity());
		String responsestr = EntityUtils.toString(closeablehttpresp.getEntity(), "UTF-8");
		System.out.println(responsestr);

	}

}
