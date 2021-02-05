package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;

public class currencyLanguage {
	
	WebDriver driverOne = runner.driver;

	@Given("user is connected to Booking0")
	public void user_is_connected_to_booking0() {
		
		System.out.println("user is connected to Booking");
		String pageTitle2 = driverOne.getTitle();
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle2);
		/*WebElement msg = driverOne.findElement(By.xpath("//*[@class=\"sb-searchbox__title-text\"]"));
		String txtmsg = msg.getText();
		Assert.assertEquals("Trouvez des offres sur des hôtels, des hébergements indépendants et bien plus encore...", txtmsg);*/
		
	}

	@When("I click on currency icon")
	public void I_click_on_currency_icon() throws InterruptedException {
		
		System.out.println("I click on currency icon");
		WebElement currency = driverOne.findElement(By.xpath("//*[@data-modal-aria-label=\"Sélectionnez votre devise\"]"));
		
		currency.click();
		Thread.sleep(2000);
		
	}

	@Then("currency list is shown")
	public void currency_list_is_shown() throws InterruptedException {
		
		Boolean val = false;
		
		System.out.println("currency list is shown");
		WebElement currencies = driverOne.findElement(By.xpath("//*[contains(text(),\"Devises principales\") or contains(text(),\"Sélectionnez votre devise\")]"));
		String textcurrencies = currencies.getText();
		Thread.sleep(2000);
		System.out.println(textcurrencies);
		if(textcurrencies.equalsIgnoreCase("Devises principales") || textcurrencies.equalsIgnoreCase("Sélectionnez votre devise")) {
			val = true;
	    }
		Assert.assertTrue(val == true);
	}

	@When("I choose usa dollar currency")
	public void I_choose_usa_dollar_currency() {
		
		System.out.println("I choose usa dollar currency");
		WebElement usacurrency = driverOne.findElement(By.xpath("//*[@data-lang=\"USD\" or (@class = \"bui-inline-container__main\" and contains(text(), \"Dollar américain\"))]"));
		usacurrency.click();
		
	}

	@Then("currency should change to usa dollar")
	public void currency_should_change_to_usa_dollar() throws InterruptedException {
		
		Boolean val = false;
		
		System.out.println("currency should change to usa dollar");
		WebElement usacurrencyshown = driverOne.findElement(By.xpath("//*[@data-modal-aria-label=\"Sélectionnez votre devise\"]//child::span//child::span[1]"));
		String textusacurrencyshown = usacurrencyshown.getText();
		Thread.sleep(2000);
		System.out.println(textusacurrencyshown);
		if(textusacurrencyshown.equalsIgnoreCase("US$")  || textusacurrencyshown.equalsIgnoreCase("USD")) {
			val = true;
	    }
		Assert.assertTrue(val == true);
	}

	@When("I choose euro currency")
	public void I_choose_euro_currency() {

		System.out.println("I choose euro currency");
		WebElement eurcurrency = driverOne.findElement(By.xpath("//*[@data-lang=\"EUR\" or (@class = \"bui-inline-container__main\" and contains(text(), \"Euro\"))]"));
		eurcurrency.click();
	}

	@Then("currency should change to euro")
	public void currency_should_change_to_euro() throws InterruptedException {
		
		Boolean val = false;
		
		System.out.println("currency should change to euro");
		WebElement eurcurrencyshown = driverOne.findElement(By.xpath("//*[@data-modal-aria-label=\"Sélectionnez votre devise\"]//child::span//child::span[1]"));
		String texteurcurrencyshown = eurcurrencyshown.getText();
		Thread.sleep(2000);
		System.out.println(texteurcurrencyshown);
		if(texteurcurrencyshown.equalsIgnoreCase("€")  || texteurcurrencyshown.equalsIgnoreCase("EUR")) {
			val = true;
	    }
		Assert.assertTrue(val == true);
		
	}

	@When("I click on language icon")
	public void I_click_on_language_icon() {
		
		System.out.println("I click on language icon");
		WebElement language = driverOne.findElement(By.xpath("//*[@data-id=\"language_selector\" or @data-modal-id=\"language-selection\"]"));		
		language.click();
	}

	@Then("language list is shown")
	public void language_list_is_shown() throws InterruptedException {
		
		Boolean val = false;
		
		System.out.println("language list is shown");
		WebElement languages = driverOne.findElement(By.xpath("//*[@aria-label=\"Sélectionnez votre langue\" or @aria-label=\"Select your language\"]//child::h2[@class=\"bui-modal__title\"]"));
		
		Thread.sleep(2000);
		String textlanguages = languages.getText();
		
		System.out.println(textlanguages);
		if(textlanguages.equalsIgnoreCase("Sélectionnez votre langue") || textlanguages.equalsIgnoreCase("Select your language")) {
			val = true;	
	    }
		Assert.assertTrue(val == true);
	}

	@When("I choose english language")
	public void I_choose_english_language() {
		
		System.out.println("I choose english language");
		WebElement enlanguage = driverOne.findElement(By.xpath("//*[@data-lang=\"en-gb\"]"));		
		enlanguage.click();
		
	}

	@Then("language should change to english")
	public void language_should_change_to_english() throws InterruptedException {
		
		System.out.println("language should change to english");
		WebElement eng = driverOne.findElement(By.xpath("//*[@data-modal-id=\"language-selection\"]//child::span[@class=\"bui-u-sr-only\"]"));
		String txtEng = eng.getText();
		System.out.println(txtEng);	
		Assert.assertEquals("Choose your language. Your current language is English (UK)", txtEng);
	}

	@When("I choose french language")
	public void I_choose_french_language() {
		
		System.out.println("I choose french language");
		WebElement frlanguage = driverOne.findElement(By.xpath("//*[@data-lang=\"fr\"]"));		
		frlanguage.click();
	}

	@Then("language should change to french")
	public void language_should_change_to_french() throws InterruptedException {
		
		System.out.println("language should change to french");
		WebElement fren = driverOne.findElement(By.xpath("//*[@data-modal-id=\"language-selection\"]//child::span[@class=\"bui-u-sr-only\"]"));
		String txtFren = fren.getText();
		System.out.println(txtFren);	
		Assert.assertEquals("Choisissez votre langue. Votre langue actuelle est celle-ci : Français.", txtFren);
	}

}
