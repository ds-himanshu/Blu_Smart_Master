package Blu_Smart_UI.Actions;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Blu_Smart_UI.PageObjects.HomePage;
import Blu_Smart_UI.UI_Utility.ExcelUtility;
import Blu_Smart_UI.testComponent.Base;

public class HomePageValidation extends Base {
	String actualPop;
	String expectedPopUp = "Please enter invalid no";

	@Test(dataProvider = "excel-data", dataProviderClass = ExcelUtility.class)
	public void validate_submit_button_is_not_clickable_with_invalid_inputs(String name, String phoneno)
			throws IOException, InterruptedException {
		String expectedPopUp = "Invalid contact no and name.";
		HomePage hp = new HomePage(driver);
		hp.clickOnDriveWithUs();
		hp.enterInvalidMandatoryFields(name, phoneno);
		hp.enterEmail("Test@mail");
		hp.enterCity("Noida");
		hp.clickOnSubmitButton();
		String actualPopUpMessage = hp.getPopUpText();
		hp.acceptPopUp();
		Assert.assertEquals(actualPopUpMessage, expectedPopUp);
	}

	@Test(dataProvider = "excel-valid-data", dataProviderClass = ExcelUtility.class)
	public void validate_submit_is_clikable_with_valid_inputs(String name, String phone, String mail, String city)
			throws InterruptedException {
		String expectedPopUp = "Thank you for your interest. We will reach out to you within the next 24 hours.";
		HomePage hp = new HomePage(driver);
		hp.clickOnDriveWithUs();
		hp.enterValidData(name, mail, phone, city);
		hp.clickOnSubmitButton();
		String actualPopUpMessage = hp.getPopUpText();
		hp.acceptPopUp();
		Assert.assertEquals(actualPopUpMessage, expectedPopUp);

	}

}
