package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {

	RemoteWebDriver driver;
	String excelName ="";
	
	String browserName ="Chrome";
	
	@Parameters({"url","username","password"})
	
	@BeforeMethod
	public void preCondition(String url,String username,String password ) {

		if (browserName.equals("Chrome")) {
			
			WebDriverManager.chromedriver().setup();

			//Handling browser notifications
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");

			//launching chrome

			 driver = new ChromeDriver(opt);
			
		} else if(browserName.equals("Edge")) {

			WebDriverManager.edgedriver().setup();

			//Handling browser notifications
			EdgeOptions opt = new EdgeOptions();
			opt.addArguments("--disable-notifications");

			//launching chrome

			 driver = new EdgeDriver(opt);
		}

		//launching salesforce

		driver.get(url);

		//maximize

		driver.manage().window().maximize();

		//adding implicit waits

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter the username

		driver.findElement(By.id("username")).sendKeys(username);

		//Enter the password

		driver.findElement(By.id("password")).sendKeys(password);

		//Click on login

		driver.findElement(By.id("Login")).click();

		//Click on the toggle menu button from the left corner

		driver.findElement(By.className("slds-icon-waffle")).click();

		//Click View All

		driver.findElement(By.xpath("//button[@class='slds-button']")).click();

	}
 
	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@DataProvider(name="fetch")
	public String[][] fetchData() throws IOException {
		
		String[][] data = Exceldata.readData(excelName);
		return data;
	}
}
