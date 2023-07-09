package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgValidationPage {
	
	public OrgValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement orgNameVal;

	@FindBy(xpath="//span[@id='dtlview_Phone']")
	private WebElement orgPhoneVal;
	
	@FindBy(xpath="//span[@id='dtlview_Email']")
	private WebElement orgEmailVal;
	
	
	@FindBy(xpath="//span[@id='dtlview_Industry']")
	private WebElement orgInd;
	
	@FindBy(xpath="//span[@id='dtlview_Type']")
	private WebElement orgTyp;
	
	public WebElement getOrgInd() {
		return orgInd;
	}

	public WebElement getOrgTyp() {
		return orgTyp;
	}

	public WebElement getOrgPhoneVal() {
		return orgPhoneVal;
	}

	public WebElement getOrgEmailVal() {
		return orgEmailVal;
	}

	public WebElement getOrgNameVal() {
		return orgNameVal;
	}
	
	/*public String onv(WebDriver driver, String actData)
	{
		String data = orgNameVal.getText();
		return data;
	}*/
	
	public String orgNamev()
	{
		 return orgNameVal.getText();
	}
	
	public String orgPhonev()
	{
		return orgPhoneVal.getText();
	}
	
	public String orgEmailv()
	{
		return orgEmailVal.getText();
	}
	

	public String orgIndVal()
	{
		return orgInd.getText();
	}
	

	public String orgTypVal()
	{
		return orgTyp.getText();
	}
}
