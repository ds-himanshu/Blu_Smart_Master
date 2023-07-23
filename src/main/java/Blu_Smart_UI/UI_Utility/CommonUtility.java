package Blu_Smart_UI.UI_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {

	WebDriver driver;

	public CommonUtility(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	public void waitforElementToClikable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	

}
