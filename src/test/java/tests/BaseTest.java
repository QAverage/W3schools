package tests;

import events.Events;
import lombok.extern.log4j.Log4j2;
import menu.HeaderMenu;
import menu.dropdown.RecoveryPasswordDropdownMenu;
import menu.dropdown.SignInDropdownMenu;
import menu.dropdown.SignUpDropdownMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.TestListener;
import steps.Authorization;

import java.time.Duration;
import java.util.HashMap;

import static utils.AllureUtils.takeScreenshot;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    Events events;
    HeaderMenu headerMenu;
    SignInDropdownMenu signInDropdownMenu;
    SignUpDropdownMenu signUpDropdownMenu;
    RecoveryPasswordDropdownMenu recoveryPasswordDropdownMenu;

    //wrappers
    Authorization authorization;

    public void setup(String browser) {
        log.info("Setup and config browser driver");
        //Базовая настройка драйвера
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        //Дополнительные настройки
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        initializeComponents();
    }

    protected void initializeComponents() {
        //Действия
        softAssert = new SoftAssert();
        events = new Events(driver);
        //Обертки
        authorization = new Authorization(driver);
        //Страницы

        //Меню
        signInDropdownMenu = new SignInDropdownMenu(driver);
        signUpDropdownMenu = new SignUpDropdownMenu(driver);
        recoveryPasswordDropdownMenu = new RecoveryPasswordDropdownMenu(driver);

        headerMenu = new HeaderMenu(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            log.debug("Make screenshot point with error");
            takeScreenshot(driver);
        }
        log.info("delete cookies and quit of browser");
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
