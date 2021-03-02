package framework;

import java.io.File;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BrowserActions extends Browsers{
	public static void openUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	public static  String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public static String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public static void takeScreenshot(WebDriver driver,String path) {
		try {
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(path));
		}
		catch (Exception e) {
			System.out.println("Unable to take screenshot due to following Exception"+e);
		}
	}
	public static void navigateToRequiredWindowByPageTitle(WebDriver driver,String requiredPageTitle){
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			driver.switchTo().window(window);
			String actualTitle=getPageTitle(driver);
			if(actualTitle.equals(requiredPageTitle)) {
				break;
			}
		}
	}
	public static void closeTab(WebDriver driver) {
		driver.close();
	}
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}
}
