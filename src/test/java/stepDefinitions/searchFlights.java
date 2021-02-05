package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;
import webPages.flightsPage;

public class searchFlights {

		WebDriver driver = runner.driver;
		flightsPage flightspage = new flightsPage(driver);
		
		@Given("Booking page is open")
		public void booking_page_is_open() {
			flightspage.booking_page_is_open();
		}

		@When("I click on flights in the page header")
		public void I_click_on_flights_in_the_page_header() {
			flightspage.I_click_on_flights_in_the_page_header();			
		}
		@Then("text find and book your next flight is shown")
		public void text_find_and_book_your_next_flight_is_shown() {
			flightspage.text_find_and_book_your_next_flight_is_shown();
		}
		
		@When("I select one way ticket")
		public void I_select_one_way_ticket() {
			flightspage.I_select_one_way_ticket();	
		}
		@Then("radio button one way ticket is selected")
		public void radio_button_one_way_ticket_is_selected() {
			flightspage.radio_button_one_way_ticket_is_selected();
		}
		
		@When("I click on select departure airport")
		public void I_click_on_select_departure_airport() {
			flightspage.I_click_on_select_departure_airport();
		}
		@Then("menu to select departure airport is shown")
		public void menu_to_select_departure_airport_is_shown() {
			flightspage.menu_to_select_departure_airport_is_shown();			
		}
		
		@When("I select departure airport")
		public void I_select_departure_airport() throws InterruptedException {
			flightspage.I_select_departure_airport();
		}
		@Then("field to select arrival airport is shown")
		public void field_to_select_arrival_airport_is_shown() {
			flightspage.field_to_select_arrival_airport_is_shown();
		}
		
		@When("I select arrival airport")
		public void I_select_arrival_airport() throws InterruptedException {
			flightspage.I_select_arrival_airport();
		}
		@Then("calendar is shown1")
		public void calendar_is_shown1() {
			flightspage.calendar_is_shown1();
		}
		
		@When("I select date")
		public void I_select_date() throws InterruptedException {
			flightspage.I_select_date();		
		}
		@Then("calendar is gone1")
		public void calendar_is_gone1() {
			flightspage.calendar_is_gone1();
		}
		
		@When("I click on select number of persons")
		public void I_click_on_select_number_of_persons() {
			flightspage.I_click_on_select_number_of_persons();
		}
		@Then("menu to select number of persons is shown")
		public void menu_to_select_number_of_persons_is_shown() {
			flightspage.menu_to_select_number_of_persons_is_shown();
		}
		
		@When("I select adults and children")
		public void I_select_adults_and_children() throws InterruptedException {
			flightspage.I_select_adults_and_children();
		}
		@Then("number of person is shown")
		public void number_of_person_is_shown() {
			flightspage.number_of_person_is_shown();
		}
		
		@When("I click on ok")
		public void I_click_on_ok() {
			flightspage.I_click_on_ok();
		}
		@Then("menu is gone")
		public void menu_is_gone() {
			flightspage.menu_is_gone();
		}
			
		@When("I click on search button1")
		public void I_click_on_search_button1() throws InterruptedException {
			flightspage.I_click_on_search_button1();
		}
		@Then("list of flights is shown")
		public void list_of_flights_is_shown() throws InterruptedException {
			flightspage.list_of_flights_is_shown();
		}
}
