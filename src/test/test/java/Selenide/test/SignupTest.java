package Selenide.test;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import utils.Retry;

import static Selenide.Page.SignUpPage.checkText;
import static Selenide.Page.LoginPage.clickSignupLink;
import static Selenide.Page.SignUpPage.clickSubmitLink;
import static com.codeborne.selenide.Selenide.$x;

public class SignupTest extends BaseTest {
    @Test(priority = 1, testName = "Поле имени не заполнено", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с незаполненным полем имени.")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void withoutFirstName() {
        clickSignupLink();
        signUpPage.fillForm("", "Gorev", "test@test.ru", "Test@Test", "Test@Test");
        clickSubmitLink();
        checkText($x("//*[@for=\"create_first\"][2]").getText(), "This field is required.");
    }

    @Test(priority = 1, testName = "Поле фамилия не заполнено", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с незаполненным полем фамилии")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void withoutLastName() {
        clickSignupLink();
        signUpPage.fillForm("Andrey", "", "test@test.ru", "Test@Test", "Test@Test");
        clickSubmitLink();
        checkText($x("//*[@for=\"create_last\"][2]").getText(), "This field is required.");
    }

    @Test(priority = 1, testName = "Поле email не заполнено", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с незаполненным полем email")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void withoutEmail() {
        clickSignupLink();
        signUpPage.fillForm("Andrey", "Gorev", "", "Test@Test", "Test@Test");
        clickSubmitLink();
        checkText($x("//*[@for=\"create_email\"][2]").getText(), "This field is required.");
    }

    @Test(priority = 1, testName = "Поле пароль не заполнено", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с незаполненным полем пароль")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void withoutPassMeter() {
        clickSignupLink();
        signUpPage.fillForm("Andrey", "Gorev", "test@test.ru", "", "Test@Test");
        clickSubmitLink();
        checkText($x("//*[@for=\"password_meter\"]").getText(), "This field is required.");
    }

    @Test(priority = 1, testName = "Поле повторите пароль не заполнено", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с незаполненным полем повторите пароль")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void withoutPassMatch() {
        clickSignupLink();
        signUpPage.fillForm("Andrey", "Gorev", "test@test.ru", "Test@Test", "");
        clickSubmitLink();
        checkText($x("//*[@for=\"create_passwordmatch\"][2]").getText(), "This field is required.");
    }

    @Test(priority = 1, testName = "Поле email заполнено некорректно", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с email заполненным некорректно")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void invalidEmail() {
        clickSignupLink();
        signUpPage.fillForm("Andrey", "Gorev", "test@test", "Test@Test", "Test@test");
        clickSubmitLink();
        checkText($x("//*[@for=\"create_email\"][2]").getText(), "Please enter a valid email address.");
    }

    @Test(priority = 1, testName = "Поле пароль заполнено некорректно", retryAnalyzer = Retry.class)
    @Description("Проверка регистрации с паролем заполненным некорректно")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("FinalSurge-1.0")
    @Feature("Signup at FinalSurge")
    @Story("Регистрация")
    @TmsLink("http://www.jira.simple/RL-84")
    @Issue("http://www.jira.simple/RL-145")
    @Flaky
    public void passwordIsNotInForm() {
        clickSignupLink();
        signUpPage.fillForm("Andrey", "Gorev", "test@test.ru", "Test", "Test");
        clickSubmitLink();
        checkText($x("//*[@id=\"login-wrapper\"]/div[1]/div/div").getText(),
                "Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length.");
    }
}