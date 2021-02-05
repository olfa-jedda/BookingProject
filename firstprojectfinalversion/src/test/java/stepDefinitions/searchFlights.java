package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;

public class searchFlights {

		WebDriver driverFour = runner.driver;
		
		@Given("Booking page is open")
		public void booking_page_is_open() {
			
			System.out.println("Booking page is open");
			String pageTitle = driverFour.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
			
		}

		@When("I click on flights in the page header")
		public void I_click_on_flights_in_the_page_header() {
			
			System.out.println("I click on flights in the page header");
			WebElement flights = driverFour.findElement(By.xpath("//*[@data-decider-header=\"flights\"]"));
			flights.click();
			
		}
		@Then("text find and book your next flight is shown")
		public void text_find_and_book_your_next_flight_is_shown() {
			
			System.out.println("text find and book your next flight is shown");
			WebElement txtshown = driverFour.findElement(By.xpath("//*[@class=\"keel-container s-t-bp\"]//child::h1"));
			String txt = txtshown.getText();
			System.out.println(txt);
			Assert.assertEquals("Parcourez des centaines de sites de vols à la fois.", txt);
		}
		
		
		@When("I select one way ticket")
		public void I_select_one_way_ticket() {
			
			System.out.println("I select one way ticket");
			WebElement ticket = driverFour.findElement(By.xpath("//*[@class=\"col-switch _iXn\"]"));
			ticket.click();
			WebElement oneway = driverFour.findElement(By.xpath("//*[@data-value=\"oneway\"]"));
			oneway.click();
			
		}
		@Then("radio button one way ticket is selected")
		public void radio_button_one_way_ticket_is_selected() {
			
			System.out.println("radio button one way ticket is selected");
			//WebElement selcTicket = driverFour.findElement(By.xpath("//*[@class=\"col-switch _iXn\"]//child::div//child::div//child::div//child::div"));
			WebElement selcTicket = driverFour.findElement(By.xpath("//*[contains(@id, \"-switch-display-status\")]"));
			String txtSelcTicket = selcTicket.getAttribute("data-value");
			System.out.println(txtSelcTicket);
			Assert.assertEquals("oneway", txtSelcTicket);
			
		}
		
		
		@When("I click on select departure airport")
		public void I_click_on_select_departure_airport() {
			System.out.println("I click on select departure airport");
			//WebElement depairport = driverFour.findElement(By.xpath("//*[@class=\"js-display-icon _ikm _ifh _ifi _h-2 _i22 _j0O _h-Z _jze _ibw _kam\"]"));
			//WebElement depAirport = driverFour.findElement(By.xpath("//*[@class=\"_ia1\"]//child::div//child::div//child::div//child::div"));
			WebElement depAirport = driverFour.findElement(By.xpath("//*[contains(@id, \"-origin-airport-display\")]"));
			JavascriptExecutor js = (JavascriptExecutor) driverFour;
			js.executeScript("arguments[0].click()", depAirport);
		}
		@Then("menu to select departure airport is shown")
		public void menu_to_select_departure_airport_is_shown() {
			System.out.println("menu to select departure airport is shown");
			WebElement selecDepAirport = driverFour.findElement(By.xpath("//*[contains(@id, \"-origin-airport-smarty-content\")]"));		
			String txtSelecDepAirport = selecDepAirport.getAttribute("class");
			System.out.println(txtSelecDepAirport);
			Assert.assertEquals("Common-Widgets-Text-InputModal-smarty-content visible", txtSelecDepAirport);
			
		}
		
		
		@When("I select departure airport")
		public void I_select_departure_airport() throws InterruptedException {
			System.out.println("I select departure airport");
			WebElement depAirportSel = driverFour.findElement(By.xpath("//*[contains(@id, \"-origin-airport-textInputWrapper\")]//child::input"));	
			depAirportSel.clear();
			Thread.sleep(500);
			depAirportSel.sendKeys("Milan");
			WebElement depAirportMil = driverFour.findElement(By.xpath("//*[@id=\"ap-MIL/53596\"]"));	
			depAirportMil.click();
			
		}
		@Then("field to select arrival airport is shown")
		public void field_to_select_arrival_airport_is_shown() {
			System.out.println("field to select arrival airport is shown");//was changed!!
			WebElement depAirportShown = driverFour.findElement(By.xpath("//*[contains(@id, \"-origin-airport-display-inner\")]"));
			String txtDepAirportShown = depAirportShown.getText();
			System.out.println(txtDepAirportShown);
			//Assert.assertEquals("Milan (MIL)", txtDepAirportShown);//problem!!
			Assert.assertEquals("Milan", txtDepAirportShown);
		}
		
		
		@When("I select arrival airport")
		public void I_select_arrival_airport() throws InterruptedException {
			System.out.println("I select arrival airport");
			WebElement arrAirport = driverFour.findElement(By.xpath("//*[contains(@id, \"-destination-airport-display\")]"));
			JavascriptExecutor js = (JavascriptExecutor) driverFour;
			js.executeScript("arguments[0].click()", arrAirport);
			Thread.sleep(500);
			arrAirport = driverFour.findElement(By.xpath("//input[contains(@id, \"-destination-airport\")]"));
			arrAirport.sendKeys("Tunis");
			Thread.sleep(500);
			WebElement arrAirportTun = driverFour.findElement(By.xpath("//*[@id=\"ap-TUN/32784\"]"));	
			arrAirportTun.click();
			
		}
		@Then("calendar is shown1")
		public void calendar_is_shown1() {
			System.out.println("calendar is shown1");;//was changed!!
			WebElement arrAirportShown = driverFour.findElement(By.xpath("//*[contains(@id, \"-destination-airport-display-inner\")]"));
			String txtArrAirportShown = arrAirportShown.getText();
			System.out.println(txtArrAirportShown);
			//Assert.assertEquals("Tunis \(TUN\)", txtDepAirportShown);//problem!!
			Assert.assertEquals("Tunis", txtArrAirportShown);
		}
		
		
		@When("I select date")
		public void I_select_date() throws InterruptedException {
			System.out.println("I select date");
			WebElement selecdate = driverFour.findElement(By.xpath("//div[@class=\"_iaf _iEU _iam _iai\"]"));
			JavascriptExecutor js = (JavascriptExecutor) driverFour;
			js.executeScript("arguments[0].click()", selecdate);
			//WebElement actualMonth = driverFour.findElement(By.xpath("//*[@id=\"stl-jam-cal-monthsGrid\"]//child::div[contains(@id, \"stl-jam-cal-\")]"));
			WebElement actualMonth = driverFour.findElement(By.xpath("//*[@id=\"stl-jam-cal-monthsGrid\"]//child::div[contains(@id,\"stl-jam-cal-\")][3]//child::div[@class=\"_ijM _iAr _iaB _idE _iXr\"]"));
			
			String txtActualMonth = actualMonth.getText();
			System.out.println(txtActualMonth);	
			WebElement nextmonth = driverFour.findElement(By.xpath("//*[@id=\"stl-jam-cal-nextMonth\"]"));
			Boolean foundmonth = txtActualMonth.equals("mars 2021");			
			
			while (!foundmonth) {
				
				  nextmonth.click();
				  Thread.sleep(1000);
				  actualMonth = driverFour.findElement(By.xpath("//*[@id=\"stl-jam-cal-monthsGrid\"]//child::div[contains(@id,\"stl-jam-cal-\")][3]//child::div[@class=\"_ijM _iAr _iaB _idE _iXr\"]"));
				  txtActualMonth = actualMonth.getText();
				  System.out.println(txtActualMonth);	
				  Thread.sleep(1000);
				  foundmonth = txtActualMonth.equals("mars 2021");
				  
			}		
				
			WebElement selectday = driverFour.findElement(By.xpath("//div[@aria-label=\"mars 13\"]"));
			selectday.click();
					
		}
		@Then("calendar is gone1")
		public void calendar_is_gone1() {
			System.out.println("calendar is gone1");
			WebElement selecDay = driverFour.findElement(By.xpath("//*[contains(@id, \"-dateRangeInput-display-start-inner\")]"));
			String txtselecDay = selecDay.getText();
			System.out.println(txtselecDay);	
			Assert.assertEquals("sam. 13/3", txtselecDay);
		}
		
		
		@When("I click on select number of persons")
		public void I_click_on_select_number_of_persons() {
			System.out.println("I click on select number of persons");
			WebElement selecNumPer = driverFour.findElement(By.xpath("//*[contains(@id, \"-travelersAboveForm-dialog-trigger\")]"));
			selecNumPer.click();
		}
		@Then("menu to select number of persons is shown")
		public void menu_to_select_number_of_persons_is_shown() {
			System.out.println("menu to select number of persons is shown");
			WebElement selecNumPer = driverFour.findElement(By.xpath("//*[contains(@id, \"-travelersAboveForm-dialog-trigger\")]"));
			String txtselecNumPer = selecNumPer.getAttribute("aria-expanded");
			System.out.println(txtselecNumPer);
			Assert.assertEquals("true", txtselecNumPer);
		}
		
		
		@When("I select adults and children")
		public void I_select_adults_and_children() throws InterruptedException {
			System.out.println("I select adults and children");
			WebElement addAdults = driverFour.findElement(By.xpath("//div[contains(@id, \"-travelersAboveForm-adults\")]//child::button[@aria-label=\"Plus\"]"));
			addAdults.click();
			WebElement addChild = driverFour.findElement(By.xpath("//div[contains(@id, \"-travelersAboveForm-child\")]//child::button[@aria-label=\"Plus\"]"));
			addChild.click();
			Thread.sleep(1000);
		}
		@Then("number of person is shown")
		public void number_of_person_is_shown() {
			System.out.println("number of person is shown");
			WebElement numPer = driverFour.findElement(By.xpath("//*[contains(@id, \"-travelersAboveForm-dialog-trigger-display-text\")]"));
			String txtNumPer = numPer.getAttribute("aria-label");
			System.out.println(txtNumPer);
			Assert.assertEquals("3 voyageurs", txtNumPer);
		}
		
		
		@When("I click on ok")
		public void I_click_on_ok() {
			System.out.println("I click on ok");//was changed
			WebElement clickMenu = driverFour.findElement(By.xpath("//*[@class=\"coverPhotoBackground\"]"));//question!!
			JavascriptExecutor js = (JavascriptExecutor) driverFour;
			js.executeScript("arguments[0].click()", clickMenu);
			
		}
		@Then("menu is gone")
		public void menu_is_gone() {
			System.out.println("menu is gone");
			WebElement menu = driverFour.findElement(By.xpath("//*[contains(@id, \"-travelersAboveForm-dialog-trigger\")]"));
			String txtMenu = menu.getAttribute("aria-expanded");
			System.out.println(txtMenu);
			Assert.assertEquals("false", txtMenu);
		}
		
		
		@When("I click on search button1")
		public void I_click_on_search_button1() throws InterruptedException {
			System.out.println("I click on search button1");
			WebElement searchButt = driverFour.findElement(By.xpath("//button[contains(@id, \"-submit\")]"));
			searchButt.click();
			Thread.sleep(4000);
		}
		@Then("list of flights is shown")
		public void list_of_flights_is_shown() throws InterruptedException {
			System.out.println("list of flights is shown");
			WebElement listFli = driverFour.findElement(By.xpath("//*[contains(@id, \"-complianceMessage\")]//child::div[1]"));
			String txtListFli = listFli.getText();
			Thread.sleep(2000);
			System.out.println(txtListFli);
			Assert.assertEquals("Vols classés par défaut selon le Meilleur choix, comprenant la durée, le prix, le nombre d’escales.", txtListFli);
	
		}



}
