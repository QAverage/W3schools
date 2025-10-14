package menu.dropdown;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import menu.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class RecoveryPasswordDropdownMenu extends BaseMenu {

    public RecoveryPasswordDropdownMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка видимости дропдауна на странице")
    public WebElement findRecoveryDropdown() {
        return findElement(authDropdown.findDropdownOnPage("Reset your password"));
    }
}
