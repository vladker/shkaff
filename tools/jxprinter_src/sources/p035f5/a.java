package p035f5;

import A3.AbstractC0157z;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import g5.b;
import g5.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Collection f3972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SQLiteDatabase f3973j;

    public static String A(d dVar) {
        String str = dVar.f4026a;
        Collection<b> collectionValues = dVar.b.values();
        if (collectionValues.isEmpty()) {
            return null;
        }
        StringBuilder sbY = AbstractC0157z.y("insert into ", str, "(");
        boolean z6 = false;
        boolean z7 = false;
        for (b bVar : collectionValues) {
            if (z7) {
                sbY.append(", ");
            }
            sbY.append(bVar.f4024a);
            z7 = true;
        }
        sbY.append(") select ");
        for (b bVar2 : collectionValues) {
            if (z6) {
                sbY.append(", ");
            }
            sbY.append(bVar2.f4024a);
            z6 = true;
        }
        sbY.append(" from ");
        sbY.append(D(str));
        return sbY.toString();
    }

    public static String D(String str) {
        return androidx.collection.a.n(str, "_temp");
    }

    public static boolean E(g5.a aVar, String str, String str2) {
        return aVar.f4023a.equalsIgnoreCase(str) && aVar.b.equalsIgnoreCase(str2);
    }

    public static void z(ArrayList arrayList, SQLiteDatabase sQLiteDatabase) {
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList2.add(c.t((String) arrayList.get(i5)));
        }
        c.q(arrayList2, sQLiteDatabase);
    }

    public final ArrayList B(d dVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = C(dVar.f4026a).b.values().iterator();
        while (it.hasNext()) {
            String str = ((b) it.next()).f4024a;
            if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.US).endsWith("_id") && !str.equalsIgnoreCase("_id") && !dVar.b.containsKey(AbstractC1282k.a(str))) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:62:0x012f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0134  */
    public final d C(String str) throws Throwable {
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabase = this.f3973j;
        if (!J.l(str, sQLiteDatabase)) {
            throw new p024d5.b(AbstractC0157z.n("Table doesn't exist when executing ", str));
        }
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery2 = null;
        try {
            Cursor cursorRawQuery3 = sQLiteDatabase.rawQuery("pragma index_list(" + str + ")", null);
            try {
                if (cursorRawQuery3.moveToFirst()) {
                    cursorRawQuery = null;
                    do {
                        try {
                            if (cursorRawQuery3.getInt(cursorRawQuery3.getColumnIndexOrThrow("unique")) == 1) {
                                cursorRawQuery = sQLiteDatabase.rawQuery("pragma index_info(" + cursorRawQuery3.getString(cursorRawQuery3.getColumnIndexOrThrow("name")) + ")", null);
                                if (cursorRawQuery.moveToFirst()) {
                                    hashSet.add(cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("name")));
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            cursorRawQuery2 = cursorRawQuery3;
                            try {
                                e.printStackTrace();
                                throw new p024d5.b(e.getMessage());
                            } catch (Throwable th) {
                                th = th;
                                if (cursorRawQuery2 != null) {
                                    cursorRawQuery2.close();
                                }
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursorRawQuery2 = cursorRawQuery3;
                            if (cursorRawQuery2 != null) {
                                cursorRawQuery2.close();
                            }
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            throw th;
                        }
                    } while (cursorRawQuery3.moveToNext());
                } else {
                    cursorRawQuery = null;
                }
                cursorRawQuery3.close();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                d dVar = new d();
                dVar.f4026a = str;
                try {
                    try {
                        cursorRawQuery2 = sQLiteDatabase.rawQuery(AbstractC0157z.o("pragma table_info(", str, ")"), null);
                        if (cursorRawQuery2.moveToFirst()) {
                            do {
                                b bVar = new b();
                                String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("name"));
                                String string2 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("type"));
                                boolean z6 = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndexOrThrow("notnull")) != 1;
                                boolean zContains = hashSet.contains(string);
                                String string3 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndexOrThrow("dflt_value"));
                                bVar.f4024a = string;
                                bVar.b = string2;
                                bVar.c = z6;
                                bVar.d = zContains;
                                bVar.b(string3 != null ? string3.replace("'", "") : "");
                                dVar.b.put(AbstractC1282k.a(bVar.f4024a), bVar);
                            } while (cursorRawQuery2.moveToNext());
                        }
                        cursorRawQuery2.close();
                        return dVar;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        throw new p024d5.b(e6.getMessage());
                    }
                } catch (Throwable th3) {
                    if (cursorRawQuery2 != null) {
                        cursorRawQuery2.close();
                    }
                    throw th3;
                }
            } catch (Exception e7) {
                e = e7;
                cursorRawQuery = null;
            } catch (Throwable th4) {
                th = th4;
                cursorRawQuery = null;
            }
        } catch (Exception e8) {
            e = e8;
            cursorRawQuery = null;
        } catch (Throwable th5) {
            th = th5;
            cursorRawQuery = null;
        }
    }

    public final void F(String str, ArrayList arrayList) throws Throwable {
        if (arrayList.isEmpty()) {
            return;
        }
        d dVarC = C(str);
        HashMap map = dVarC.b;
        StringBuilder sbY = AbstractC0157z.y("alter table ", str, " rename to ");
        sbY.append(D(str));
        String string = sbY.toString();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            map.remove(AbstractC1282k.a((String) obj));
        }
        String strS = c.s(dVarC.f4026a, map.values(), true);
        String strA = A(dVarC);
        String strT = c.t(D(str));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(string);
        arrayList2.add(strS);
        arrayList2.add(strA);
        arrayList2.add(strT);
        c.q(arrayList2, this.f3973j);
    }

    public final void y(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("delete from table_schema where");
        int size = arrayList.size();
        boolean z6 = false;
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            String str = (String) obj;
            if (z6) {
                sb.append(" or ");
            }
            androidx.collection.a.x(sb, " lower(name) = lower('", str, "')");
            z6 = true;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(sb.toString());
        c.q(arrayList2, this.f3973j);
    }
}
