package tests;

import data.Users;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.*;

import static menu.dropdown.SignInDropdownMenu.TITLE;
import static menu.dropdown.SignInDropdownMenu.SWITCH_FORM_TEXT;

import static urlPaths.UrlPaths.BASE_URL;
import static urlPaths.UrlPaths.BASE_URL_AFTER_AUTH;

@Tag(value = "AuthDropdownTests")
public class SignInDropdownTest extends BaseTest {

    @DataProvider(name = "SocialButton")
    public Object[][] socialButton() {
        return new Object[][]{
                {"google", "https://accounts.google.com"},
                {"facebook", "https://www.facebook.com"},
                {"github", "https://github.com"},
                {"feide", "https://auth.dataporten.no"}
        };
    }

    @Parameters({"browser"})
    @BeforeMethod(description = "Настройки драйвера")
    public void specifySetup(@Optional("chrome") String browser) {
        setup(browser);
        events.open(BASE_URL, "MainPage");
        headerMenu.clickOnLogInButton();
    }

    @Test(description = "Проверка видимости меню авторизации")
    public void shouldSeeDropdownMenu() {
        signInDropdownMenu.findSignInDropdown().isDisplayed();
    }

    @Test(description = "Проверка заголовка меню авторизации")
    public void shouldCompareTitleText() {
        signInDropdownMenu.textEquals(signInDropdownMenu.findTitleText(),
                String.format("%s", TITLE));
    }

    @Test(description = "Проверка текста в поле со сменой типа дропдауна")
    public void shouldCompareTextInSwitchDropdownTitle() {
        signInDropdownMenu.textEquals(signInDropdownMenu.findSwitchTabText(),
                String.format("%s", SWITCH_FORM_TEXT));
    }

    @Test(description = "Проверка переключения типа дропдауна")
    public void shouldSwitchDropdownMenu() {
        signInDropdownMenu.clickOnChangeDropdownLink();

        signUpDropdownMenu.findSignUpDropdown().isDisplayed();
    }

    @Test(description = "Проверка открытия нового окна через кнопки соц.сетей", dataProvider = "SocialButton")
    public void shouldOpenNewWindow(String socialButton, String exceptedUrl) {
        signInDropdownMenu.clickOnSocialButton(socialButton).checkUrlOfNewWindow(exceptedUrl);
    }

    @Test(description = "Проверка успешной авторизации")
    public void shouldAuthUser() {
        authorizationStep.authUser(Users.EMAIL_ADDRESS, Users.PASSWORD)
                .checkUrl(BASE_URL_AFTER_AUTH);
    }

    @Test(description = "Проверка открытия формы для восстановления пароля")
    public void shouldOpenRecoveryPasswordForm(){
        signInDropdownMenu.clickOnForgotPasswordLink();

        recoveryPasswordDropdownMenu.findRecoveryDropdown().isDisplayed();
    }
}

