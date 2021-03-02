package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest extends  WaitUtils{
	public static ExtentReports extent;
	public WebDriver driver;
	public ExtentTest test;
	public static Properties prop;
	
	@BeforeAll
	public static void config() throws IOException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String dateInString = dtf.format(now);
		extent = new ExtentReports("src/testreports/extentReport_" + dateInString + ".html");
		extent.loadConfig(new File("extent-config.xml"));
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources//Config.properties");
		prop.load(fis);
	}

	@BeforeEach
	public void beforeMethod(TestInfo testInfo) {
		String browservalue = prop.getProperty("browser");
		if (browservalue.equals("chrome")) {
			driver = chromeBrowser();
		} else if (browservalue.equals("firefox")) {
			driver = firefoxBrowser();
		}
		test = extent.startTest(testInfo.getTestMethod().orElseThrow(null).getName());
	}

	@AfterEach
	public void afterMethod() {
		extent.endTest(test);
		driver.quit();
	}

	@AfterAll
	public static void afterAll() {
		extent.flush();
	}
}
