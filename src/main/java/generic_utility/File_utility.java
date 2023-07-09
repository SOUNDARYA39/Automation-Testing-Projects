package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	public String getStringKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/adselpropery.properties.txt");
		Properties pro= new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}

}
