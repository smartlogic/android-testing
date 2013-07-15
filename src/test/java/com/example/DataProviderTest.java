package com.example;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.DatabaseConfig;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class DataProviderTest {
    DataProvider dataProvider;
    Uri uri;

    @Before
    public void setUp() {

        dataProvider = new DataProvider();
        dataProvider.onCreate();

        uri = Uri.parse("content://myapp/items");


        assertNotNull(dataProvider.getContext());
    }

    @Test
    public void shouldGetItemType() {
        assertThat(dataProvider.getType(uri), equalTo("items"));
    }

    @Test
    @Ignore
    public void shouldQueryForItems() {
        ContentValues values = new ContentValues();
        values.put("name", "eric");
        dataProvider.insert(uri, values);

        Cursor cursor = dataProvider.query(uri, null, null, null, null);

        assertThat(cursor.getCount(), equalTo(1));

        cursor.moveToFirst();

        assertThat(cursor.getString(cursor.getColumnIndex("name")), equalTo("eric)"));
    }
}

