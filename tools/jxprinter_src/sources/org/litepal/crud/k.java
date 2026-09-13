package org.litepal.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends c {
    public k(SQLiteDatabase sQLiteDatabase) {
        this.f7678g = sQLiteDatabase;
    }

    private void updateGenericTables(f fVar, List<Field> list, long... jArr) {
        long[] jArr2 = jArr;
        if (jArr2 == null || jArr2.length <= 0) {
            return;
        }
        Iterator<Field> it = list.iterator();
        while (it.hasNext()) {
            Field next = it.next();
            p008a5.b bVar = (p008a5.b) next.getAnnotation(p008a5.b.class);
            Class clsF = Z4.a.f(next);
            String name = clsF != null ? clsF.getName() : null;
            String strAlgorithm = (bVar == null || !"java.lang.String".equals(name)) ? null : bVar.algorithm();
            next.setAccessible(true);
            Collection collection = (Collection) next.get(fVar);
            if (collection != null && !collection.isEmpty()) {
                String strF = J.f(fVar.getClassName(), next.getName());
                String strG = J.g(fVar.getClassName());
                int length = jArr2.length;
                int i5 = 0;
                while (i5 < length) {
                    long j6 = jArr2[i5];
                    this.f7678g.delete(strF, androidx.collection.a.n(strG, " = ?"), new String[]{String.valueOf(j6)});
                    Iterator it2 = collection.iterator();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        ContentValues contentValues = new ContentValues();
                        it2 = it2;
                        contentValues.put(strG, Long.valueOf(j6));
                        Object objQ = c.q(next2, strAlgorithm);
                        if (fVar.getClassName().equals(name)) {
                            f fVar2 = (f) objQ;
                            if (fVar2 != null) {
                                long baseObjId = fVar2.getBaseObjId();
                                if (baseObjId > 0) {
                                    contentValues.put(J.j(next), Long.valueOf(baseObjId));
                                }
                            }
                        } else {
                            e.send(contentValues, "put", new Object[]{J.b(AbstractC1282k.a(next.getName())), objQ}, contentValues.getClass(), new Class[]{String.class, Z4.a.f(next)});
                        }
                        this.f7678g.insert(strF, null, contentValues);
                        it = it;
                        next = next;
                    }
                    i5++;
                    jArr2 = jArr;
                    it = it;
                }
            }
            jArr2 = jArr;
            it = it;
        }
    }

    public int onUpdate(f fVar, long j6) {
        List listG = g(fVar.getClassName());
        updateGenericTables(fVar, h(fVar.getClassName()), j6);
        ContentValues contentValues = new ContentValues();
        putFieldsValue(fVar, listG, contentValues);
        z(fVar, contentValues, j6);
        if (contentValues.size() > 0) {
            return this.f7678g.update(fVar.getTableName(), contentValues, androidx.collection.a.j(j6, "id = "), null);
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0087  */
    /* JADX WARN: Code duplicated, block: B:29:0x0096 A[RETURN] */
    public int onUpdateAll(f fVar, String... strArr) {
        String[] strArr2;
        long[] jArr;
        ContentValues contentValues;
        String tableName;
        ArrayList arrayListA;
        AbstractC1282k.b(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = J.c(strArr[0]);
        }
        List listG = g(fVar.getClassName());
        List listH = h(fVar.getClassName());
        if (!listH.isEmpty()) {
            String[] strArr3 = {"id"};
            int i5 = Z4.b.f903a;
            Class<?> cls = fVar.getClass();
            synchronized (f.class) {
                strArr2 = strArr;
                arrayListA = new d(p035f5.b.f()).A(cls, strArr3, strArr2, null, null);
            }
            if (arrayListA.size() > 0) {
                int size = arrayListA.size();
                jArr = new long[size];
                for (int i6 = 0; i6 < size; i6++) {
                    jArr[i6] = ((f) arrayListA.get(i6)).getBaseObjId();
                }
                updateGenericTables(fVar, listH, jArr);
            }
            contentValues = new ContentValues();
            putFieldsValue(fVar, listG, contentValues);
            z(fVar, contentValues, jArr);
            tableName = fVar.getTableName();
            AbstractC1282k.b(strArr2);
            if (contentValues.size() > 0) {
                return this.f7678g.update(tableName, contentValues, c.x(strArr2), c.w(strArr2));
            }
            return 0;
        }
        strArr2 = strArr;
        jArr = null;
        contentValues = new ContentValues();
        putFieldsValue(fVar, listG, contentValues);
        z(fVar, contentValues, jArr);
        tableName = fVar.getTableName();
        AbstractC1282k.b(strArr2);
        if (contentValues.size() > 0) {
            return this.f7678g.update(tableName, contentValues, c.x(strArr2), c.w(strArr2));
        }
        return 0;
    }

    public final void z(f fVar, ContentValues contentValues, long... jArr) {
        String str = null;
        try {
            try {
                f fVarU = u(fVar);
                Class<?> cls = fVarU.getClass();
                String str2 = null;
                for (String str3 : fVar.getFieldsToSetToDefault()) {
                    try {
                        if (!Z4.a.k(str3)) {
                            try {
                                Field declaredField = cls.getDeclaredField(str3);
                                if (!Z4.a.j(declaredField.getType())) {
                                    putContentValuesForUpdate(fVarU, declaredField, contentValues);
                                } else if (jArr != null && jArr.length > 0) {
                                    Class clsF = Z4.a.f(declaredField);
                                    if (AbstractC1282k.d(clsF != null ? clsF.getName() : null)) {
                                        String strF = J.f(fVar.getClassName(), declaredField.getName());
                                        String strG = J.g(fVar.getClassName());
                                        StringBuilder sb = new StringBuilder();
                                        int length = jArr.length;
                                        int i5 = 0;
                                        boolean z6 = false;
                                        while (i5 < length) {
                                            long j6 = jArr[i5];
                                            if (z6) {
                                                sb.append(" or ");
                                            }
                                            sb.append(strG);
                                            sb.append(" = ");
                                            sb.append(j6);
                                            i5++;
                                            z6 = true;
                                        }
                                        this.f7678g.delete(strF, sb.toString(), null);
                                    }
                                }
                                str2 = str3;
                            } catch (NoSuchFieldException e) {
                                e = e;
                                str = str3;
                                throw new p024d5.e(p024d5.e.a(fVar.getClassName(), str), e);
                            }
                        }
                    } catch (NoSuchFieldException e6) {
                        e = e6;
                        str = str2;
                    }
                }
            } catch (Exception e7) {
                throw new p024d5.e(e7.getMessage(), e7);
            }
        } catch (NoSuchFieldException e8) {
            e = e8;
        }
    }
}
