package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {
	
	public DeleteProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@value='Delete'])[2]")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	public void delete() {
		deleteButton.click();
		
	}

}
