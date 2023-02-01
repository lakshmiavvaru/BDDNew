package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
WebDriver lDriver;
	
	public SearchCustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
@FindBy(id = "SearchEmail")
WebElement searchEmail;

@FindBy(id = "search-customers")
WebElement searchBtn;

@FindBy(xpath = "//table[@id='customers-grid']/tbody/tr[1]/td")
List<WebElement> tableColumns;

@FindBy(xpath = "//table[@id='customers-grid']/tbody/tr")
List<WebElement> tableRows;

//total columns - //table[@id='customers-grid']/tbody/tr[1]/td
//total rows - //table[@id='customers-grid']/tbody/tr

public void searchEmail(String dEmail) {
	searchEmail.sendKeys(dEmail);
}

public void clickSearchButton() {
	searchBtn.click();
}

public boolean searchEmailFound(String expected) {
	boolean found = false;
	int totalRows = tableRows.size();
	//int totalColumns =tableColumns.size();
	for(int i=1;i<=totalRows;i++) {//starting from second row as first row is just ehading
		WebElement email = lDriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[i]/td[2]")); //we have to check 2nd column of every row - what email
		String actualEmail = email.getText();
		if(actualEmail.equals(expected)) {
			found = true;
		}
	}
	return found;
	
}

}
