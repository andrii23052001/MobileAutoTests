package pages;

import base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DialogPage extends BasePage {
    private By changeDateIcon = MobileBy.xpath("//android.widget.Button[@content-desc=\"change the date\"]");
    private By okButton = MobileBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
    private By changeTheTime = MobileBy.xpath("//android.widget.Button[@content-desc=\"change the time (spinner)\"]");
    private By hours = MobileBy.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"1\"]");
    private By minutes = MobileBy.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"02\"]");
    private By periodDay = MobileBy.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"AM\"]");
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

    public DialogPage setDataAndTime(int enteredHours, int enteredMin, String enteredPeriodDay) {
        WebElement hoursInput = wait.until(ExpectedConditions.elementToBeClickable((hours)));
        hoursInput.click();
        hoursInput.clear();
        hoursInput.sendKeys(String.valueOf(enteredHours));
        WebElement minutesInput = wait.until(ExpectedConditions.elementToBeClickable((minutes)));
        minutesInput.click();
        minutesInput.clear();
        minutesInput.sendKeys(String.valueOf(enteredMin));
        WebElement periodOfDay = wait.until(ExpectedConditions.elementToBeClickable((periodDay)));
        periodOfDay.click();
        periodOfDay.clear();
        periodOfDay.sendKeys(String.valueOf(enteredPeriodDay));
        periodOfDay.click();
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
