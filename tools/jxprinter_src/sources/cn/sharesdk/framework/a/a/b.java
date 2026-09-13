package cn.sharesdk.framework.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2129a = new a();

    private b() {
    }

    public static synchronized b a() {
        try {
            if (b == null) {
                b = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.f2129a.getWritableDatabase();
        SSDKLog.b().a("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
        } catch (Exception e) {
            SSDKLog.b().b(e, "when query database occur error table:%s,", str);
            return null;
        }
    }

    public long a(String str, ContentValues contentValues) {
        try {
            return this.f2129a.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e) {
            SSDKLog.b().b(e, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    public int a(String str, String str2, String[] strArr) {
        int iDelete;
        try {
            iDelete = this.f2129a.getWritableDatabase().delete(str, str2, strArr);
            try {
                SSDKLog.b().a("Deleted %d rows from table: %s", Integer.valueOf(iDelete), str);
                return iDelete;
            } catch (Exception e) {
                e = e;
                SSDKLog.b().b(e, "when delete database occur error table:%s,", str);
                return iDelete;
            }
        } catch (Exception e6) {
            e = e6;
            iDelete = 0;
        }
    }

    public int a(String str) throws Throwable {
        Exception e;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) this.f2129a.getClass().getMethod("getWritableDatabase", null).invoke(this.f2129a, null);
            cursor = (Cursor) sQLiteDatabase.getClass().getDeclaredMethod("rawQuery", String.class, String[].class).invoke(sQLiteDatabase, "select count(*) from " + str, null);
            try {
                try {
                    int i5 = cursor.moveToNext() ? cursor.getInt(0) : 0;
                    cursor.close();
                    return i5;
                } catch (Exception e6) {
                    e = e6;
                    SSDKLog.b().b(e);
                    cursor.close();
                    return 0;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                cursor2.close();
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor2.close();
            throw th;
        }
    }
}
