package webPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),\"Se connecter\")]")
	WebElement connect;
	
	@FindBy(xpath = "//h1[contains(text(),\"Se connecter\")]")
	WebElement connect_subtitle;
	
	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement user_email;
	
	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement next;

	@FindBy(xpath = "//*[@class=\"bui_font_display_two bui_font_heading--bold bui-spacer--medium nw-step-header\"]")
	WebElement password_subtitle;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement user_password;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement login;
	
	@FindBy(xpath = "//*[@class=\"sb-searchbox__title-text\"]")
	WebElement quest;
	
	public loginPage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	}
	
	@Given("booking page is opened")
	public void booking_page_is_opened() {
		
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());
	}
	
	@When("I click on login button")
	public void I_click_on_login_button() {
		
		System.out.println("I click on login button");
		connect.click();
	
	}

	@Then("connection page is displayed")
	public void connection_page_is_displayed() throws InterruptedException {
		
		System.out.println("connection page is displayed");		
		Assert.assertEquals("Se connecter ou créer un compte",connect_subtitle.getText());	

	}	

	@When("I enter valid email")
	public void I_enter_valid_email(String email) {
		
		System.out.println("I enter valid email");
		user_email.sendKeys(email);
	}

	@When("I click on next button")
	public void I_click_on_next_button() throws InterruptedException {
		
		System.out.println("I click on next button");
		next.click();
		Thread.sleep(1000);
	}

	@Then("password page is displayed")
	public void password_page_is_displayed() {
	   
		System.out.println("password page is displayed");
		Assert.assertEquals("Indiquez votre mot de passe", password_subtitle.getText());
	}

	@When("I enter valid password")
	public void I_enter_valid_password(String password) {

		System.out.println("I enter valid password");
		user_password.sendKeys(password);
	}
			
	@When("I click on login button1")
	public void I_click_on_login_button1() {
		
		System.out.println("I click on login button1");		
		login.click();
	}
	
	@Then("I am connected")
	public void I_am_connected() {
		
		System.out.println("I am connected");
		Assert.assertEquals("Olfa, quelle sera votre prochaine destination ?", quest.getText());
	}
}

