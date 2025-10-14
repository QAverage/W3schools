package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class BasePage {

    WebDriver driver;
    public WebDriverWait wait;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Примеры использования JavascriptExecutor
    public void clickJS(WebElement element) {
        js.executeScript("arguments[0].click;", element);
    }

    public void scrollToElementJS(WebElement element) {
        js.executeScript("argument[0].scrollIntoView(true)", element);
    }

    public void getValueJS(WebElement element) {
        js.executeScript("return argument[0].value", element);
    }

    //Метод для ожидания загрузки Ajax страницы
    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
    }
}
