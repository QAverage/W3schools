package steps;

import lombok.extern.log4j.Log4j2;
import menu.BaseMenu;
import menu.dropdown.SignInDropdownMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import wrappers.AuthDropdown;

import static menu.dropdown.SignInDropdownMenu.TYPE_OF_LOGIN_CLASS;

@Log4j2
public class AuthorizationStep extends BaseMenu {

    SignInDropdownMenu signInDropdownMenu;
    AuthDropdown authDropdown;

    public AuthorizationStep(WebDriver driver) {
        super(driver);
        signInDropdownMenu = new SignInDropdownMenu(driver);
        authDropdown = new AuthDropdown();
    }

    public AuthorizationStep authUser(String email, String password){
        log.info("Auth on page");
        signInDropdownMenu.inputEmail(email)
                .inputPassword(password)
                .clickOnSubmitButton();
        wait.until(ExpectedConditions.invisibilityOf(findElement(authDropdown.submitButton(TYPE_OF_LOGIN_CLASS))));
        return this;
    }
}
