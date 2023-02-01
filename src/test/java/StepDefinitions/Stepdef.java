package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.CustomersPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Stepdef extends BaseClass{
	
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    customersPage = new CustomersPage(driver);
	    loginPage = new LoginPage(driver);
	    searchCustomerPage = new SearchCustomerPage(driver);
	    
	}


	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		 driver.get(url);
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String pwd) {
		loginPage.enterEmail(emailAdd);
		loginPage.enterPwd(pwd);
	}

	@When("click on Login")
	public void click_on_login() {
		loginPage.clickLoginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be1(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() {
		loginPage.clickLogoutButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expected) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expected)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	   driver.quit();
	}
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   String expected =  customersPage.getPageTitle();
	   String actual = "Dashboard / nopCommerce administration";
	   if(actual.equals(expected)) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() {
		customersPage.clickOnCustomerMenu();
		
	}
	
	@And("click on Customers menu item")
	public void click_on_Customers_menu_item() throws InterruptedException {
		customersPage.clickOnCustomerMenuItem();
	}


	@And("click on Add new button")
	public void click_on_add_new_button() {
		customersPage.clickOnAddNewCustomer();
	}

	@Then("User can view Add new customers page")
	public void user_can_view_add_new_customers_page() {
	    String actual = customersPage.getPageTitle();
	    String expected = "Add a new customer / nopCommerce administration";
	    if(actual.equals(expected)) {
			   Assert.assertTrue(true);
		   }else {
			   Assert.assertTrue(false);
		   }
	    
	}

	@When("User enters customer info")
	public void user_enters_customer_info() {
		customersPage.addEmail(generateEmail());
		customersPage.addPassword();
	}

	@When("click on save button")
	public void click_on_save_button() {
		customersPage.clickSaveButton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
    String expected ="The new customer has been added successfully.";
    String actual =  customersPage.confirmationMesg();
    if(actual.equals(expected)) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	
	}
	
/////
	@When("User enters email in searchbox")
	public void user_enters_email_in_searchbox() {
		searchCustomerPage.searchEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchCustomerPage.clickSearchButton();
	}

	@Then("User should find the email in the search results table")
	public void user_should_find_the_email_in_the_search_results_table() {
		Assert.assertTrue(searchCustomerPage.searchEmailFound("victoria_victoria@nopCommerce.com"));
	}

}
