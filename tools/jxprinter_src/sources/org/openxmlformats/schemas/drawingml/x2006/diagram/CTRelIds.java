package org.openxmlformats.schemas.drawingml.x2006.diagram;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTRelIds extends XmlObject {
    public static final DocumentFactory<CTRelIds> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTRelIds> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctrelidsfef2type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getCs();

    String getDm();

    String getLo();

    String getQs();

    void setCs(String str);

    void setDm(String str);

    void setLo(String str);

    void setQs(String str);

    STRelationshipId xgetCs();

    STRelationshipId xgetDm();

    STRelationshipId xgetLo();

    STRelationshipId xgetQs();

    void xsetCs(STRelationshipId sTRelationshipId);

    void xsetDm(STRelationshipId sTRelationshipId);

    void xsetLo(STRelationshipId sTRelationshipId);

    void xsetQs(STRelationshipId sTRelationshipId);
}
