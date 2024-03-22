package pages;

import base.BasePage;
import base.Swiper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ViewsPage extends BasePage {
    private By tabElement = MobileBy.xpath("//*[@resource-id='android:id/text1']");
    private By dataWidgetsTab = MobileBy.xpath("//android.widget.TextView[@content-desc=\"Date Widgets\"]");
    private By textSwitcherTab = MobileBy.xpath("//android.widget.TextView[@content-desc=\"TextSwitcher\"]");

    public ViewsPage() {
        super();
    }

    public int getTabElementsCount() {
        List<String> listOfElementsText = new ArrayList<>();
        List<MobileElement> listOfElementsOnCurrentPage;
        for (int i = 0; i < 5; i++) {
            listOfElementsOnCurrentPage = driver.findElements(tabElement);
            for (MobileElement element : listOfElementsOnCurrentPage) {
                listOfElementsText.add(element.getText());
            }
            swiper.swipe(Swiper.Directions.DOWN);
        }
        return new HashSet<>(listOfElementsText).size();
    }

    public DataWidgetsPage clickDateWidgets() {
        wait.until(ExpectedConditions.elementToBeClickable(dataWidgetsTab)).click();
        return new DataWidgetsPage();
    }

    public ViewsPage scrollToTheEnd() {
        for (int i = 0; i < 3; i++) {
            swiper.swipe(Swiper.Directions.DOWN);
        }
        return this;
    }

    public TextSwitcherPage clickTextSwitcher() {
        wait.until(ExpectedConditions.elementToBeClickable(textSwitcherTab)).click();
        return new TextSwitcherPage();
    }
}
