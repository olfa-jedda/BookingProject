package stepDefinitions;

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
	
		@Given("user is connected to Booking1")
		public void user_is_connected_to_booking1() {
			System.out.println("user is connected to Booking1");
			String pageTitle = driverTwo.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		}
		

		@When("I click on username")
		public void i_click_on_username() {
			System.out.println("I click on username");
			WebElement name = driverTwo.findElement(By.xpath("//*[@aria-label=\"Ouvre le menu du profil\"]"));
			name.click();
		}
		@Then("options list is shown")
		public void options_list_is_shown() {
			System.out.println("options list is shown");
			WebElement list = driverTwo.findElement(By.xpath("//*[@aria-label=\"Ouvre le menu du profil\"]"));
			String txtList = list.getAttribute("aria-pressed");
			System.out.println(txtList);
			Assert.assertEquals("true", txtList);
		}
		
		
		@When("I click on manage account")
		public void i_click_on_manage_account() {
			System.out.println("I click on manage account");
			WebElement profile = driverTwo.findElement(By.xpath("//*[@aria-label=\"Ouvre le menu du profil\"]//following::li[1]"));
			profile.click();
		}
		@Then("account settings page is displayed")
		public void account_settings_page_is_displayed() {
			System.out.println("account settings page is displayed");
			WebElement setpage = driverTwo.findElement(By.xpath("//*[@aria-label=\"Paramètres du compte\"]//child::h1"));
			String txtSetpage = setpage.getText();
			System.out.println(txtSetpage);
			Assert.assertEquals("Paramètres du compte", txtSetpage);
		}
		@Then("three blocs are shown")
		public void three_blocs_are_shown() {
			System.out.println("three blocs are shown");
			WebElement persDetail = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-sections-menu-flex\"]//child::li[1]//child::a"));
			String txtPersDetail = persDetail.getAttribute("aria-labelledby");
			System.out.println(txtPersDetail);
			Assert.assertEquals("informationspersonnelles_title", txtPersDetail);
			
			WebElement security = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-sections-menu-flex\"]//child::li[3]//child::a"));
			String txtSecurity = security.getAttribute("aria-labelledby");
			System.out.println(txtSecurity);
			Assert.assertEquals("sécurité_title", txtSecurity);
			
			WebElement email = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-sections-menu-flex\"]//child::li[5]//child::a"));
			String txtEmail = email.getAttribute("aria-labelledby");
			System.out.println(txtEmail);
			Assert.assertEquals("notificationspare-mail_title", txtEmail);		
		}
		
		
		@When("I click on personal details")
		public void i_click_on_personal_details() throws InterruptedException {
			System.out.println("I click on personal details");
			WebElement persDetail = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-sections-menu-flex\"]//child::li[1]//child::a"));
			persDetail.click();
		}
		@Then("updating information page is displayed")
		public void updating_information_page_is_displayed(){
			System.out.println("updating information page is displayed");
			WebElement updatepage = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-page\"]//child::div[@class=\"bui-title__subtitle\"]"));
			String txtUpdatepage = updatepage.getText();
			System.out.println(txtUpdatepage);
			Assert.assertEquals("Mettez à jour vos informations et découvrez comment elles sont utilisées.", txtUpdatepage);
			
		}
		
		
		@When("I click on edit name")
		public void i_click_on_edit_name() {
			System.out.println("I click on edit name");
			
			WebElement editName = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-edit-table bui-f-font-featured \"]//child::div[@class=\"my-settings-row\"][2]//child::div[@class=\"my-settings-edit-col\"]//child::button"));
			editName.click();
		}
		@When("I enter the new name")
		public void i_enter_the_new_name() throws InterruptedException {
			System.out.println("I enter the new name");
			WebElement name = driverTwo.findElement(By.xpath("//*[@name=\"last\"]"));
			name.clear();
			Thread.sleep(1000);
			name.sendKeys("Jedda Naimi");
			Thread.sleep(1000);
		}
		@When("I click on save")
		public void i_click_on_save() {
			System.out.println("I click on save");
			WebElement saveName = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-edit-table bui-f-font-featured \"]//child::div[@class=\"my-settings-row my-settings-edit-row--editing\"]//child::button[@class=\"bui-button\"]"));
			saveName.click();
			
		}
		@Then("modification is saved")
		public void modification_is_saved() {
			System.out.println("modification is saved");
			
			WebElement savedName = driverTwo.findElement(By.xpath("//*[@class=\"my-settings-edit-table bui-f-font-featured \"]//child::div[@class=\"my-settings-row\"][2]//child::div[@class=\"full-name--display\"]//child::div[2]"));
			String txtSavedName = savedName.getText();
			System.out.println(txtSavedName);
			Assert.assertEquals("Jedda Naimi", txtSavedName);
		}
		
		
		@When("I click on booking.com logo")
		public void i_click_on_booking_com_logo() {
			System.out.println("I click on booking.com logo");
			WebElement logo = driverTwo.findElement(By.xpath("//*[@id=\"Welcome\"]"));
			logo.click();
			
		}
		@Then("home page is shown")
		public void home_page_is_shown() {
			System.out.println("home page is shown");
			String pageTitle = driverTwo.getTitle();
			Assert.assertEquals("Booking.com | Site officiel | Les meilleurs hôtels et hébergements", pageTitle);
		}
		@Then("name is changed")
		public void name_is_changed() {
			System.out.println("name is changed");
			WebElement newName = driverTwo.findElement(By.xpath("//*[@id=\"profile-menu-trigger--title\"]"));
			String txtNewName = newName.getText();
			System.out.println(txtNewName);
			Assert.assertEquals("Olfa Jedda Naimi", txtNewName);
			
		}

}
