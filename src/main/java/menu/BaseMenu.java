package menu;

import org.openqa.selenium.WebDriver;
import events.Events;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.AuthDropdown;

import java.time.Duration;

public class BaseMenu extends Events {

    public AuthDropdown authDropdown;
    public WebDriverWait wait;

    public BaseMenu(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        authDropdown = new AuthDropdown();
    }
}
