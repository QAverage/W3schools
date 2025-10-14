package menu;

import events.Events;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.AuthDropdown;

@Log4j2
public class HeaderMenu extends BaseMenu {

    private final By mainLogo = By.xpath("a[id='w3-logo']");
    private final By signInButton = By.xpath("//span[text()='Sign In']");

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по главной иконке")
    public void clickOnMainLogo() {
        log.info("Click on main logo");
        clickOnElement(mainLogo);
    }

    @Step("Клик по кнопке 'Sign In'")
    public void clickOnLogInButton() {
        log.info("Click on button Sign In");
        clickOnElement(signInButton);
    }
}
