package organizationpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationTab;
	
	@FindBy(xpath ="//a[text()='Products']")
	private WebElement productLink; 
	
	@FindBy(linkText  = "More")
	private WebElement more;
	
     @FindBy(xpath="//a[@name='Campaigns']")
     private WebElement campaignLink;
     
     @FindBy(linkText = "Contacts")
     private WebElement contactLink;
     
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getOrganizationTab() {
		return organizationTab;
	}
	
	public WebElement getMore() {
		return more;
	}

	public void orgLink()
	{
		organizationTab.click();
	}
	
    public void productLink()
    {
    	productLink.click();
    }
    
    public void moreLink()
    {
    	more.click();
    }
    public void campaign()
    {
    	campaignLink.click();
    }
    
    public void conlink()
    {
    	contactLink.click();
    }
    
    public void signout(WebDriver driver) throws Throwable
    {
    	 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    	 
    }
}
