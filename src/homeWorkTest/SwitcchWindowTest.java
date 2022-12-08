package homeWorkTest;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GuruPage;
import utlis.TestDataReader;
import utlis.driver;

public class SwitcchWindowTest {
	@Test
	public void windowTest() throws InterruptedException {
		driver.getDriver().get(TestDataReader.getProperty("guruUrl"));
		driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		// Get the title and store it in a variable.
		String titlePage = driver.getDriver().getTitle(); 
		
		//Click on Click Here button  
		GuruPage guruPage = new GuruPage(); 
		guruPage.ClickHereLink.click();
		//switch over to next window 
		// In order to switch to 2nd window, we need to get the IDs and store them into Set<>
		// Then iterate 
		Set <String> windowIds = driver.getDriver().getWindowHandles(); 
		Iterator<String> itr = windowIds.iterator();  
		// Moves to the next page
		String firstWindowId = itr.next();
		String secondWindowId = itr.next(); 
		driver.getDriver().switchTo().window(secondWindowId); 
		Thread.sleep(500);
		// provide an email jon.dow@gmail.com then click Submit
		guruPage.emailField.sendKeys(TestDataReader.getProperty("email"));
		guruPage.submitBtn.click();
		Thread.sleep(500);
		// Get text of the user ID and password
		//store them in variables, 
		String UserID = guruPage.userIdValue.getText(); 
		String Password = guruPage.passwordValue.getText(); 
		Thread.sleep(500);
		//print them out. 
		System.out.println("User Id is: " + UserID);
		System.out.println("Password is: " + Password);
		
		Thread.sleep(500);
		//Then verify the text “This access is valid only for 20 days.”
		
		String Validation =guruPage.accessValidDurationText.getText(); 
		
		Assert.assertEquals(Validation, TestDataReader.getProperty("credentialValidateText"));
		
	   //  Close the window.
		driver.getDriver().close();
		Thread.sleep(500);
		//Go back to the main window, 
		driver.getDriver().switchTo().window(firstWindowId); 
		Thread.sleep(500);
		//and get the title then verify it equals to your stored title.
		String mainPageTitle = driver.getDriver().getTitle(); 
		Assert.assertEquals(mainPageTitle, titlePage);
		Thread.sleep(500);
		
	    //Quit driver.
		driver.quitDriver();
		
		
	}

}
