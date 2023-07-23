package Blu_Smart_UI.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Blu_Smart_UI.UI_Utility.CommonUtility;

public class HomePage extends CommonUtility {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav//a[@routerlink='drive']")
	WebElement driveWithUs;

	@FindBy(id = "name")
	WebElement d_name;

	@FindBy(id = "email")
	WebElement d_email;

	@FindBy(id = "phone")
	WebElement d_phone;

	@FindBy(id = "city")
	WebElement d_city;

	@FindBy(css = "[class='btn btn-primary']")
	WebElement submit_button;

	public void clickOnDriveWithUs() {

		driveWithUs.click();

	}

	public void enterName(String name) {

		d_name.sendKeys(name);
	}

	public void enterEmail(String email) {
		d_email.sendKeys(email);
	}

	public void enterPhoneNo(String phoneNo) {
		d_phone.sendKeys(phoneNo);

	}

	public void enterCity(String city) {
		d_city.sendKeys(city);
	}

	public void clickOnSubmitButton() throws InterruptedException {
		submit_button.click();
		Thread.sleep(2000);
	}

	public void navigateTo() {
		driver.get("https://blu-smart.com/");
	}

	public String getPopUpText() {
		Alert alert = driver.switchTo().alert(); // switch to alert
		String popUpText = alert.getText();
		return popUpText;
	}
	
	public void acceptPopUp() {
		driver.switchTo().alert().accept();;
	}

	public boolean isSubmitButtonEnabled() {
		return submit_button.isEnabled();
	}

	public void enterInvalidMandatoryFields(String name, String phoneno) {
		d_name.sendKeys(name);
		d_phone.sendKeys(phoneno);
	}

	public void enterValidData(String name, String email, String phone, String City) {
		d_email.sendKeys(email);
		d_city.sendKeys(City);
		d_name.sendKeys(name);
		d_phone.sendKeys(phone);

	}

}
