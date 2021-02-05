package otherTests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class title {

	@Test
	public void test() {
		
		System.out.println("Open chrome and start application");
	
				
		System.out.println("Reading chrome driver");       
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olfa_\\eclipse-workspace\\firstproject\\driver\\chromedriver.exe");
		
		System.out.println("Opening Chrome"); 
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		//Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		//Assert.assertEquals("les deux valeurs ne sont pas égales","Booking.com", pageTitle);
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		
	}

}
