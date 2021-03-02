package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasicActions extends BrowserActions {
	public static void enterText(WebDriver driver,By by,String data) {
		driver.findElement(by).sendKeys(data);
	}
	public static void clearAndEnterText(WebDriver driver,By by,String data) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(data);
	}
	public static String getText(WebDriver driver,By by) {
		return driver.findElement(by).getText();
	}
	public static boolean getTextAndCompare(WebDriver driver,By by,String expectedText) {
		String actualText= driver.findElement(by).getText();
		if(expectedText.equals(actualText)) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void seletValueByIndex(WebDriver driver,By by,int indexNumber) {
		WebElement dd=driver.findElement(by);
		Select dropDown=new Select(dd);
		dropDown.selectByIndex(indexNumber);
	}
	public static void selectValuesByIndexes(WebDriver driver,By by,String indexesSeperatedByColon) {
		WebElement dd=driver.findElement(by);
		Select dropDown=new Select(dd);
		String[] indexes=indexesSeperatedByColon.split(":");
		for(String indexInString:indexes) {
			int indexInInteger=Integer.parseInt(indexInString);
			dropDown.selectByIndex(indexInInteger);
		}
	}
	
	public static void checkCheckBox(WebDriver driver,By by){
		WebElement dd=driver.findElement(by);
		boolean status=dd.isSelected();
		if(!status) {
			dd.click();
		}
	}
	public static void click(WebDriver driver,By by){
		WebElement dd=driver.findElement(by);
		boolean status=dd.isEnabled();
		if(status) {
			dd.click();
		}
	}
	public static boolean  elementIsDisplayed(WebDriver driver,By by){
		WebElement dd=driver.findElement(by);
		boolean status=dd.isDisplayed();
		return status;
	}
}
