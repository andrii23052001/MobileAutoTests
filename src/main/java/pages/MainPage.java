package pages;

import base.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    private By viewsTab = MobileBy.AccessibilityId("Views");

    public MainPage() {
        super();
    }

    public ViewsPage clickViews() {
        wait.until(ExpectedConditions.elementToBeClickable(viewsTab)).click();
        return new ViewsPage();
    }
}
