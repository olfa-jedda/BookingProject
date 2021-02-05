package otherTests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features="features", glue= {"stepDefinitions"})
//@CucumberOptions(features="features", glue= {"stepDefinitions"}, tags= "@login or @flight")
@CucumberOptions(features="features", glue= {"stepDefinitions"}, tags= "@login")
public class runner {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openingPage() {
		System.out.println("booking page is opened");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\olfa_\\eclipse-workspace\\firstprojectfinalversion\\src\\test\\resources\\driver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
	}
	public class RunWith {

	}
	@AfterClass
	public void closingPage() {
		driver.close();
		driver.quit();
	}
}
