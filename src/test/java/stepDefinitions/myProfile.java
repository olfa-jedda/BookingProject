package stepDefinitions;


import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;
import webPages.profilePage;

public class myProfile {
	
		WebDriver driver = runner.driver;
		profilePage profilepage = new profilePage(driver);
	
		@Given("user is connected to Booking1")
		public void user_is_connected_to_booking1() {
			profilepage.user_is_connected_to_booking1();
		}

		@When("I click on username")
		public void i_click_on_username() {
			profilepage.i_click_on_username();
		}
		@Then("options list is shown")
		public void options_list_is_shown() {
			profilepage.options_list_is_shown();
		}
			
		@When("I click on manage account")
		public void i_click_on_manage_account() {
			profilepage.i_click_on_manage_account();
		}
		@Then("account settings page is displayed")
		public void account_settings_page_is_displayed() {
			profilepage.account_settings_page_is_displayed();
		}
		@Then("three blocs are shown")
		public void three_blocs_are_shown() {
			profilepage.three_blocs_are_shown();
		}
			
		@When("I click on personal details")
		public void i_click_on_personal_details() throws InterruptedException {
			profilepage.i_click_on_personal_details();
		}
		@Then("updating information page is displayed")
		public void updating_information_page_is_displayed(){
			profilepage.updating_information_page_is_displayed();
		}
		
		@When("I click on edit name")
		public void i_click_on_edit_name() {
			profilepage.i_click_on_edit_name();
		}
		@When("I enter the new name")
		public void i_enter_the_new_name() throws InterruptedException {
			profilepage.i_enter_the_new_name("Jedda Naimi");
		}
		@When("I click on save")
		public void i_click_on_save() {
			profilepage.i_click_on_save();			
		}
		@Then("modification is saved")
		public void modification_is_saved() {
			profilepage.modification_is_saved();
		}
		
		@When("I click on booking.com logo")
		public void i_click_on_booking_com_logo() {
			profilepage.i_click_on_booking_com_logo();	
		}
		@Then("home page is shown")
		public void home_page_is_shown() {
			profilepage.home_page_is_shown();
		}
		@Then("name is changed")
		public void name_is_changed() {
			profilepage.name_is_changed();
		}
}
