package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCrosses extends XmlObject {
    public static final DocumentFactory<CTCrosses> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCrosses> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcrossesbcb8type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STCrosses.Enum getVal();

    void setVal(STCrosses.Enum r6);

    STCrosses xgetVal();

    void xsetVal(STCrosses sTCrosses);
}
