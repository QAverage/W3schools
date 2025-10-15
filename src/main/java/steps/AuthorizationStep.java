package steps;

import lombok.extern.log4j.Log4j2;
import menu.BaseMenu;
import menu.dropdown.SignInDropdownMenu;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AuthorizationStep extends BaseMenu {

    SignInDropdownMenu signInDropdownMenu;

    public AuthorizationStep(WebDriver driver) {
        super(driver);
        signInDropdownMenu = new SignInDropdownMenu(driver);
    }

    public AuthorizationStep authUser(String email, String password){
        log.info("Auth on page");
        signInDropdownMenu.inputEmail(email)
                .inputPassword(password)
                .clickOnSubmitButton();
        return this;
    }
}
