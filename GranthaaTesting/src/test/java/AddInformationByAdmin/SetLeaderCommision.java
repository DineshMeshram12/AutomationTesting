package AddInformationByAdmin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetLeaderCommision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			//---- First Admin Login------
			driver.get("https://granthaadeveloperpvtltd.com/pms/");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys("admin@example.com");
			 driver.findElement(By.id("password")).sendKeys("password");
			 driver.findElement(By.xpath("//button[@type='submit']")).click();
			 
			 
			 //--Wait for login success ---//
			 wait.until(ExpectedConditions.urlContains("/admin"));
			 
			 //NOW open add_location (session exists now)
			 driver.get("https://granthaadeveloperpvtltd.com/pms/admin/add_commission");
			 
			 
			 //Select Site location
			 WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Choose a site location')]")));
			 dropdown.click();
			// Select option
			WebElement option= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Mul')]")));
			option.click();
			
			 //Select dropdown
			WebElement dropdownLeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Choose a leader')]")));
			dropdownLeader.click();
			 
			// Select leader
			 WebElement optionLeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Leader_1_124134')]")));
			 optionLeader.click();
			 
			 //Select Commission Type
			 
			  // Percentage
			 driver.findElement(By.xpath("//span[contains(text(),'Percentage')]")).click();
			 
			//or for Amount
		//	 driver.findElement(By.xpath("//span[contains(text(),'Amount')]")).click();
			 
			 //Enter Commission Value
			 WebElement commissionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("commission_value")));
			 
			 
			 commissionInput.clear();
			 commissionInput.sendKeys("10");
			 
			//Click Save button
			 
			 wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@type='submit']")
                )).click();
			 
			 //HANDLE ALERT (VERY IMPORTANT)
			 wait.until(ExpectedConditions.alertIsPresent());
			    driver.switchTo().alert().accept();
			    
			    System.out.println("Commission Set Successfully");
			    
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
			 
			 
			 
			 
			 
			 
	}	
			 

	}


