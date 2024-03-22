package base;

import driver.WebDriverSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest extends WebDriverSetup {
    protected MainPage mainPage;
    protected ViewsPage viewsPage;
    protected DialogPage dialogPage;
    protected DataWidgetsPage dataWidgetsPage;
    protected TextSwitcherPage textSwitcherPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSetup.getInstance().setup();
        mainPage = new MainPage();
        viewsPage = new ViewsPage();
        dialogPage = new DialogPage();
        dataWidgetsPage = new DataWidgetsPage();
        textSwitcherPage = new TextSwitcherPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
