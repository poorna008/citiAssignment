package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction extends ExcelUtils{
	public static void mouseHover(WebDriver driver,By  by) {
		Actions mouseActions=new Actions(driver);
		mouseActions.moveToElement(driver.findElement(by));
		mouseActions.build().perform();
	}
	public static void pressKey(WebDriver driver,Keys key) {
		Actions mouseActions=new Actions(driver);
		mouseActions.sendKeys(key);
		mouseActions.build().perform();
	}

}
