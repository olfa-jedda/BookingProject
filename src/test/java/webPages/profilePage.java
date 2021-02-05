package webPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class profilePage {
	
WebDriver driver;
	
	@FindBy(xpath = "//*[@aria-label=\"Ouvre le menu du profil\"]")
	WebElement name;
	
	@FindBy(xpath = "//*[@aria-label=\"Ouvre le menu du profil\"]//following::li[1]")
	WebElement profile;
	
	@FindBy(xpath = "//*[@aria-label=\"Paramètres du compte\"]//child::h1")
	WebElement setpage;

	@FindBy(xpath = "//*[@class=\"my-settings-sections-menu-flex\"]//child::li[1]//child::a")
	WebElement persDetail;
	
	@FindBy(xpath = "//*[@class=\"my-settings-sections-menu-flex\"]//child::li[3]//child::a")
	WebElement security;
	
	@FindBy(xpath = "//*[@class=\"my-settings-sections-menu-flex\"]//child::li[5]//child::a")
	WebElement email;
		
	@FindBy(xpath = "//*[@class=\"my-settings-page\"]//child::div[@class=\"bui-title__subtitle\"]")
	WebElement updatepage;
	
	@FindBy(xpath = "//*[@class=\"my-settings-edit-table bui-f-font-featured \"]//child::div[@class=\"my-settings-row\"][2]//child::div[@class=\"my-settings-edit-col\"]//child::button")
	WebElement editName;
	
	@FindBy(xpath = "//*[@name=\"last\"]")
	WebElement lastname;
	
	@FindBy(xpath = "//*[@class=\"my-settings-edit-table bui-f-font-featured \"]//child::div[@class=\"my-settings-row my-settings-edit-row--editing\"]//child::button[@class=\"bui-button\"]")
	WebElement saveName;
	
	@FindBy(xpath = "//*[@class=\"my-settings-edit-table bui-f-font-featured \"]//child::div[@class=\"my-settings-row\"][2]//child::div[@class=\"full-name--display\"]//child::div[2]")
	WebElement savedName;
	
	@FindBy(xpath = "//*[@id=\"Welcome\"]")
	WebElement logo;
	
	@FindBy(xpath = "//*[@id=\"profile-menu-trigger--title\"]")
	WebElement newName;
	
	public profilePage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	}
	
	@Given("user is connected to Booking1")
	public void user_is_connected_to_booking1() {
		System.out.println("user is connected to Booking1");
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());
	}
	
	@When("I click on username")
	public void i_click_on_username() {
		System.out.println("I click on username");
		name.click();
	}
	@Then("options list is shown")
	public void options_list_is_shown() {
		System.out.println("options list is shown");
		Assert.assertEquals("true", name.getAttribute("aria-pressed"));
	}

	@When("I click on manage account")
	public void i_click_on_manage_account() {
		System.out.println("I click on manage account");
		profile.click();
	}
	@Then("account settings page is displayed")
	public void account_settings_page_is_displayed() {
		System.out.println("account settings page is displayed");
		Assert.assertEquals("Paramètres du compte", setpage.getText());
	}
	@Then("three blocs are shown")
	public void three_blocs_are_shown() {
		System.out.println("three blocs are shown");
		Assert.assertEquals("informationspersonnelles_title", persDetail.getAttribute("aria-labelledby"));
		Assert.assertEquals("sécurité_title", security.getAttribute("aria-labelledby"));
		Assert.assertEquals("notificationspare-mail_title", email.getAttribute("aria-labelledby"));		
	}
	
	@When("I click on personal details")
	public void i_click_on_personal_details() throws InterruptedException {
		System.out.println("I click on personal details");
		persDetail.click();
	}
	@Then("updating information page is displayed")
	public void updating_information_page_is_displayed(){
		System.out.println("updating information page is displayed");
		Assert.assertEquals("Mettez à jour vos informations et découvrez comment elles sont utilisées.", updatepage.getText());	
	}
	
	@When("I click on edit name")
	public void i_click_on_edit_name() {
		System.out.println("I click on edit name");
		editName.click();
	}
	@When("I enter the new name")
	public void i_enter_the_new_name(String newname) throws InterruptedException {
		System.out.println("I enter the new name");
		lastname.clear();
		Thread.sleep(1000);
		lastname.sendKeys(newname);
	}
	@When("I click on save")
	public void i_click_on_save() {
		System.out.println("I click on save");
		saveName.click();	
	}
	@Then("modification is saved")
	public void modification_is_saved() {
		System.out.println("modification is saved");
		Assert.assertEquals("Jedda Naimi", savedName.getText());
	}
	
	@When("I click on booking.com logo")
	public void i_click_on_booking_com_logo() {
		System.out.println("I click on booking.com logo");
		logo.click();	
	}
	@Then("home page is shown")
	public void home_page_is_shown() {
		System.out.println("home page is shown");
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());
	}
	@Then("name is changed")
	public void name_is_changed() {
		System.out.println("name is changed");
		Assert.assertEquals("Olfa Jedda Naimi", newName.getText());	
	}


}
