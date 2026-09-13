package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotCache extends XmlObject {
    public static final DocumentFactory<CTPivotCache> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotCache> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotcache4de9type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getCacheId();

    String getId();

    void setCacheId(long j6);

    void setId(String str);

    XmlUnsignedInt xgetCacheId();

    STRelationshipId xgetId();

    void xsetCacheId(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(STRelationshipId sTRelationshipId);
}
