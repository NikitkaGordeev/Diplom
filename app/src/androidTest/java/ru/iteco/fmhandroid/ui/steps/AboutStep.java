package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.viewElements.AboutElements;

public class AboutStep {
    AboutElements aboutElements = new AboutElements();

    @Step("Проверка видимость страницы About")
    public void checkAboutPage() {
        Allure.step("Проверка видимость страницы About");
        aboutElements.versionText.check(matches(isDisplayed()));
    }

    @Step("Проверка кликабельности ссылки")
    public void checkingTheLinksClickabilityLinkTermsOfUse() {
        Allure.step("Проверка кликабельности ссылки TermsOfUse");
        aboutElements.linkTermsOfUse.check(matches(isClickable()));
    }

    @Step("Проверка кликабельности ссылки")
    public void checkingTheLinksClickabilityLinkPrivacyPolicy() {
        Allure.step("Проверка кликабельности ссылки PrivacyPolicy");
        aboutElements.linkPrivacyPolicy.check(matches(isDisplayed()));
    }

}