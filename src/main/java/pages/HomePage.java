package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public By firstNameTextBox() {
		return By.name("firstname");
	}
	public By lastNameTextBox() {
		return By.name("lastname");
	}
	public void createAccount(String firstName,String lastName) {
		driver.findElement(firstNameTextBox()).sendKeys(firstName);
		driver.findElement(firstNameTextBox()).sendKeys(lastName);
	}
}
