package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Login {
	
	public WebDriver driver;
	public LoginPage loginPage;
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	    loginPage = new LoginPage(driver);
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

}
