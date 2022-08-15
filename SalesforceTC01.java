package marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SalesforceTC01 extends ProjectSpecificMethods {
		
	@BeforeTest
	public void setup() {
		
		browserName = "Chrome";
		excelName = "SalesforceTC01";
	}
	

	@Test(dataProvider="fetch")
	public void runSalesforceTC01(String Question,String Details) throws InterruptedException {

		//Type Content on the Search box

		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");

		//Click Content Link

		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();

		//Click on Chatter Tab

		WebElement element = driver.findElement(By.xpath("//span[text()='Chatter']"));

		driver.executeScript("arguments[0].click();", element);
		
		Thread.sleep(5000);
		
		//Verify Chatter title on the page
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		// Click Question tab
		
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		
		//Type Question with data (coming from excel)
		
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(Question);	
		
		//Type Details with data (coming from excel)
		
		////div[contains(@class,'ql-editor ql-blank')]
	
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(Details);	
		
		//Click Ask
	
		//button[text()='Ask']
		
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		
		//13) Confirm the question appears

		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		
		System.out.println(text);
		
		
	}

}
