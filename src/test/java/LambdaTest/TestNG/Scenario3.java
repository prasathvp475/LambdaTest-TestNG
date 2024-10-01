package LambdaTest.TestNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.*;

public class Scenario3 extends BaseTest{

	WebDriver driver;
	@BeforeClass(alwaysRun = true)
    public void setUp()
	{
      this.driver = super.driver;
    }
	
	 @Test(priority = 3)
	    public void jsAlertTest() {
	        driver.findElement(By.linkText("Javascript Alerts")).click();
	        
	        // Click on "Click Me" button for Alert box
	        driver.findElement(By.xpath("(//p[text()='JavaScript Alerts']//button")).click();
	        
	        // Switch to Alert
	        Alert alert = driver.switchTo().alert();
	        
	        // Validate Alert text
	        Assert.assertEquals(alert.getText(), "I am an alert box!", "Alert message mismatch");
	        
	        // Accept the alert
	        alert.accept();
	    }
}
