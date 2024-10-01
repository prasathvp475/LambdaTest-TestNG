package LambdaTest.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Scenario1 extends BaseTest{

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass(alwaysRun = true)
    public void setUp()
	{
      this.driver = super.driver;
    }
	
	@Test(priority = 1,timeOut=20)
    public void validateTitle() {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("LambdaTest"));
    
        softAssert.assertEquals(driver.getTitle(), "LambdaTest");
        
        System.out.println("Test continues even after soft assert failure");
        
        softAssert.assertAll();
    }
}
