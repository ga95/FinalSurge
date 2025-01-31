package Selenide.test;

import Selenide.Page.LoginPage;
import Selenide.Page.SignUpPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

import static Selenide.Page.LoginPage.openMainPage;


@Listeners(TestListener.class)
public class BaseTest {

    protected LoginPage loginPage;
    protected SignUpPage signUpPage;

    @BeforeMethod
    @Step("Открытие браузера, ожидание 5сек на загрузку.")
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true;
        Configuration.timeout = 5000; // Timeout in milliseconds
        openMainPage();
        loginPage = new LoginPage();
        signUpPage = new SignUpPage();
    }

//    @AfterMethod(alwaysRun = true)
//    public void exit() {
//    }
}