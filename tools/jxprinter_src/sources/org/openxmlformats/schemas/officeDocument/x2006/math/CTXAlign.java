package org.openxmlformats.schemas.officeDocument.x2006.math;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXAlign;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTXAlign extends XmlObject {
    public static final DocumentFactory<CTXAlign> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTXAlign> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctxalignd265type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STXAlign.Enum getVal();

    void setVal(STXAlign.Enum r6);

    STXAlign xgetVal();

    void xsetVal(STXAlign sTXAlign);
}
