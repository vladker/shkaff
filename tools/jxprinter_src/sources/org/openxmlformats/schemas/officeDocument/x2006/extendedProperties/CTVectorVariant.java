package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTVectorVariant extends XmlObject {
    public static final DocumentFactory<CTVectorVariant> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTVectorVariant> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctvectorvariant9d75type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTVector addNewVector();

    CTVector getVector();

    void setVector(CTVector cTVector);
}
