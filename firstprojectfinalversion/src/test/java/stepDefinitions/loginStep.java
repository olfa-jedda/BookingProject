package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;

public class loginStep {
	
		WebDriver driver = runner.driver;		
		@Given("booking page is opened")
		public void booking_page_is_opened() {
			
			String pageTitle = driver.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		}
		
		@When("I click on login button")
		public void I_click_on_login_button() {
			
			System.out.println("I click on login button");
			WebElement connect = driver.findElement(By.xpath("//span[contains(text(),\"Se connecter\")]"));
			connect.click();
		
		}

		@Then("connection page is displayed")
		public void connection_page_is_displayed() throws InterruptedException {
			
			Boolean val = false;
			
			System.out.println("connection page is displayed");
			String pageTitle1 = driver.getTitle();
			Assert.assertEquals("Booking.com", pageTitle1);
			
			WebElement subtitle1 = driver.findElement(By.xpath("//h1[contains(text(),\"Se connecter\")]"));
			String textsubtitle1 = subtitle1.getText();
			Thread.sleep(2000);
			if(textsubtitle1.equalsIgnoreCase("Se connecter") || textsubtitle1.equalsIgnoreCase("Se connecter ou créer un compte")) {
				val = true;
		    }
			Assert.assertTrue(val == true);	

		}	

		@When("I enter valid email")
		public void I_enter_valid_email() {
			
			System.out.println("I enter valid email");
			WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			username.sendKeys("olfa_jedda@outlook.com");
		}

		@When("I click on next button")
		public void I_click_on_next_button() throws InterruptedException {
			
			System.out.println("I click on next button");
			WebElement next = driver.findElement(By.xpath("//*[@type=\"submit\"]"));
			next.click();
			Thread.sleep(1000);
		}

		@Then("password page is displayed")
		public void password_page_is_displayed() {
		   
			System.out.println("password page is displayed");
			WebElement subtitle2 = driver.findElement(By.xpath("//*[@class=\"bui_font_display_two bui_font_heading--bold bui-spacer--medium nw-step-header\"]"));
			String textsubtitle2 = subtitle2.getText();
			System.out.println(textsubtitle2);
			Assert.assertEquals("Indiquez votre mot de passe", textsubtitle2);
		}

		@When("I enter valid password")
		public void I_enter_valid_password() {

			System.out.println("I enter valid password");
			WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
			password.sendKeys("docteur2018");
		}
				
		@When("I click on login button1")
		public void I_click_on_login_button1() {
			
			System.out.println("I click on login button1");
			WebElement connect1 = driver.findElement(By.xpath("//button[@type=\"submit\"]"));		
			connect1.click();
		}
		
		@Then("I am connected")
		public void I_am_connected() {
			
			System.out.println("I am connected");
			WebElement quest = driver.findElement(By.xpath("//*[@class=\"sb-searchbox__title-text\"]"));
			String textquest = quest.getText();
			Assert.assertEquals("Olfa, quelle sera votre prochaine destination ?", textquest);
		}
}
