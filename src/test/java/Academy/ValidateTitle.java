package Academy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import pageObjects.LandingPage;
import resources.Base;


public class ValidateTitle extends Base {
	WebDriver driver;
	@BeforeTest
	public void prerequisite() throws IOException
	{
		driver= initiationDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void BasePageNavigation( ) throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		//Assert.assertEquals(l.featuredtext().getText(), "FEATURED COURSES123");
		//Assertion.assertEquals(l.featuredtext().getText(), "FEATURED COURSES123");
		Assert.assertEquals(l.featuredtext().getText(), "FEATURED COURSES2");
		Assert.assertTrue(l.navigationbar().isDisplayed());
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	


}
