package com.claseetn.carlosbetancur.m_v_p_base.providers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by carlos andres betancur marin on 13/12/17.
 */
    public abstract class DbContentProvider {
    public SQLiteDatabase mDb;

    public DbContentProvider (SQLiteDatabase mDb){
        this.mDb = mDb;
    }

    public int delete (String tableName, String selection, String [] selectionArgs){
        return mDb.delete(tableName, selection, selectionArgs);
    }

    public long insert (String tableName, ContentValues values){
        return mDb.insert(tableName, null, values);
    }

    protected abstract <T> T cursorToEntity (Cursor cursor);

    public Cursor query (String tableName, String [] columns, String selection, String [] selectionArgs, String sortOrder){
        final Cursor cursor = mDb.query(tableName, columns, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    public Cursor query (String tableName, String [] columns, String selection, String [] selectionArgs, String sortOrder, String limit){
        return mDb.query(tableName, columns, selection, selectionArgs, null, null, sortOrder, limit);
    }

    public Cursor query (String tableName, String [] columns, String selection, String [] selectionArgs, String groupBy, String having, String orderBy, String limit){
        return mDb.query(tableName, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
    }

    public int update (String tableName, ContentValues values, String selection, String[] selectionArgs){
        return mDb.update(tableName, values, selection, selectionArgs);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return mDb.rawQuery(sql, selectionArgs);
    }


}