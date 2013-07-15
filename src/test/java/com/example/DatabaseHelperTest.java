package com.example;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class DatabaseHelperTest {
    private DatabaseHelper dbHelper;

    @Before
    public void setUp() {
        Context context = new Activity(); // Activity implements context
        dbHelper = new DatabaseHelper(context);
    }

    @Test
    public void shouldCreateItemsTable() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("items", null, null, null, null, null, null);

        assertThat(cursor.getCount(), equalTo(0));
        cursor.close();

        ContentValues values = new ContentValues();
        values.put("name", "hi");
        db.insert("items", "name", values);

        cursor = db.query("items", null, null, null, null, null, null);

        assertThat(cursor.getCount(), equalTo(1));
    }
}
