package automation;

import static org.junit.Assert.*;
// import java.util.ArrayList;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
// import org.junit.Test;
// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yelp {
	
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {				
		System.setProperty("webdriver.chrome.driver", "chromedriver_233_linux64");
		driver = new ChromeDriver();				
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();  
		driver.quit();  		  							
	}
	
	@Test
	public void LaunchYelpSite() {
        // Initialize
        String urlString = "https://www.yelp.com/biz/my-car-travel-tukwila";

        // Execution
        driver.get(urlString);
        driver.manage().window().maximize();

        // Validation
        String observedUrlString = driver.getCurrentUrl();
        assertEquals(urlString, observedUrlString);		
	}
	
}
