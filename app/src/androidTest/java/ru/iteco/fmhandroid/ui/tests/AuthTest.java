package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.Data.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.Data.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.oneSumbolLogin;
import static ru.iteco.fmhandroid.ui.data.Data.oneSumbolPassword;
import static ru.iteco.fmhandroid.ui.data.Data.registerValidLogin;
import static ru.iteco.fmhandroid.ui.data.Data.registerValidPassword;
import static ru.iteco.fmhandroid.ui.data.Data.specLogin;
import static ru.iteco.fmhandroid.ui.data.Data.specSumbolPassword;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;
import static ru.iteco.fmhandroid.ui.data.Data.сyrillicLogin;
import static ru.iteco.fmhandroid.ui.data.Data.сyrillicPassword;
import static ru.iteco.fmhandroid.ui.data.Helper.generateScreenshotName;
import static ru.iteco.fmhandroid.ui.data.Helper.waitElement;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthTest {

    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();

    @Before
    public void setUp(){

        authStep.checkLogOutAndLogOutIfNot();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));


    @Test
    @DisplayName("Авторизация с валидными данными")
    public void validLoginAndPasswordAuthorizationTest() {
        authStep.login(validLogin, validPassword);
        waitElement(mainStep.LoginOutId);
        mainStep.logOutIsVisible();
    }

    @Test
    @DisplayName("Авторизация с пустой формой")
    public void emptyLoginAndPasswordAuthorizationTest() {
        authStep.login(emptyLogin,emptyPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Авторизация при вводе незарегестрированного пользователя")
    public void invalidLoginAuthorizationTest() {
        authStep.login(invalidLogin, validPassword);
        authStep.wrongLoginandPassword();
    }
    @Test
    @DisplayName("Авторизация при вводе в поле логин спецсимволов")
    public void specLoginAuthorizationTest() {
        authStep.login(specLogin, validPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("Авторизация при вводе в поле логин одного символа")
    public void oneSumbolLoginAuthorizationTest() {
        authStep.login(oneSumbolLogin, validPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("Авторизация при вводе в поле логина на кириллице (поле должно остаться пустым, так как не должно быть возможности ввода логина на кириллице)")
    public void сyrillicLoginAndPasswordAuthorizationTest() {
        authStep.login(сyrillicLogin,validPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Авторизация при вводе в поле логин валидного логина разным регистром")
    public void registerValidLoginAuthorizationTest() {
        authStep.login(registerValidLogin, validPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("Авторизация при пустом поле пароля")
    public void emptyPasswordAuthorizationTest() {
        authStep.login(validLogin, emptyPassword);
        authStep.emptyLoginAndPassword();
    }

    @Test
    @DisplayName("Авторизация при вводе невалиного пароля")
    public void invalidPasswordAuthorizationTest() {
        authStep.login(validLogin, invalidPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("В поле Password введены спецсимволы")
    public void specSumbolPasswordAuthorizationTest() {
        authStep.login(validLogin, specSumbolPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("В поле Password введен один символ")
    public void oneSumbolPasswordAuthorizationTest() {
        authStep.login(validLogin, oneSumbolPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("В поле Password введен валидный пароль разным регистром")
    public void registerValidPasswordAuthorizationTest() {
        authStep.login(validLogin, registerValidPassword);
        authStep.wrongLoginandPassword();
    }

    @Test
    @DisplayName("В поле Password введен пароль на кириллице (поле должно остаться пустым, так как не должно быть возможности ввода логина на кириллице)")
    public void сyrillicPasswordAuthorizationTest() {
        authStep.login(validLogin, сyrillicPassword);
        authStep.emptyLoginAndPassword();
    }
}