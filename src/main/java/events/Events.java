package events;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

//Класс-обертка для различных действий с элементами
@Log4j2
public class Events {

    WebDriver driver;

    public Events(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы: {page}")
    public void open(String url, String page) {
        driver.get(url);
        log.info("Open {}", page);
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public Events inputValue(By element, String value) {
        driver.findElement(element).sendKeys(value);
        return this;
    }

    public void textEquals(String currentText, String expectedText) {
        assertEquals(currentText, expectedText,
                String.format("""
                        Current value is not same with expected
                        Expected message: %s
                        Current message: %s""", expectedText, currentText));
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    public void checkUrl(String url) {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, url, "Current url is not same with expected");
    }

    public void checkUrlOfNewWindow(String url) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Object[] windowHandles = driver.getWindowHandles().toArray();
        try {
            driver.switchTo().window((String) windowHandles[1]);
        } catch (NoSuchWindowException e) {
            log.error("No such window with url: {}", url);
        } catch (TimeoutException e) {
            log.error("Timeout of wait a new window with url: {}", url);
        }
        String currentUrl = driver.getCurrentUrl();
        assertEquals(extractBaseUrl(currentUrl), url, "Current url is not same with expected");
    }

    private static String extractBaseUrl(String url) {
        String regex = "^(https?://[^/]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return url;
        }
    }
}
