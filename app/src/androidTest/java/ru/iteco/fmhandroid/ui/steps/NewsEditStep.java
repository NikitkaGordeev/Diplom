package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static ru.iteco.fmhandroid.ui.data.Data.dateNews;
import static ru.iteco.fmhandroid.ui.data.Data.description;
import static ru.iteco.fmhandroid.ui.data.Data.timeNews;
import static ru.iteco.fmhandroid.ui.data.Data.titleBirthday;
import static ru.iteco.fmhandroid.ui.data.Data.titleHelp;
import static ru.iteco.fmhandroid.ui.data.Data.titleHoliday;
import static ru.iteco.fmhandroid.ui.data.Data.titleMassage;
import static ru.iteco.fmhandroid.ui.data.Data.titleNotificate;
import static ru.iteco.fmhandroid.ui.data.Data.titleSalary;
import static ru.iteco.fmhandroid.ui.data.Data.titleThanks;
import static ru.iteco.fmhandroid.ui.data.Data.titleUnion;
import static ru.iteco.fmhandroid.ui.data.Helper.checkToast;
import static ru.iteco.fmhandroid.ui.data.Helper.clickChildViewWithId;
import static ru.iteco.fmhandroid.ui.data.Helper.waitElement;
import static ru.iteco.fmhandroid.ui.data.Helper.waitUntilVisible;

import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.viewElements.EditNewsElements;

public class NewsEditStep {
    EditNewsElements editNewsElements = new EditNewsElements();
    public static int confirmDeleteNewsButtonId = android.R.id.button1;
    NewsStep newsStep = new NewsStep();


    public void scrollNews(int i) {
        onView(withId(newsStep.newsListId))
                .perform(scrollToPosition(i))
                .perform(actionOnItemAtPosition(i, scrollTo()))
                .check(matches(isDisplayed()));
    }

    @Step("Создание новой новости")
    public void addNews(String category, String tittle, String date, String time, String description) {
        Allure.step("Создание новой новости");
        editNewsElements.addNewsButton.perform(click());
        editNewsElements.categoryField.perform(replaceText(category));
        editNewsElements.tittleField.perform(replaceText(tittle));
        editNewsElements.dateField.perform(replaceText(date));
        editNewsElements.timeField.perform(replaceText(time));
        editNewsElements.descriptionField.perform(replaceText(description));
        editNewsElements.saveButton.perform(click());
    }

    @Step("Поиск новости в списке по загаловку")
    public void findNewsWithTittle(String tittle) {
        Allure.step("Поиск новости в списке по загаловку ");
        waitElement(newsStep.newsListId);
        onView(withId(newsStep.newsListId)).check(matches(isDisplayed())).perform(RecyclerViewActions.scrollTo(hasDescendant(allOf(withText(tittle)))));
        onView(withId(newsStep.newsListId)).check(matches(isDisplayed()));
    }

    @Step("Редактирование новости")
    public void editNews(String tittle) {
        Allure.step("Редактирование новости");
        findNewsWithTittle(tittle);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(tittle))))
                .perform(clickChildViewWithId(R.id.edit_news_item_image_view));
    }

    @Step("Проверка полей созданной новости Notificate")
    public void checkNewsNotificate() {
        Allure.step("Проверка полей созданной новости Notificate");
        onView(withText(titleNotificate)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Massage")
    public void checkNewsMassage() {
        Allure.step("Проверка полей созданной новости Massage");
        onView(withText(titleMassage)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Thanks")
    public void checkNewsThanks() {
        Allure.step("Проверка полей созданной новости Thanks");
        onView(withText(titleThanks)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Help")
    public void checkNewsHelp() {
        Allure.step("Проверка полей созданной новости Help");
        onView(withText(titleHelp)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Birthday")
    public void checkNewsBirthday() {
        Allure.step("Проверка полей созданной новости Birthday");
        onView(withText(titleBirthday)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Holiday")
    public void checkNewsHoliday() {
        Allure.step("Проверка полей созданной новости Holiday");
        onView(withText(titleHoliday)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Salary")
    public void checkNewsSalary() {
        Allure.step("Проверка полей созданной новости Salary");
        onView(withText(titleSalary)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка полей созданной новости Union")
    public void checkNewsUnion() {
        Allure.step("Проверка полей созданной новости Union");
        onView(withText(titleUnion)).check(matches(isDisplayed()));
        onView(withText(dateNews)).check(matches(isDisplayed()));
        onView(withText(timeNews)).check(matches(isDisplayed()));
        onView(withText(description)).check(matches(isDisplayed()));
    }

    @Step("Проверка заголовка после изменения")
    public void checkTittleСhange(String tittle) {
        Allure.step("Проверка заголовка после изменения");
        onView(withText(tittle)).check(matches(isDisplayed()));
    }

    @Step("Смена заголовка новости")
    public void changeTittleNews(String newTittle) {
        Allure.step("Смена заголовка новости");
        editNewsElements.tittleField.perform(replaceText(newTittle));
        editNewsElements.saveButton.perform(click());
        waitElement(newsStep.newsListId);
    }

    @Step("Удаление новости")
    public void deleteNews(String tittle) {
        Allure.step("Удаление новости");
        findNewsWithTittle(tittle);
        onView(allOf(withId(R.id.news_item_material_card_view), hasDescendant(withText(tittle))))
                .perform(clickChildViewWithId(R.id.delete_news_item_image_view));
        confirmDelete();
    }

    @Step("Проверка, что новость удалена")
    public void checkIfNoNewsWithTitle(String title) {
        Allure.step("Проверка, что новости с указанным заголовком нет");
        onView(allOf(withText(title), isDisplayed())).check(doesNotExist());
    }


    @Step("Подверждение удаления новости")
    public void confirmDelete() {
        Allure.step("Подверждение удаления новости");
        waitElement(confirmDeleteNewsButtonId);
        editNewsElements.confirmDeleteNewsButton.perform(click());
    }

    @Step("Создание новости с пустыми полями")
    public void addNewsWithEmptyFields() {
        Allure.step("Создание новости с пустыми полями");
        editNewsElements.addNewsButton.perform(click());
        editNewsElements.saveButton.perform(click());
    }

    @Step("Создание новости с пустым заголовком")
    public void addNewsWithEmptyTittle(String category, String date, String time, String description) {
        Allure.step("Создание новости с пустым заоголовком");
        editNewsElements.addNewsButton.perform(click());
        editNewsElements.categoryField.perform(replaceText(category));
        editNewsElements.dateField.perform(replaceText(date));
        editNewsElements.timeField.perform(replaceText(time));
        editNewsElements.descriptionField.perform(replaceText(description));
        editNewsElements.saveButton.perform(click());
    }

    @Step("Видимость сообщения об ошибке при создании новости с пустыми полями")
    public void visibleErrorNotBeEmpty() {
        Allure.step("Видимость сообщения об ошибке при создании новости с пустыми полями");
        waitUntilVisible(checkToast(R.string.empty_fields, true));
    }
}