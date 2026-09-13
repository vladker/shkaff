package p035f5;

import A3.AbstractC0157z;
import Z4.a;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import g5.b;
import g5.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f3975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashSet f3976h;

    public static void n(SQLiteDatabase sQLiteDatabase, boolean z6) throws Throwable {
        c cVar = new c();
        for (g5.a aVar : (HashSet) cVar.u()) {
            int i5 = aVar.d;
            if (2 == i5 || 1 == i5) {
                o(aVar.f4023a, aVar.b, aVar.c, sQLiteDatabase);
            } else if (3 == i5) {
                String str = aVar.f4023a;
                String str2 = aVar.b;
                ArrayList arrayList = new ArrayList();
                b bVar = new b();
                bVar.f4024a = androidx.collection.a.n(str, "_id");
                bVar.b = "integer";
                b bVar2 = new b();
                bVar2.f4024a = androidx.collection.a.n(str2, "_id");
                bVar2.b = "integer";
                arrayList.add(bVar);
                arrayList.add(bVar2);
                String strI = J.i(str, str2);
                ArrayList arrayList2 = new ArrayList();
                if (!J.l(strI, sQLiteDatabase)) {
                    arrayList2.add(s(strI, arrayList, false));
                } else if (z6) {
                    arrayList2.add(t(strI));
                    arrayList2.add(s(strI, arrayList, false));
                }
                q(arrayList2, sQLiteDatabase);
                w(strI, 1, sQLiteDatabase);
            }
        }
        for (g5.c cVar2 : cVar.f902f) {
            String str3 = cVar2.f4025a;
            String str4 = cVar2.b;
            String str5 = cVar2.c;
            String str6 = cVar2.d;
            ArrayList arrayList3 = new ArrayList();
            b bVar3 = new b();
            bVar3.f4024a = str4;
            bVar3.b = str5;
            b bVar4 = new b();
            bVar4.f4024a = str6;
            bVar4.b = "integer";
            arrayList3.add(bVar3);
            arrayList3.add(bVar4);
            ArrayList arrayList4 = new ArrayList();
            if (!J.l(str3, sQLiteDatabase)) {
                arrayList4.add(s(str3, arrayList3, false));
            } else if (z6) {
                arrayList4.add(t(str3));
                arrayList4.add(s(str3, arrayList3, false));
            }
            q(arrayList4, sQLiteDatabase);
            w(str3, 2, sQLiteDatabase);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    public static void o(String str, String str2, String str3, SQLiteDatabase sQLiteDatabase) {
        String strE;
        if (!J.l(str, sQLiteDatabase)) {
            throw new p024d5.b(AbstractC0157z.n("Table doesn't exist with the name of ", str));
        }
        if (!J.l(str2, sQLiteDatabase)) {
            throw new p024d5.b(AbstractC0157z.n("Table doesn't exist with the name of ", str2));
        }
        Cursor cursorRawQuery = null;
        if (str.equals(str3)) {
            strE = a.e(str2);
        } else {
            strE = str2.equals(str3) ? a.e(str) : null;
        }
        boolean z6 = false;
        if (!TextUtils.isEmpty(strE) && !TextUtils.isEmpty(str3)) {
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery("pragma table_info(" + str3 + ")", null);
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            if (strE.equalsIgnoreCase(cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("name")))) {
                                z6 = true;
                                break;
                            }
                        } while (cursorRawQuery.moveToNext());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (cursorRawQuery != null) {
                        break;
                    }
                    if (z6) {
                    }
                    b bVar = new b();
                    bVar.f4024a = strE;
                    bVar.b = "integer";
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(r(str3, bVar));
                    q(arrayList, sQLiteDatabase);
                }
                cursorRawQuery.close();
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        }
        if (z6) {
            b bVar2 = new b();
            bVar2.f4024a = strE;
            bVar2.b = "integer";
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(r(str3, bVar2));
            q(arrayList2, sQLiteDatabase);
        }
    }

    public static void p(d dVar, SQLiteDatabase sQLiteDatabase, boolean z6) throws Throwable {
        ArrayList arrayList = new ArrayList();
        if (z6) {
            arrayList.add(t(dVar.f4026a));
            arrayList.add(s(dVar.f4026a, dVar.b.values(), true));
        } else if (J.l(dVar.f4026a, sQLiteDatabase)) {
            arrayList = null;
        } else {
            arrayList.add(s(dVar.f4026a, dVar.b.values(), true));
        }
        q(arrayList, sQLiteDatabase);
        w(dVar.f4026a, 0, sQLiteDatabase);
    }

    public static void q(ArrayList arrayList, SQLiteDatabase sQLiteDatabase) {
        String strA = "";
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        strA = AbstractC1282k.a(str);
                        sQLiteDatabase.execSQL(strA);
                    }
                }
            } catch (SQLException unused) {
                throw new p024d5.b(AbstractC0157z.n("An exception that indicates there was an error with SQL parsing or execution. ", strA));
            }
        }
    }

    public static String r(String str, b bVar) {
        StringBuilder sbY = AbstractC0157z.y("alter table ", str, " add column ");
        sbY.append(bVar.f4024a);
        sbY.append(" ");
        sbY.append(bVar.b);
        if (!bVar.c) {
            sbY.append(" not null");
        }
        if (bVar.d) {
            sbY.append(" unique");
        }
        String str2 = bVar.e;
        if (!TextUtils.isEmpty(str2)) {
            sbY.append(" default ");
            sbY.append(str2);
        } else if (!bVar.c) {
            if ("integer".equalsIgnoreCase(bVar.b)) {
                str2 = "0";
            } else if ("text".equalsIgnoreCase(bVar.b)) {
                str2 = "''";
            } else if ("real".equalsIgnoreCase(bVar.b)) {
                str2 = IdManager.DEFAULT_VERSION_NAME;
            }
            sbY.append(" default ");
            sbY.append(str2);
        }
        return sbY.toString();
    }

    public static String s(String str, Collection collection, boolean z6) {
        StringBuilder sbY = AbstractC0157z.y("create table ", str, " (");
        if (z6) {
            sbY.append("id integer primary key autoincrement,");
        }
        Iterator it = collection.iterator();
        do {
            if (!it.hasNext()) {
                sbY.deleteCharAt(sbY.length() - 1);
                break;
            }
        } while (((b) it.next()).a());
        Iterator it2 = collection.iterator();
        boolean z7 = false;
        while (it2.hasNext()) {
            b bVar = (b) it2.next();
            if (!bVar.a()) {
                if (z7) {
                    sbY.append(", ");
                }
                sbY.append(bVar.f4024a);
                sbY.append(" ");
                sbY.append(bVar.b);
                if (!bVar.c) {
                    sbY.append(" not null");
                }
                if (bVar.d) {
                    sbY.append(" unique");
                }
                String str2 = bVar.e;
                if (!TextUtils.isEmpty(str2)) {
                    sbY.append(" default ");
                    sbY.append(str2);
                }
                z7 = true;
            }
        }
        sbY.append(")");
        return sbY.toString();
    }

    public static String t(String str) {
        return AbstractC0157z.n("drop table if exists ", str);
    }

    public static void w(String str, int i5, SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select * from table_schema", null);
                try {
                    if (x(cursorRawQuery, str)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("name", AbstractC1282k.a(str));
                        contentValues.put("type", Integer.valueOf(i5));
                        sQLiteDatabase.insert("table_schema", null, contentValues);
                    }
                    cursorRawQuery.close();
                } catch (Exception e) {
                    e = e;
                    cursor = cursorRawQuery;
                    e.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public static boolean x(Cursor cursor, String str) {
        if (cursor.moveToFirst()) {
            while (!cursor.getString(cursor.getColumnIndexOrThrow("name")).equalsIgnoreCase(str)) {
                if (!cursor.moveToNext()) {
                }
            }
            return false;
        }
        return !"table_schema".equalsIgnoreCase(str);
    }

    public final Collection u() {
        HashSet hashSet = this.f3976h;
        if (hashSet == null || hashSet.isEmpty()) {
            List listA = p029e5.a.b().a();
            if (this.d == null) {
                this.d = new HashSet();
            }
            if (this.f902f == null) {
                this.f902f = new HashSet();
            }
            this.d.clear();
            this.f902f.clear();
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                c(1, (String) it.next());
            }
            this.f3976h = this.d;
        }
        return this.f3976h;
    }

    public final Collection v() {
        if (this.f3975g == null) {
            this.f3975g = new ArrayList();
        }
        ArrayList arrayList = this.f3975g;
        if (arrayList == null || arrayList.size() != p029e5.a.b().a().size()) {
            this.f3975g.clear();
            Iterator it = p029e5.a.b().a().iterator();
            while (it.hasNext()) {
                this.f3975g.add(i((String) it.next()));
            }
        }
        return this.f3975g;
    }
}
