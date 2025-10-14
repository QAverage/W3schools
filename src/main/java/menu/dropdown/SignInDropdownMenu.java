package menu.dropdown;

import data.Users;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import menu.BaseMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static urlPaths.UrlPaths.BASE_URL_AFTER_AUTH;

@Log4j2
public class SignInDropdownMenu extends BaseMenu {

    private final By FORGOT_PASSWORD_LINK = By.xpath("//div[@class='forgot-password']");

    public static final String TYPE_OF_LOGIN_CLASS = "login";
    public static final String TITLE = """
            
                 \s
                   \s
                     \s
                     \s
                   \s
                 \s
                  Sign in\
            
                  Get access to more learning features
                \
            """;
    public static final String SWITCH_FORM_TEXT = "\n      Don't have an account? Register\n    ";

    public SignInDropdownMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка видимости дропдауна на странице")
    public WebElement findSignInDropdown() {
        return findElement(authDropdown.findDropdownOnPage("Sign in"));
    }

    public String findTitleText() {
        return findElement(authDropdown.authHeader(TYPE_OF_LOGIN_CLASS)).getDomProperty("textContent");
    }

    public String findSwitchTabText() {
        return findElement(authDropdown.authSwitchForm(TYPE_OF_LOGIN_CLASS)).getDomProperty("textContent");
    }

    @Step("Клик по кнопке соц.сети {name}")
    public void clickOnSocialButton(String nameOfElement) {
        log.info("Click on social button {}", nameOfElement);
        clickOnElement(authDropdown.socialButton(TYPE_OF_LOGIN_CLASS, nameOfElement));
    }

    @Step("Клик по ссылке register")
    public void clickOnChangeDropdownLink() {
        log.info("Click on Register link");
        clickOnElement(authDropdown.changeFormLink(TYPE_OF_LOGIN_CLASS, "signup"));
    }

    @Step("Ввод email")
    public void inputEmail(String email) {
        log.info("Input email address");
        inputValue(authDropdown.input(TYPE_OF_LOGIN_CLASS, "Email"), email);
    }

    @Step("Ввод пароля")
    public void inputPassword(String password) {
        log.info("Input password");
        inputValue(authDropdown.input(TYPE_OF_LOGIN_CLASS, "Password"), password);
    }

    @Step("Клик по кнопке Submit")
    public void clickOnSubmitButton() {
        log.info("Click on submit button");
        clickOnElement(authDropdown.submitButton(TYPE_OF_LOGIN_CLASS));
        wait.until(ExpectedConditions.urlToBe(BASE_URL_AFTER_AUTH));
    }

    @Step("Клик по ссылке для восстановления пароля")
    public void clickOnForgotPasswordLink() {
        log.info("Click on forgot password link");
        clickOnElement(FORGOT_PASSWORD_LINK);
    }
}

