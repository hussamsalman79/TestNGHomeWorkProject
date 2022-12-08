package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utlis.driver;

public class GuruPage {
	
	// Create a constructor
		public GuruPage() {
			 PageFactory.initElements(driver.getDriver(), this);// Initialize  

}
		
		@FindBy(linkText = "Click Here")
		public WebElement ClickHereLink; 
		
		@FindBy(name ="emailid")
		public WebElement emailField; 
		
		@FindBy(name ="btnLogin")
		public WebElement submitBtn; 
		
		//td[contains(text(), 'mngr')] - alternative way to find the user id element text
		@FindBy(xpath= "//td[text()='User ID :']/following-sibling::td")
		public WebElement userIdValue; 
		
		@FindBy(xpath= "//td[text()='Password :']/following-sibling::td")
		public WebElement passwordValue; 
		
		@FindBy(xpath= "//h3[contains(text(), 'valid only for 20 days.')]")
		public WebElement accessValidDurationText; 
		
		
}
