/**
 * CSCI 3130 - Assignment 2
 *
 * File:            UITest.java
 * Description:     Espresso tests verify the functionality of the app's UI
 *
 * Author:          Jon Wadden, B00713127
 * Date:            June 9, 2018
 */

package ca.jwdn.password_validator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {

    // Define passwords to validate
    private String passes1 = "pass";
    private String passes2 = "notpassword";
    private String passes3 = "moreSecure";
    private String passes4 = "securePassword1";
    private String passes5 = "superSecurePassword123!";

    // Tests are to be run on the main activity
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    // Verify rule 1 (Password is not 'password')
    @Test
    public void verifyRule1(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes1));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 1/5")));
    }

    // Verify rule 2 (Password is 8 or more characters)
    @Test
    public void verifyRule2(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes2));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 2/5")));
    }

    // Verify rule 3 (Password contains at least 1 lowercase and 1 capital letter)
    @Test
    public void verifyRule3(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes3));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 3/5")));
    }

    // Verify rule 4 (Password contains at least 1 number)
    @Test
    public void verifyRule4(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes4));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 4/5")));
    }

    // Verify rule 5 (Password contains at least 1 non-alphanumeric character)
    @Test
    public void verifyRule5(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes5));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 5/5")));
    }
}

