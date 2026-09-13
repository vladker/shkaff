package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SQLiteHelper implements PublicMemberKeeper {

    public static class SingleTableDB implements PublicMemberKeeper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3681a;
        private String b;
        private SQLiteDatabase c;
        private LinkedHashMap<String, String> d;
        private HashMap<String, Boolean> e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f3682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f3683g;

        public void addField(String str, String str2, boolean z6) {
            if (this.c == null) {
                this.d.put(str, str2);
                this.e.put(str, Boolean.valueOf(z6));
            }
        }

        private SingleTableDB(String str, String str2) {
            this.f3681a = str;
            this.b = str2;
            this.d = new LinkedHashMap<>();
            this.e = new HashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() throws Throwable {
            if (TextUtils.isEmpty(this.f3681a)) {
                throw new Throwable("path is null");
            }
            File file = new File(this.f3681a);
            Cursor cursorQuery = null;
            if (this.c != null && !file.exists()) {
                this.c.close();
                try {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && (!parentFile.exists() || !parentFile.isDirectory())) {
                        parentFile.delete();
                        parentFile.mkdirs();
                    }
                } catch (Throwable unused) {
                }
                this.c = null;
            }
            if (this.c == null) {
                if (!file.exists()) {
                    try {
                        File parentFile2 = file.getParentFile();
                        if (parentFile2 != null && (!parentFile2.exists() || !parentFile2.isDirectory())) {
                            parentFile2.delete();
                            parentFile2.mkdirs();
                            file.createNewFile();
                        }
                    } catch (Throwable unused2) {
                    }
                }
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.c = sQLiteDatabaseOpenOrCreateDatabase;
                try {
                    cursorQuery = sQLiteDatabaseOpenOrCreateDatabase.query("sqlite_master", null, "type=? and name=?", new String[]{"table", this.b}, null, null, null);
                    boolean z6 = cursorQuery == null || cursorQuery.getCount() <= 0;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (z6) {
                        StringBuilder sbR = androidx.collection.a.r("create table  ");
                        sbR.append(this.b);
                        sbR.append("(");
                        for (Map.Entry<String, String> entry : this.d.entrySet()) {
                            String key = entry.getKey();
                            String value = entry.getValue();
                            boolean zBooleanValue = this.e.get(key).booleanValue();
                            boolean zEquals = key.equals(this.f3682f);
                            boolean z7 = zEquals ? this.f3683g : false;
                            androidx.collection.a.x(sbR, key, " ", value);
                            sbR.append(zBooleanValue ? " not null" : "");
                            sbR.append(zEquals ? " primary key" : "");
                            sbR.append(z7 ? " autoincrement," : ",");
                        }
                        sbR.replace(sbR.length() - 1, sbR.length(), ");");
                        try {
                            SQLiteDatabase.class.getMethod("execSQL", String.class).invoke(this.c, sbR.toString());
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                        }
                    }
                } catch (Throwable th2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            SQLiteDatabase sQLiteDatabase = this.c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.c = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            return this.b;
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.b();
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.delete(singleTableDB.c(), str, strArr);
    }

    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context != null ? context.getDatabasePath(str).getPath() : null, str);
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.replace(singleTableDB.c(), null, contentValues);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.query(singleTableDB.c(), strArr, str, strArr2, null, null, str2);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        singleTableDB.a();
        return singleTableDB.c.update(singleTableDB.c(), contentValues, str, strArr);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str, str2);
    }
}
