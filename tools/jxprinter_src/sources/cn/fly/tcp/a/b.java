package cn.fly.tcp.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.fly.commons.x;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f1529a;

    public b(Context context) {
        this.f1529a = new a(context.getApplicationContext());
    }

    public void a(String str, long j6) {
        try {
            SQLiteDatabase writableDatabase = this.f1529a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("workId", str);
            contentValues.put("expireTime", Long.valueOf(j6));
            writableDatabase.replace(a.f1528a, null, contentValues);
            writableDatabase.close();
        } catch (Throwable th) {
            c.a().a(th);
        }
    }

    public void b(String str) {
        try {
            SQLiteDatabase writableDatabase = this.f1529a.getWritableDatabase();
            SQLiteDatabase.class.getDeclaredMethod(x.b("007e5dh5eb]dkiied"), String.class, Object[].class).invoke(writableDatabase, "delete from " + a.f1528a + " where workId = ?", new String[]{str});
            writableDatabase.close();
        } catch (Throwable th) {
            c.a().a(th);
        }
    }

    public long a(String str) {
        try {
            SQLiteDatabase readableDatabase = this.f1529a.getReadableDatabase();
            Cursor cursor = (Cursor) SQLiteDatabase.class.getMethod(x.b("008Lci7cYefiicfOe;cidb"), String.class, String[].class).invoke(readableDatabase, "select expireTime from " + a.f1528a + " where workId = ?", new String[]{str});
            if (cursor.moveToFirst()) {
                return cursor.getLong(cursor.getColumnIndex("expireTime"));
            }
            cursor.close();
            readableDatabase.close();
            return 0L;
        } catch (Throwable th) {
            c.a().a(th);
            return 0L;
        }
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = this.f1529a.getWritableDatabase();
            String str = "delete from " + a.f1528a + " where expireTime < ?";
            SQLiteDatabase.class.getDeclaredMethod(x.b("007e*dhQeb!dkiied"), String.class, Object[].class).invoke(writableDatabase, str, new String[]{System.currentTimeMillis() + ""});
            writableDatabase.close();
        } catch (Throwable th) {
            c.a().a(th);
        }
    }
}
