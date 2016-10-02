package com.fmsirvent.experimentalarchitecturemarvel.view;


import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.fmsirvent.experimentalarchitecturemarvel.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class OpenComicTest {
    private static final String FIRST_CHARACTER_NAME = "3-D Man";
    private static final int WAIT_MILLISECONDS = 2000;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void openComicTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.add_character),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        SystemClock.sleep(WAIT_MILLISECONDS);

        ViewInteraction firstItem = onView(
                allOf(withText(FIRST_CHARACTER_NAME),
                        isDisplayed()));
        firstItem.perform(click());

        SystemClock.sleep(WAIT_MILLISECONDS);

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.favourite_characters),
                        withParent(allOf(withId(R.id.favourite_characters),
                                withParent(withId(R.id.activity_main)))),
                        isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        SystemClock.sleep(WAIT_MILLISECONDS);

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.comics),
                        withParent(allOf(withId(R.id.content),
                                withParent(withId(R.id.activity_main)))),
                        isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        SystemClock.sleep(WAIT_MILLISECONDS);

        ViewInteraction imageView = onView(
                allOf(withId(R.id.comic_thumbnail),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
