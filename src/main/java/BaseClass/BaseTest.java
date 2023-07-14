package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
	
	public static Properties prop;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/RestAssured/src/main/java/Properties/config.properties");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		
		}
	}

}
