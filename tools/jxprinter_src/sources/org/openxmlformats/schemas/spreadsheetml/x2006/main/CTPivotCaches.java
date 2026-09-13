package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotCaches extends XmlObject {
    public static final DocumentFactory<CTPivotCaches> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotCaches> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotcaches4f32type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPivotCache addNewPivotCache();

    CTPivotCache getPivotCacheArray(int i5);

    CTPivotCache[] getPivotCacheArray();

    List<CTPivotCache> getPivotCacheList();

    CTPivotCache insertNewPivotCache(int i5);

    void removePivotCache(int i5);

    void setPivotCacheArray(int i5, CTPivotCache cTPivotCache);

    void setPivotCacheArray(CTPivotCache[] cTPivotCacheArr);

    int sizeOfPivotCacheArray();
}
