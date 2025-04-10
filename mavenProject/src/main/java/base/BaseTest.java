package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static WebDriver driver;
	public static Properties pro = new Properties();
	public static FileReader fr ;
	
	@BeforeTest
	public void SetUp() throws IOException {
		if(driver == null)
		{
			fr = new FileReader("C:\\Users\\luis_\\.eclipse\\eclipseWokspace\\mavenProject\\src\\main\\java\\utilities\\config.properties");
			pro.load(fr);
		}
		if (pro.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","K:\\Users\\luis_\\Selenium\\geckodriver.exe");
	 		
	 		FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			option.addPreference("app.update.enabled", true);
			option.addPreference("pdfjs.disabled", true);
//	      profile.setPreference("dom.webnotifications.enabled", true);
			option.addPreference("geo.enabled", true);
			option.addPreference("geo.provider.use_corelocation", true);
			option.addPreference("geo.prompt.testing", true);
			option.addPreference("geo.prompt.testing.allow", true);
			option.addPreference("geo.wifi.uri", "path-to-loglatjson\\geo-location-ITPL.json");
	        // profile.setPreference("browser.helperApps.neverAsk.openFile",	
			driver = new FirefoxDriver(option);
			
		}
		
		driver.manage().window().maximize();
		
	}
	public void doWait() {
		
		
	}
	@AfterTest
	public void TearDown() {
		driver.close();
	}

}
