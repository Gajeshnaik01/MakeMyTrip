package org.makemytrip.bookTicket;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.ThreadSafeClass;

@Listeners(org.yantra.genericUtility.ListenerImpClass.class)
public class BookFlightTicketTest extends BaseClass {

	@Test
	public void bookFlightTicketTest() {
		homePage.closePopUp().fromCity(ThreadSafeClass.getExcelUtility().getExcelData(IConstants.sheetName, 2, 1))
		.toCity(ThreadSafeClass.getExcelUtility().getExcelData(IConstants.sheetName, 2, 2))
		.selectDepatureDate(ThreadSafeClass.getExcelUtility().getExcelData(IConstants.sheetName, 2, 3))
		.selectReturnDate(ThreadSafeClass.getExcelUtility().getExcelData(IConstants.sheetName, 2, 4)).clickSearch()
		.clickOnIndigoCheckBox().clickOnBookNow().clickOnSaver().clickOnContinue();
		ThreadSafeClass.getWebDriverUtility().switchWinUrl(currentUrl);
	}
}
