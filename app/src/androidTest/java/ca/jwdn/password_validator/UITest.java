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
    private String passes1 = "pass";
    private String passes2 = "notpassword";
    private String passes3 = "moreSecure";
    private String passes4 = "securePassword1";
    private String passes5 = "superSecurePassword123!";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void verifyRule1(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes1));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 1/5")));
    }

    @Test
    public void verifyRule2(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes2));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 2/5")));
    }

    @Test
    public void verifyRule3(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes3));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 3/5")));
    }

    @Test
    public void verifyRule4(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes4));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 4/5")));
    }

    @Test
    public void verifyRule5(){
        onView(withId(R.id.passwordInput)).perform(click());
        onView(withId(R.id.passwordInput)).perform(typeText(passes5));
        onView(withId(R.id.submitButton)).perform((click()));
        onView(withId(R.id.resultLabel)).check(matches(withText("Security: 5/5")));
    }
}

