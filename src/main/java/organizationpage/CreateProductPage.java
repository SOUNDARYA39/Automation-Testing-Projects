package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusButtonpro;
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement proName;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;
	
	

	public WebElement getCreatepro() {
		return  plusButtonpro;
	}

	public WebElement getProName() {
		return proName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	
	
	public void proplus()
	{
		plusButtonpro.click();
	}
	
	public void productName(String prddata)
	{
		proName.sendKeys(prddata);
	}
	
	public void save()
	{
		saveButton.click();
	}
	
	
}
