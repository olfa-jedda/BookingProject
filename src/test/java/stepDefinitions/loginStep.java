package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;
import webPages.loginPage;

public class loginStep {
	
		WebDriver driver = runner.driver;
		loginPage loginpage = new loginPage(driver);
		
		@Given("booking page is opened")
		public void booking_page_is_opened() {
			
			loginpage.booking_page_is_opened();
		}
		
		@When("I click on login button")
		public void I_click_on_login_button() {
			
			loginpage.I_click_on_login_button();
		
		}

		@Then("connection page is displayed")
		public void connection_page_is_displayed() throws InterruptedException {
			
			loginpage.connection_page_is_displayed();

		}	

		@When("I enter valid email")
		public void I_enter_valid_email() {
			
			loginpage.I_enter_valid_email("olfa_jedda@outlook.com");
		}

		@When("I click on next button")
		public void I_click_on_next_button() throws InterruptedException {
			
			loginpage.I_click_on_next_button();
		}

		@Then("password page is displayed")
		public void password_page_is_displayed() {
		   
			loginpage.password_page_is_displayed();
		}

		@When("I enter valid password")
		public void I_enter_valid_password() {

			loginpage.I_enter_valid_password("docteur2018");
		}
				
		@When("I click on login button1")
		public void I_click_on_login_button1() {
			
			loginpage.I_click_on_login_button1();
		}
		
		@Then("I am connected")
		public void I_am_connected() {
			
			loginpage.I_am_connected();
		}
		
		
}
