package webPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class currencyPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@data-modal-aria-label=\"Sélectionnez votre devise\"]")
	WebElement currency;
	
	@FindBy(xpath = "//*[contains(text(),\"Devises principales\") or contains(text(),\"Sélectionnez votre devise\")]")
	WebElement currencies;
	
	@FindBy(xpath = "//*[@data-lang=\"USD\" or (@class = \"bui-inline-container__main\" and contains(text(), \"Dollar américain\"))]")
	WebElement usacurrency;
	
	@FindBy(xpath = "//*[@data-modal-aria-label=\"Sélectionnez votre devise\"]//child::span//child::span[1]")
	WebElement usacurrencyshown;

	@FindBy(xpath = "//*[@data-lang=\"EUR\" or (@class = \"bui-inline-container__main\" and contains(text(), \"Euro\"))]")
	WebElement eurcurrency;
	
	@FindBy(xpath = "//*[@data-modal-aria-label=\"Sélectionnez votre devise\"]//child::span//child::span[1]")
	WebElement eurcurrencyshown;

	@FindBy(xpath = "//*[@data-id=\"language_selector\" or @data-modal-id=\"language-selection\"]")
	WebElement language;	
	
	@FindBy(xpath = "//*[@aria-label=\"Sélectionnez votre langue\" or @aria-label=\"Select your language\"]//child::h2[@class=\"bui-modal__title\"]")
	WebElement languages;
		
	@FindBy(xpath = ("//*[@data-lang=\"en-gb\"]"))
	WebElement enlanguage;	
	
	@FindBy(xpath = ("//*[@data-modal-id=\"language-selection\"]//child::span[@class=\"bui-u-sr-only\"]"))
	WebElement eng;
	
	@FindBy(xpath = ("//*[@data-lang=\"fr\"]"))
	WebElement frlanguage;	
	
	@FindBy(xpath = ("//*[@data-modal-id=\"language-selection\"]//child::span[@class=\"bui-u-sr-only\"]"))
	WebElement fren;	

	public currencyPage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	}
	
	@Given("user is connected to Booking0")
	public void user_is_connected_to_booking0() {
		System.out.println("user is connected to Booking");
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());
	}

	@When("I click on currency icon")
	public void I_click_on_currency_icon() throws InterruptedException {
		System.out.println("I click on currency icon");
		currency.click();
		Thread.sleep(2000);
	}

	@Then("currency list is shown")
	public void currency_list_is_shown() throws InterruptedException {
		System.out.println("currency list is shown");
		Assert.assertEquals("Sélectionnez votre devise", currencies.getText());
	}

	@When("I choose usa dollar currency")
	public void I_choose_usa_dollar_currency() {
		System.out.println("I choose usa dollar currency");
		usacurrency.click();
	}

	@Then("currency should change to usa dollar")
	public void currency_should_change_to_usa_dollar() throws InterruptedException {
		System.out.println("currency should change to usa dollar");
		Boolean val = false;
		if(usacurrencyshown.getText().equalsIgnoreCase("US$")  || usacurrencyshown.getText().equalsIgnoreCase("USD")) {
			val = true;
	    }
		Assert.assertTrue(val == true);
	}

	@When("I choose euro currency")
	public void I_choose_euro_currency() {
		System.out.println("I choose euro currency");
		eurcurrency.click();
	}

	@Then("currency should change to euro")
	public void currency_should_change_to_euro() throws InterruptedException {
		System.out.println("currency should change to euro");
		Boolean val = false;
		if(eurcurrencyshown.getText().equalsIgnoreCase("€")  || eurcurrencyshown.getText().equalsIgnoreCase("EUR")) {
			val = true;
	    }
		Assert.assertTrue(val == true);
	}

	@When("I click on language icon")
	public void I_click_on_language_icon() {
		
		System.out.println("I click on language icon");
		language.click();
	}

	@Then("language list is shown")
	public void language_list_is_shown() throws InterruptedException {
		System.out.println("language list is shown");
		Boolean val = false;
		if(languages.getText().equalsIgnoreCase("Sélectionnez votre langue") || languages.getText().equalsIgnoreCase("Select your language")) {
			val = true;	
	    }
		Assert.assertTrue(val == true);
	}

	@When("I choose english language")
	public void I_choose_english_language() {
		System.out.println("I choose english language");	
		enlanguage.click();
	}

	@Then("language should change to english")
	public void language_should_change_to_english() throws InterruptedException {
		System.out.println("language should change to english");
		Assert.assertEquals("Choose your language. Your current language is English (UK)", eng.getText());
	}

	@When("I choose french language")
	public void I_choose_french_language() {
		System.out.println("I choose french language");	
		frlanguage.click();
	}

	@Then("language should change to french")
	public void language_should_change_to_french() throws InterruptedException {
		System.out.println("language should change to french");
		Assert.assertEquals("Choisissez votre langue. Votre langue actuelle est celle-ci : Français.", fren.getText());
	}

}
