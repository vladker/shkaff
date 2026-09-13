package p035f5;

import A3.AbstractC0157z;
import Z4.b;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import g5.a;
import g5.c;
import g5.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.litepal.LitePalApplication;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws Throwable {
        ArrayList arrayList = (ArrayList) new c().v();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            c.p((d) obj, sQLiteDatabase, true);
        }
        c.n(sQLiteDatabase, true);
        int i6 = b.f903a;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x020a  */
    /* JADX WARN: Code duplicated, block: B:115:0x022b  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a5 A[PHI: r11
  0x02a5: PHI (r11v12 android.database.Cursor) = 
  (r11v11 android.database.Cursor)
  (r11v13 android.database.Cursor)
  (r11v13 android.database.Cursor)
  (r11v13 android.database.Cursor)
 binds: [B:147:0x02b3, B:121:0x0259, B:126:0x0272, B:308:0x02a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:155:0x02db  */
    /* JADX WARN: Code duplicated, block: B:158:0x0301  */
    /* JADX WARN: Code duplicated, block: B:175:0x034f  */
    /* JADX WARN: Code duplicated, block: B:188:0x039f  */
    /* JADX WARN: Code duplicated, block: B:198:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:204:0x041c  */
    /* JADX WARN: Code duplicated, block: B:207:0x0434  */
    /* JADX WARN: Code duplicated, block: B:230:0x048f  */
    /* JADX WARN: Code duplicated, block: B:232:0x0496 A[LOOP:18: B:231:0x0494->B:232:0x0496, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:237:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:242:0x0540 A[LOOP:20: B:241:0x053e->B:242:0x0540, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:246:0x056f  */
    /* JADX WARN: Code duplicated, block: B:248:0x057c  */
    /* JADX WARN: Code duplicated, block: B:250:0x057f  */
    /* JADX WARN: Code duplicated, block: B:25:0x007d A[LOOP:1: B:24:0x007b->B:25:0x007d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:271:0x014f A[EDGE_INSN: B:271:0x014f->B:63:0x014f BREAK  A[LOOP:2: B:27:0x00a2->B:62:0x0142], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x013f A[EDGE_INSN: B:274:0x013f->B:61:0x013f BREAK  A[LOOP:4: B:38:0x00f2->B:59:0x0137], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x013c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:278:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:279:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:316:0x04ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:320:0x037a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:324:0x0380 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:325:0x030e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x02fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:332:0x0369 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:347:0x03fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:349:0x03e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:353:0x0444 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:354:0x0468 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x042e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:361:0x042e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:367:0x04fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:369:0x04e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:42:0x0107  */
    /* JADX WARN: Code duplicated, block: B:44:0x010f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0117  */
    /* JADX WARN: Code duplicated, block: B:49:0x011e  */
    /* JADX WARN: Code duplicated, block: B:54:0x012d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0165  */
    /* JADX WARN: Code duplicated, block: B:89:0x01e0  */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList;
        int size;
        int i7;
        int i8;
        f fVar;
        Iterator it;
        int i9;
        ArrayList arrayListD;
        int size2;
        int i10;
        ArrayList arrayListD2;
        int size3;
        int i11;
        f fVar2;
        ArrayList arrayList2;
        int size4;
        int i12;
        SharedPreferences.Editor editorEdit;
        Iterator it2;
        Iterator it3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayListB;
        int size5;
        int i13;
        ArrayList arrayList7;
        int size6;
        int i14;
        String str;
        int size7;
        int i15;
        String str2;
        g5.b bVar;
        int i16;
        String str3;
        Cursor cursor2;
        Cursor cursorQuery2;
        String str4;
        Cursor cursor3;
        Cursor cursorQuery3;
        ArrayList arrayList8;
        ArrayList arrayListB2;
        String str5;
        int size8;
        int i17;
        String str6;
        String strG;
        Iterator it4;
        a aVar;
        int i18;
        Iterator it5;
        d dVar = new d();
        dVar.f3977k = dVar.v();
        dVar.f3973j = sQLiteDatabase;
        ArrayList arrayList9 = new ArrayList();
        try {
            cursorQuery = dVar.f3973j.query("table_schema", null, null, null, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("name"));
                            if (dVar.G(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type")), string)) {
                                arrayList9.add(string);
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    while (true) {
                        i9 = 3;
                        if (it.hasNext()) {
                            break;
                        }
                        d dVarI = fVar.i((String) it.next());
                        arrayList8 = new ArrayList();
                        arrayListB2 = fVar.B(dVarI);
                        str5 = dVarI.f4026a;
                        size8 = arrayListB2.size();
                        i17 = i7;
                        while (i17 < size8) {
                            Object obj = arrayListB2.get(i17);
                            i17++;
                            str6 = (String) obj;
                            if (TextUtils.isEmpty(str6) && str6.toLowerCase(Locale.US).endsWith("_id")) {
                                strG = androidx.collection.a.g(i9, i7, str6);
                            } else {
                                strG = null;
                            }
                            it4 = fVar.f3972i.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    arrayList8.add(str6);
                                    break;
                                }
                                aVar = (a) it4.next();
                                i18 = aVar.d;
                                it5 = it4;
                                if (i18 == 1) {
                                    if (!str5.equalsIgnoreCase(aVar.c)) {
                                        continue;
                                    } else if (aVar.f4023a.equalsIgnoreCase(str5)) {
                                        if (a.E(aVar, str5, strG)) {
                                            break;
                                        }
                                    } else {
                                        if (aVar.b.equalsIgnoreCase(str5) && a.E(aVar, strG, str5)) {
                                            break;
                                        }
                                    }
                                    it4 = it5;
                                } else if (i18 == 2 && a.E(aVar, strG, str5)) {
                                    break;
                                } else {
                                    it4 = it5;
                                }
                            }
                            i7 = 0;
                            i9 = 3;
                        }
                        arrayList8.toString();
                        fVar.F(dVarI.f4026a, arrayList8);
                        i7 = 0;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (cursorQuery != null) {
                    }
                    a.z(arrayList9, dVar.f3973j);
                    dVar.y(arrayList9);
                    arrayList = (ArrayList) new c().v();
                    size = arrayList.size();
                    i7 = 0;
                    i8 = 0;
                    while (i8 < size) {
                        Object obj2 = arrayList.get(i8);
                        i8++;
                        c.p((d) obj2, sQLiteDatabase, false);
                    }
                    fVar = new f();
                    fVar.f3972i = fVar.u();
                    fVar.f3973j = sQLiteDatabase;
                    it = p029e5.a.b().a().iterator();
                    while (true) {
                        i9 = 3;
                        if (it.hasNext()) {
                            break;
                            break;
                        }
                        d dVarI2 = fVar.i((String) it.next());
                        arrayList8 = new ArrayList();
                        arrayListB2 = fVar.B(dVarI2);
                        str5 = dVarI2.f4026a;
                        size8 = arrayListB2.size();
                        i17 = i7;
                        while (i17 < size8) {
                            Object obj3 = arrayListB2.get(i17);
                            i17++;
                            str6 = (String) obj3;
                            if (TextUtils.isEmpty(str6)) {
                                strG = null;
                            } else {
                                strG = null;
                            }
                            it4 = fVar.f3972i.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    arrayList8.add(str6);
                                    break;
                                    break;
                                }
                                aVar = (a) it4.next();
                                i18 = aVar.d;
                                it5 = it4;
                                if (i18 == 1) {
                                    if (!str5.equalsIgnoreCase(aVar.c)) {
                                        continue;
                                    } else if (aVar.f4023a.equalsIgnoreCase(str5)) {
                                        if (a.E(aVar, str5, strG)) {
                                            break;
                                            break;
                                        }
                                    } else if (aVar.b.equalsIgnoreCase(str5)) {
                                        continue;
                                    }
                                    it4 = it5;
                                } else {
                                    if (i18 == 2) {
                                        continue;
                                    }
                                    it4 = it5;
                                }
                            }
                            i7 = 0;
                            i9 = 3;
                        }
                        arrayList8.toString();
                        fVar.F(dVarI2.f4026a, arrayList8);
                        i7 = 0;
                    }
                    ArrayList arrayList10 = new ArrayList();
                    arrayListD = J.d(fVar.f3973j);
                    size2 = arrayListD.size();
                    i10 = 0;
                    while (i10 < size2) {
                        int i19 = i10 + 1;
                        str4 = (String) arrayListD.get(i10);
                        SQLiteDatabase sQLiteDatabase2 = fVar.f3973j;
                        if (TextUtils.isEmpty(str4)) {
                        }
                        i10 = i19;
                    }
                    arrayList10.toString();
                    a.z(arrayList10, fVar.f3973j);
                    fVar.y(arrayList10);
                    ArrayList arrayList11 = new ArrayList();
                    arrayListD2 = J.d(fVar.f3973j);
                    size3 = arrayListD2.size();
                    i11 = 0;
                    while (i11 < size3) {
                        int i20 = i11 + 1;
                        str3 = (String) arrayListD2.get(i11);
                        SQLiteDatabase sQLiteDatabase3 = fVar.f3973j;
                        if (TextUtils.isEmpty(str3)) {
                        }
                        i11 = i20;
                    }
                    a.z(arrayList11, fVar.f3973j);
                    fVar.y(arrayList11);
                    fVar2 = new f();
                    fVar2.f3973j = sQLiteDatabase;
                    arrayList2 = (ArrayList) fVar2.v();
                    size4 = arrayList2.size();
                    i12 = 0;
                    while (i12 < size4) {
                        Object obj4 = arrayList2.get(i12);
                        i12++;
                        d dVar2 = (d) obj4;
                        fVar2.f3978k = dVar2;
                        fVar2.f3979l = fVar2.C(dVar2.f4026a);
                        d dVar3 = fVar2.f3978k;
                        String str7 = dVar3.f4026a;
                        it2 = dVar3.b.values().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                bVar = (g5.b) it2.next();
                                if (bVar.a()) {
                                    g5.b bVar2 = (g5.b) fVar2.f3979l.b.get(AbstractC1282k.a(bVar.f4024a));
                                    if (!bVar.d) {
                                    }
                                    c.p(fVar2.f3978k, fVar2.f3973j, true);
                                    for (p019c5.a aVar2 : (HashSet) fVar2.d(fVar2.f3978k.c)) {
                                        i16 = aVar2.f1192f;
                                        if (i16 != 2) {
                                        }
                                        if (aVar2.c.equalsIgnoreCase(fVar2.f3978k.c)) {
                                            String strK = J.k(aVar2.b);
                                            String str8 = fVar2.f3978k.f4026a;
                                            c.o(str8, strK, str8, fVar2.f3973j);
                                        }
                                    }
                                }
                            } else {
                                fVar2.f3980m = false;
                                String str9 = fVar2.f3978k.f4026a;
                                ArrayList arrayList12 = new ArrayList();
                                it3 = fVar2.f3979l.b.values().iterator();
                                while (it3.hasNext()) {
                                    str2 = ((g5.b) it3.next()).f4024a;
                                    if (fVar2.f3978k.b.containsKey(AbstractC1282k.a(str2))) {
                                    }
                                }
                                arrayList12.toString();
                                fVar2.H(arrayList12);
                                arrayList3 = new ArrayList();
                                for (g5.b bVar3 : fVar2.f3978k.b.values()) {
                                    if (!fVar2.f3979l.b.containsKey(AbstractC1282k.a(bVar3.f4024a))) {
                                        arrayList3.add(bVar3);
                                    }
                                }
                                fVar2.G(arrayList3);
                                arrayList4 = new ArrayList();
                                for (g5.b bVar4 : fVar2.f3979l.b.values()) {
                                    for (g5.b bVar5 : fVar2.f3978k.b.values()) {
                                        if (!bVar4.f4024a.equalsIgnoreCase(bVar5.f4024a)) {
                                            if (!bVar4.b.equalsIgnoreCase(bVar5.b)) {
                                                arrayList4.add(bVar5);
                                            }
                                            if (!fVar2.f3980m) {
                                                String str10 = bVar4.e;
                                                String str11 = bVar5.e;
                                                if (bVar4.c == bVar5.c) {
                                                }
                                                fVar2.f3980m = true;
                                            }
                                        }
                                    }
                                }
                                arrayList5 = new ArrayList();
                                if (!arrayList4.isEmpty()) {
                                    size7 = arrayList4.size();
                                    i15 = 0;
                                    while (i15 < size7) {
                                        Object obj5 = arrayList4.get(i15);
                                        i15++;
                                        arrayList5.add(((g5.b) obj5).f4024a);
                                    }
                                }
                                fVar2.H(arrayList5);
                                fVar2.G(arrayList4);
                                if (fVar2.f3980m) {
                                    String str12 = fVar2.f3978k.f4026a;
                                    StringBuilder sbY = AbstractC0157z.y("alter table ", str12, " rename to ");
                                    sbY.append(a.D(str12));
                                    String string2 = sbY.toString();
                                    d dVar4 = fVar2.f3978k;
                                    String strS = c.s(dVar4.f4026a, dVar4.b.values(), true);
                                    arrayList6 = new ArrayList();
                                    arrayListB = fVar2.B(fVar2.f3978k);
                                    size5 = arrayListB.size();
                                    i13 = 0;
                                    while (i13 < size5) {
                                        Object obj6 = arrayListB.get(i13);
                                        i13++;
                                        str = (String) obj6;
                                        if (!fVar2.f3978k.b.containsKey(AbstractC1282k.a(str))) {
                                            g5.b bVar6 = new g5.b();
                                            bVar6.f4024a = str;
                                            bVar6.b = "integer";
                                            arrayList6.add(c.r(fVar2.f3978k.f4026a, bVar6));
                                        }
                                    }
                                    String strA = a.A(fVar2.f3979l);
                                    String strT = c.t(a.D(fVar2.f3978k.f4026a));
                                    arrayList7 = new ArrayList();
                                    arrayList7.add(string2);
                                    arrayList7.add(strS);
                                    arrayList7.addAll(arrayList6);
                                    arrayList7.add(strA);
                                    arrayList7.add(strT);
                                    size6 = arrayList7.size();
                                    i14 = 0;
                                    while (i14 < size6) {
                                        Object obj7 = arrayList7.get(i14);
                                        i14++;
                                    }
                                    c.q(arrayList7, fVar2.f3973j);
                                }
                            }
                        }
                    }
                    c.n(sQLiteDatabase, false);
                    p029e5.a.b().getClass();
                    editorEdit = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0).edit();
                    if (TextUtils.isEmpty(null)) {
                        throw null;
                    }
                    editorEdit.putInt("litepal_version", i6);
                    editorEdit.apply();
                    int i21 = b.f903a;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursorQuery.close();
        a.z(arrayList9, dVar.f3973j);
        dVar.y(arrayList9);
        arrayList = (ArrayList) new c().v();
        size = arrayList.size();
        i7 = 0;
        i8 = 0;
        while (i8 < size) {
            Object obj8 = arrayList.get(i8);
            i8++;
            c.p((d) obj8, sQLiteDatabase, false);
        }
        fVar = new f();
        fVar.f3972i = fVar.u();
        fVar.f3973j = sQLiteDatabase;
        it = p029e5.a.b().a().iterator();
        ArrayList arrayList13 = new ArrayList();
        arrayListD = J.d(fVar.f3973j);
        size2 = arrayListD.size();
        i10 = 0;
        while (i10 < size2) {
            int i110 = i10 + 1;
            str4 = (String) arrayListD.get(i10);
            SQLiteDatabase sQLiteDatabase4 = fVar.f3973j;
            if (TextUtils.isEmpty(str4) && str4.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
                try {
                    cursorQuery3 = sQLiteDatabase4.query("table_schema", null, null, null, null, null, null);
                    try {
                        try {
                            if (cursorQuery3.moveToFirst()) {
                                while (true) {
                                    if (!str4.equalsIgnoreCase(cursorQuery3.getString(cursorQuery3.getColumnIndexOrThrow("name")))) {
                                        try {
                                            if (!cursorQuery3.moveToNext()) {
                                                cursorQuery3.close();
                                            }
                                        } catch (Exception e7) {
                                            e = e7;
                                            e.printStackTrace();
                                            if (cursorQuery3 != null) {
                                            }
                                            i10 = i110;
                                        }
                                    } else if (cursorQuery3.getInt(cursorQuery3.getColumnIndexOrThrow("type")) == 1) {
                                        cursorQuery3.close();
                                        boolean z6 = true;
                                        for (a aVar3 : fVar.f3972i) {
                                            if (aVar3.d == 3 && str4.equalsIgnoreCase(J.i(aVar3.f4023a, aVar3.b))) {
                                                z6 = false;
                                            }
                                        }
                                        if (z6) {
                                            arrayList13.add(str4);
                                        }
                                    } else {
                                        cursorQuery3.close();
                                    }
                                }
                            } else {
                                cursorQuery3.close();
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor3 = cursorQuery3;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            throw th;
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } catch (Exception e9) {
                    e = e9;
                    cursorQuery3 = null;
                } catch (Throwable th4) {
                    th = th4;
                    cursor3 = null;
                }
            }
            i10 = i110;
        }
        arrayList13.toString();
        a.z(arrayList13, fVar.f3973j);
        fVar.y(arrayList13);
        ArrayList arrayList14 = new ArrayList();
        arrayListD2 = J.d(fVar.f3973j);
        size3 = arrayListD2.size();
        i11 = 0;
        while (i11 < size3) {
            int i22 = i11 + 1;
            str3 = (String) arrayListD2.get(i11);
            SQLiteDatabase sQLiteDatabase5 = fVar.f3973j;
            if (TextUtils.isEmpty(str3) && str3.matches("[0-9a-zA-Z]+_[0-9a-zA-Z]+")) {
                try {
                    cursorQuery2 = sQLiteDatabase5.query("table_schema", null, null, null, null, null, null);
                    try {
                        try {
                            if (!cursorQuery2.moveToFirst()) {
                                cursorQuery2.close();
                                break;
                                break;
                            }
                            while (true) {
                                if (str3.equalsIgnoreCase(cursorQuery2.getString(cursorQuery2.getColumnIndexOrThrow("name")))) {
                                    if (cursorQuery2.getInt(cursorQuery2.getColumnIndexOrThrow("type")) == 2) {
                                        cursorQuery2.close();
                                        Iterator it6 = fVar.f902f.iterator();
                                        boolean z7 = true;
                                        while (it6.hasNext()) {
                                            if (str3.equalsIgnoreCase(((c) it6.next()).f4025a)) {
                                                z7 = false;
                                            }
                                        }
                                        if (!z7) {
                                            break;
                                        }
                                        arrayList14.add(str3);
                                        break;
                                    }
                                } else if (!cursorQuery2.moveToNext()) {
                                }
                                cursorQuery2.close();
                                break;
                            }
                        } catch (Exception e10) {
                            e = e10;
                            e.printStackTrace();
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                                break;
                                break;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursorQuery2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    cursorQuery2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    cursor2 = null;
                }
            }
            i11 = i22;
        }
        a.z(arrayList14, fVar.f3973j);
        fVar.y(arrayList14);
        fVar2 = new f();
        fVar2.f3973j = sQLiteDatabase;
        arrayList2 = (ArrayList) fVar2.v();
        size4 = arrayList2.size();
        i12 = 0;
        while (i12 < size4) {
            Object obj9 = arrayList2.get(i12);
            i12++;
            d dVar5 = (d) obj9;
            fVar2.f3978k = dVar5;
            fVar2.f3979l = fVar2.C(dVar5.f4026a);
            d dVar6 = fVar2.f3978k;
            String str13 = dVar6.f4026a;
            it2 = dVar6.b.values().iterator();
            while (true) {
                if (it2.hasNext()) {
                    bVar = (g5.b) it2.next();
                    if (bVar.a()) {
                        g5.b bVar7 = (g5.b) fVar2.f3979l.b.get(AbstractC1282k.a(bVar.f4024a));
                        if ((!bVar.d && (bVar7 == null || !bVar7.d)) || (bVar7 != null && !bVar.c && bVar7.c)) {
                            c.p(fVar2.f3978k, fVar2.f3973j, true);
                            while (r5.hasNext()) {
                                i16 = aVar2.f1192f;
                                if (i16 != 2 || i16 == 1) {
                                    if (aVar2.c.equalsIgnoreCase(fVar2.f3978k.c)) {
                                        String strK2 = J.k(aVar2.b);
                                        String str14 = fVar2.f3978k.f4026a;
                                        c.o(str14, strK2, str14, fVar2.f3973j);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    fVar2.f3980m = false;
                    String str15 = fVar2.f3978k.f4026a;
                    ArrayList arrayList15 = new ArrayList();
                    it3 = fVar2.f3979l.b.values().iterator();
                    while (it3.hasNext()) {
                        str2 = ((g5.b) it3.next()).f4024a;
                        if (fVar2.f3978k.b.containsKey(AbstractC1282k.a(str2)) && !Z4.a.k(str2) && !AbstractC1282k.c(str2, fVar2.B(fVar2.f3978k))) {
                            arrayList15.add(str2);
                        }
                    }
                    arrayList15.toString();
                    fVar2.H(arrayList15);
                    arrayList3 = new ArrayList();
                    while (r6.hasNext()) {
                        if (!fVar2.f3979l.b.containsKey(AbstractC1282k.a(bVar3.f4024a))) {
                            arrayList3.add(bVar3);
                        }
                    }
                    fVar2.G(arrayList3);
                    arrayList4 = new ArrayList();
                    while (r6.hasNext()) {
                        while (r8.hasNext()) {
                            if (!bVar4.f4024a.equalsIgnoreCase(bVar5.f4024a)) {
                                if (!bVar4.b.equalsIgnoreCase(bVar5.b) && (!bVar5.b.equalsIgnoreCase("blob") || !TextUtils.isEmpty(bVar4.b))) {
                                    arrayList4.add(bVar5);
                                }
                                if (!fVar2.f3980m) {
                                    String str16 = bVar4.e;
                                    String str17 = bVar5.e;
                                    if (bVar4.c == bVar5.c || !str16.equalsIgnoreCase(str17) || (bVar4.d && !bVar5.d)) {
                                        fVar2.f3980m = true;
                                    }
                                }
                            }
                        }
                    }
                    arrayList5 = new ArrayList();
                    if (!arrayList4.isEmpty()) {
                        size7 = arrayList4.size();
                        i15 = 0;
                        while (i15 < size7) {
                            Object obj10 = arrayList4.get(i15);
                            i15++;
                            arrayList5.add(((g5.b) obj10).f4024a);
                        }
                    }
                    fVar2.H(arrayList5);
                    fVar2.G(arrayList4);
                    if (fVar2.f3980m) {
                        String str18 = fVar2.f3978k.f4026a;
                        StringBuilder sbY2 = AbstractC0157z.y("alter table ", str18, " rename to ");
                        sbY2.append(a.D(str18));
                        String string3 = sbY2.toString();
                        d dVar7 = fVar2.f3978k;
                        String strS2 = c.s(dVar7.f4026a, dVar7.b.values(), true);
                        arrayList6 = new ArrayList();
                        arrayListB = fVar2.B(fVar2.f3978k);
                        size5 = arrayListB.size();
                        i13 = 0;
                        while (i13 < size5) {
                            Object obj11 = arrayListB.get(i13);
                            i13++;
                            str = (String) obj11;
                            if (!fVar2.f3978k.b.containsKey(AbstractC1282k.a(str))) {
                                g5.b bVar8 = new g5.b();
                                bVar8.f4024a = str;
                                bVar8.b = "integer";
                                arrayList6.add(c.r(fVar2.f3978k.f4026a, bVar8));
                            }
                        }
                        String strA2 = a.A(fVar2.f3979l);
                        String strT2 = c.t(a.D(fVar2.f3978k.f4026a));
                        arrayList7 = new ArrayList();
                        arrayList7.add(string3);
                        arrayList7.add(strS2);
                        arrayList7.addAll(arrayList6);
                        arrayList7.add(strA2);
                        arrayList7.add(strT2);
                        size6 = arrayList7.size();
                        i14 = 0;
                        while (i14 < size6) {
                            Object obj12 = arrayList7.get(i14);
                            i14++;
                        }
                        c.q(arrayList7, fVar2.f3973j);
                    }
                }
            }
        }
        c.n(sQLiteDatabase, false);
        p029e5.a.b().getClass();
        editorEdit = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0).edit();
        if (TextUtils.isEmpty(null)) {
            throw null;
        }
        editorEdit.putInt("litepal_version", i6);
        editorEdit.apply();
        int i23 = b.f903a;
    }
}
