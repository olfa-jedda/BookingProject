package otherTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchStays {
	
		WebDriver driverThree = loginStep.driver;
		String arrivaldate = "samedi 20 mars 2021";

		@Given("user is connected to Booking2")
		public void user_is_connected_to_booking2() {

			System.out.println("user is connected to Booking");
			String pageTitle = driverThree.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
			driverThree.findElement(By.xpath("//span[contains(text(), \"quelle sera votre prochaine destination\")]"));
		}
		

		@When("click on stays in the page header")
		public void click_on_stays_in_the_page_header() {
			
			System.out.println("click on stays in the page header");
			WebElement stays = driverThree.findElement(By.xpath("//*[@data-ga-track=\"click|Product Expansion|accommodation|booking (index)\"]"));
			stays.click();
			
		}
		@Then("text what will be your next destination is shown")
		public void text_what_will_be_your_next_destination_is_shown() {
			
			System.out.println("text what will be your next destination is shown");
			WebElement firstname = driverThree.findElement(By.xpath("//*[@class=\"header_name user_firstname ge-no-yellow-bg\"]"));
			String txtfirstname = firstname.getText();
			WebElement txtshown = driverThree.findElement(By.xpath("//*[@class=\"sb-searchbox__title-text\"]"));
			String txt = txtshown.getText();
			System.out.println(txt);
			Assert.assertEquals(txtfirstname+ ", quelle sera votre prochaine destination ?", txt);
		}
		
		
		@When("enter paris in where are you going box")
		public void enter_paris_in_where_are_you_going_box() {

			System.out.println("enter paris in where are you going box");
			WebElement destination = driverThree.findElement(By.xpath("//*[@id=\"ss\"]"));
			destination.sendKeys("Paris");
			//destination.submit();
			
		}
		
		
		@When("click on check-in")
		public void click_on_check_in() {
			
			System.out.println("click on check-in");
			WebElement dates = driverThree.findElement(By.xpath("//*[@class=\"xp__dates-inner\"]"));
			dates.click();
			
			
		}
		@Then("calendar is shown0")
		public void calendar_is_shown0() {

			System.out.println("calendar is shown0");
			WebElement calendar = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__display\"]"));
			String txtcalendar = calendar.getText();
			System.out.println(txtcalendar);
			Assert.assertEquals("Arrivée - Départ", txtcalendar);	
			
			/*WebElement calendar = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__display\"]"));
			String txtcalendar = calendar.getText();
			System.out.println(txtcalendar);
			Assert.assertEquals("Date d'arrivée - Date de départ", txtcalendar);	*/		
			
		}
		
		
		@When("select date of arrival")
		public void select_date_of_arrival() throws InterruptedException {

			System.out.println("select date of arrival");
			WebElement actualmonth = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
			String txtactualmonth = actualmonth.getText();
			System.out.println(txtactualmonth);		
			WebElement nextmonth = driverThree.findElement(By.xpath("//*[@data-bui-ref=\"calendar-next\"]"));
			while (txtactualmonth == "november 2020") {
				
				  nextmonth.click();
				  actualmonth = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
				  txtactualmonth = actualmonth.getText();
				  Thread.sleep(5000);
			}
			
			//nextmonth.click();
			//actualmonth = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
			//Thread.sleep(2000);
			//txtactualmonth = actualmonth.getText();
			
			
			System.out.println(txtactualmonth);	
			//WebElement arrivalday = driverThree.findElement(By.xpath("//*[@data-date=\"2021-03-20\"]"));
			//arrivalday.click();


		}
		@Then("date of arrival is changed to selected date")
		public void date_of_arrival_is_changed_to_selected_date() {
			
			System.out.println("date of arrival is changed to selected date");
			/*WebElement arrivaldatevar = driverThree.findElement(By.xpath("//*[@class=\"sb-date-field__display\" and @data-placeholder=\"Arrivée\"]"));
			String txtarrivaldate = arrivaldatevar.getText();
			System.out.println(txtarrivaldate);
			Assert.assertEquals("sam 20 mars", txtarrivaldate);*/
			
			
		}
		
		
		@When("select date of departure")
		public void select_date_of_departure() {


			System.out.println("select date of departure");
		}
		@Then("date of departure is changed to selected date")
		public void date_of_departure_is_changed_to_selected_date() {


			System.out.println("date of departure is changed to selected date");
		}
		@Then("calendar is gone0")
		public void calendar_is_gone0() {


			System.out.println("calendar is gone0");
		}
		@When("choose adults children and rooms")
		public void choose_adults_children_and_rooms() {


			System.out.println("choose adults children and rooms");
		}
		@When("click on search button0")
		public void click_on_search_button0() {


			System.out.println("click on search button0");
		}
		@Then("page of establishments found is shown")
		public void page_of_establishments_found_is_shown() {


			System.out.println("page of establishments found is shown");
		}
		@Then("search criteria shown in the left are correct")
		public void search_criteria_shown_in_the_left_are_correct() {

			System.out.println("search criteria shown in the left are correct");
		}
		@Then("number of establishments is more than 20")
		public void number_of_establishments_is_more_than() {

			System.out.println("number of establishments is more than 20");
		}
		@When("click on the first establishment image")
		public void click_on_the_first_establishment_image() {
			System.out.println("click on the first establishment image");
		}
		@Then("new window of establishment is opened")
		public void new_window_of_establishment_is_opened() {
			System.out.println("new window of establishment is opened");
		}
		@When("click on equipment")
		public void click_on_equipment() {
			System.out.println("click on equipment");
		}
		@Then("new block of establishment equipments is shown")
		public void new_block_of_establishment_equipments_is_shown() {
			System.out.println("new block of establishment equipments is shown");
		}
		@When("close window")
		public void close_window() {
			System.out.println("close window");
		}
		@Then("search page is shown")
		public void search_page_is_shown() {
			System.out.println("search page is shown");
		}
		@When("click on booking logo")
		public void click_on_booking_logo() {
			System.out.println("click on booking logo");
		}




}
