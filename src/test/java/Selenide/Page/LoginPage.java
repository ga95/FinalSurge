package Selenide.Page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final SelenideElement LOGIN_BUTTON = $x("//*[text()=\"Login\"]");
    private static final SelenideElement LOGIN_INPUT = $x("//*[@id=\"login_name\"]");
    private static final SelenideElement PASS_INPUT = $x("//*[@id=\"login_password\"]");
    private static final SelenideElement LOGOUT_BUTTON = $x("//*[text()=\"Logout\"]");
    private static final SelenideElement WELCOME_TEXT = $(".user-info");
    private static final SelenideElement LOGOUT_TEXT = $x("//*[@id=\"login-wrapper\"]/div[1]/div/div[1]/strong");
    private static final SelenideElement SIGNUP_LINK = $x("//*[@id=\"login-validate\"]/div[3]/a");

    public static void openMainPage() {
        open("https://log.finalsurge.com/");
    }

    public static void logIn(String login, String pass) {
        LOGIN_INPUT.setValue(login);
        PASS_INPUT.setValue(pass);
        clickLoginButton();
        checkText(WELCOME_TEXT.getText(), "Welcome, Andrey\nSettings · Logout");
    }

    public static void logOut() {
        LOGOUT_BUTTON.click();
        checkText(LOGOUT_TEXT.getText(), "You have been successfully logged out of the system.");
    }

    @Step("Проверка ожидаемого и выведенного текста")
    public static void checkText(String actualString, String expectedString) {
        if (!actualString.equals(expectedString)) {
            throw new AssertionError("Expected: " + expectedString + ", but got: " + actualString);
        }
    }

    @Step("Нажать на кнопку зарегестрироваться")
    public static void clickSignupLink() {
        SIGNUP_LINK.click();
    }

    @Step("Нажать на кнопку авторизироваться.")
    public static void clickLoginButton() {
        LOGIN_BUTTON.click();
    }

    @Step("Проверяем, что авторизация удалась по первому слову welcome.")
    public static void checkAuth(String actualString, String expectedString) {
        char[] ch = actualString.toCharArray();
        char[] ch2 = expectedString.toCharArray();
        int i = 0;
        for(i=0;i<7; i++){
            if (ch[i] != ch2[i]) { throw new AssertionError("Expected: " + expectedString + ", but got: " + actualString);}
        }
    }

}