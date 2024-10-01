package LambdaTest.TestNG;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest {

	public WebDriver driver;
    public String gridURL = "https://hub.lambdatest.com/wd/hub"; // LambdaTest Grid URL
    
	
	@BeforeClass(alwaysRun = true)
    @Parameters({"browser", "version", "platform", "url"})
	public void setup(String browser, String version, String platform, String url) throws MalformedURLException {
    	
    	HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", "prasathvp475");
        ltOptions.put("accessKey", "h8pE2NqubanZJpMGGk57oxLz2Ys3c684NKLjYkpXSfR2GmiIz9");
        ltOptions.put("project", "TestNG Certification");
        ltOptions.put("w3c", true);
        ltOptions.put("name", "Test on "+browser+" in "+platform); // test name
        ltOptions.put("build", "TestNG ");
        ltOptions.put("network", true); // Enable network logs
        ltOptions.put("video", true); // Enable video recording
        ltOptions.put("console", true); // Enable console logs
        ltOptions.put("visual", true); // Enable screenshots
        
    	switch (browser) {
            case "Chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion(version);
                chromeOptions.setPlatformName(platform);
                chromeOptions.setCapability("LT:Options", ltOptions);          
                driver = new RemoteWebDriver(new URL(gridURL), chromeOptions);
                break;
            case "MicrosoftEdge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setBrowserVersion(version);
                edgeOptions.setPlatformName(platform);
                edgeOptions.setCapability("LT:Options", ltOptions);                     
                driver = new RemoteWebDriver(new URL(gridURL), edgeOptions);
                break;
            case "Firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBrowserVersion(version);
                firefoxOptions.setPlatformName(platform);
                firefoxOptions.setCapability("LT:Options", ltOptions);               
                driver = new RemoteWebDriver(new URL(gridURL), firefoxOptions);
                break;
            case "Internet Explorer":
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setBrowserVersion(version);
                ieOptions.setPlatformName(platform);
                ieOptions.setCapability("LT:Options", ltOptions);               
                driver = new RemoteWebDriver(new URL(gridURL), ieOptions);
                break;
        }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
	}
        
        @AfterClass(alwaysRun = true)
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
}
