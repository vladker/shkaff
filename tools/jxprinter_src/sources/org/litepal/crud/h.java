package org.litepal.crud;

import java.util.AbstractCollection;
import java.util.Collection;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends a {
    private void analyzeManySide(f fVar, p019c5.a aVar) {
        f associatedModel = getAssociatedModel(fVar, aVar);
        if (associatedModel == null) {
            fVar.addFKNameToClearSelf(Z4.a.e(J.k(aVar.b)));
            return;
        }
        AbstractCollection abstractCollectionZ = a.z(getReverseAssociatedModels(associatedModel, aVar), aVar.e);
        setReverseAssociatedModels(associatedModel, aVar, abstractCollectionZ);
        if (!abstractCollectionZ.contains(fVar)) {
            abstractCollectionZ.add(fVar);
        }
        if (associatedModel.isSaved()) {
            fVar.addAssociatedModelWithoutFK(associatedModel.getTableName(), associatedModel.getBaseObjId());
        }
    }

    private void analyzeOneSide(f fVar, p019c5.a aVar) {
        Collection<f> associatedModels = getAssociatedModels(fVar, aVar);
        if (associatedModels == null || associatedModels.isEmpty()) {
            fVar.addAssociatedTableNameToClearFK(J.k(aVar.b));
            return;
        }
        for (f fVar2 : associatedModels) {
            buildBidirectionalAssociations(fVar, fVar2, aVar);
            a.A(fVar, fVar2);
        }
    }

    public void analyze(f fVar, p019c5.a aVar) {
        if (fVar.getClassName().equals(aVar.c)) {
            analyzeManySide(fVar, aVar);
        } else {
            analyzeOneSide(fVar, aVar);
        }
    }
}
