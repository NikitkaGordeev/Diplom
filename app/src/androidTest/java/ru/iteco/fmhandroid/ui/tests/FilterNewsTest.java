package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.catBirthday;
import static ru.iteco.fmhandroid.ui.data.Data.catHelp;
import static ru.iteco.fmhandroid.ui.data.Data.catHoliday;
import static ru.iteco.fmhandroid.ui.data.Data.catMassage;
import static ru.iteco.fmhandroid.ui.data.Data.catNotificate;
import static ru.iteco.fmhandroid.ui.data.Data.catSalary;
import static ru.iteco.fmhandroid.ui.data.Data.catThanks;
import static ru.iteco.fmhandroid.ui.data.Data.catUnion;
import static ru.iteco.fmhandroid.ui.data.Data.dateNews;
import static ru.iteco.fmhandroid.ui.data.Data.description;
import static ru.iteco.fmhandroid.ui.data.Data.timeNews;
import static ru.iteco.fmhandroid.ui.data.Data.titleBirthdayFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleHelpFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleHolidayFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleMassageFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleNotificateFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleSalaryFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleThanksFilt;
import static ru.iteco.fmhandroid.ui.data.Data.titleUnionFilt;
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
import ru.iteco.fmhandroid.ui.steps.AuthStep;
import ru.iteco.fmhandroid.ui.steps.FilterNewsStep;
import ru.iteco.fmhandroid.ui.steps.MainStep;
import ru.iteco.fmhandroid.ui.steps.NewsEditStep;
import ru.iteco.fmhandroid.ui.steps.NewsStep;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class FilterNewsTest {

    FilterNewsStep filterNewsStep = new FilterNewsStep();
    AuthStep authStep = new AuthStep();
    MainStep mainStep = new MainStep();
    NewsStep newsStep = new NewsStep();
    NewsEditStep newsEditStep = new NewsEditStep();
    @Before
    public void setUp() {
        authStep.checkLogInAndLogInIfNot();
        mainStep.goToNewsPage();
        newsStep.goToNewsEditingPage();
    }

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule = new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE, generateScreenshotName("Failed"));

    @Test
    @DisplayName("Фильтрация новостей по категории Профсоюз")
    public void filteredNewsUnion() {
        newsEditStep.addNews(catUnion, titleUnionFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catUnion);
        newsEditStep.checkTittleСhange(titleUnionFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории День рождения")
    public void filteredNewsBirthday() {
        newsEditStep.addNews(catBirthday, titleBirthdayFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catBirthday);
        newsEditStep.checkTittleСhange(titleBirthdayFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории Благодарность")
    public void filteredNewsThanks() {
        newsEditStep.addNews(catThanks, titleThanksFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catThanks);
        newsEditStep.checkTittleСhange(titleThanksFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории Зарплата")
    public void filteredNewsSalary() {
        newsEditStep.addNews(catSalary, titleSalaryFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catSalary);
        newsEditStep.checkTittleСhange(titleSalaryFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории Массаж")
    public void filteredNewsMassage() {
        newsEditStep.addNews(catMassage, titleMassageFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catMassage);
        newsEditStep.checkTittleСhange(titleMassageFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории Нужна помощь")
    public void filteredNewsHelp() {
        newsEditStep.addNews(catHelp, titleHelpFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catHelp);
        newsEditStep.checkTittleСhange(titleHelpFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории Праздник")
    public void filteredNewsHoliday() {
        newsEditStep.addNews(catHoliday, titleHolidayFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catHoliday);
        newsEditStep.checkTittleСhange(titleHolidayFilt);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории Объявления")
    public void filteredNewsNotificate() {
        newsEditStep.addNews(catNotificate, titleNotificateFilt, dateNews, timeNews, description);
        mainStep.goToNewsPage();
        filterNewsStep.filterNews(catNotificate);
        newsEditStep.checkTittleСhange(titleNotificateFilt);
    }
}
