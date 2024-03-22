package pages;

import base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextSwitcherPage extends BasePage {
    private By nextButton = MobileBy.xpath("//android.widget.Button[@content-desc=\"Next\"]");
    private String numberOfClicks ="//android.widget.TextView[@text=\"%d\"]";

    public TextSwitcherPage() {
        super();
    }

    public void clickRandomTimesOnNextButton(int random) {
        for (int i = 0; i < random; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(nextButton))).click();
        }
    }
    public int getNumberOfClicks(int expectedNumber){
        By locator =  MobileBy.xpath(String.format(numberOfClicks, expectedNumber));
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).getText());
    }
}