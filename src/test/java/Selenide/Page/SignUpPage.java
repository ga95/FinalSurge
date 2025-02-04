package Selenide.Page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SignUpPage {

    private static final SelenideElement SUBMIT_BUTTON = $x("//*[@type=\"submit\"]");
    private static final SelenideElement FIRST_NAME = $x("//*[@id=\"create_first\"]");
    private static final SelenideElement LAST_NAME = $x("//*[@id=\"create_last\"]");
    private static final SelenideElement EMAIL_FIELD = $x("//*[@id=\"create_email\"]");
    private static final SelenideElement PASSWORD_METER = $x("//*[@id=\"password_meter\"]");
    private static final SelenideElement PASSWORD_MARCH = $x("//*[@id=\"create_passwordmatch\"]");

    @Step("Нажимаем на кнопку зарегестрироваться")
    public static void clickSubmitLink() {
        SUBMIT_BUTTON.click();
    }

    @Step("Заполняем форму")
    public void fillForm(String first, String last, String email, String passMeter, String passMatch) {
        FIRST_NAME.setValue(first);
        LAST_NAME.setValue(last);
        EMAIL_FIELD.setValue(email);
        PASSWORD_METER.setValue(passMeter);
        PASSWORD_MARCH.setValue(passMatch);
    }

    @Step("Проверяем, что выведенный текст соответствует ожидаемому.")
    public static void checkText(String actualString, String expectedString) {
        if (!actualString.equals(expectedString)) {
            throw new AssertionError("Expected: " + expectedString + ", but got: " + actualString);
        }
    }
}