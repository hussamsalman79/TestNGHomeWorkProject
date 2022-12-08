package utlis;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driver {
	
	public static WebDriver driver; 
	
	public static WebDriver getDriver() {
		if (driver==null) {
			System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\hkarmah\\Desktop\\Tools\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); 	
		}		
		return driver; 
	}
	
	
	public static void quitDriver() {
		
		if (driver != null) {
			driver.quit();
			driver = null; // set it back to null so we can keep use it in the getDriver method
		}
		
		
	}

}
