package com.foxsay.mathtest.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

import com.foxsay.mathtest.provider.MathTestContract.*;
import com.foxsay.mathtest.util.SelectionBuilder;

import java.util.Arrays;

import static com.foxsay.mathtest.util.LogUtils.LOGV;
import static com.foxsay.mathtest.util.LogUtils.makeLogTag;

public class MathTestProvider extends ContentProvider {
    private static final String TAG = makeLogTag(MathTestProvider.class);

    private MathTestDatabaseHelper mDBOpenHelper;

    static final String PROVIDER_NAME = "com.foxsay.mathtest";

    static final String URL = "content://" + PROVIDER_NAME + "/cpcontacts";

    static final Uri CONTENT_URL = Uri.parse(URL);

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static final int TASKS = 100;
    private static final int TASKS_ID = 101;

    private static final int TESTS = 200;
    private static final int TESTS_ID = 201;

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = MathTestContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, "tasks", TASKS);
        matcher.addURI(authority, "tasks/*", TASKS_ID);

        matcher.addURI(authority, "tests", TESTS);
        matcher.addURI(authority, "tests/*", TESTS_ID);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        mDBOpenHelper = new MathTestDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        final SQLiteDatabase db = mDBOpenHelper.getReadableDatabase();

        String tagsFilter = uri.getQueryParameter(Sessions.QUERY_PARAMETER_TAG_FILTER);
        final int match = sUriMatcher.match(uri);

        // avoid the expensive string concatenation below if not loggable
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            LOGV(TAG, "uri=" + uri + " match=" + match + " proj=" + Arrays.toString(projection) +
                    " selection=" + selection + " args=" + Arrays.toString(selectionArgs) + ")");
        }


        switch (match) {
            default: {
                // Most cases are handled with simple SelectionBuilder
                final SelectionBuilder builder = buildExpandedSelection(uri, match);

                // If a special filter was specified, try to apply it
                if (!TextUtils.isEmpty(tagsFilter)) {
                    addTagsFilter(builder, tagsFilter);
                }

                boolean distinct = !TextUtils.isEmpty(
                        uri.getQueryParameter(ScheduleContract.QUERY_PARAMETER_DISTINCT));

                Cursor cursor = builder
                        .where(selection, selectionArgs)
                        .query(db, distinct, projection, sortOrder, null);
                Context context = getContext();
                if (null != context) {
                    cursor.setNotificationUri(context.getContentResolver(), uri);
                }
                return cursor;
            }
            case SEARCH_SUGGEST: {
                final SelectionBuilder builder = new SelectionBuilder();

                // Adjust incoming query to become SQL text match
                selectionArgs[0] = selectionArgs[0] + "%";
                builder.table(Tables.SEARCH_SUGGEST);
                builder.where(selection, selectionArgs);
                builder.map(SearchManager.SUGGEST_COLUMN_QUERY,
                        SearchManager.SUGGEST_COLUMN_TEXT_1);

                projection = new String[] {
                        BaseColumns._ID,
                        SearchManager.SUGGEST_COLUMN_TEXT_1,
                        SearchManager.SUGGEST_COLUMN_QUERY
                };

                final String limit = uri.getQueryParameter(SearchManager.SUGGEST_PARAMETER_LIMIT);
                return builder.query(db, false, projection, SearchSuggest.DEFAULT_SORT, limit);
            }
        }
    }

    @Override
    public String getType(Uri uri) {

        switch (uriMatcher.match(uri)){

            case uriCode:
                return "vnd.android.cursor.dir/cpcontacts";

            default:
                throw new IllegalArgumentException("Unsupported URI " + uri);

        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        final SQLiteDatabase db = mDBOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);

        switch (match){
            case TASKS: {
                db.insertOrThrow(Tables.TASKS, null, values);
                return Tasks.buildUri(values.getAsString(BaseColumns._ID));
            }
            default: {
                throw new UnsupportedOperationException("Unknown insert uri: " + uri);
            }
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        LOGV(TAG, "delete(uri=" + uri + ")");

        final SQLiteDatabase db = mDBOpenHelper.getWritableDatabase();
        final SelectionBuilder builder = buildSimpleSelection(uri);

        return builder.where(selection, selectionArgs).delete(db);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        LOGV(TAG, "update(uri=" + uri + ", values=" + values.toString() + ")");
        final SQLiteDatabase db = mDBOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);

        final SelectionBuilder builder = buildSimpleSelection(uri);
        if (match == TASKS) {
            //TODO impl smth
        }
        return builder.where(selection, selectionArgs).update(db, values);
    }

    /**
     * Build a simple {@link SelectionBuilder} to match the requested
     * {@link Uri}. This is usually enough to support {@link #insert},
     * {@link #update}, and {@link #delete} operations.
     */
    private SelectionBuilder buildSimpleSelection(Uri uri) {
        final SelectionBuilder builder = new SelectionBuilder();
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case TASKS: {
                return builder.table(Tables.TASKS);
            }
            case TASKS_ID: {
                return builder.table(Tables.TASKS).where(BaseColumns._ID + "=" + Tasks.getId(uri));
            }
            default: {
                throw new UnsupportedOperationException("Unknown uri for " + match + ": " + uri);
            }
        }
    }

}
