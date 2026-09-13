package org.openxmlformats.schemas.xpackage.x2006.digitalSignature;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTRelationshipReference extends XmlString {
    public static final DocumentFactory<CTRelationshipReference> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTRelationshipReference> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctrelationshipreferencee68ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getSourceId();

    void setSourceId(String str);

    XmlString xgetSourceId();

    void xsetSourceId(XmlString xmlString);
}
