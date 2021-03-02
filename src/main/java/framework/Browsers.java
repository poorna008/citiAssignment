package framework;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
	public static WebDriver chromeBrowser() {
		if(SystemUtils.IS_OS_MAC){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver");
		}else if (SystemUtils.IS_OS_WINDOWS) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver.exe");
		}
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static WebDriver firefoxBrowser() {
		if(SystemUtils.IS_OS_MAC){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/resources/driver/geckodriver");
		}else if (SystemUtils.IS_OS_WINDOWS) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/driver/geckodriver.exe");
		}
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	

}
