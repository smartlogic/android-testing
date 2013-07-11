package com.example;

import android.widget.Button;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;
    private Button button;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        button = (Button) activity.findViewById(R.id.button);
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull("Activity is null", activity);
        assertNotNull("Button is null", button);
    }
}
