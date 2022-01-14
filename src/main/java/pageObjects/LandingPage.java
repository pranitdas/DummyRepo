package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By login=By.xpath("//span[normalize-space()='Login']");
	By featuredtext= By.xpath("//h2[normalize-space()='Featured Courses']");
	By navigationbar= By.xpath("//div[@role='navigation']");
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	public WebElement featuredtext()
	{
		return driver.findElement(featuredtext);
	}
	public WebElement navigationbar()
	{
		return driver.findElement(navigationbar);
	}

}
