package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {

	public CreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrg;

	@FindBy(name="accountname")
	private WebElement orgName;
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhoneno() {
		return phoneno;
	}

	public WebElement getEmail() {
		return emailco;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(id="phone")
	private WebElement phoneno;
	
	@FindBy(id="email1")
	private WebElement emailco;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	public void coplus()
	{
		createOrg.click();
	}
	
	/*public void organizationName(String accName)
	{
		orgName.sendKeys(accName);
	}
	
	public void phoneNumber(String phone)
	{
		phoneno.sendKeys(phone);
	}
	
	public void emailAdd(String email)
	{
		emailco.sendKeys(email);
	}*/

	public void orgData(String accNmae, String phone, String email)
	{
		orgName.sendKeys(accNmae);
		phoneno.sendKeys(phone);
		emailco.sendKeys(email);
	}
	
	public void saveButtonco()
	{
		saveButton.click();
	}
}
