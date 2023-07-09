package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaign;
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	
	public WebElement getCreatecampaign() {
		return createcampaign;
	}

	public WebElement getSaveButtonCam() {
		return saveButtonCam;
	}

	public WebElement getSelectpro() {
		return selectpro;
	}

	public WebElement getSearchpro() {
		return searchpro;
	}

	public WebElement getSearch() {
		return search;
	}
	public WebElement getCampaignName() {
		return campaignName;
	}

	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButtonCam;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectpro;
	
	@FindBy(name="search_text")
	private WebElement searchpro;
	
	@FindBy(name="search")
	private WebElement search;
	

	
	public void campName(String camp) 
	{
		campaignName.sendKeys(camp);
	}
	
	public void pluscamp() 
	{
		createcampaign.click();
	}

	public void selectSwitching()
	{
		selectpro.click();
	}
	
	public void searchPro(String prddata)
	{
		searchpro.sendKeys(prddata);
	}
	
	public void searchButton()
	{
		search.click();
	}
	
	public void saveButton()
	{
		saveButtonCam.click();
	}
	

}
