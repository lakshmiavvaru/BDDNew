package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
@FindBy(id = "Email")
WebElement email;

@FindBy(id = "Password")
WebElement password;

@FindBy(xpath = "//button[@class='button-1 login-button']")
WebElement Login;

@FindBy(xpath = "//a[contains(text(),'Logout')]")
WebElement Logout;

public void enterEmail(String dEmail) {
	email.clear();
	email.sendKeys(dEmail);
}

public void enterPwd(String dpassword) {
	password.clear();
	password.sendKeys(dpassword);
}

public void clickLoginButton() {
	Login.click();
}

public void clickLogoutButton() {
	Logout.click();
}

}
