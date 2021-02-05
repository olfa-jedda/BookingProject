package stepDefinitions;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;

public class searchStays {
	
		WebDriver driverThree = runner.driver;
		String arrivaldate = "samedi 20 mars 2021";
		String city = "Paris"; 
		String parentHandle = driverThree.getWindowHandle();

		@Given("user is connected to Booking2")
		public void user_is_connected_to_booking2() {

			System.out.println("user is connected to Booking");
			String pageTitle = driverThree.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		}
		

		@When("I click on stays in the page header")
		public void I_click_on_stays_in_the_page_header() {
			
			System.out.println("I click on stays in the page header");
			WebElement stays = driverThree.findElement(By.xpath("//*[@data-ga-track=\"click|Product Expansion|accommodation|booking (index)\"]"));
			stays.click();
			
		}
		@Then("text what will be your next destination is shown")
		public void text_what_will_be_your_next_destination_is_shown() {
			
			Boolean val = false;
			
			System.out.println("text what will be your next destination is shown");
			WebElement txtshown = driverThree.findElement(By.xpath("//*[@class=\"sb-searchbox__title-text\"]"));
			String txt = txtshown.getText();
			System.out.println(txt);
			if(txt.equalsIgnoreCase("Olfa, quelle sera votre prochaine destination ?") || txt.equalsIgnoreCase("Trouvez des offres sur des hôtels, des hébergements indépendants et bien plus encore...")) {
				val = true;
		    }
			Assert.assertTrue(val == true);
		}
		
		
		@When("I enter paris in where are you going box")
		public void I_enter_paris_in_where_are_you_going_box() throws InterruptedException {

			System.out.println("I enter paris in where are you going box");
			WebElement destination = driverThree.findElement(By.xpath("//*[@id=\"ss\"]"));
			destination.clear();
			Thread.sleep(1000);
			destination.sendKeys(city);
			
		}
		@When("I click on check-in")
		public void I_click_on_check_in() {
			
			System.out.println("I click on check-in");
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
		
		
		@When("I select date of arrival")
		public void I_select_date_of_arrival() throws InterruptedException {

			System.out.println("I select date of arrival");
			WebElement actualmontharv = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
			String txtactualmontharv = actualmontharv.getText();
			System.out.println(txtactualmontharv);		
			WebElement nextmonth = driverThree.findElement(By.xpath("//*[@data-bui-ref=\"calendar-next\"]"));
			Boolean foundarv = txtactualmontharv.equals("mars 2021");
			while (!foundarv) {
				
				  nextmonth.click();
				  actualmontharv = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
				  txtactualmontharv = actualmontharv.getText();
				  foundarv = txtactualmontharv.equals("mars 2021");
				  Thread.sleep(500);
			}			
			
			System.out.println(txtactualmontharv);	
			//WebElement arrivalday = driverThree.findElement(By.xpath("//*[@data-date=\"2021-03-20\"]"));
			
			WebElement arrivalday = driverThree.findElement(By.xpath("//*[@aria-label=\"20 mars 2021\"]"));
			arrivalday.click();


		}
		@Then("date of arrival is changed to selected date")
		public void date_of_arrival_is_changed_to_selected_date() {
			
			System.out.println("date of arrival is changed to selected date");
			WebElement arrivaldatevar = driverThree.findElement(By.xpath("//*[@class=\"sb-date-field__display\" and @data-placeholder=\"Arrivée\"]"));
			String txtarrivaldate = arrivaldatevar.getText();
			System.out.println(txtarrivaldate);
			Assert.assertEquals("sam 20 mars", txtarrivaldate);	
			
		}
		
		
		@When("I select date of departure")
		public void I_select_date_of_departure() throws InterruptedException {

			System.out.println("I select date of departure");
			WebElement actualmonthdep = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
			String txtactualmonthdep = actualmonthdep.getText();
			System.out.println(txtactualmonthdep);		
			WebElement nextmonth = driverThree.findElement(By.xpath("//*[@data-bui-ref=\"calendar-next\"]"));
			Boolean founddep = txtactualmonthdep.equals("mars 2021");
			while (!founddep) {
				
				  nextmonth.click();
				  actualmonthdep = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div"));
				  txtactualmonthdep = actualmonthdep.getText();
				  founddep = txtactualmonthdep.equals("mars 2021");
				  Thread.sleep(500);
			}			
			
			System.out.println(txtactualmonthdep);
			
			WebElement departureday = driverThree.findElement(By.xpath("//*[@aria-label=\"27 mars 2021\"]"));
			departureday.click();
			
		}
		@Then("date of departure is changed to selected date")
		public void date_of_departure_is_changed_to_selected_date() {


			System.out.println("date of departure is changed to selected date");
			WebElement departuredatevar = driverThree.findElement(By.xpath("//*[@class=\"sb-date-field__display\" and @data-placeholder=\"Départ\"]"));
			String txtdeparturedate = departuredatevar.getText();
			System.out.println(txtdeparturedate);
			Assert.assertEquals("sam 27 mars", txtdeparturedate);	
			
		}
		@Then("calendar is gone0")
		public void calendar_is_gone0() {

			System.out.println("calendar is gone0");
			WebElement calendargone = driverThree.findElement(By.xpath("//*[@class=\"bui-calendar\"]"));
			String txtcalendargone = calendargone.getAttribute("style");
			Assert.assertEquals("display: none;", txtcalendargone);
			
		}
		
		
		@When("I choose adults children and rooms")
		public void I_choose_adults_children_and_rooms() throws InterruptedException {

			System.out.println("I choose adults children and rooms");
			WebElement guests = driverThree.findElement(By.xpath("//*[@class=\"xp__guests__count\"]"));
			guests.click();
			//Adults
			WebElement adults = driverThree.findElement(By.xpath("//*[@id=\"group_adults\"]"));
			String adultsnbr = adults.getAttribute("value");
			Boolean foundadults = adultsnbr.equals("3");
			int i = Integer.valueOf(adultsnbr);
			WebElement adultsplus = driverThree.findElement(By.xpath("//*[@aria-label=\"Ajouter des Adultes\"]"));
			WebElement adultsminus = driverThree.findElement(By.xpath("//*[@aria-label=\"Supprimer des Adultes\"]"));
			if(i<3) {
				while (!foundadults) {
					
					adultsplus.click();
					adults = driverThree.findElement(By.xpath("//*[@id=\"group_adults\"]"));
					adultsnbr = adults.getAttribute("value");
					foundadults = adultsnbr.equals("3");
					i++;
					Thread.sleep(500);
				}
			}
			else if(i>3) { 
				while (!foundadults) {	
					
					adultsminus.click();
					adults = driverThree.findElement(By.xpath("//*[@id=\"group_adults\"]"));
					adultsnbr = adults.getAttribute("value");
					foundadults = adultsnbr.equals("3");
					i--;
					Thread.sleep(500);
				}
			}
			
			//Children
			WebElement children = driverThree.findElement(By.xpath("//*[@id=\"group_children\"]"));
			String childrennbr = children.getAttribute("value");
			Boolean foundchild = childrennbr.equals("2");
			int j = Integer.valueOf(childrennbr);
			WebElement childrenplus = driverThree.findElement(By.xpath("//*[@aria-label=\"Ajouter des Enfants\"]"));
			WebElement childrenminus = driverThree.findElement(By.xpath("//*[@aria-label=\"Supprimer des Enfants\"]"));
			if(j<2) {
				while (!foundchild) {
					
					childrenplus.click();
					children = driverThree.findElement(By.xpath("//*[@id=\"group_children\"]"));
					childrennbr = children.getAttribute("value");
					foundchild = childrennbr.equals("2");
					j++;
					Thread.sleep(500);
				}
			}
			else if(j>2) { 
				while (!foundchild) {	
					
					childrenminus.click();
					children = driverThree.findElement(By.xpath("//*[@id=\"group_children\"]"));
					childrennbr = children.getAttribute("value");
					foundchild = childrennbr.equals("2");
					j--;
					Thread.sleep(500);
				}
			}
			
			//Rooms
			WebElement room = driverThree.findElement(By.xpath("//*[@id=\"no_rooms\"]"));
			String roomnbr = room.getAttribute("value");
			Boolean foundroom = roomnbr.equals("2");
			//int k = Integer.valueOf(roomnbr);
			WebElement roomplus = driverThree.findElement(By.xpath("//*[@aria-label=\"Ajouter des Chambres\"]"));
			
			while (!foundroom) {	
				
				roomplus.click();
				room = driverThree.findElement(By.xpath("//*[@id=\"no_rooms\"]"));
				roomnbr = room.getAttribute("value");
				foundroom = roomnbr.equals("2");
				//k++;
				Thread.sleep(500);
			}
			
			//ChildrenAge
			WebElement agechild1 = driverThree.findElement(By.xpath("//*[@data-group-child-age=\"0\"]"));
			agechild1.click();
			WebElement age2y = driverThree.findElement(By.xpath("//*[@data-group-child-age=\"0\"]//child::option[4]"));
			age2y.click();
			WebElement agechild2 = driverThree.findElement(By.xpath("//*[@data-group-child-age=\"1\"]"));
			agechild2.click();
			WebElement age11y = driverThree.findElement(By.xpath("//*[@data-group-child-age=\"1\"]//child::option[13]"));
			age11y.click();
			
			
		}
		@When("I click on search button0")
		public void I_click_on_search_button0() {

			System.out.println("I click on search button0");
			WebElement searchbutt = driverThree.findElement(By.xpath("//*[@class=\"sb-searchbox__button \"]"));
			searchbutt.click();
			
		}
		@Then("page of establishments found is shown")
		public void page_of_establishments_found_is_shown() {

			System.out.println("page of establishments found is shown");
			String pageTitle1 = driverThree.getTitle();
			System.out.println(pageTitle1);
			Assert.assertEquals("Booking.com : Hôtels à : Paris . Réservez votre hôtel dès maintenant\u00a0!", pageTitle1);

		}
		@Then("search criteria shown in the left are correct")
		public void search_criteria_shown_in_the_left_are_correct() {

			System.out.println("search criteria shown in the left are correct");
			//destination
			WebElement dest = driverThree.findElement(By.xpath("//*[@id=\"ss\"]"));
			String txtdest = dest.getAttribute("value");
			System.out.println(txtdest);
			Assert.assertEquals("Paris", txtdest);
			
			//arv
			WebElement arv = driverThree.findElement(By.xpath("//*[@data-placeholder=\"Date d'arrivée\"]"));
			String txtarv = arv.getText();
			System.out.println(txtarv);
			Assert.assertEquals("samedi 20 mars 2021", txtarv);
			
			//dep
			WebElement dep = driverThree.findElement(By.xpath("//*[@data-placeholder=\"Date de départ\"]"));
			String txtdep = dep.getText();
			System.out.println(txtdep);
			Assert.assertEquals("samedi 27 mars 2021", txtdep);
			
			//adl
			WebElement adl = driverThree.findElement(By.xpath("//*[@id=\"group_adults\"]//child::option[3]"));
			String txtadl = adl.getAttribute("selected");
			System.out.println(txtadl);
			//Assert.assertEquals("selected", txtadl);
			Assert.assertEquals("true", txtadl);
			
			//chld
			WebElement chld = driverThree.findElement(By.xpath("//*[@id=\"group_children\"]//child::option[3]"));
			String txtchld = chld.getAttribute("selected");
			System.out.println(txtchld);
			//Assert.assertEquals("selected", txtchld);
			Assert.assertEquals("true", txtchld);
			
			//rms
			WebElement rms = driverThree.findElement(By.xpath("//*[@id=\"no_rooms\"]//child::option[2]"));
			String txtrms = rms.getAttribute("selected");
			System.out.println(txtrms);
			//Assert.assertEquals("selected", txtrms);
			Assert.assertEquals("true", txtrms);
			
			//ac1
			WebElement ac1 = driverThree.findElement(By.xpath("//*[@data-group-child-age=\"0\"]//child::option[13]"));
			String txtac1 = ac1.getAttribute("selected");
			System.out.println(txtac1);
			//Assert.assertEquals("selected", txtac1);
			Assert.assertEquals("true", txtac1);
			
			//ac2
			WebElement ac2 = driverThree.findElement(By.xpath("//*[@data-group-child-age=\"1\"]//child::option[4]"));
			String txtac2 = ac2.getAttribute("selected");
			System.out.println(txtac2);
			//Assert.assertEquals("selected", txtac2);
			Assert.assertEquals("true", txtac2);
			
		}
		@Then("number of establishments is more than 20")
		public void number_of_establishments_is_more_than() throws InterruptedException {

			Boolean val = false;
			int num = 0;
			
			System.out.println("number of establishments is more than 20");
			
			WebElement est = driverThree.findElement(By.xpath("//*[@class=\"sr_header \"]"));
			String txtEst = est.getText();
			txtEst = txtEst.replaceAll("(?<=\\d) +(?=\\d)", "");
			System.out.println(txtEst);
			Pattern p = Pattern.compile("\\d+");
	        Matcher n = p.matcher(txtEst);
	        if (n.find()) {
	            //System.out.println(n.group());
	            num = Integer.parseInt(n.group());
		        System.out.println(num);
	        }
	        
			if(num>20) {
				val = true;
				//System.out.println(val);
		    }
			Assert.assertTrue(val == true);
			
		}
		
		
		@When("I click on the first establishment image")
		public void I_click_on_the_first_establishment_image() {
			
			System.out.println("I click on the first establishment image");
			
			parentHandle = driverThree.getWindowHandle(); // Save parent window
			System.out.println(parentHandle);
			WebElement firstImg = driverThree.findElement(By.xpath("//*[@id=\"hotellist_inner\"]//child::div[1]//child::div[1]//child::a//child::img"));
			firstImg.click();
			
		}
		@Then("new window of establishment is opened")
		public void new_window_of_establishment_is_opened() {
			
			Boolean val = false;
			System.out.println("new window of establishment is opened");
			//driverThree.WindowHandles.Count;
			Set<String> handles = driverThree.getWindowHandles();

            if(handles.size() == 2){
                val = true;
            }
            Assert.assertTrue(val == true);
		}
		
		
		@When("I click on equipment")
		public void I_click_on_equipment() throws InterruptedException {
			
			System.out.println("I click on equipment");
			
			Set<String> handles = driverThree.getWindowHandles();		
		
			for (String handle : handles) {
		        driverThree.switchTo().window(handle);
		        if (!parentHandle.equals(handle)) {
		            break;
		        }
		    }

			WebElement equip = driverThree.findElement(By.xpath("//*[@class=\"hp_nav_bar boldify_hp_nav\"]//child::li[2]"));
			equip.click();
			Thread.sleep(1000);
			
		}
		@Then("new block of establishment equipments is shown")
		public void new_block_of_establishment_equipments_is_shown() {
			
			System.out.println("new block of establishment equipments is shown");
			WebElement equiWind = driverThree.findElement(By.xpath("//*[@data-target=\"hp-facilities-sliding\"]"));
			String txtequiWind = equiWind.getAttribute("class");
			System.out.println(txtequiWind);
			Assert.assertEquals("hp_nav_facilities_link is-selected", txtequiWind);
			
		}
		
		
		@When("I close window")
		public void I_close_window() {
			
			System.out.println("I close window");
			driverThree.close();
			
		}
		@Then("search page is shown")
		public void search_page_is_shown() {
			
			System.out.println("search page is shown");
			driverThree.switchTo().window(parentHandle);
			String pageTitle4 = driverThree.getTitle();
			System.out.println(pageTitle4);
			Assert.assertEquals("Booking.com : Hôtels à : Paris . Réservez votre hôtel dès maintenant\u00a0!", pageTitle4);
			
		}
		
		
		@When("I click on booking logo")
		public void I_click_on_booking_logo() {
			
			System.out.println("I click on booking logo");
			WebElement booLogo = driverThree.findElement(By.xpath("//*[@class=\"bk-icon -logos-booking-logo-inv\"]"));
			booLogo.click();
			
		}
		@Then("home page is shown1")
		public void home_page_is_shown1() {
			
			System.out.println("home page is shown1");
			String pageTitle5 = driverThree.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle5);
		}



}
