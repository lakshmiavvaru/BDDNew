package StepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.CustomersPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public CustomersPage customersPage;
	public SearchCustomerPage searchCustomerPage;
	
	
	public String generateEmail() {
	String email =	RandomStringUtils.randomAlphabetic(5);
	return email+"@mail.com";
		
	}

}
