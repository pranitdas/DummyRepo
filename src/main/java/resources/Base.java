package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	protected Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initiationDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\00555U744\\Box\\Selenium Projects\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\00555U744\\Box\\Selenium Projects\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\00555U744\\Box\\Selenium Projects\\Drivers\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\00555U744\\Box\\Selenium Projects\\Drivers\\edgedriver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\00555U744\\Box\\Selenium Projects\\Drivers\\IEDriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String TakeScreenshotPath(String testCaseName, WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		try {
			FileUtils.copyFile(source, new File(destFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
	
		}
		return destFile;
	}
	

}
