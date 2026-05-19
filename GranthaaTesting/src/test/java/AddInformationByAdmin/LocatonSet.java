package AddInformationByAdmin;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatonSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			//---- First Admin Login------
			driver.get("https://granthaadeveloperpvtltd.com/qa/");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys("admin@example.com");
			 driver.findElement(By.id("password")).sendKeys("password");
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 
			 
			 //--Wait for login success ---//
			 wait.until(ExpectedConditions.urlContains("/admin"));
			 
			 //NOW open add_location (session exists now)
			 driver.get("https://granthaadeveloperpvtltd.com/qa/admin/add_location");
			 
			// Create Location  
			 List<String> locations = Arrays.asList(
	                    "Chimur",
	                    "Chandrapur",
	                    "Ponbhurna",
	                    "Shivni",
	                    "Morwa"
			
			);
			 
			 for (String loc : locations) {
				 
				 // Wait for modal input field
				 WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//input[@placeholder='Enter your site location']")));
				 
				 //Enter location
				 
				 input.clear();
				 input.sendKeys(loc);
				 
				 //Click Save button
				 
				 wait.until(ExpectedConditions.elementToBeClickable(
	                        By.xpath("//button[@type='submit']")
	                )).click();
				 
				 //HANDLE ALERT (VERY IMPORTANT)
				 wait.until(ExpectedConditions.alertIsPresent());
				    driver.switchTo().alert().accept();
				 
				 
				
	 
				 System.out.println("Created: " + loc);
			 }
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			driver.quit();
		}
		

	}

}
