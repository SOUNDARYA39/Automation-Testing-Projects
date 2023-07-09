package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_utility {

	

	public void waitForPageToLoad(WebDriver driver )
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	public void switchToWindow(WebDriver driver, String PartialtWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialtWindowTitle))
			{
				break;
			}
		}
	}
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();;
	}
	

	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	public void switchToFrame(WebDriver driver, int Index)
	{
		driver.switchTo().frame(Index);
	}
	
	public void handleDropDown(WebElement element,int Index )
	{
		Select sel = new Select(element);
		sel.selectByIndex(Index);
	}
	
	public void handleDropDown(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void handleDropDown1(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void mouseHoverOnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	public void rightClickoOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void moveByOffest(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}

	//public void scrollDown(WebElement element,)
	public String signOut(WebElement element,WebDriver driver)
	{
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement ele = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		ele.click();
		return null;
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/*public void save(WebElement element, WebDriver driver)
	{
		WebElement saveele = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		saveele.click();
		}*/
	
}
