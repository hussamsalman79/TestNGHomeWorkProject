package homeWorkTest;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AmazonPage;
import utlis.TestDataReader;
import utlis.driver;

public class AmazonTests {
	
	//@Test 
	public void AmazonTestCase1() {
		driver.getDriver().get(TestDataReader.getProperty("amazonUrl"));
		driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		
		// Create an AmazonPage object in order to use the elements that saved in AmazonPage
		AmazonPage amzonPage = new AmazonPage(); 
		Select letsSelect = new Select(amzonPage.departmentDropdown); 
		//get all the options in the departments select drop down
		List <WebElement> Options = letsSelect.getOptions(); 
		
		// We need to verify there are 59 departments 
		Assert.assertEquals(Options.size(),59);
		System.out.println(Options.size());
		
		// print all the departments
		
		for (WebElement departments : Options) {
			System.out.println(departments.getText());	
		}
		driver.quitDriver();
	}
	
	@Test
	public void AmazonTestCase2() throws InterruptedException {
		//verify you are in the Home & Kitchen department.

		//go to amazon.com
		driver.getDriver().get(TestDataReader.getProperty("amazonUrl"));
		
		//verify that you are on the amazon home page. (verify with title). 
		Assert.assertEquals(driver.getDriver().getTitle(), 
				TestDataReader.getProperty("amazonTitle"));
		
		//verify drop down value is by default “All Departments”
		AmazonPage amzonPage = new AmazonPage(); 
		Select letsSelect = new Select(amzonPage.departmentDropdown); 
		//String FirstOption = letsSelect.getFirstSelectedOption().getText(); 
		Assert.assertEquals(letsSelect.getFirstSelectedOption().getText() , TestDataReader.getProperty("defaultDept"));
		
		//select department Home & Kitchen, and search for a coffee mug.
		letsSelect.selectByVisibleText("Home & Kitchen");
		amzonPage.HomePageSearchBox.sendKeys("Coffee Mug");
		amzonPage.HomePageSearchBtn.click();
		
		//verify you are on the coffee mug search results page (use title).  
		//String CoffeePageTitle = driver.getDriver().getTitle(); 
		Thread.sleep(500);
		Assert.assertEquals(driver.getDriver().getTitle(), "Amazon.com : Coffee Mug");
		
		//verify you are in the Home & Kitchen department.
		Assert.assertEquals(letsSelect.getFirstSelectedOption().getText() , "Home & Kitchen");
		driver.quitDriver();
		
	}
}
