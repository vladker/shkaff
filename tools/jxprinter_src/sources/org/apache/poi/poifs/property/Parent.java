package org.apache.poi.poifs.property;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Parent extends Child, Iterable<Property> {
    void addChild(Property property);

    Iterator<Property> getChildren();

    @Override // org.apache.poi.poifs.property.Child
    void setNextChild(Child child);

    @Override // org.apache.poi.poifs.property.Child
    void setPreviousChild(Child child);
}
