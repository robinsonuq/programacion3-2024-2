package flujosDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {


	public static void main(String[] args) {
		Properties properties= new Properties();

		try {
			properties.load(new FileInputStream(new File("src/resources/user.properties")));
			System.out.println(properties.get("name"));


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
