package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTMarkerStyle extends XmlObject {
    public static final DocumentFactory<CTMarkerStyle> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMarkerStyle> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmarkerstyle1f6ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STMarkerStyle.Enum getVal();

    void setVal(STMarkerStyle.Enum r6);

    STMarkerStyle xgetVal();

    void xsetVal(STMarkerStyle sTMarkerStyle);
}
