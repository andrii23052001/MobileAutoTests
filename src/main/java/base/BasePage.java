package base;

import driver.WebDriverSetup;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected Swiper swiper;

    public BasePage() {
        this.driver = WebDriverSetup.getInstance().getDriver();
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        this.swiper = new Swiper(driver);

    }
}
