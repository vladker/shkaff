package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTUnsignedInt extends XmlObject {
    public static final DocumentFactory<CTUnsignedInt> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTUnsignedInt> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctunsignedinte8ectype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getVal();

    void setVal(long j6);

    XmlUnsignedInt xgetVal();

    void xsetVal(XmlUnsignedInt xmlUnsignedInt);
}
