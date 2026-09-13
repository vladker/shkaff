package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCrossBetween extends XmlObject {
    public static final DocumentFactory<CTCrossBetween> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCrossBetween> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcrossbetweeneb14type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STCrossBetween.Enum getVal();

    void setVal(STCrossBetween.Enum r6);

    STCrossBetween xgetVal();

    void xsetVal(STCrossBetween sTCrossBetween);
}
