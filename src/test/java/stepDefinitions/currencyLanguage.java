package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;
import webPages.currencyPage;

public class currencyLanguage {
	
	WebDriver driver = runner.driver;
	currencyPage currencypage = new currencyPage(driver);

	@Given("user is connected to Booking0")
	public void user_is_connected_to_booking0() {
		currencypage.user_is_connected_to_booking0();
	}

	@When("I click on currency icon")
	public void I_click_on_currency_icon() throws InterruptedException {
		currencypage.I_click_on_currency_icon();
	}
	@Then("currency list is shown")
	public void currency_list_is_shown() throws InterruptedException {
		currencypage.currency_list_is_shown();
	}

	@When("I choose usa dollar currency")
	public void I_choose_usa_dollar_currency() {
		currencypage.I_choose_usa_dollar_currency();
	}
	@Then("currency should change to usa dollar")
	public void currency_should_change_to_usa_dollar() throws InterruptedException {
		currencypage.currency_should_change_to_usa_dollar();
	}

	@When("I choose euro currency")
	public void I_choose_euro_currency() {
		currencypage.I_choose_euro_currency();
	}
	@Then("currency should change to euro")
	public void currency_should_change_to_euro() throws InterruptedException {
		currencypage.currency_should_change_to_euro();
	}
	
	@When("I click on language icon")
	public void I_click_on_language_icon() {
		currencypage.I_click_on_language_icon();
	}
	@Then("language list is shown")
	public void language_list_is_shown() throws InterruptedException {
		currencypage.language_list_is_shown();
	}

	@When("I choose english language")
	public void I_choose_english_language() {
		currencypage.I_choose_english_language();
	}
	@Then("language should change to english")
	public void language_should_change_to_english() throws InterruptedException {
		currencypage.language_should_change_to_english();
	}

	@When("I choose french language")
	public void I_choose_french_language() {
		currencypage.I_choose_french_language();
	}
	@Then("language should change to french")
	public void language_should_change_to_french() throws InterruptedException {
		currencypage.language_should_change_to_french();
	}

}
