package com.example;

import com.example.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
  private MainActivity activity;

  @Before
  public void setUp() {
    activity = Robolectric.buildActivity(MainActivity.class).create().get();
  }

  @Test
  public void shouldNotBeNull() {
    assertNotNull(activity);
  }
}
