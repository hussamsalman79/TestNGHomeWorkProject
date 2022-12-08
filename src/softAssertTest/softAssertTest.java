package softAssertTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utlis.TestDataReader;
import utlis.driver;

public class softAssertTest {
	
		@Test 
		public void AmazonTestCase1() {
			driver.getDriver().get(TestDataReader.getProperty("amazonUrl"));
			driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
			
			
			// Create an AmazonPage object in order to use the elements that saved in AmazonPage
			AmazonPage amzonPage = new AmazonPage(); 
			Select letsSelect = new Select(amzonPage.departmentDropdown); 
			//get all the options in the departments select drop down
			List <WebElement> Options = letsSelect.getOptions(); 
			
			// We need to verify there are 59 departments
			SoftAssert softCheck = new SoftAssert(); 
			softCheck.assertEquals(Options.size(), 59);// this check did stop the test 
			
			
			//Assert.assertEquals(Options.size(),59);
			System.out.println(Options.size());
			
			// print all the departments
			
			for (WebElement departments : Options) {
				System.out.println(departments.getText());	
			}
			
			driver.quitDriver();
			softCheck.assertAll();// this code will mark the test pass or fail in soft assert
		}

}
