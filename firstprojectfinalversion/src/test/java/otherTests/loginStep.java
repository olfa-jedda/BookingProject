package otherTests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStep {
	
		public static WebDriver driver;
		
		@Given("open chrome")
		public void open_chrome() {
			
			System.out.println("Open chrome and start application");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\olfa_\\eclipse-workspace\\firstproject\\driver\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@Given("start application")
		public void start_application() {
			
			driver.get("https://www.booking.com/");
			String pageTitle = driver.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		}
		
		@When("click on login button")
		public void click_on_login_button() {
			
			WebElement connect = driver.findElement(By.xpath("//span[contains(text(),\"Se connecter\")]"));
			connect.click();
		
		}

		@Then("connection page is opened")
		public void connection_page_is_opened() {
			
			String pageTitle1 = driver.getTitle();
			Assert.assertEquals("Booking.com Account", pageTitle1);
			
			WebElement subtitle1 = driver.findElement(By.xpath("//h1[contains(text(),\"Se connecter\")]"));
			String textsubtitle1 = subtitle1.getText();
			Assert.assertEquals("Se connecter", textsubtitle1);			

		}	

		@When("enter valid email")
		public void enter_valid_email() {
			
			//System.out.println("enter valid email and click on next button");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			username.sendKeys("olfa_jedda@outlook.com");
		}

		@When("click on next button")
		public void click_on_next_button() {
			
			WebElement next = driver.findElement(By.xpath("//span[contains(text(),\"Suivant\")]"));		
			next.click();
		}

		@Then("password page is displayed")
		public void password_page_is_displayed() {
		   
			//System.out.println("password page is displayed");
			driver.findElement(By.xpath("//h1[contains(text(),\"Indiquez votre mot de passe\")]"));
			//WebElement subtitle2 = driver.findElement(By.xpath("//h1[contains(text(),\"Indiquez votre mot de passe\")]"));
			//String textsubtitle2 = subtitle2.getText();
			//Assert.assertEquals("Indiquez votre mot de passe", textsubtitle2);
		}

		@When("enter valid password")
		public void enter_valid_password() {

			//System.out.println("enter valid password and click on login button");
			WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
			password.sendKeys("docteur2018");
		}
				
		@When("click on login button1")
		public void click_on_login_button1() {
			
			WebElement connect1 = driver.findElement(By.xpath("//button[@type=\"submit\"]"));		
			connect1.click();
		}
		
		@Then("user should be able to login successfully")
		public void user_should_be_able_to_login_successfully() {
			
			//System.out.println("user should be able to login successfully");
			driver.findElement(By.xpath("//span[contains(text(), \"quelle sera votre prochaine destination\")]"));
			
			//WebElement button1 = driver.findElement(By.xpath("//*[@class=\"user_center_option uc_account js-uc-account logged_in_user resize_login_popover\"]"));
			//button1.click();
			//WebElement button2 = driver.findElement(By.name("Gérer mon compte"));
			//System.out.println("Gérer mon compte");
			//String textbutton2 = button2.getText();
			//System.out.println(textbutton2);
			//Assert.assertEquals("Gérer mon compte", textbutton2);
		}
}
