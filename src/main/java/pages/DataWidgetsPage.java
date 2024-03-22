package pages;

import base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DataWidgetsPage extends BasePage {
    private By dialogTab = MobileBy.xpath("//android.widget.TextView[@content-desc=\"1. Dialog\"]");

    public DataWidgetsPage() {
        super();
    }

    public DialogPage clickDialog() {
        wait.until(ExpectedConditions.elementToBeClickable(dialogTab)).click();
        return new DialogPage();
    }
}
