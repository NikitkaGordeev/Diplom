package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Helper.generateScreenshotName;

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
import ru.iteco.fmhandroid.ui.steps.AboutStep;
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
import ru.iteco.fmhandroid.ui.steps.QuotesStep;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NavigateTest {

    AboutStep aboutStep = new AboutStep();
    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();
    NewsStep newsStep = new NewsStep();
    QuotesStep quotesStep = new QuotesStep();


    @Before
    public void setUp(){
        authStep.checkLogInAndLogInIfNot();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));

    @Test
    @DisplayName("Переход на вкладку  ALL NEWS")
    public void goToNewsPageByAllNewsButtonTest() {
        mainStep.goToNewsPageByAllNewsButton();
        newsStep.checkNewsPage();
    }

    @Test
    @DisplayName("Переход в новости через главное меню")
    public void goToNewsPageTest() {
        mainStep.goToNewsPage();
        newsStep.checkNewsPage();
    }

    @Test
    @DisplayName("Переход на страницу О приложении через главное меню")
    public void goToAboutPageTest() {
        mainStep.goToAboutPage();
        aboutStep.checkAboutPage();
    }

    @Test
    @DisplayName("Переход в на страницу Цитаты")
    public void goToQuotesPageTest() {
        mainStep.goToQuotesPage();
        quotesStep.checkQuotesPage();
    }

}