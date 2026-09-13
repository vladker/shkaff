package cn.fly.tcp.a;

import A3.AbstractC0157z;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.fly.commons.m;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1528a;
    private static final String b;

    static {
        String strA = m.a("003Ufhhkgl");
        f1528a = strA;
        b = AbstractC0157z.o("CREATE TABLE ", strA, " (workId TEXT PRIMARY KEY,expireTime INTEGER )");
    }

    public a(Context context) {
        super(context, "elp_msg.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            SQLiteDatabase.class.getMethod(m.a("007hBgk<he^gnllhg"), String.class).invoke(sQLiteDatabase, b);
        } catch (Throwable th) {
            c.a().a(th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
    }
}
