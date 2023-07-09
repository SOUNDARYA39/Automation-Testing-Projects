package organizationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement userNameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//@FindBys({@FindBy(id="submitButton"),@FindBy(xpath = "(//input[@type='submit'])")})
	//@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	//private WebElement loginButton;
	
//getters method

	public WebElement getUserNameTextfield() {
		return userNameTextfield;
	}


	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//bussiness logic
	public void loginToApp(String Username, String Password)
	{
		userNameTextfield.sendKeys(Username);
		passwordTextfield.sendKeys(Password);
		loginButton.click();
	}

}
