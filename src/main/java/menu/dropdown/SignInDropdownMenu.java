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
    public SignInDropdownMenu clickOnSocialButton(String nameOfElement) {
        log.info("Click on social button {}", nameOfElement);
        clickOnElement(authDropdown.socialButton(TYPE_OF_LOGIN_CLASS, nameOfElement));
        return this;
    }

    @Step("Клик по ссылке register")
    public SignInDropdownMenu clickOnChangeDropdownLink() {
        log.info("Click on Register link");
        clickOnElement(authDropdown.changeFormLink(TYPE_OF_LOGIN_CLASS, "signup"));
        return this;
    }

    @Step("Ввод email")
    public SignInDropdownMenu inputEmail(String email) {
        inputValue(authDropdown.input(TYPE_OF_LOGIN_CLASS, "Email"), email);
        log.info("Input email address");
        return this;
    }

    @Step("Ввод пароля")
    public SignInDropdownMenu inputPassword(String password) {
        inputValue(authDropdown.input(TYPE_OF_LOGIN_CLASS, "Password"), password);
        log.info("Input password");
        return this;
    }

    @Step("Клик по кнопке Submit")
    public SignInDropdownMenu clickOnSubmitButton() {
        clickOnElement(authDropdown.submitButton(TYPE_OF_LOGIN_CLASS));
        log.info("Click on submit button");
        return this;

    }

    @Step("Клик по ссылке для восстановления пароля")
    public void clickOnForgotPasswordLink() {
        clickOnElement(FORGOT_PASSWORD_LINK);
        log.info("Click on forgot password link");
    }
}

