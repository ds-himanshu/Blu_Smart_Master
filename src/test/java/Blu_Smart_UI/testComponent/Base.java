package Blu_Smart_UI.testComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Blu_Smart_UI.PageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public HomePage hp;

	public WebDriver initializDriver() throws IOException {

		Properties property = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Blu_Smart_UI\\Resource\\Config.properties");
		property.load(file);
		String browserName = property.getProperty("browser");
		switch (browserName) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);

			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("disable-popup-blocking");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

			break;
		case "firefox":
			// firefox driver initialization code
		case "geckdriver":
			// lunch gecko driver code

		default:
			break;
		}
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod
	public void launchApplication() throws IOException {
		driver = initializDriver();
		HomePage hp = new HomePage(driver);
		hp.navigateTo();
	}

	@AfterMethod
	public void closeDriver() throws InterruptedException {
		driver.close();
	}



}
