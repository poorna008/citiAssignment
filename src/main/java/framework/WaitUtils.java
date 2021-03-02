package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends BasicActions{
	public static void wait(int timeinSeconds) {
		try {
			Thread.sleep(timeinSeconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void implictWait(WebDriver driver,int timeOutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
	}
	public static void implictWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void elementToClickable(WebDriver driver,int timeoutInSeconds,By by) {
		WebDriverWait expWait=new WebDriverWait(driver, timeoutInSeconds);
		expWait.until(ExpectedConditions.elementToBeClickable(by));
	}
	public static void elementToVisible(WebDriver driver,int timeoutInSeconds,By by) {
		WebDriverWait expWait=new WebDriverWait(driver, timeoutInSeconds);
		expWait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
	}
	public static void elementPresence(WebDriver driver,int timeoutInSeconds,By by) {
		WebDriverWait expWait=new WebDriverWait(driver, timeoutInSeconds);
		expWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
}
