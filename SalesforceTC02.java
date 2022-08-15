package marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceTC02 extends ProjectSpecificMethods {

	@BeforeTest
	public void setup() {
		
		browserName = "Edge";
		excelName = "SalesforceTC02";
	}
	
	@Test(dataProvider="fetch")
	public void runSalesforceTC02(String Salut,String LastName) throws InterruptedException {


		//Type Individuals on the Search box

		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");

		//Click Individuals Link

		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		//Click New

		WebElement element = driver.findElement(By.xpath("//div[text()='New']"));

		driver.executeScript("arguments[0].click();", element);

		//Select Salutation with data (coming from excel)

		driver.findElement(By.xpath("//a[@class='select']")).click();

		//a[@title='Mr.']

		driver.findElement(By.xpath("//a[@title="+Salut+"]")).click();

		//Enter the Last Name

		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);

		//Click on save

		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

		/*
		 * 
		 *  11) Click on the App Launcher (dots)
			12) Click View All
			13) Type Customers on the Search box
			14) Click Customers Link
			15) Click New
			16) Type the same name provided in step 8 and confirm it appears
			17) Close the browser
		 */

		Thread.sleep(5000);
		//11) Click on the App Launcher (dots)

		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//Click View All

		driver.findElement(By.xpath("//button[@class='slds-button']")).click();

		Thread.sleep(5000);

		//Type Customers on the Search box

		driver.findElement(By.xpath("//label[text()='Search apps or items...']/following::input")).sendKeys("Customers");

		// Click Customers Link

		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		Thread.sleep(3000);

		//Click New

		WebElement element1 = driver.findElement(By.xpath("//div[text()='New']"));

		driver.executeScript("arguments[0].click();", element1);

		//Type the same name provided in step 8 and confirm it appears
		

		//input[contains(@class,'default input')]
		
	    driver.findElement(By.xpath("//input[contains(@class,'default input')]")).sendKeys("S");
		

	    String Name = driver.findElement(By.xpath("//div[@class='primaryLabel slds-truncate slds-lookup__result-text']")).getText();
	    
	    System.out.println(Name);
	}

}
