import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class MobileTests extends BaseTest {

    @Test(description = "Check count of views tab")
    public void clickViewsTest() {
        Assert.assertEquals(mainPage.clickViews().getTabElementsCount(), 42, "The expected number of tabs does not match the actual number");
    }

    @Test(description = "Set data and time")
    public void setDataAndTime() {
        mainPage.clickViews()
                .clickDateWidgets()
                .clickDialog()
                .clickChangeDate()
                .selectNextDayInCalendar()
                .clickConfirmButton()
                .clickChangeTheTime()
                .setDataAndTime(11,11,"PM")
                .clickConfirmButton();
        Assert.assertEquals(dialogPage.getViewedDate(), dialogPage.getNextDayExpected() + " 23:11", "The expected date does not match the actual date");
    }

    @Test(description = "Check 'next' button functionality and number")
    public void clickNextAndCheckNumber() {
        int numberOfClicks = new Random().nextInt(5, 11);
        mainPage.clickViews()
                .scrollToTheEnd()
                .clickTextSwitcher()
                .clickRandomTimesOnNextButton(numberOfClicks);
        Assert.assertEquals(textSwitcherPage.getNumberOfClicks(numberOfClicks),numberOfClicks,"The number on screen does not match with clicks count");
    }
}
