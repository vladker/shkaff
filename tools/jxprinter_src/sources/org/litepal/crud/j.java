package org.litepal.crud;

import A3.AbstractC0157z;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ContentValues f7680i = new ContentValues();

    public j(SQLiteDatabase sQLiteDatabase) {
        this.f7678g = sQLiteDatabase;
    }

    public static void A(ContentValues contentValues, f fVar) {
        Map<String, Long> associatedModelsMapWithoutFK = fVar.getAssociatedModelsMapWithoutFK();
        for (String str : associatedModelsMapWithoutFK.keySet()) {
            contentValues.put(Z4.a.e(str), associatedModelsMapWithoutFK.get(str));
        }
    }

    private void afterSave(f fVar, List<Field> list, List<Field> list2, long j6) {
        Field next;
        f fVar2;
        long j7;
        if (j6 == -1) {
            throw new p024d5.e("Save current model failed.");
        }
        Iterator<Field> it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Z4.a.k(next.getName()));
        try {
            giveBaseObjIdValue(fVar, j6);
            if (next != null) {
                fVar2 = fVar;
                j7 = j6;
                try {
                    giveModelIdValue(fVar2, next.getName(), next.getType(), j7);
                } catch (Exception e) {
                    e = e;
                    Exception exc = e;
                    throw new p024d5.e(exc.getMessage(), exc);
                }
            } else {
                fVar2 = fVar;
                j7 = j6;
            }
            updateGenericTables(fVar2, list2, j7);
            B(fVar2);
            z(fVar2, false);
        } catch (Exception e6) {
            e = e6;
        }
    }

    private void afterUpdate(f fVar, List<Field> list) {
        updateGenericTables(fVar, list, fVar.getBaseObjId());
        B(fVar);
        z(fVar, true);
        for (String str : fVar.getListToClearAssociatedFK()) {
            String strE = Z4.a.e(fVar.getTableName());
            ContentValues contentValues = new ContentValues();
            contentValues.putNull(strE);
            StringBuilder sbX = AbstractC0157z.x(strE, " = ");
            sbX.append(fVar.getBaseObjId());
            this.f7678g.update(str, contentValues, sbX.toString(), null);
        }
    }

    private void beforeSave(f fVar, List<Field> list, ContentValues contentValues) {
        putFieldsValue(fVar, list, contentValues);
        A(contentValues, fVar);
    }

    private void beforeUpdate(f fVar, List<Field> list, ContentValues contentValues) {
        putFieldsValue(fVar, list, contentValues);
        A(contentValues, fVar);
        Iterator<String> it = fVar.getListToClearSelfFK().iterator();
        while (it.hasNext()) {
            contentValues.putNull(it.next());
        }
    }

    private void doSaveAction(f fVar, List<Field> list, List<Field> list2) {
        ContentValues contentValues = this.f7680i;
        contentValues.clear();
        beforeSave(fVar, list, contentValues);
        if (contentValues.size() == 0) {
            contentValues.putNull("id");
        }
        afterSave(fVar, list, list2, this.f7678g.insert(fVar.getTableName(), null, contentValues));
    }

    private void doUpdateAction(f fVar, List<Field> list, List<Field> list2) {
        ContentValues contentValues = this.f7680i;
        contentValues.clear();
        beforeUpdate(fVar, list, contentValues);
        if (contentValues.size() > 0) {
            this.f7678g.update(fVar.getTableName(), contentValues, "id = ?", new String[]{String.valueOf(fVar.getBaseObjId())});
        }
        afterUpdate(fVar, list2);
    }

    private void giveModelIdValue(f fVar, String str, Class<?> cls, long j6) {
        Object objValueOf;
        if (str == null || cls == null || j6 <= 0) {
            return;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            objValueOf = Integer.valueOf((int) j6);
        } else {
            if (cls != Long.TYPE && cls != Long.class) {
                throw new p024d5.e("id type is not supported. Only int or long is acceptable for id");
            }
            objValueOf = Long.valueOf(j6);
        }
        e.setField(fVar, str, objValueOf, fVar.getClass());
    }

    private void updateGenericTables(f fVar, List<Field> list, long j6) {
        for (Field field : list) {
            p008a5.b bVar = (p008a5.b) field.getAnnotation(p008a5.b.class);
            Class clsF = Z4.a.f(field);
            String name = clsF != null ? clsF.getName() : null;
            String strAlgorithm = (bVar == null || !"java.lang.String".equals(name)) ? null : bVar.algorithm();
            field.setAccessible(true);
            Collection collection = (Collection) field.get(fVar);
            if (collection != null) {
                Log.d("DataHandler", "updateGenericTables: class name is " + fVar.getClassName() + " , field name is " + field.getName());
                String strF = J.f(fVar.getClassName(), field.getName());
                String strG = J.g(fVar.getClassName());
                this.f7678g.delete(strF, androidx.collection.a.n(strG, " = ?"), new String[]{String.valueOf(j6)});
                for (Object obj : collection) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(strG, Long.valueOf(j6));
                    Object objQ = c.q(obj, strAlgorithm);
                    if (fVar.getClassName().equals(name)) {
                        f fVar2 = (f) objQ;
                        if (fVar2 != null) {
                            long baseObjId = fVar2.getBaseObjId();
                            if (baseObjId > 0) {
                                contentValues.put(J.j(field), Long.valueOf(baseObjId));
                            }
                        }
                    } else {
                        e.send(contentValues, "put", new Object[]{AbstractC1282k.a(J.b(field.getName())), objQ}, contentValues.getClass(), new Class[]{String.class, Z4.a.f(field)});
                    }
                    this.f7678g.insert(strF, null, contentValues);
                }
            }
        }
    }

    public final void B(f fVar) {
        Map<String, Set<Long>> associatedModelsMapWithFK = fVar.getAssociatedModelsMapWithFK();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapWithFK.keySet()) {
            contentValues.clear();
            contentValues.put(Z4.a.e(fVar.getTableName()), Long.valueOf(fVar.getBaseObjId()));
            Set<Long> set = associatedModelsMapWithFK.get(str);
            if (set != null && !set.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = this.f7678g;
                StringBuilder sb = new StringBuilder();
                Iterator<Long> it = set.iterator();
                boolean z6 = false;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    if (z6) {
                        sb.append(" or ");
                    }
                    sb.append("id = ");
                    sb.append(jLongValue);
                    z6 = true;
                }
                sQLiteDatabase.update(str, contentValues, AbstractC1282k.a(sb.toString()), null);
            }
        }
    }

    public void onSave(f fVar) {
        String className = fVar.getClassName();
        List listG = g(className);
        List listH = h(className);
        Collection collectionD = d(className);
        if (fVar.isSaved()) {
            c.n(fVar, collectionD);
            doUpdateAction(fVar, listG, listH);
        } else {
            c.n(fVar, collectionD);
            doSaveAction(fVar, listG, listH);
            c.n(fVar, collectionD);
        }
    }

    public <T extends f> void onSaveAll(Collection<T> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        f[] fVarArr = (f[]) collection.toArray(new f[0]);
        String className = fVarArr[0].getClassName();
        List listG = g(className);
        List listH = h(className);
        Collection collectionD = d(className);
        for (f fVar : fVarArr) {
            if (fVar.isSaved()) {
                c.n(fVar, collectionD);
                doUpdateAction(fVar, listG, listH);
            } else {
                c.n(fVar, collectionD);
                doSaveAction(fVar, listG, listH);
                c.n(fVar, collectionD);
            }
            fVar.clearAssociatedData();
        }
    }

    public final void z(f fVar, boolean z6) {
        Map<String, List<Long>> associatedModelsMapForJoinTable = fVar.getAssociatedModelsMapForJoinTable();
        ContentValues contentValues = new ContentValues();
        for (String str : associatedModelsMapForJoinTable.keySet()) {
            String strA = AbstractC1282k.a(J.i(fVar.getTableName(), str));
            if (z6) {
                this.f7678g.delete(strA, Z4.a.e(fVar.getTableName()) + " = ?", new String[]{String.valueOf(fVar.getBaseObjId())});
            }
            for (Long l6 : associatedModelsMapForJoinTable.get(str)) {
                l6.getClass();
                contentValues.clear();
                contentValues.put(Z4.a.e(fVar.getTableName()), Long.valueOf(fVar.getBaseObjId()));
                contentValues.put(Z4.a.e(str), l6);
                this.f7678g.insert(strA, null, contentValues);
            }
        }
    }
}
