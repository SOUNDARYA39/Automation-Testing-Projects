package organizationpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/*@FindBy(name="accountname")
	private WebElement orgName;
	*/
	
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

	public void orgData(String accName, String phone, String email)
	{
		orgName.sendKeys(accName);
		phoneno.sendKeys(phone);
		emailco.sendKeys(email);
	}
	
	public void saveButtonco()
	{
		saveButton.click();
	}
	
	@FindBy(linkText = "Contacts")
	private WebElement conlink;
	
	public WebElement getEmailco() {
		return emailco;
	}

	public WebElement getConlink() {
		return conlink;
	}

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement crecon;
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement firstnameDropdown;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnameTextfield;
	
	@FindBy(xpath="(//img[@title='Select'][1])")
	private WebElement orgSel;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchOrg;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNow;

	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getSearchOrg() {
		return searchOrg;
	}

	public WebElement getCrecon() {
		return crecon;
	}

	public WebElement getFirstnameDropdown() {
		return firstnameDropdown;
	}

	public WebElement getFirstnameTextfield() {
		return firstnameTextfield;
	}

	public WebElement getOrgSel() {
		return orgSel;
	}
	
	public void createContact()
	{
		crecon.click();
	}
	

	public void firstNameDD(String firstdd)
	{
		firstnameDropdown.sendKeys(firstdd);
		
	}
	public void firstNameTT(String firstName)
	{
		firstnameTextfield.sendKeys(firstName);
		
	}
	
	public void organizationSel()
	{
		orgSel.click();
	}
	
	public void orgSearch(String accName)
	{
		searchOrg.sendKeys(accName);
	}
	
	public void searchNowButton()
	{
		searchNow.click();
	}
	
	public void contactLink()
	{
		conlink.click();
	}
	
	
	
	public void dynamicData(WebDriver driver,String accName)
	{
		driver.findElement(By.xpath("//a[text()='"+accName+"']")).click();
	}
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement conSave;

	public WebElement getConSave() {
		return conSave;
	}
	
	public void contactSave()
	{
		conSave.click();
	}
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextfield;

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}
	
	public void lastName(String lastname)
	{
		lastNameTextfield.sendKeys(lastname);
	}
}
