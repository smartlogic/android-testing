package com.example;


import android.widget.ListView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricTestRunner.class)
public class PlanetsActivityTest {
    private PlanetsActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(PlanetsActivity.class).create().get();
    }

    @Test
    public void shouldHaveAllPlanetsListed() {
        ListView view = (ListView) activity.findViewById(android.R.id.list);

        assertThat(view).hasCount(8);
    }
}
