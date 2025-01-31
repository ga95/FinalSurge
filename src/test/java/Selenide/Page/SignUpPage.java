package Selenide.Page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage {

    private static final SelenideElement submitButton = $x("//*[@type=\"submit\"]");
    private static final SelenideElement firstName = $x("//*[@id=\"create_first\"]");
    private static final SelenideElement lastName = $x("//*[@id=\"create_last\"]");
    private static final SelenideElement emailField = $x("//*[@id=\"create_email\"]");
    private static final SelenideElement passwordMeter = $x("//*[@id=\"password_meter\"]");
    private static final SelenideElement passwordMatch = $x("//*[@id=\"create_passwordmatch\"]");

    public SignUpPage() {
    }

    @Step("Нажимаем на кнопку зарегестрироваться")
    public static void clickSubmitLink() {
        submitButton.click();
    }

    @Step("Заполняем форму")
    public void fillForm(String first, String last, String email, String passMeter, String passMatch) {
        firstName.setValue(first);
        lastName.setValue(last);
        emailField.setValue(email);
        passwordMeter.setValue(passMeter);
        passwordMatch.setValue(passMatch);
    }

    @Step("Проверяем, что выведенный текст соответствует ожидаемому")
    public static void checkText(String actualString, String expectedString) {
        if (!actualString.equals(expectedString)) {
            throw new AssertionError("Expected: " + expectedString + ", but got: " + actualString);
        }
    }

}