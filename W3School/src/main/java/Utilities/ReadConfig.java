package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadConfig {
	Properties prop;
	 public ReadConfig() throws IOException
	 {
		 FileInputStream fis;
		 try {
			fis = new FileInputStream("src/main/java/resources/config.properties");
			prop = new Properties();
		     prop.load(fis);
			 
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 }
		
	 public String getURL() 
	 { 
		 return prop.getProperty("url"); 
	 }
	 public  String getEmailId() {
		 return prop.getProperty("email");
	 }
	 public  String getFirstname (){
		 return prop.getProperty("firstname");
	 }
	 public  String getLastname() {
		 return prop.getProperty("lastname");
	 }
	 public  String getPassword() {
		 return prop.getProperty("password");
	 }
	 public  String getSearchData() {
		 return prop.getProperty("serarchData");
	 }
}





