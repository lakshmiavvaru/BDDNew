package PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {
	
	WebDriver lDriver;
	
	public CustomersPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(xpath = "(//a[@class='nav-link active']//i[contains(@class,'right fas fa-angle-left')]")
	WebElement customersMenu;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement addNewCustBtn;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p")
	WebElement customersMenuItem;
	
	@FindBy(id = "Email")
	WebElement emailAddNew;
	
	@FindBy(id = "Password")
	WebElement addNewPwd;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement confirmationMesg;
	
	public String getPageTitle() {
		return lDriver.getTitle();
	}

	public void clickOnCustomerMenu() {
		customersMenu.click();
	}
	
	public void clickOnCustomerMenuItem() throws InterruptedException {
		Thread.sleep(10000);
		customersMenuItem.click();
	}
	
	public void clickOnAddNewCustomer() {
		addNewCustBtn.click();
	}
	
	public void addEmail(String randomEmail) {
		emailAddNew.sendKeys();
	}
	
	public void addPassword() {
		addNewPwd.sendKeys("test@mail.com");
	}
	
	public void clickSaveButton() {
		saveBtn.click();
	}
	
	public String confirmationMesg() {
		return confirmationMesg.getText();
	}
}
