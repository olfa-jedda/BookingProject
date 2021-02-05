package testRunners;

//import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue= {"stepDefinitions"}, tags= "@flight",plugin = {"pretty", "html:target/cucumber"})
//@CucumberOptions(features="src/test/resources/features", glue= {"stepDefinitions"}, tags= "@login or @profile")
//@CucumberOptions(features="features", glue= {"stepDefinitions"}, tags= "@login or @flight")
public class runner {

	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("booking page is opened");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\olfa_\\eclipse-workspace\\firstprojectfinalversion\\src\\test\\resources\\driver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
	public class RunWith {

	}

}
