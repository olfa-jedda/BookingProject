package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;
import webPages.staysPage;

public class searchStays {
	
		WebDriver driver = runner.driver;
		staysPage stayspage = new staysPage(driver);

		@Given("user is connected to Booking2")
		public void user_is_connected_to_booking2() {
			stayspage.user_is_connected_to_booking2();
		}
		
		@When("I click on stays in the page header")
		public void I_click_on_stays_in_the_page_header() {
			stayspage.I_click_on_stays_in_the_page_header();
		}
		@Then("text what will be your next destination is shown")
		public void text_what_will_be_your_next_destination_is_shown() {
			stayspage.text_what_will_be_your_next_destination_is_shown();
		}
		
		@When("I enter paris in where are you going box")
		public void I_enter_paris_in_where_are_you_going_box() throws InterruptedException {
			stayspage.I_enter_paris_in_where_are_you_going_box("Paris");	
		}
		@When("I click on check-in")
		public void I_click_on_check_in() {
			stayspage.I_click_on_check_in();	
		}
		@Then("calendar is shown0")
		public void calendar_is_shown0() {
			stayspage.calendar_is_shown0();
		}
		
		@When("I select date of arrival")
		public void I_select_date_of_arrival() throws InterruptedException {
			stayspage.I_select_date_of_arrival();
		}
		@Then("date of arrival is changed to selected date")
		public void date_of_arrival_is_changed_to_selected_date() {
			stayspage.date_of_arrival_is_changed_to_selected_date();		
		}
		
		@When("I select date of departure")
		public void I_select_date_of_departure() throws InterruptedException {
			stayspage.I_select_date_of_departure();	
		}
		@Then("date of departure is changed to selected date")
		public void date_of_departure_is_changed_to_selected_date() {
			stayspage.date_of_departure_is_changed_to_selected_date();
		}
		@Then("calendar is gone0")
		public void calendar_is_gone0() {
			stayspage.calendar_is_gone0();		
		}
		
		@When("I choose adults children and rooms")
		public void I_choose_adults_children_and_rooms() throws InterruptedException {
			stayspage.I_choose_adults_children_and_rooms();
		}
		@When("I click on search button0")
		public void I_click_on_search_button0() {
			stayspage.I_click_on_search_button0();
		}
		@Then("page of establishments found is shown")
		public void page_of_establishments_found_is_shown() {
			stayspage.page_of_establishments_found_is_shown();
		}
		@Then("search criteria shown in the left are correct")
		public void search_criteria_shown_in_the_left_are_correct() {
			stayspage.search_criteria_shown_in_the_left_are_correct();
		}
		@Then("number of establishments is more than 20")
		public void number_of_establishments_is_more_than() throws InterruptedException {
			stayspage.number_of_establishments_is_more_than();	
		}
		
		@When("I click on the first establishment image")
		public void I_click_on_the_first_establishment_image() {
			stayspage.I_click_on_the_first_establishment_image();		
		}
		@Then("new window of establishment is opened")
		public void new_window_of_establishment_is_opened() {
			stayspage.new_window_of_establishment_is_opened();
		}
		
		@When("I click on equipment")
		public void I_click_on_equipment() throws InterruptedException {
			stayspage.I_click_on_equipment();	
		}
		@Then("new block of establishment equipments is shown")
		public void new_block_of_establishment_equipments_is_shown() {
			stayspage.new_block_of_establishment_equipments_is_shown();	
		}
		
		@When("I close window")
		public void I_close_window() {
			stayspage.I_close_window();	
		}
		@Then("search page is shown")
		public void search_page_is_shown() {
			stayspage.search_page_is_shown();	
		}
		
		@When("I click on booking logo")
		public void I_click_on_booking_logo() {
			stayspage.I_click_on_booking_logo();	
		}
		@Then("home page is shown1")
		public void home_page_is_shown1() {
			stayspage.home_page_is_shown1();
		}

}
