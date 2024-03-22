package pages;

import base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DialogPage extends BasePage {
    private By changeDateIcon = MobileBy.xpath("//android.widget.Button[@content-desc=\"change the date\"]");
    private By okButton = MobileBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private By changeTheTime = MobileBy.xpath("//android.widget.Button[@content-desc=\"change the time (spinner)\"]");
    private By hours12 = MobileBy.xpath("//android.widget.Button[@text=\"12\"]");
    private By hours11 = MobileBy.xpath("//android.widget.Button[@text=\"11\"]");
    private By minutes03 = MobileBy.xpath("//android.widget.Button[@text=\"03\"]");
    private By minutes04 = MobileBy.xpath("//android.widget.Button[@text=\"04\"]");
    private By minutes05 = MobileBy.xpath("//android.widget.Button[@text=\"05\"]");
    private By minutes06 = MobileBy.xpath("//android.widget.Button[@text=\"06\"]");
    private By minutes07 = MobileBy.xpath("//android.widget.Button[@text=\"07\"]");
    private By minutes08 = MobileBy.xpath("//android.widget.Button[@text=\"08\"]");
    private By minutes09 = MobileBy.xpath("//android.widget.Button[@text=\"09\"]");
    private By minutes10 = MobileBy.xpath("(//android.widget.Button[@text=\"10\"])[2]");
    private By minutes11 = MobileBy.xpath("//android.widget.Button[@text=\"11\"]");

    private By viewedDate = MobileBy.xpath("//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/dateDisplay\"]");

    public DialogPage() {
        super();
    }

    public DialogPage clickChangeDate() {
        wait.until(ExpectedConditions.elementToBeClickable(changeDateIcon)).click();
        return this;
    }

    public DialogPage selectNextDayInCalendar() {
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        String xpathExpression = String.format("//*[@index='%d']", dayOfMonth);
        By nextDayIndex = MobileBy.xpath(xpathExpression);
        wait.until(ExpectedConditions.elementToBeClickable(nextDayIndex)).click();
        return this;
    }

    public DialogPage clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
        return this;
    }

    public DialogPage clickChangeTheTime() {
        wait.until(ExpectedConditions.elementToBeClickable(changeTheTime)).click();
        return this;
    }

    public DialogPage setDataAndTime() {
        By[] hoursButtons = {hours12, hours11};
        By[] minutesButtons = {minutes03, minutes04, minutes05, minutes06, minutes07, minutes08, minutes09, minutes10, minutes11};
        for (By button : hoursButtons) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
        for (By button : minutesButtons) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
        return this;
    }

    public String getNextDayExpected() {
        LocalDate nextDay = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-dd-yyyy");
        String formattedDate = nextDay.format(formatter);
        return formattedDate;
    }

    public String getViewedDate() {
        return driver.findElement(viewedDate).getText();
    }
}
