package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class WebDriverSetup {

    protected AppiumDriver driver;
    private static WebDriverSetup instance;

    public AppiumDriver setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_5_API_30");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
            desiredCapabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriverSetup getInstance() {
        if (instance == null)
            instance = new WebDriverSetup();
        return instance;
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}