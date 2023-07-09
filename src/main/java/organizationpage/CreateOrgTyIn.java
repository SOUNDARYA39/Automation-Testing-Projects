package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.Webdriver_utility;

public class CreateOrgTyIn {
	
	public CreateOrgTyIn(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement orgplus;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgna;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement orgind;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement orgtyp;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveClick;
	

	public WebElement getSaveClick() {
		return saveClick;
	}

	public WebElement getOrgtyp() {
		return orgtyp;
	}

	public WebElement getOrgind() {
		return orgind;
	}

	public WebElement getOrgplus() {
		return orgplus;
	}

	public WebElement getOrgna() {
		return orgna;
	}
	
     public void orgClick()
     {
    	 orgplus.click();
     }
     
     public void orgaName(String orgname)
     {
    	 orgna.sendKeys(orgname);
     }
     
     public void orgindustry(String industry)
     {
    	Webdriver_utility wlib = new  Webdriver_utility();
    	wlib.handleDropDown1(orgind, industry);
     }
    public void orgType(String type)
    {
    	Webdriver_utility wlib=new Webdriver_utility();
    	wlib.handleDropDown1(orgtyp, type);
    }
	
    public void saveButton()
    {
    	saveClick.click();
    }
}
