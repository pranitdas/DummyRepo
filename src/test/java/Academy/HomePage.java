package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


public class HomePage extends Base {
	WebDriver driver;
	
	@BeforeTest
	public void prerequisite() throws IOException
	{
		driver= initiationDriver();
		
	}
	
	@Test(dataProvider="GetData")
	public void BasePageNavigation( String username, String password, String text1) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.login().click();
		LoginPage lp=new LoginPage(driver);
		lp.email().sendKeys(username);
		lp.password().sendKeys(password);
		lp.LoginBtn().click();
		System.out.println(text1);
		//driver.close();
	}
	
	@DataProvider
	public Object[][] GetData()
	{
		//row stands for how many different data should run
		//column is how many values per test
		Object[][] data= new Object[2][3];
		data[0][0]="Unrestricted user@gmail.com";
		data[0][1]="Password";
		data[0][2]="Unrestricted user";
		
		data[1][0]="Restricted user@gmail.com";
		data[1][1]="Password1";
		data[1][2]="Restricted user";
		return data;
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
