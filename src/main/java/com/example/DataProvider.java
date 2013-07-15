package com.example;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class DataProvider extends ContentProvider {
    private DatabaseHelper database;
    UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int ITEMS = 0;

    @Override
    public boolean onCreate() {
        uriMatcher.addURI("myapp", "items", ITEMS);

        database = new DatabaseHelper(getContext());

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        qb.setTables("items");
        Cursor cursor = qb.query(database.getReadableDatabase(), projection, selection, selectionArgs, null, null, "_id");
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case ITEMS:
                return "items";
            default:
                return null;
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
