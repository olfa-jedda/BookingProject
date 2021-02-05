package webPages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class flightsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@data-decider-header=\"flights\"]")
	WebElement flights;
	
	@FindBy(xpath = "//*[@class=\"keel-container s-t-bp\"]//child::h1")
	WebElement txtshown;
	
	@FindBy(xpath = "//*[@class=\"col-switch _iXn\"]")
	WebElement ticket;
	
	@FindBy(xpath = "//*[@data-value=\"oneway\"]")
	WebElement oneway;
	
	@FindBy(xpath = "//*[contains(@id, \"-switch-display-status\")]")
	WebElement selcTicket;
	
	
	@FindBy(xpath = "//*[contains(@id, \"-origin-airport-display\")]")
	WebElement depAirport;

	@FindBy(xpath = "//*[contains(@id, \"-origin-airport-smarty-content\")]")
	WebElement selecDepAirport;
	
	@FindBy(xpath = "//*[contains(@id, \"-origin-airport-textInputWrapper\")]//child::input")
	WebElement depAirportSel;
	
	@FindBy(xpath = "//*[@id=\"ap-MIL/53596\"]")
	WebElement depAirportMil;
	
	@FindBy(xpath = "//*[contains(@id, \"-origin-airport-display-inner\")]")
	WebElement depAirportShown;
	
	@FindBy(xpath = "//*[contains(@id, \"-destination-airport-display\")]")
	WebElement arrAirport;
	
	@FindBy(xpath = "//input[contains(@id, \"-destination-airport\")]")
	WebElement arrAirport2;
	
	@FindBy(xpath = "//*[@id=\"ap-TUN/32784\"]")
	WebElement arrAirportTun;
	
	@FindBy(xpath = "//*[contains(@id, \"-destination-airport-display-inner\")]")
	WebElement arrAirportShown;


	@FindBy(xpath = "//div[@class=\"_iaf _iEU _iam _iai\"]")
	WebElement selecdate;
	
	@FindBy(xpath = "//*[@id=\"stl-jam-cal-monthsGrid\"]//child::div[contains(@id,\"stl-jam-cal-\")][3]//child::div[@class=\"_ijM _iAr _iaB _idE _iXr\"]")
	WebElement actualMonth;
	
	@FindBy(xpath = "//*[@id=\"stl-jam-cal-nextMonth\"]")
	WebElement nextmonth;
	
	@FindBy(xpath = "//div[@aria-label=\"mars 13\"]")
	WebElement selectday;
	
	@FindBy(xpath = "//*[contains(@id, \"-dateRangeInput-display-start-inner\")]")
	WebElement selecDay;
	
	@FindBy(xpath = "//*[contains(@id, \"-travelersAboveForm-dialog-trigger\")]")
	WebElement selecNumPer;
	

	@FindBy(xpath = "//div[contains(@id, \"-travelersAboveForm-adults\")]//child::button[@aria-label=\"Plus\"]")
	WebElement addAdults;
	
	@FindBy(xpath = "//div[contains(@id, \"-travelersAboveForm-child\")]//child::button[@aria-label=\"Plus\"]")
	WebElement addChild;
	
	@FindBy(xpath = "//*[contains(@id, \"-travelersAboveForm-dialog-trigger-display-text\")]")
	WebElement numPer;
	
	@FindBy(xpath = "//*[@class=\"coverPhotoBackground\"]")
	WebElement clickMenu;
	
	@FindBy(xpath = "//*[contains(@id, \"-travelersAboveForm-dialog-trigger\")]")
	WebElement menu;
	
	@FindBy(xpath = "//button[contains(@id, \"-submit\")]")
	WebElement searchButt;
	
	@FindBy(xpath = "//*[contains(@id, \"-complianceMessage\")]//child::div[1]")
	WebElement listFli;
	
	public flightsPage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	}
	
	@Given("Booking page is open")
	public void booking_page_is_open() {	
		System.out.println("Booking page is open");
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());	
	}
	
	@When("I click on flights in the page header")
	public void I_click_on_flights_in_the_page_header() {
		System.out.println("I click on flights in the page header");
		flights.click();
	}
	@Then("text find and book your next flight is shown")
	public void text_find_and_book_your_next_flight_is_shown() {		
		System.out.println("text find and book your next flight is shown");
		Assert.assertEquals("Parcourez des centaines de sites de vols à la fois.", txtshown.getText());
	}
	
	@When("I select one way ticket")
	public void I_select_one_way_ticket() {
		System.out.println("I select one way ticket");
		ticket.click();
		oneway.click();	
	}
	@Then("radio button one way ticket is selected")
	public void radio_button_one_way_ticket_is_selected() {
		System.out.println("radio button one way ticket is selected");
		Assert.assertEquals("oneway", selcTicket.getAttribute("data-value"));
	}
	
	@When("I click on select departure airport")
	public void I_click_on_select_departure_airport() {
		System.out.println("I click on select departure airport");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", depAirport);
	}
	@Then("menu to select departure airport is shown")
	public void menu_to_select_departure_airport_is_shown() {
		System.out.println("menu to select departure airport is shown");
		Assert.assertEquals("Common-Widgets-Text-InputModal-smarty-content visible", selecDepAirport.getAttribute("class"));	
	}

	@When("I select departure airport")
	public void I_select_departure_airport() throws InterruptedException {
		System.out.println("I select departure airport");
		depAirportSel.clear();
		Thread.sleep(500);
		depAirportSel.sendKeys("Milan");
		depAirportMil.click();
	}
	@Then("field to select arrival airport is shown")
	public void field_to_select_arrival_airport_is_shown() {
		System.out.println("field to select arrival airport is shown");//was changed!!
		Assert.assertEquals("Milan", depAirportShown.getText());
	}
	
	@When("I select arrival airport")
	public void I_select_arrival_airport() throws InterruptedException {
		System.out.println("I select arrival airport");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", arrAirport);
		Thread.sleep(500);
		arrAirport2.sendKeys("Tunis");
		Thread.sleep(500);	
		arrAirportTun.click();
	}
	@Then("calendar is shown1")
	public void calendar_is_shown1() {
		System.out.println("calendar is shown1");;//was changed!!
		Assert.assertEquals("Tunis", arrAirportShown.getText());
	}
	
	@When("I select date")
	public void I_select_date() throws InterruptedException {
		System.out.println("I select date");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", selecdate);
		Boolean foundmonth = actualMonth.getText().equals("mars 2021");			
		while (!foundmonth) {
			  nextmonth.click();
			  Thread.sleep(1000);
			  foundmonth = actualMonth.getText().equals("mars 2021");	  
		}		
		selectday.click();		
	}
	@Then("calendar is gone1")
	public void calendar_is_gone1() {
		System.out.println("calendar is gone1");
		Assert.assertEquals("sam. 13/3", selecDay.getText());
	}
	
	@When("I click on select number of persons")
	public void I_click_on_select_number_of_persons() {
		System.out.println("I click on select number of persons");
		selecNumPer.click();
	}
	@Then("menu to select number of persons is shown")
	public void menu_to_select_number_of_persons_is_shown() {
		System.out.println("menu to select number of persons is shown");
		Assert.assertEquals("true", selecNumPer.getAttribute("aria-expanded"));
	}
	
	@When("I select adults and children")
	public void I_select_adults_and_children() throws InterruptedException {
		System.out.println("I select adults and children");
		addAdults.click();
		addChild.click();
		Thread.sleep(1000);
	}
	@Then("number of person is shown")
	public void number_of_person_is_shown() {
		System.out.println("number of person is shown");
		Assert.assertEquals("3 voyageurs", numPer.getAttribute("aria-label"));
	}
	
	@When("I click on ok")
	public void I_click_on_ok() {
		System.out.println("I click on ok");//was changed
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clickMenu);	
	}
	@Then("menu is gone")
	public void menu_is_gone() {
		System.out.println("menu is gone");
		Assert.assertEquals("false", menu.getAttribute("aria-expanded"));
	}
	
	@When("I click on search button1")
	public void I_click_on_search_button1() throws InterruptedException {
		System.out.println("I click on search button1");
		searchButt.click();
		Thread.sleep(4000);
	}
	@Then("list of flights is shown")
	public void list_of_flights_is_shown() throws InterruptedException {
		System.out.println("list of flights is shown");
		Assert.assertEquals("Vols classés par défaut selon le Meilleur choix, comprenant la durée, le prix, le nombre d’escales.", listFli.getText());
	}
}
