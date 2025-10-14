package steps;

import lombok.extern.log4j.Log4j2;
import menu.dropdown.SignInDropdownMenu;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Authorization{

    SignInDropdownMenu signInDropdownMenu;

    public Authorization(WebDriver driver) {
        signInDropdownMenu = new SignInDropdownMenu(driver);
    }

    public void authUser(String email, String password){
        log.info("Auth on page");
        signInDropdownMenu.inputEmail(email);
        signInDropdownMenu.inputPassword(password);
        signInDropdownMenu.clickOnSubmitButton();
    }
}
