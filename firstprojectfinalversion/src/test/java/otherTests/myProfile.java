package otherTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunners.runner;

public class myProfile {

		WebDriver driverTwo = runner.driver;
		String newname = "Jedda Naimi";

		@Given("user is connected to Booking1")
		public void user_is_connected_to_booking1() {
			
			System.out.println("user is connected to Booking");
			String pageTitle = driverTwo.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
			WebElement msg = driverTwo.findElement(By.xpath("//*[@class=\"sb-searchbox__title-text\"]"));
			String txtmsg = msg.getText();
			//Assert.assertEquals("Trouvez des offres sur des hôtels, des hébergements indépendants et bien plus encore...", txtmsg);	
			Assert.assertEquals("Olfa, quelle sera votre prochaine destination ?", txtmsg);	
			 
		}
		

		@When("I click on username")
		public void I_click_on_username() {
						
			System.out.println("I click on username");
			WebElement username = driverTwo.findElement(By.xpath("//*[@aria-label=\"Ouvre le menu du profil\"]"));
			username.click();
		}
		@Then("options list is shown")
		public void options_list_is_shown() {
			
			System.out.println("options list is shown");
			WebElement profilemenu = driverTwo.findElement(By.xpath("//*[@class=\"profile-menu__item profile_menu__item--mydashboard\"]"));
			String textprofilemenu = profilemenu.getText();
			System.out.println(textprofilemenu);
			Assert.assertEquals("Accueil", textprofilemenu);	
		}
		
		
		@When("I choose home")
		public void I_choose_home() {
			
		    System.out.println("I choose home");
		    WebElement profilemenu = driverTwo.findElement(By.xpath("//*[@class=\"profile-menu__item profile_menu__item--mydashboard\"]"));
		    profilemenu.click();
		}
		@Then("profile page is shown")
		public void profile_page_is_shown() {
			
			System.out.println("profile page is shown");
			String pageTitle1 = driverTwo.getTitle();
			System.out.println(pageTitle1);
			Assert.assertEquals("Profil Booking.com - Votre tableau de bord", pageTitle1);
			
		}
		@Then("level is different from level0")
		public void level_is_different_from_level0() throws InterruptedException {
			
			System.out.println("level is different from level0");
			WebElement profilecompletness = driverTwo.findElement(By.xpath("//*[@class=\"profile-completeness__completeness_graph\"]//child::div"));
			String percentage = profilecompletness.getAttribute("data-completeness-percentage");
			//System.out.println(percentage);
			Assert.assertNotEquals("0", percentage);
		}
		@Then("three blocs are shown")
		public void three_blocs_are_shown() {
			
			System.out.println("three blocs are shown");
			driverTwo.findElement(By.xpath("//*[@class=\"action_panel--mainoptions_title\" and contains(text(),\"Trouvez\")]"));
			driverTwo.findElement(By.xpath("//*[@class=\"action_panel--mainoptions_title\" and contains(text(),\"Ajoutez\")]"));
			driverTwo.findElement(By.xpath("//*[@class=\"action_panel--mainoptions_title\" and contains(text(),\"Téléchargez\")]"));
			
		}
		
		
		@When("I click on modify your profile")
		public void I_click_on_modify_your_profile() {
			
			System.out.println("I click on modify your profile");
			WebElement modifyprofile = driverTwo.findElement(By.xpath("//*[@class=\"acc-profile-card__edit-settings-action\"]"));
			modifyprofile.click();
				
		}
		@Then("profile modification page is shown")
		public void profile_modification_page_is_shown() {
			
			System.out.println("profile modification page is shown");
			String pageTitle2 = driverTwo.getTitle();
			Assert.assertEquals("Vos paramètres Booking.com", pageTitle2);
		}
		
		
		@When("I change name")
		public void I_change_name() throws InterruptedException {
			
			System.out.println("I change name");
			WebElement name = driverTwo.findElement(By.xpath("//*[@id=\"lastname\"]"));
			name.clear();
			Thread.sleep(1000);
			name.sendKeys(newname);
			System.out.println(name.getAttribute("value"));
			
		}
		@When("I click on modify home adress button")
		public void I_click_on_modify_home_adress_button() {
			
			System.out.println("I click on modify home adress button");
			WebElement address = driverTwo.findElement(By.xpath("//*[@data-google-track=\"Click/mysettings/address_change_other\"]"));
			address.click();
			
		}
		@Then("modification is saved")
		public void modification_is_saved() {
			
			System.out.println("modification is saved");
			WebElement modifiedname = driverTwo.findElement(By.xpath("//*[@id=\"lastname\"]"));
			String textmodifiedname = modifiedname.getAttribute("value");
			Assert.assertEquals(newname, textmodifiedname);
			
			WebElement adresstomodify = driverTwo.findElement(By.xpath("//*[@class=\"settings-form settings-form--personal ClickTaleSensitive\"]//following::span[1]"));
			System.out.println(adresstomodify.getText());
			Assert.assertEquals("Adresse", adresstomodify.getText());
			
		}
		
		
		@When("I click on booking.com logo")
		public void I_click_on_booking_com_logo() throws InterruptedException {
			
			System.out.println("I click on booking.com logo");
			WebElement bookinglogo = driverTwo.findElement(By.xpath("//img[@id=\"logo_no_globe_new_logo\"]"));
			Thread.sleep(1000);
			bookinglogo.click();
			
		}
		@Then("home page is shown")
		public void home_page_is_shown() {
			
			System.out.println("home page is shown");
			String pageTitle3 = driverTwo.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle3);
			
		}
		@Then("name is changed")
		public void name_is_changed() {
			
			System.out.println("name is changed");
			WebElement shownname = driverTwo.findElement(By.xpath("//*[@class=\"header_name user_lastname ge-no-yellow-bg\"]"));
			//System.out.println(shownname.getText());
			Assert.assertEquals(newname, shownname.getText());
		
		}




}
