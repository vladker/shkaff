package org.litepal.crud;

import android.database.Cursor;
import java.util.AbstractCollection;
import java.util.Collection;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends a {
    public static String B(f fVar, f fVar2) {
        return Z4.a.e(fVar.getTableName()) + " = ? and " + Z4.a.e(fVar2.getTableName()) + " = ?";
    }

    @Deprecated
    private boolean isDataExists(f fVar, f fVar2) {
        Cursor cursorQuery = null;
        try {
            cursorQuery = p035f5.b.f().query(AbstractC1282k.a(J.i(fVar.getTableName(), fVar2.getTableName())), null, B(fVar, fVar2), new String[]{String.valueOf(fVar.getBaseObjId()), String.valueOf(fVar2.getBaseObjId())}, null, null, null);
            return cursorQuery.getCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        } finally {
            cursorQuery.close();
        }
    }

    public void analyze(f fVar, p019c5.a aVar) {
        Collection<f> associatedModels = getAssociatedModels(fVar, aVar);
        fVar.addEmptyModelForJoinTable(AbstractC1282k.a(J.k(aVar.b)));
        if (associatedModels != null) {
            for (f fVar2 : associatedModels) {
                AbstractCollection abstractCollectionZ = a.z(getReverseAssociatedModels(fVar2, aVar), aVar.e);
                if (!abstractCollectionZ.contains(fVar)) {
                    abstractCollectionZ.add(fVar);
                }
                setReverseAssociatedModels(fVar2, aVar, abstractCollectionZ);
                if (fVar2.isSaved()) {
                    fVar.addAssociatedModelForJoinTable(fVar2.getTableName(), fVar2.getBaseObjId());
                }
            }
        }
    }
}
