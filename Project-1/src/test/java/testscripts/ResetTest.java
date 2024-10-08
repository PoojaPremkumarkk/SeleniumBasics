package testscripts;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation.org.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.ResetPage;
import utilities.ExcelUtility;

public class ResetTest extends Base {
	@Test(groups="Smoke")
	public void errormessagewithInvalidEmailid() {

		ResetPage reset = new ResetPage(driver);
		reset.clickResetLink();
		String emailId = ExcelUtility.getStringData(0, 0, Constants.RESETPAGE);
		String errormessage = ExcelUtility.getStringData(0, 1, Constants.RESETPAGE);
		reset.enterEmail(emailId);
		reset.clickSubmit();
		String actualerrormsg = reset.getErrorMessage();
		Assert.assertEquals(actualerrormsg, errormessage, Messages.INVALIDCREDS);
	}

	@Test
	public void passwordResetwithValidEmailid() {
		ResetPage reset = new ResetPage(driver);
		reset.clickResetLink();
		String emailId = ExcelUtility.getStringData(1, 0, Constants.RESETPAGE);
		reset.enterEmail(emailId);
		reset.clickSubmit();
		String expectedSuccessMessage = ExcelUtility.getStringData(0, 2, Constants.RESETPAGE);
		String actualSuccessMessage = reset.getSuccessMessage();
		assertEquals(Messages.RESETINLINEERRORMSG, expectedSuccessMessage, actualSuccessMessage);
	}
}
