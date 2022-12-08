package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utlis.driver;

public class AmazonPage {
	
	
	// Create a constructor
	public AmazonPage() {
		 PageFactory.initElements(driver.getDriver(), this);// Initialize  
		 
	 }
	
	@FindBy(id = "searchDropdownBox")
	public WebElement departmentDropdown; 
	
	
	@FindBy(id = "twotabsearchtextbox")
	public WebElement HomePageSearchBox; 
	
	
	@FindBy(id = "nav-search-submit-button")
	public WebElement HomePageSearchBtn; 
	
}
