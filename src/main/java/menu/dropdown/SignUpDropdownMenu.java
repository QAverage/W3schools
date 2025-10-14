package menu.dropdown;

import io.qameta.allure.Step;
import menu.BaseMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpDropdownMenu extends BaseMenu {

    public static final String TYPE_OF_SIGN_UP_CLASS = "signup";

    public SignUpDropdownMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка видимости дропдауна на странице")
    public WebElement findSignUpDropdown() {
        return findElement(authDropdown.findDropdownOnPage("Create your account"));
    }
}
