package org.litepal.crud;

import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends a {
    public void analyze(f fVar, p019c5.a aVar) {
        f associatedModel = getAssociatedModel(fVar, aVar);
        if (associatedModel == null) {
            fVar.addAssociatedTableNameToClearFK(J.k(aVar.b));
            return;
        }
        buildBidirectionalAssociations(fVar, associatedModel, aVar);
        if (aVar.e == null) {
            a.A(fVar, associatedModel);
        } else if (associatedModel.isSaved()) {
            fVar.addAssociatedModelWithFK(associatedModel.getTableName(), associatedModel.getBaseObjId());
            fVar.addAssociatedModelWithoutFK(associatedModel.getTableName(), associatedModel.getBaseObjId());
        }
    }
}
