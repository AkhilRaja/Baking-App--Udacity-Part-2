package com.example.akhilraja.bakingapp.Activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.akhilraja.bakingapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest3 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest3() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView),
                        childAtPosition(
                                withId(R.id.fragement_main),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.ingredient_list),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardView),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView.perform(replaceText("1.  Graham Cracker crumbs\n2.  unsalted butter, melted\n3.  granulated sugar\n4.  salt\n5.  vanilla\n6.  Nutella or other chocolate-hazelnut spread\n7.  Mascapone Cheese(room temperature)\n8.  heavy cream(cold)\n9.  cream cheese(softened)\n"), closeSoftKeyboard());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recyclerView2),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(4970);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.ingredient_list),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardView),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView2.perform(replaceText("1.  Graham Cracker crumbs\n2.  unsalted butter, melted\n3.  granulated sugar\n4.  salt\n5.  vanilla\n6.  Nutella or other chocolate-hazelnut spread\n7.  Mascapone Cheese(room temperature)\n8.  heavy cream(cold)\n9.  cream cheese(softened)\n"), closeSoftKeyboard());

        ViewInteraction appCompatTextView3 = onView(
                allOf(withId(R.id.ingredient_list),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardView),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView3.perform(replaceText("1.  Graham Cracker crumbs\n2.  unsalted butter, melted\n3.  granulated sugar\n4.  salt\n5.  vanilla\n6.  Nutella or other chocolate-hazelnut spread\n7.  Mascapone Cheese(room temperature)\n8.  heavy cream(cold)\n9.  cream cheese(softened)\n"), closeSoftKeyboard());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.recyclerView2),
                        childAtPosition(
                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                1)));
        recyclerView3.perform(actionOnItemAtPosition(0, click()));

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.exo_pause), withContentDescription("Pause"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                3),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.exo_play), withContentDescription("Play"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(538);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatTextView4 = onView(
                allOf(withId(R.id.ingredient_list),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardView),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView4.perform(replaceText("1.  Graham Cracker crumbs\n2.  unsalted butter, melted\n3.  granulated sugar\n4.  salt\n5.  vanilla\n6.  Nutella or other chocolate-hazelnut spread\n7.  Mascapone Cheese(room temperature)\n8.  heavy cream(cold)\n9.  cream cheese(softened)\n"), closeSoftKeyboard());

        ViewInteraction appCompatTextView5 = onView(
                allOf(withId(R.id.ingredient_list),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardView),
                                        0),
                                1),
                        isDisplayed()));
        appCompatTextView5.perform(replaceText("1.  Graham Cracker crumbs\n2.  unsalted butter, melted\n3.  granulated sugar\n4.  salt\n5.  vanilla\n6.  Nutella or other chocolate-hazelnut spread\n7.  Mascapone Cheese(room temperature)\n8.  heavy cream(cold)\n9.  cream cheese(softened)\n"), closeSoftKeyboard());

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
