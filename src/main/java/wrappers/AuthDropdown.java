package wrappers;

import org.openqa.selenium.By;

//Класс-обертка для поиска элементов дропдауна регистрации/логина
public class AuthDropdown {

    private final String container = "//div[@class = 'tnb-%s-dropdown-form-container']";

    public By dropdownContainer(String typeOfClass) {
        return By.xpath(String.format(container, typeOfClass));
    }

    public By exitButton(String typeOfClass) {
        return By.xpath(String.format(container + "//a[@id='tnb-login-dropdown-signup-link']", typeOfClass));
    }

    public By authHeader(String typeOfClass) {
        return By.xpath(String.format(container + "//div[@class='auth-header']", typeOfClass));
    }

    public By authSwitchForm(String typeOfClass) {
        return By.xpath(String.format(container + "//p[@class='switch-form']", typeOfClass));
    }

    public By changeFormLink(String typeOfClass, String nameOfElement) {
        return By.xpath(String.format("//a[@id='tnb-%s-dropdown-%s-link']", typeOfClass, nameOfElement));
    }

    public By socialButton(String typeOfClass, String nameOfElement) {
        return By.xpath(String.format(container + "//button[@class ='social-button %s']", typeOfClass, nameOfElement));
    }

    public By input(String typeOfClass, String nameOfElement) {
        return By.xpath(String.format(container + "//input[@placeholder='%s']", typeOfClass, nameOfElement));
    }

    public By submitButton(String typeOfClass) {
        return By.xpath(String.format(container + "//button[@type='submit']", typeOfClass));
    }

    public By findDropdownOnPage(String text) {
        return By.xpath(String.format("//div[contains(text(), '%s')]", text));
    }
}
