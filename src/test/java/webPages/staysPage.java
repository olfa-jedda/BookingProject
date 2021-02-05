package webPages;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class staysPage {
	
	WebDriver driver;
	String parentHandle;
	
	@FindBy(xpath = "//*[@data-ga-track=\"click|Product Expansion|accommodation|booking (index)\"]")
	WebElement stays;
	
	@FindBy(xpath = "//*[@class=\"sb-searchbox__title-text\"]")
	WebElement txtshown;
	
	@FindBy(xpath = "//*[@id=\"ss\"]")
	WebElement destination;

	@FindBy(xpath = "//*[@class=\"xp__dates-inner\"]")
	WebElement dates;
	
	@FindBy(xpath = "//*[@class=\"bui-calendar__display\"]")
	WebElement calendar;

	@FindBy(xpath = "//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div")
	WebElement actualmontharv;
		
	@FindBy(xpath = "//*[@data-bui-ref=\"calendar-next\"]")
	WebElement nextmonth;
	
	@FindBy(xpath = "//*[@aria-label=\"20 mars 2021\"]")
	WebElement arrivalday;
	
	@FindBy(xpath = "//*[@class=\"sb-date-field__display\" and @data-placeholder=\"Arrivée\"]")
	WebElement arrivaldatevar;
	
	@FindBy(xpath = "//*[@class=\"bui-calendar__content\"]//child::div[1]//child::div")
	WebElement actualmonthdep;
		
	@FindBy(xpath = "//*[@aria-label=\"27 mars 2021\"]")
	WebElement departureday;
	
	@FindBy(xpath = "//*[@class=\"sb-date-field__display\" and @data-placeholder=\"Départ\"]")
	WebElement departuredatevar;
	
	@FindBy(xpath = "//*[@class=\"bui-calendar\"]")
	WebElement calendargone;
	
	@FindBy(xpath = "//*[@class=\"xp__guests__count\"]")
	WebElement guests;

	@FindBy(xpath = "//*[@id=\"group_adults\"]")
	WebElement adults;
	
	@FindBy(xpath = "//*[@aria-label=\"Ajouter des Adultes\"]")
	WebElement adultsplus;
	
	@FindBy(xpath = "//*[@id=\"group_children\"]")
	WebElement children;
	
	@FindBy(xpath = "//*[@aria-label=\"Ajouter des Enfants\"]")
	WebElement childrenplus;
	
	@FindBy(xpath = "//*[@id=\"no_rooms\"]")
	WebElement room;

	@FindBy(xpath = "//*[@aria-label=\"Ajouter des Chambres\"]")
	WebElement roomplus;
		
	@FindBy(xpath = "//*[@data-group-child-age=\"0\"]")
	WebElement agechild1;

	@FindBy(xpath = "//*[@data-group-child-age=\"0\"]//child::option[4]")
	WebElement age2y ;
	
	@FindBy(xpath = "//*[@data-group-child-age=\"1\"]")
	WebElement agechild2;

	@FindBy(xpath = "//*[@data-group-child-age=\"1\"]//child::option[13]")
	WebElement age11y;

	@FindBy(xpath = "//*[@class=\"sb-searchbox__button \"]")
	WebElement searchbutt;
	
	@FindBy(xpath = "//*[@id=\"ss\"]")
	WebElement dest;
	
	@FindBy(xpath = "//*[@data-placeholder=\"Date d'arrivée\"]")
	WebElement arv;
	
	@FindBy(xpath = "//*[@data-placeholder=\"Date de départ\"]")
	WebElement dep;
	
	@FindBy(xpath = "//*[@id=\"group_adults\"]//child::option[3]")
	WebElement adl;
	
	@FindBy(xpath = "//*[@id=\"group_children\"]//child::option[3]")
	WebElement chld;
	
	@FindBy(xpath = "//*[@id=\"no_rooms\"]//child::option[2]")
	WebElement rms;
	
	@FindBy(xpath = "//*[@data-group-child-age=\"0\"]//child::option[13]")
	WebElement ac1;
	
	@FindBy(xpath = "//*[@data-group-child-age=\"1\"]//child::option[4]")
	WebElement ac2;
	
	@FindBy(xpath = "//*[@class=\"sr_header \"]")
	WebElement est;
	
	@FindBy(xpath = "//*[@id=\"hotellist_inner\"]//child::div[1]//child::div[1]//child::a//child::img")
	WebElement firstImg;

	@FindBy(xpath = "//*[@class=\"hp_nav_bar boldify_hp_nav\"]//child::li[2]")
	WebElement equip;
	
	@FindBy(xpath = "//*[@data-target=\"hp-facilities-sliding\"]")
	WebElement equiWind;

	@FindBy(xpath = "//*[@class=\"bk-icon -logos-booking-logo-inv\"]")
	WebElement booLogo;
	
	public staysPage(WebDriver driver){
	       this.driver=driver;
	       PageFactory.initElements(driver, this);
	}
	
	@Given("user is connected to Booking2")
	public void user_is_connected_to_booking2() {
		System.out.println("user is connected to Booking2");
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());
	}
	
	@When("I click on stays in the page header")
	public void I_click_on_stays_in_the_page_header() {
		System.out.println("I click on stays in the page header");
		stays.click();	
	}
	@Then("text what will be your next destination is shown")
	public void text_what_will_be_your_next_destination_is_shown() {
		System.out.println("text what will be your next destination is shown");
		Boolean val = false;
		if(txtshown.getText().equalsIgnoreCase("Olfa, quelle sera votre prochaine destination ?") || txtshown.getText().equalsIgnoreCase("Trouvez des offres sur des hôtels, des hébergements indépendants et bien plus encore...")) {
			val = true;
	    }
		Assert.assertTrue(val == true);
	}
	
	@When("I enter paris in where are you going box")
	public void I_enter_paris_in_where_are_you_going_box(String city) throws InterruptedException {
		System.out.println("I enter paris in where are you going box");
		destination.clear();
		Thread.sleep(1000);
		destination.sendKeys(city);
	}
	@When("I click on check-in")
	public void I_click_on_check_in() {	
		System.out.println("I click on check-in");
		dates.click();
	}
	@Then("calendar is shown0")
	public void calendar_is_shown0() {
		System.out.println("calendar is shown0");
		Assert.assertEquals("Arrivée - Départ", calendar.getText());			
	}
	
	@When("I select date of arrival")
	public void I_select_date_of_arrival() throws InterruptedException {
		System.out.println("I select date of arrival");		
		Boolean foundarv = actualmontharv.getText().equals("mars 2021");
		while (!foundarv) {		
			  nextmonth.click();
			  foundarv = actualmontharv.getText().equals("mars 2021");
			  Thread.sleep(500);
		}			
		arrivalday.click();
	}
	@Then("date of arrival is changed to selected date")
	public void date_of_arrival_is_changed_to_selected_date() {
		System.out.println("date of arrival is changed to selected date");
		Assert.assertEquals("sam 20 mars", arrivaldatevar.getText());	
	}
	
	@When("I select date of departure")
	public void I_select_date_of_departure() throws InterruptedException {
		System.out.println("I select date of departure");
		Boolean founddep = actualmonthdep.getText().equals("mars 2021");
		while (!founddep) {
			  nextmonth.click();
			  founddep = actualmonthdep.getText().equals("mars 2021");
			  Thread.sleep(500);
		}				
		departureday.click();	
	}
	@Then("date of departure is changed to selected date")
	public void date_of_departure_is_changed_to_selected_date() {
		System.out.println("date of departure is changed to selected date");
		Assert.assertEquals("sam 27 mars", departuredatevar.getText());	
		
	}
	@Then("calendar is gone0")
	public void calendar_is_gone0() {
		System.out.println("calendar is gone0");
		Assert.assertEquals("display: none;", calendargone.getAttribute("style"));
	}
	
	@When("I choose adults children and rooms")
	public void I_choose_adults_children_and_rooms() throws InterruptedException {

		System.out.println("I choose adults children and rooms");
		guests.click();
		//Adults
		Boolean foundadults = adults.getAttribute("value").equals("3");
		while (!foundadults) {
			adultsplus.click();
			foundadults = adults.getAttribute("value").equals("3");
			Thread.sleep(500);
		}

		//Children
		Boolean foundchild = children.getAttribute("value").equals("2");
		while (!foundchild) {
			childrenplus.click();
			foundchild = children.getAttribute("value").equals("2");
			Thread.sleep(500);
		}

		//Rooms
		Boolean foundroom = room.getAttribute("value").equals("2");
		while (!foundroom) {		
			roomplus.click();
			foundroom = room.getAttribute("value").equals("2");
			Thread.sleep(500);
		}
		
		//ChildrenAge
		agechild1.click();
		age2y.click();
		agechild2.click();
		age11y.click();	
		Thread.sleep(2000);
	}
	@When("I click on search button0")
	public void I_click_on_search_button0() {
		System.out.println("I click on search button0");
		searchbutt.click();
	}
	@Then("page of establishments found is shown")
	public void page_of_establishments_found_is_shown() {
		System.out.println("page of establishments found is shown");
		Assert.assertEquals("Booking.com : Hôtels à : Paris . Réservez votre hôtel dès maintenant\u00a0!", driver.getTitle());
	}
	@Then("search criteria shown in the left are correct")
	public void search_criteria_shown_in_the_left_are_correct() {
		System.out.println("search criteria shown in the left are correct");
		Assert.assertEquals("Paris", dest.getAttribute("value"));//destination
		Assert.assertEquals("samedi 20 mars 2021", arv.getText());//arv
		Assert.assertEquals("samedi 27 mars 2021", dep.getText());//dep
		Assert.assertEquals("true", adl.getAttribute("selected"));//adl
		Assert.assertEquals("true", chld.getAttribute("selected"));//chld
		Assert.assertEquals("true", rms.getAttribute("selected"));//rms
		Assert.assertEquals("true", ac1.getAttribute("selected"));//ac1
		Assert.assertEquals("true", ac2.getAttribute("selected"));//ac2
	}
	@Then("number of establishments is more than 20")
	public void number_of_establishments_is_more_than() throws InterruptedException {
		System.out.println("number of establishments is more than 20");
		Boolean val = false;
		int num = 0;
		String txtEst = est.getText().replaceAll("(?<=\\d) +(?=\\d)", "");
		Pattern p = Pattern.compile("\\d+");
        Matcher n = p.matcher(txtEst);
        if (n.find()) {
            num = Integer.parseInt(n.group());
        }
		if(num>20) {
			val = true;
	    }
		Assert.assertTrue(val == true);
	}
	
	@When("I click on the first establishment image")
	public void I_click_on_the_first_establishment_image() {	
		System.out.println("I click on the first establishment image");
		parentHandle = driver.getWindowHandle(); // Save parent window
		firstImg.click();
	}
	@Then("new window of establishment is opened")
	public void new_window_of_establishment_is_opened() {
		Boolean val = false;
		System.out.println("new window of establishment is opened");
		Set<String> handles = driver.getWindowHandles();
        if(handles.size() == 2){
            val = true;
        }
        Assert.assertTrue(val == true);
	}
	
	@When("I click on equipment")
	public void I_click_on_equipment() throws InterruptedException {
		System.out.println("I click on equipment");		
		Set<String> handles = driver.getWindowHandles();		
		for (String handle : handles) {
	        driver.switchTo().window(handle);
	        if (!parentHandle.equals(handle)) {
	            break;
	        }
	    }
		equip.click();
		Thread.sleep(1000);		
	}
	@Then("new block of establishment equipments is shown")
	public void new_block_of_establishment_equipments_is_shown() {	
		System.out.println("new block of establishment equipments is shown");
		Assert.assertEquals("hp_nav_facilities_link is-selected", equiWind.getAttribute("class"));	
	}
	
	@When("I close window")
	public void I_close_window() {
		System.out.println("I close window");
		driver.close();
	}
	@Then("search page is shown")
	public void search_page_is_shown() {
		System.out.println("search page is shown");
		driver.switchTo().window(parentHandle);
		Assert.assertEquals("Booking.com : Hôtels à : Paris . Réservez votre hôtel dès maintenant\u00a0!", driver.getTitle());
	}
	
	@When("I click on booking logo")
	public void I_click_on_booking_logo() {
		System.out.println("I click on booking logo");
		booLogo.click();
	}
	@Then("home page is shown1")
	public void home_page_is_shown1() {	
		System.out.println("home page is shown1");
		Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", driver.getTitle());
	}

}
