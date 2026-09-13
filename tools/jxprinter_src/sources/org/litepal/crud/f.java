package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f {
    protected static final String AES = "AES";
    protected static final String MD5 = "MD5";
    Map<String, List<Long>> associatedModelsMapForJoinTable;
    private Map<String, Set<Long>> associatedModelsMapWithFK;
    private Map<String, Long> associatedModelsMapWithoutFK;
    long baseObjId;
    private List<String> fieldsToSetToDefault;
    private List<String> listToClearAssociatedFK;
    private List<String> listToClearSelfFK;

    public void addAssociatedModelForJoinTable(String str, long j6) {
        List<Long> list = getAssociatedModelsMapForJoinTable().get(str);
        if (list != null) {
            list.add(Long.valueOf(j6));
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j6));
        this.associatedModelsMapForJoinTable.put(str, arrayList);
    }

    public void addAssociatedModelWithFK(String str, long j6) {
        Set<Long> set = getAssociatedModelsMapWithFK().get(str);
        if (set != null) {
            set.add(Long.valueOf(j6));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Long.valueOf(j6));
        this.associatedModelsMapWithFK.put(str, hashSet);
    }

    public void addAssociatedModelWithoutFK(String str, long j6) {
        getAssociatedModelsMapWithoutFK().put(str, Long.valueOf(j6));
    }

    public void addAssociatedTableNameToClearFK(String str) {
        List<String> listToClearAssociatedFK = getListToClearAssociatedFK();
        if (listToClearAssociatedFK.contains(str)) {
            return;
        }
        listToClearAssociatedFK.add(str);
    }

    public void addEmptyModelForJoinTable(String str) {
        if (getAssociatedModelsMapForJoinTable().get(str) == null) {
            this.associatedModelsMapForJoinTable.put(str, new ArrayList());
        }
    }

    public void addFKNameToClearSelf(String str) {
        List<String> listToClearSelfFK = getListToClearSelfFK();
        if (listToClearSelfFK.contains(str)) {
            return;
        }
        listToClearSelfFK.add(str);
    }

    public void assignBaseObjId(int i5) {
        this.baseObjId = i5;
    }

    public void clearAssociatedData() {
        Iterator<String> it = getAssociatedModelsMapWithFK().keySet().iterator();
        while (it.hasNext()) {
            this.associatedModelsMapWithFK.get(it.next()).clear();
        }
        this.associatedModelsMapWithFK.clear();
        getAssociatedModelsMapWithoutFK().clear();
        Iterator<String> it2 = getAssociatedModelsMapForJoinTable().keySet().iterator();
        while (it2.hasNext()) {
            this.associatedModelsMapForJoinTable.get(it2.next()).clear();
        }
        this.associatedModelsMapForJoinTable.clear();
        getListToClearSelfFK().clear();
        getListToClearAssociatedFK().clear();
    }

    public void clearSavedState() {
        this.baseObjId = 0L;
    }

    public int delete() {
        int iZ;
        synchronized (f.class) {
            try {
                SQLiteDatabase sQLiteDatabaseF = p035f5.b.f();
                sQLiteDatabaseF.beginTransaction();
                try {
                    d dVar = new d();
                    dVar.f7678g = sQLiteDatabaseF;
                    iZ = dVar.z(this);
                    this.baseObjId = 0L;
                    sQLiteDatabaseF.setTransactionSuccessful();
                    sQLiteDatabaseF.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseF.endTransaction();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iZ;
    }

    @Deprecated
    public p013b5.f deleteAsync() {
        return new p013b5.f();
    }

    public Map<String, List<Long>> getAssociatedModelsMapForJoinTable() {
        if (this.associatedModelsMapForJoinTable == null) {
            this.associatedModelsMapForJoinTable = new HashMap();
        }
        return this.associatedModelsMapForJoinTable;
    }

    public Map<String, Set<Long>> getAssociatedModelsMapWithFK() {
        if (this.associatedModelsMapWithFK == null) {
            this.associatedModelsMapWithFK = new HashMap();
        }
        return this.associatedModelsMapWithFK;
    }

    public Map<String, Long> getAssociatedModelsMapWithoutFK() {
        if (this.associatedModelsMapWithoutFK == null) {
            this.associatedModelsMapWithoutFK = new HashMap();
        }
        return this.associatedModelsMapWithoutFK;
    }

    public long getBaseObjId() {
        return this.baseObjId;
    }

    public String getClassName() {
        return getClass().getName();
    }

    public List<String> getFieldsToSetToDefault() {
        if (this.fieldsToSetToDefault == null) {
            this.fieldsToSetToDefault = new ArrayList();
        }
        return this.fieldsToSetToDefault;
    }

    public List<String> getListToClearAssociatedFK() {
        if (this.listToClearAssociatedFK == null) {
            this.listToClearAssociatedFK = new ArrayList();
        }
        return this.listToClearAssociatedFK;
    }

    public List<String> getListToClearSelfFK() {
        if (this.listToClearSelfFK == null) {
            this.listToClearSelfFK = new ArrayList();
        }
        return this.listToClearSelfFK;
    }

    public String getTableName() {
        return AbstractC1282k.a(J.k(getClassName()));
    }

    public boolean isSaved() {
        return this.baseObjId > 0;
    }

    public boolean save() {
        try {
            saveThrows();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public p013b5.e saveAsync() {
        return new p013b5.e();
    }

    public boolean saveOrUpdate(String... strArr) {
        synchronized (f.class) {
            try {
                if (strArr == null) {
                    return save();
                }
                int i5 = Z4.b.f903a;
                Class<?> cls = getClass();
                synchronized (f.class) {
                    ArrayList arrayListA = new d(p035f5.b.f()).A(cls, null, strArr, null, null);
                    if (arrayListA.isEmpty()) {
                        return save();
                    }
                    SQLiteDatabase sQLiteDatabaseF = p035f5.b.f();
                    sQLiteDatabaseF.beginTransaction();
                    try {
                        try {
                            int size = arrayListA.size();
                            int i6 = 0;
                            while (i6 < size) {
                                Object obj = arrayListA.get(i6);
                                i6++;
                                this.baseObjId = ((f) obj).getBaseObjId();
                                new j(sQLiteDatabaseF).onSave(this);
                                clearAssociatedData();
                            }
                            sQLiteDatabaseF.setTransactionSuccessful();
                            sQLiteDatabaseF.endTransaction();
                            return true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            sQLiteDatabaseF.endTransaction();
                            return false;
                        }
                    } catch (Throwable th) {
                        sQLiteDatabaseF.endTransaction();
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Deprecated
    public p013b5.e saveOrUpdateAsync(String... strArr) {
        return new p013b5.e();
    }

    public void saveThrows() {
        synchronized (f.class) {
            SQLiteDatabase sQLiteDatabaseF = p035f5.b.f();
            sQLiteDatabaseF.beginTransaction();
            try {
                try {
                    new j(sQLiteDatabaseF).onSave(this);
                    clearAssociatedData();
                    sQLiteDatabaseF.setTransactionSuccessful();
                    sQLiteDatabaseF.endTransaction();
                } catch (Exception e) {
                    throw new p024d5.e(e.getMessage(), e);
                }
            } catch (Throwable th) {
                sQLiteDatabaseF.endTransaction();
                throw th;
            }
        }
    }

    public void setToDefault(String str) {
        getFieldsToSetToDefault().add(str);
    }

    public int update(long j6) {
        int iOnUpdate;
        synchronized (f.class) {
            SQLiteDatabase sQLiteDatabaseF = p035f5.b.f();
            sQLiteDatabaseF.beginTransaction();
            try {
                try {
                    iOnUpdate = new k(p035f5.b.f()).onUpdate(this, j6);
                    getFieldsToSetToDefault().clear();
                    sQLiteDatabaseF.setTransactionSuccessful();
                    sQLiteDatabaseF.endTransaction();
                } catch (Exception e) {
                    throw new p024d5.e(e.getMessage(), e);
                }
            } catch (Throwable th) {
                sQLiteDatabaseF.endTransaction();
                throw th;
            }
        }
        return iOnUpdate;
    }

    public int updateAll(String... strArr) {
        int iOnUpdateAll;
        synchronized (f.class) {
            SQLiteDatabase sQLiteDatabaseF = p035f5.b.f();
            sQLiteDatabaseF.beginTransaction();
            try {
                try {
                    iOnUpdateAll = new k(p035f5.b.f()).onUpdateAll(this, strArr);
                    getFieldsToSetToDefault().clear();
                    sQLiteDatabaseF.setTransactionSuccessful();
                    sQLiteDatabaseF.endTransaction();
                } catch (Exception e) {
                    throw new p024d5.e(e.getMessage(), e);
                }
            } catch (Throwable th) {
                sQLiteDatabaseF.endTransaction();
                throw th;
            }
        }
        return iOnUpdateAll;
    }

    @Deprecated
    public p013b5.f updateAllAsync(String... strArr) {
        return new p013b5.f();
    }

    @Deprecated
    public p013b5.f updateAsync(long j6) {
        return new p013b5.f();
    }
}
