package org.litepal.crud;

import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends c {
    public static void A(f fVar, f fVar2) {
        if (fVar2 != null) {
            if (fVar2.isSaved()) {
                fVar.addAssociatedModelWithFK(fVar2.getTableName(), fVar2.getBaseObjId());
            } else if (fVar.isSaved()) {
                fVar2.addAssociatedModelWithoutFK(fVar.getTableName(), fVar.getBaseObjId());
            }
        }
    }

    public static AbstractCollection z(Collection collection, Field field) {
        AbstractCollection hashSet;
        if (List.class.isAssignableFrom(field.getType())) {
            hashSet = new ArrayList();
        } else {
            if (!Set.class.isAssignableFrom(field.getType())) {
                throw new p024d5.e("The field to declare many2one or many2many associations should be List or Set.");
            }
            hashSet = new HashSet();
        }
        if (collection != null) {
            hashSet.addAll(collection);
        }
        return hashSet;
    }

    public void buildBidirectionalAssociations(f fVar, f fVar2, p019c5.a aVar) {
        setFieldValue(fVar2, aVar.e, fVar);
    }

    public Collection<f> getReverseAssociatedModels(f fVar, p019c5.a aVar) {
        return (Collection) getFieldValue(fVar, aVar.e);
    }

    public void setReverseAssociatedModels(f fVar, p019c5.a aVar, Collection<f> collection) {
        setFieldValue(fVar, aVar.e, collection);
    }
}
