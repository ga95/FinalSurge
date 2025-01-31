package Selenide.Page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final SelenideElement loginButton = $x("//*[text()=\"Login\"]");
    private static final SelenideElement loginInput = $x("//*[@id=\"login_name\"]");
    private static final SelenideElement passInput = $x("//*[@id=\"login_password\"]");
    private static final SelenideElement logoutButton = $x("//*[text()=\"Logout\"]");
    private static final SelenideElement welcomeText = $(".user-info");
    private static final SelenideElement logoutText = $x("//*[@id=\"login-wrapper\"]/div[1]/div/div[1]/strong");
    private static final SelenideElement signUpLink = $x("//*[@id=\"login-validate\"]/div[3]/a");

    public static void openMainPage() {
        open("https://log.finalsurge.com/");
    }

    public static void logIn(String login, String pass) {
        loginInput.setValue(login);
        passInput.setValue(pass);
        clickLoginButton();
        checkText(welcomeText.getText(), "Welcome, Andrey\nSettings · Logout");
    }

    public static void logOut() {
        logoutButton.click();
        checkText(logoutText.getText(), "You have been successfully logged out of the system.");
    }

    @Step("Проверка ожидаемого и выведенного текста")
    public static void checkText(String actualString, String expectedString) {
        if (!actualString.equals(expectedString)) {
            throw new AssertionError("Expected: " + expectedString + ", but got: " + actualString);
        }
    }

    @Step("Нажать на кнопку зарегестрироваться")
    public static void clickSignupLink() {
        signUpLink.click();
    }

    @Step("Нажать на кнопку авторизироваться.")
    public static void clickLoginButton() {
        loginButton.click();
    }
}