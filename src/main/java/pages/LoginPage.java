package pages;

import framework.KeyBoardAction;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends KeyBoardAction {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public By usernameTextbox() {
		return By.id("email");
	}
	public By passwordTextBox() {
		return By.id("pass");
	}
	public By loginButton() {
		return By.name("login");
	}
	public By errorMessage() {
		 return By.xpath("//div[text()='The password you’ve entered is incorrect. ']");
	}
	public By errorSignUpMessage() {
		return By.xpath("//div[text()='The email or phone number you’ve entered doesn’t match any account. ']");
	}
	public void enterCredentials(String username,String password) {
		enterText(driver,usernameTextbox(),username);
		enterText(driver,passwordTextBox(),password);
	}
	public void clickLoginButton() {
		click(driver,loginButton());

	}
	public void validateInvalidPasswordErrorMessage() {
		elementPresence(driver,30,errorMessage());
		Assertions.assertEquals(elementIsDisplayed(driver,errorMessage()), true);
	}
	public void validateSignUpErrorMessage() {
		elementPresence(driver,30,errorSignUpMessage());
		Assertions.assertEquals(elementIsDisplayed(driver,errorSignUpMessage()), true);
	}
}
