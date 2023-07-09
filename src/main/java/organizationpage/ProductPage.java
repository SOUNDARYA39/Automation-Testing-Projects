package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

}
