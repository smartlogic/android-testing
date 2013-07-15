package com.example;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.robolectric.tester.android.view.TestMenuItem;


import static org.fest.assertions.api.ANDROID.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;
    private Button button;
    private Button hideTextButton;
    private TextView text;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        button = (Button) activity.findViewById(R.id.button);
        hideTextButton = (Button) activity.findViewById(R.id.hide_text_button);
        text = (TextView) activity.findViewById(R.id.text_view);
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull("Activity is null", activity);
        assertNotNull("Button is null", button);
        assertNotNull("Hide text button is null", hideTextButton);
        assertNotNull("Text is null", text);
    }

    @Test
    public void englishLanguage() {
        assertThat(button).containsText("Hello");
    }

    @Test @Config(qualifiers = "de")
    public void germanLanguage() {
        assertThat(button).containsText("Hallo");
    }

    @Test
    public void shouldHideText() {
        hideTextButton.performClick();

        assertThat(text).isNotVisible();
    }

    @Test
    public void shouldLaunchNewActivity() {
        button.performClick();

        ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Robolectric.shadowOf(startedIntent);

        assertThat(shadowIntent.getComponent().getClassName(), equalTo(AnotherActivity.class.getName()));
    }

    @Test
    public void clickingMenuItems() {
        MenuItem item = new TestMenuItem(R.id.launch_activity);

        activity.onOptionsItemSelected(item);

        ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = Robolectric.shadowOf(startedIntent);

        assertThat(shadowIntent.getComponent().getClassName(), equalTo(AnotherActivity.class.getName()));
    }
}
