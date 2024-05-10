package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.viewElements.QuotesElements;

public class QuotesStep {
    QuotesElements quotesElements = new QuotesElements();
    @Step("Проверяем видимость страницы с цитатами")
    public void checkQuotesPage() {
        Allure.step("Проверяем видимость страницы с цитатами");
        quotesElements.quoteText.check(matches(isDisplayed()));
    }
}
