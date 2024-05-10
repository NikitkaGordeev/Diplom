package ru.iteco.fmhandroid.ui.viewElements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainElements {

    public ViewInteraction mainMenuButton = onView(allOf(withId(R.id.main_menu_image_button)));
    public ViewInteraction newsButton = onView(withText(R.string.news));
    public ViewInteraction logOutButton = onView(allOf(withId(R.id.authorization_image_button)));
    public ViewInteraction quotesButton = onView(allOf(withId(R.id.our_mission_image_button)));
    public ViewInteraction aboutButton = onView(withText(R.string.about));
    public ViewInteraction allNewsButton = onView(allOf(withId(R.id.all_news_text_view)));

}
