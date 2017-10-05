package automation;

import static org.junit.Assert.*;

import java.util.ArrayList;
// import java.util.concurrent.TimeUnit;

import org.junit.Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyCarTravel {

	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {		
		System.setProperty("webdriver.chrome.driver", "chromedriver_230_linux64");
		driver = new ChromeDriver();			
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();  
		driver.quit();  		  						
	}
	
	@Test
	public void LaunchWebsite() {
        // Initialize
        String urlString = "https://mycartravel.com/";

        // Execution
        driver.get(urlString);
        driver.manage().window().maximize();

        // Validation
        String observedUrlString = driver.getCurrentUrl();
        assertEquals(urlString, observedUrlString);		
	}
	
	@Test
	public void LaunchWebisteWWW() {
        // Initialize
        String urlString = "https://www.mycartravel.com/";

        // Execution
        driver.get(urlString);
        driver.manage().window().maximize();

        // Validation
        String observedUrlString = driver.getCurrentUrl();
        assertEquals(urlString, observedUrlString);				
	}
	
	@Test
	public void ClickReservationsButton() {
		// Initialize
		String urlString = "https://www.mycartravel.com/";
				
		// Execution
		driver.get(urlString);
		driver.manage().window().maximize();
				
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		driver.findElement(By.linkText("Reservations")).click();
		
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));		
		
		// Validation
        String observedUrlString = driver.getCurrentUrl();
        String expectedUrlString = "https://art-jimmy.github.io/reservations";
        assertEquals(expectedUrlString, observedUrlString);
        
        driver.switchTo().window(tabs2.get(0));
	}
	
}
