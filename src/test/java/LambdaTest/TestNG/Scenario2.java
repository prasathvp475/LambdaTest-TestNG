package LambdaTest.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Scenario2 extends BaseTest{

	WebDriver driver;
	@BeforeClass(alwaysRun = true)
    public void setUp()
	{
      this.driver = super.driver;
    }
	@Test(priority = 2)
    public void checkboxDemo() {
        driver.findElement(By.linkText("Checkbox Demo")).click();
        
        By singleCheckbox = By.id("isAgeSelected");
        driver.findElement(singleCheckbox).click();
        
        Assert.assertTrue(driver.findElement(singleCheckbox).isSelected(), "Checkbox is not selected");

        driver.findElement(singleCheckbox).click();
        
        Assert.assertFalse(driver.findElement(singleCheckbox).isSelected(), "Checkbox is still selected");
    }
	
}
